package com.capsols.payoneerapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.capsols.payoneerapp.Adapters.PaymentsAdapter;
import com.capsols.payoneerapp.Models.Applicable;
import com.capsols.payoneerapp.Models.ApplicableNetwork;
import com.capsols.payoneerapp.Models.PaymentMethod;
import com.capsols.payoneerapp.Models.PaymentObj;
import com.capsols.payoneerapp.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView viewPayNetworks;
    Toolbar appToolBar;
    RetrofitClient retrofitClient;
    PaymentsAdapter myRecyclerViewAdapter;
    private List<ApplicableNetwork> myApplicableNetworks = new ArrayList<>();
    private List<Applicable> applicableNetworks = new ArrayList<>();



    String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitClient = new RetrofitClient();
        //views initialization
        innitViews();

        fetchApplicableNetworks();

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
    private void fetchApplicableNetworks()
    {
     Call<PaymentObj> myCall = retrofitClient.getMyApi().getApplicableNetworks();

     myCall.enqueue(new Callback<PaymentObj>() {
         @Override
         public void onResponse(Call<PaymentObj> call, Response<PaymentObj> response) {
             if(response.isSuccessful())
             {
                 Log.e(TAG, "onResponse: success");
                 PaymentObj loadedMethods = response.body();
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         saveApplicables(loadedMethods);
                     }
                 });


             }
             else
             {
                 Log.e(TAG, "onResponse_Err : fail");
             }
         }

         @Override
         public void onFailure(Call<PaymentObj> call, Throwable t) {
             Log.e(TAG, "onFailure: "+t.toString());
         }
     });
    }

    private void saveApplicables(PaymentObj myFtechedObject)
    {
        applicableNetworks = myFtechedObject.getNetwork().getApplicable();
        Log.e(TAG, "saveApplicables: "+applicableNetworks.size());

    }

    private void inflateRecycler()
    {
        myRecyclerViewAdapter = new PaymentsAdapter(applicableNetworks, getApplicationContext());
        viewPayNetworks.setAdapter(myRecyclerViewAdapter);
        viewPayNetworks.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }
    private void callRetrofit() {
        Call<PaymentMethod> myCalls = retrofitClient.getMyApi().getNetworks();

        myCalls.enqueue(new Callback<PaymentMethod>() {
            @Override
            public void onResponse(Call<PaymentMethod> call, Response<PaymentMethod> response) {
                if(response.isSuccessful())
                {
                    Log.e(TAG, "onResponse: success");
                    PaymentMethod loadedMethods = response.body();
                }
                else{
                    Log.e(TAG, "onResponse_Err : fail");
                }
            }

            @Override
            public void onFailure(Call<PaymentMethod> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString());
            }
        });

    }

    /*
    This function will initialize view elements needed in the activity
     */
    private void innitViews()
    {

        //Recyclerview for applicable payment networks
        viewPayNetworks = (RecyclerView) findViewById(R.id.recViewBankList);
        appToolBar = (Toolbar) findViewById(R.id.toolbar);
    }
}