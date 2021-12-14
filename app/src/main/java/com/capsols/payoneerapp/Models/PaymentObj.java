package com.capsols.payoneerapp.Models;

public class PaymentObj {
    private String resultCode;
    private ReturnCode returnCode;
    private NetworkObj networks;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public NetworkObj getNetwork() {
        return networks;
    }

    public void setNetwork(NetworkObj networks) {
        this.networks = networks;
    }
}
