package com.example.myapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.databinding.ActivityLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    private final int RC_SIGN_IN = 1000;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setOnClick();
    }

    public void setOnClick() {
        binding.submitLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyEdit();
            }
        });

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignIn();
            }
        });
    }

    public void verifyEdit() {
        String login = String.valueOf(binding.editTextLogin.getText());
        String password = String.valueOf(binding.editTextPassword.getText());
        if (login.equals("")) {
            binding.textInputPassword.setErrorEnabled(false);
            binding.textInputLogin.setErrorEnabled(true);
            binding.textInputLogin.setError("Champ requis");
        } else if (password.equals("")) {
            binding.textInputLogin.setErrorEnabled(false);
            binding.textInputPassword.setErrorEnabled(true);
            binding.textInputPassword.setError("Champ requis");
        } else {
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }

    public void googleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signIn(mGoogleSignInClient);
    }

    public void signIn(GoogleSignInClient mGoogleSignInClient) {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    public void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Log.e("TAG", "Signed in successfully");
            getAccueil(account);
        } catch (ApiException e) {
            Log.e("TAG", "signInResult:failed code=" + e.getStatusCode());
        }
    }

    public void getAccueil(GoogleSignInAccount account) {
        String personPhoto = "" + account.getPhotoUrl();
        Intent accueil = new Intent(this, MainActivity.class);
        accueil.putExtra("personName", account.getDisplayName());
        accueil.putExtra("personGivenName", account.getGivenName());
        accueil.putExtra("personFamilyName", account.getFamilyName());
        accueil.putExtra("personEmail", account.getEmail());
        accueil.putExtra("personId", account.getId());
        accueil.putExtra("personPhoto", personPhoto);
        accueil.putExtra("personIdToken", account.getIdToken());
        accueil.putExtra("personServerAuthCode", account.getServerAuthCode());
        startActivity(accueil);
        finish();
    }

    @Override
    protected void onStart() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            getAccueil(account);
        }
        super.onStart();
    }
    /*private void signOut(GoogleSignInClient mGoogleSignInClient) {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
    }*/
}