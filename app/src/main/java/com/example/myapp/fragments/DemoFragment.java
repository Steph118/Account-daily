package com.example.myapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapp.adapters.DemoViewPagerAdapter;
import com.example.myapp.databinding.FragmentDemoBinding;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class DemoFragment extends Fragment {
    private FragmentDemoBinding binding;

    public DemoFragment() {
    }

    public static DemoFragment newInstance() {
        return new DemoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDemoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPager();
    }

    public void initPager() {
        SpringDotsIndicator dotsIndicator = binding.dotsIndicator;
        ViewPager2 viewPager2 = binding.pager;
        DemoViewPagerAdapter adapter = new DemoViewPagerAdapter(getParentFragmentManager(), getLifecycle());
        adapter.addFragment(DemoPiWelcomeFragment.newInstance());
        adapter.addFragment(DemoPiStep1Fragment.newInstance());
        adapter.addFragment(DemoPiStep2Fragment.newInstance());
        adapter.addFragment(DemoPiStep3Fragment.newInstance());
        viewPager2.setAdapter(adapter);
        dotsIndicator.attachTo(viewPager2);
    }
}