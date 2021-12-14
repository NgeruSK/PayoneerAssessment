package com.capsols.payoneerapp.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.capsols.payoneerapp.R;

public class PaymentMethodsViewHolder extends RecyclerView.ViewHolder {

    private View myView;
    public TextView myPaymentMethodTextView;
    public ImageView myPaymentMethodImageView;

    public PaymentMethodsViewHolder(@NonNull View itemView) {
        super(itemView);
        myView = itemView;
        myPaymentMethodTextView = myView.findViewById(R.id.tvMethodName);
        myPaymentMethodImageView =  myView.findViewById(R.id.imgMethodlogo);
    }
}
