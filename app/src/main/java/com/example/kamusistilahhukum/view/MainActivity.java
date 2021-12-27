package com.example.kamusistilahhukum.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.MenuItem;


import com.example.kamusistilahhukum.R;
import com.example.kamusistilahhukum.databinding.ActivityMainBinding;
import com.example.kamusistilahhukum.databinding.FragmentHomeBinding;
import com.example.kamusistilahhukum.model.IstilahHukum;
import com.example.kamusistilahhukum.model.IstilahHukumAdapter;
import com.example.kamusistilahhukum.viewmodel.IstilahHukumViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menyambungkan
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(bottomNavbarListener);
        // ketika aplikasi dijalankan, fragment yang akan dibuka pertama kali adalah fragment home
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.wadah_fragment,new Home())
                .commit();


    }

    final NavigationBarView.OnItemSelectedListener bottomNavbarListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            final int homeFragment = R.id.homeFragment;
            final int commentFragment = R.id.saranFragment;
            final int aboutFragment = R.id.aboutFragment;
            switch (item.getItemId()) {
                case homeFragment:
                    selectedFragment = new Home();
                    break;
                case commentFragment:
                    selectedFragment = new SaranFragment();
                    break;
                case aboutFragment:
                    selectedFragment = new AboutFragment();
                    break;
            }
            //jika selectedFragment tidak null, akan menjalankan wadah_fragment
            if (selectedFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.wadah_fragment, selectedFragment)
                        .commit();
            }
            return true;
        }
    };


}