package com.example.myapp.activities;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapp.R;
import com.example.myapp.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //binding.toolbar.setBackgroundColor(getResources().getColor(R.color.primaryTextColor));
        //binding.toolbar.setTitle("Accueil");
        //getData();
    }

    private void getData(){
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
    }
}