package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapp.R;
import com.example.myapp.databinding.FragmentListDepenseBinding;

public class ListDepenseFragment extends Fragment {

    private static final String TAG = "details";
    private FragmentListDepenseBinding binding;

    public ListDepenseFragment() {
    }

    public static ListDepenseFragment newInstance() {
        return new ListDepenseFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_depense, container, false);
    }
}