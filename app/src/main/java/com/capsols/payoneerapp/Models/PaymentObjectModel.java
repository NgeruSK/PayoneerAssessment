package com.capsols.payoneerapp.Models;

public class PaymentObjectModel {
    private String resultCode;
    private ReturnCodeModel returnCodeModel;
    private NetworkObjectModel networks;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public ReturnCodeModel getReturnCode() {
        return returnCodeModel;
    }

    public void setReturnCode(ReturnCodeModel returnCodeModel) {
        this.returnCodeModel = returnCodeModel;
    }

    public NetworkObjectModel getNetwork() {
        return networks;
    }

    public void setNetwork(NetworkObjectModel networks) {
        this.networks = networks;
    }
}
