package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;
   HomeFragment homeFragment = new HomeFragment();
   NotificationFragment notificationFragment = new NotificationFragment();
   SettingsFragment settingsFragment = new SettingsFragment();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      bottomNavigationView = findViewById(R.id.bottom_navigation);
      getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

      BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.notification);
      badgeDrawable.setVisible(true);
      badgeDrawable.setNumber(8);

      bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

         @Override
         public boolean onNavigationItemSelected(MenuItem item) {
            switch(item.getItemId()){
               case R.id.home:
                  getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                  return true;
               case R.id.notification:
                  getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                  return true;
               case R.id.setting:
                  getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                  return true;
            }
            return false;
         }
      });
   }
}