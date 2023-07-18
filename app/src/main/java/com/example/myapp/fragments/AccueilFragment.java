package com.example.myapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.adapters.DailyAccountAdapter;
import com.example.myapp.databinding.FragmentAccueilBinding;
import com.example.myapp.entities.Montant;

import java.util.ArrayList;
import java.util.List;

public class AccueilFragment extends Fragment {
    public static final String TAG = "accueil";
    private RecyclerView recyclerView;
    private FragmentAccueilBinding binding;
    private Context fContext;

    public AccueilFragment() {
    }

    public static AccueilFragment newInstance() {
        return new AccueilFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccueilBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
    }

    /*private void getData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("personName");
        Log.e(TAG, "getData Name: "+intent.getStringExtra("personGivenName"));
        Log.e(TAG, "getData FamilyName: "+intent.getStringExtra("personFamilyName"));
        Log.e(TAG, "getData Email: "+intent.getStringExtra("personEmail"));
        Log.e(TAG, "getData Id: "+intent.getStringExtra("personId"));
        Log.e(TAG, "getData Name: "+intent.getStringExtra("personName"));
        Log.e(TAG, "getData Photo: "+intent.getStringExtra("personPhoto"));
        Log.e(TAG, "getData IdToken: "+intent.getStringExtra("personIdToken"));
        Log.e(TAG, "getData ServerAuthCode: "+intent.getStringExtra("personServerAuthCode"));
    }*/

    public void setRecyclerView() {
        List<Montant> accountList = new ArrayList<>();
        accountList.add(new Montant(350, true, "09/05/2023"));
        accountList.add(new Montant(500, true, "09/05/2023"));
        recyclerView = binding.recyclerAccountDaily;
        recyclerView.setLayoutManager(new LinearLayoutManager(fContext));
        DailyAccountAdapter adapter = new DailyAccountAdapter(accountList, fContext);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.fContext = context;
        super.onAttach(context);
    }
}