package com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.cartfragment.CartFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.favorite.FavoritsFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.adapter.AllDepartsAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.morefragment.MenuFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.myorders.MyOrdersFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.OffersFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    RecyclerView alldepartsinNavigation;
    BottomNavigationView bottomNavigationView;
    MainActivityViewModel mainActivityViewModel;
     NavigationView navigationView;
    public DrawerLayout drawer;
    public ImageView logo;
    public TextView head_title;
    private  ArrayList<String> arrayList = new ArrayList<>();
    private  PreferenceHelper preferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceHelper  = new PreferenceHelper(this);
        initialize();
       getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,new MainFragment()).addToBackStack(null).commit();
    }

    private void initialize() {
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        alldepartsinNavigation = findViewById(R.id.all_departs);
        logo = findViewById(R.id.logo);
        head_title = findViewById(R.id.head_title);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        mainActivityViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(MainActivityViewModel.class);
        mainActivityViewModel.sidemenuMutableLiveData.observe(this,sidemenu ->
                alldepartsinNavigation.setAdapter(new AllDepartsAdapter(this,sidemenu.getCategory())));
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private MainActivityModelFactory getViewModelFactory() {
        return new MainActivityModelFactory(getApplication());
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,new CartFragment()).addToBackStack(null).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.more:
                drawer.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,new MenuFragment()).addToBackStack(null).commit();
                break;

            case R.id.notifications:
                drawer.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new FavoritsFragment()).addToBackStack(null).commit();
                break;
            case R.id.main:
                drawer.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new MainFragment()).addToBackStack(null).commit();
                break;

            case R.id.myorders:
                drawer.closeDrawers();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new MyOrdersFragment()).addToBackStack(null).commit();
                break;

            case R.id.offers:
                drawer.closeDrawers();
               getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new OffersFragment()).addToBackStack(null).commit();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
