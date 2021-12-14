package com.capsols.payoneerapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.capsols.payoneerapp.Models.Applicable;
import com.capsols.payoneerapp.R;
import com.capsols.payoneerapp.ViewHolders.PaymentMethodsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PaymentsAdapter extends RecyclerView.Adapter<PaymentMethodsViewHolder> {

    private List<Applicable> myApplicableNetworks = new ArrayList<>();
    private Context mContext;

    public PaymentsAdapter(List<Applicable> ApplicableNetworks, Context context)
    {
        this.myApplicableNetworks = ApplicableNetworks;
        this.mContext = context;
    }
    @NonNull
    @Override
    public PaymentMethodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_applicable_networks,parent, false);
        return new PaymentMethodsViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodsViewHolder holder, int position) {

        Applicable selectedApplicableNetwork = myApplicableNetworks.get(position);
        holder.myPaymentMethodTextView.setText(selectedApplicableNetwork.getName());

    }
    @Override
    public int getItemCount() {
        return myApplicableNetworks.size();
    }
}
