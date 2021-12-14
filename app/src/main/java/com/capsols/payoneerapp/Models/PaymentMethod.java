package com.capsols.payoneerapp.Models;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod {
    public final static String BANK_TRANSFER = "BANK_TRANSFER";
    public final static String BILLING_PROVIDER = "BILLING_PROVIDER";
    public final static String CASH_ON_DELIVERY = "CASH_ON_DELIVERY";
    public final static String CHECK_PAYMENT = "CHECK_PAYMENT";
    public final static String CREDIT_CARD = "CREDIT_CARD";
    public final static String DEBIT_CARD = "DEBIT_CARD";
    public final static String DIRECT_DEBIT = "DIRECT_DEBIT";
    public final static String ELECTRONIC_INVOICE = "ELECTRONIC_INVOICE";
    public final static String GIFT_CARD = "GIFT_CARD";
    public final static String MOBILE_PAYMENT = "MOBILE_PAYMENT";
    public final static String ONLINE_BANK_TRANSFER = "ONLINE_BANK_TRANSFER";
    public final static String OPEN_INVOICE = "OPEN_INVOICE";
    public final static String PREPAID_CARD = "PREPAID_CARD";
    public final static String TERMINAL = "TERMINAL";
    public final static String WALLET = "WALLET";

    public static String getBankTransfer() {
        return BANK_TRANSFER;
    }

    public static String getBillingProvider() {
        return BILLING_PROVIDER;
    }

    public static String getCashOnDelivery() {
        return CASH_ON_DELIVERY;
    }

    public static String getCheckPayment() {
        return CHECK_PAYMENT;
    }

    public static String getCreditCard() {
        return CREDIT_CARD;
    }

    public static String getDebitCard() {
        return DEBIT_CARD;
    }

    public static String getDirectDebit() {
        return DIRECT_DEBIT;
    }

    public static String getElectronicInvoice() {
        return ELECTRONIC_INVOICE;
    }

    public static String getGiftCard() {
        return GIFT_CARD;
    }

    public static String getMobilePayment() {
        return MOBILE_PAYMENT;
    }

    public static String getOnlineBankTransfer() {
        return ONLINE_BANK_TRANSFER;
    }

    public static String getOpenInvoice() {
        return OPEN_INVOICE;
    }

    public static String getPrepaidCard() {
        return PREPAID_CARD;
    }

    public static String getTERMINAL() {
        return TERMINAL;
    }

    public static String getWALLET() {
        return WALLET;
    }

    /**
     * Check if the given method is a valid payment method
     *
     * @param method the payment method to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String method) {

        if (method != null) {
            switch (method) {
                case BANK_TRANSFER:
                case BILLING_PROVIDER:
                case CASH_ON_DELIVERY:
                case CHECK_PAYMENT:
                case CREDIT_CARD:
                case DEBIT_CARD:
                case DIRECT_DEBIT:
                case ELECTRONIC_INVOICE:
                case GIFT_CARD:
                case MOBILE_PAYMENT:
                case ONLINE_BANK_TRANSFER:
                case OPEN_INVOICE:
                case PREPAID_CARD:
                case TERMINAL:
                case WALLET:
                    return true;
            }
        }
        return false;
    }

    /**
     * The interface Definition
     */
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            BANK_TRANSFER,
            BILLING_PROVIDER,
            CASH_ON_DELIVERY,
            CHECK_PAYMENT,
            CREDIT_CARD,
            DEBIT_CARD,
            DIRECT_DEBIT,
            ELECTRONIC_INVOICE,
            GIFT_CARD,
            MOBILE_PAYMENT,
            ONLINE_BANK_TRANSFER,
            OPEN_INVOICE,
            PREPAID_CARD,
            TERMINAL,
            WALLET })
    public @interface Definition { }



}
