package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        initFragment();

    }

    private void initFragment() {
        binding.bottomMenu.setSelectedItemId(R.id.bottomMenu);
        fragmentTranslation(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuHome: fragmentTranslation(new HomeFragment()); break;
                    case R.id.menuSearch: fragmentTranslation(new SearchFragment()); break;
                    case R.id.menuLike: fragmentTranslation(new LikeFragment()); break;
                    case R.id.menuList: fragmentTranslation(new CartListFragment()); break;
                    case R.id.menuUser: fragmentTranslation(new MyPageFragment()); break;
                }
                return true;
            }
        });
    }

    private void fragmentTranslation(Fragment requestFragment){
        Log.d("MainActivity", requestFragment.getClass().toString());
        FragmentTransaction fragmentTranslation = getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, requestFragment);
        fragmentTranslation.addToBackStack(null);
        fragmentTranslation.commit();
    }
}