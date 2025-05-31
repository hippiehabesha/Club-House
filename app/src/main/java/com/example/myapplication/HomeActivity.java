package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new HomePage())
                    .commit();
            navigationView.setCheckedItem(R.id.menuHome);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuHome) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new HomePage())
                    .commit();
        } else if (item.getItemId() == R.id.menuAccount) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new Account())
                    .commit();
        } else if (item.getItemId() == R.id.menuSettings) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new Settings())
                    .commit();
        } else if (item.getItemId() == R.id.menuClubs) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new Clubs())
                    .commit();
        } else if (item.getItemId() == R.id.menuAboutUs) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new About())
                    .commit();
        } else if (item.getItemId() == R.id.menuLogout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}