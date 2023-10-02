package com.example.myapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.adapters.DailyAccountAdapter;
import com.example.myapp.databinding.FragmentHomeBinding;
import com.example.myapp.entities.Montant;
import com.example.myapp.entities.User;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public static final String TAG = "accueil";
    private RecyclerView recyclerView;
    private FragmentHomeBinding binding;
    private Context fContext;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setRecyclerView();
        setClick();
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
        //recyclerView = binding.recyclerAccountDaily;
        //recyclerView.setLayoutManager(new LinearLayoutManager(fContext));
        //DailyAccountAdapter adapter = new DailyAccountAdapter(accountList, fContext);
        //recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.fContext = context;
        super.onAttach(context);
    }

    public void setClick(){
        binding.createDepenseFloatButton.setOnClickListener(v1 -> {
            //Navigation.findNavController(v1).navigate(R.id.action_homeFragment_to_createAccountFragment);
           /* NavHostFragment.findNavController(HomeFragment.this)
                    .navigate(R.id.action_homeFragment_to_createAccountFragment);*/
            NavDirections directions = HomeFragmentDirections.actionHomeFragmentToCreateAccountFragment();
           Navigation.findNavController(v1).navigate(directions);
        });
    }
}