package com.capsols.payoneerapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.capsols.payoneerapp.Adapters.PaymentsAdapter;
import com.capsols.payoneerapp.Models.ApplicableNetworkModel;
import com.capsols.payoneerapp.Models.PaymentObjectModel;
import com.capsols.payoneerapp.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //global declarations
    RecyclerView viewPayNetworks;
    Toolbar appToolBar;
    RetrofitClient retrofitClient;
    PaymentsAdapter myRecyclerViewAdapter;
    private List<ApplicableNetworkModel> applicableNetworks = new ArrayList<>();

    //Tag string for logs ease of tracing
    String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitClient = new RetrofitClient();
        //views initialization
        innitViews();

       // action bar and icon setup
        setSupportActionBar(appToolBar);
        appToolBar.setNavigationIcon(R.drawable.ic_back);
        getSupportActionBar().setTitle(R.string.pay_methods);
        appToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });


    }
    //Retrofit call to fetch the JSON object in question
    private void fetchApplicableNetworks()
    {
     Call<PaymentObjectModel> myCall = retrofitClient.getMyApi().getApplicableNetworks();

     myCall.enqueue(new Callback<PaymentObjectModel>() {
         @Override
         public void onResponse(Call<PaymentObjectModel> call, Response<PaymentObjectModel> response) {
             if(response.code() == 200 )
             {
                 Log.e(TAG, "onResponse: success");
                 PaymentObjectModel loadedMethods = response.body();
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         parseAndInflateRecyclerview(loadedMethods);
                     }
                 });

             }
             else if(response.code() == 404)
             {
                 Log.e(TAG, "onResponse_Err : fail - server cannot find resource");
             }
             else if(response.code() == 500)
             {
                 Log.e(TAG, "onResponse_Err : fail - internal server error");
             }
             else
             {
                 Log.e(TAG, "onResponse_Err : fail - Request error");
             }
         }

         @Override
         public void onFailure(Call<PaymentObjectModel> call, Throwable t) {
             Log.e(TAG, "onFailure: "+t.toString());
         }
     });
    }
    //this method will be called to show the methods on recyclerview as well as parse the JSON object
    private void parseAndInflateRecyclerview(PaymentObjectModel myFtechedObject)
    {
        applicableNetworks = myFtechedObject.getNetwork().getApplicable();
        Log.e(TAG, "saveApplicables: "+applicableNetworks.size());
        myRecyclerViewAdapter = new PaymentsAdapter(applicableNetworks, getApplicationContext());
        viewPayNetworks.setAdapter(myRecyclerViewAdapter);
        viewPayNetworks.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    /*
    This function will initialize view elements needed in the activity
     */
    private void innitViews()
    {
        //Recyclerview for applicable payment networks
        viewPayNetworks = (RecyclerView) findViewById(R.id.recViewBankList);
        viewPayNetworks.setHasFixedSize(true);
        appToolBar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //call API to check applicable payment networks
        fetchApplicableNetworks();
    }
}