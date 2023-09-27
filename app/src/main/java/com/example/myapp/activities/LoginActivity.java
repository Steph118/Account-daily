package com.example.myapp.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.dao.UserDao;
import com.example.myapp.database.AppDatabase;
import com.example.myapp.databinding.ActivityLoginBinding;
import com.example.myapp.dialog.ForgetPasswordFragment;
import com.example.myapp.dialog.InfosDialog;
import com.example.myapp.dialog.InfosDialogSimple;
import com.example.myapp.dialog.InscriptionFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    private final int RC_SIGN_IN = 1000;
    private boolean isSuccess = false, haveAccount = false;
    private ActivityLoginBinding binding;
    private String username = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        /*loginViewModel = new ViewModelProvider(this)
                .get(LoginViewModel.class);*/
        setOnClick();
    }

    public void setOnClick() {
        binding.submitLoginButton.setOnClickListener(v -> verifyEdit());
        binding.signInButton.setOnClickListener(v -> googleSignIn());
        binding.createAccount.setOnClickListener(v ->
                check()
        );
        binding.forgetPassword.setOnClickListener(v -> {
            ForgetPasswordFragment forgetPasswordFragment = ForgetPasswordFragment.instance();
            forgetPasswordFragment.show(getSupportFragmentManager(), ForgetPasswordFragment.TAG);
        });
    }

    public void verifyEdit() {
        username = String.valueOf(binding.editTextLogin.getText());
        password = String.valueOf(binding.editTextPassword.getText());
        if (username.equals("")) {
            binding.textInputPassword.setErrorEnabled(false);
            binding.textInputLogin.setErrorEnabled(true);
            binding.textInputLogin.setError("Champ requis");
        } else if (password.equals("")) {
            binding.textInputLogin.setErrorEnabled(false);
            binding.textInputPassword.setErrorEnabled(true);
            binding.textInputPassword.setError("Champ requis");
        } else {
            username = String.valueOf(binding.editTextLogin.getText());
            password = String.valueOf(binding.editTextPassword.getText());
            new LoginTask().execute();
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

    public void haveAccount() {
        UserDao userDao = initUserDao();
        haveAccount = userDao.haveAccount();
        if (haveAccount) {
            isSuccess = userDao.verifyLogin(username, password);
        }
    }

    public UserDao initUserDao() {
        AppDatabase database = AppDatabase.getDatabase(this);
        return database.userDao();
    }

    public void infosDialog() {
        InfosDialog infos = new InfosDialog(
                R.string.ranking,
                R.string.no_account,
                R.string.create_account,
                R.string.cancel,
                null
        );
        infos.show(getSupportFragmentManager(), "infosDialog");
    }

    public void toLogin(boolean isSuccess) {
        if (isSuccess) {
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        } else {
            binding.textInputLogin.setErrorEnabled(true);
            binding.textInputPassword.setErrorEnabled(true);
            binding.textInputLogin.setError("wrong login or password");
            binding.textInputPassword.setError("wrong login or password");
        }
    }

    public void check() {
        Runnable runnable = () -> {
            try {
                check(initUserDao().haveAccount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        executor.submit(runnable);
    }

    public void check(boolean b) {
        if (b) {
            InfosDialogSimple infos = new InfosDialogSimple(
                    R.string.app,
                    R.string.already_account,
                    R.string.ok,
                    null
            );
            infos.show(getSupportFragmentManager(), "infosDialog");
        } else {
            InscriptionFragment inscriptionFragment = InscriptionFragment.instance();
            inscriptionFragment.show(getSupportFragmentManager(), InscriptionFragment.TAG);
        }
    }

    public class LoginTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            haveAccount();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            if (!haveAccount) {
                infosDialog();
            } else {
                toLogin(isSuccess);
            }
            super.onPostExecute(unused);
        }
    }

    @Override
    protected void onDestroy() {
        executor.shutdownNow();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        executor.shutdownNow();
        super.onStop();
    }
}