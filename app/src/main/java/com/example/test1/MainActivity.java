package com.example.test1;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FaqFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_faq);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PolicyFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_policy);
        }
    }


    public void Rating(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, rating.class);
        startActivity(intent);

    }
    public void general(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, General.class);
        startActivity(intent);

    }
    public void FB(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, food_beverage.class);
        startActivity(intent);

    }
    public void feedback(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);

    }


    private void activity_feedback () {
        Intent intent=new Intent(this, FaqFragment.class);
        startActivity(intent);
    }
    private void activity_rating() {
        Intent intent=new Intent(this, rating.class);
        startActivity(intent);
    }

    private void activity_general() {
        Intent intent=new Intent(this,General.class);
        startActivity(intent);
    }

    private void activity_food_beverage() {
        Intent intent=new Intent(this,food_beverage.class);
        startActivity(intent);
    }




    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;
            case R.id.nav_faq:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FaqFragment()).commit();
                break;
            case R.id.nav_policy:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PolicyFragment()).commit();
                break;
        }
        return false;
    }


   

}