package com.example.myapp.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.databinding.DailyAccountItemBinding;
import com.example.myapp.entities.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DailyAccountAdapter extends RecyclerView.Adapter<DailyAccountAdapter.DailyViewHolder> {

    private List<Account> accounts = new ArrayList<>();
    private Context context;
    public DailyAccountAdapter() {
    }

    public DailyAccountAdapter(List<Account> accounts, Context context) {
        this.accounts = accounts;
        this.context = context;
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DailyAccountItemBinding binding = DailyAccountItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return  new DailyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        holder.binding.accountDaily.setText(String.valueOf(accounts.get(position).getMontant()));
        holder.binding.date.setText(accounts.get(position).getDate());
        holder.binding.letterView.setText("L");
        getRandomColor(holder.binding.letterView);
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }


    public void getRandomColor(View v){
        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.day_background);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, randomAndroidColor);
        v.setBackground(wrappedDrawable);
    }
    public class DailyViewHolder extends RecyclerView.ViewHolder {
        public DailyAccountItemBinding binding;
        public DailyViewHolder(@NonNull DailyAccountItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
