package com.capsols.payoneerapp.Retrofit;

import com.capsols.payoneerapp.Models.PaymentMethod;
import com.capsols.payoneerapp.Models.PaymentObj;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/";

    @GET("listresult.json")
    Call<PaymentMethod> getNetworks();


    @GET("listresult.json")
    Call<PaymentObj> getApplicableNetworks();


}