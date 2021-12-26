package com.example.kamusistilahhukum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


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
        getSupportFragmentManager().beginTransaction().replace(R.id.wadah_fragment,new Home()).commit();


    }

    NavigationBarView.OnItemSelectedListener bottomNavbarListener= new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()){
                case R.id.homeFragment:
                    selectedFragment=new Home();
                    break;
                case R.id.commentFragment:
                    selectedFragment=new CommentFragment();
                    break;
                case R.id.aboutFragment:
                    selectedFragment=new AboutFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.wadah_fragment,selectedFragment).commit();
            return true;
        }
    };


}