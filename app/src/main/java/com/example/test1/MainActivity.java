package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
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
        }
        Button btn_rating =findViewById(R.id.btn_rating);
        Button btn_general =findViewById(R.id.btn_general);
        Button btn_food_beverage=findViewById(R.id.btn_food_beverage);
        Button btn_feedback=findViewById(R.id.btn_feedback);
        btn_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity_rating();
            }
        });
        btn_general.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity_general();
            }
        });
        btn_food_beverage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity_food_beverage();
            }
        });
        btn_feedback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                activity_feedback();
            }
        });

    }

    private void activity_rating() {
        Intent intent=new Intent(this,Policy.class);
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

    private void activity_feedback() {
        Intent intent=new Intent(this,Feedback.class);
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
        }
        return false;
    }


   

}