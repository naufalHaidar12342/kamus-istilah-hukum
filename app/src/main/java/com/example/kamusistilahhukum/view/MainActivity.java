package com.example.kamusistilahhukum.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.kamusistilahhukum.R;
import com.example.kamusistilahhukum.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActivityMainBinding bindingMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //untuk saat ini orientationnya di kunci pada mode portrait/berdiri
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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