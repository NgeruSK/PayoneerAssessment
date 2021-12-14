package com.capsols.payoneerapp.Retrofit;

import com.capsols.payoneerapp.Models.PaymentObjectModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/";


    @GET("listresult.json")
    Call<PaymentObjectModel> getApplicableNetworks();


}