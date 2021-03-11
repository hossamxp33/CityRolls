package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity;

import android.Manifest;
import android.annotation.SuppressLint;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.homeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuInflater;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.helper.AddorRemoveCallbacks;
import com.codesroots.osamaomar.cityrolls.helper.Converter;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.cartfragment.CartFragment;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.favorite.FavoritsFragment;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.adapter.AllDepartsAdapter;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.MainFragment;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.myorders.MyOrdersFragment;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.offerfragment.OffersFragment;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.ProductsFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener, AddorRemoveCallbacks {

    RecyclerView alldepartsinNavigation;
    BottomNavigationView bottomNavigationView;
    MainActivityViewModel mainActivityViewModel;
    NavigationView navigationView;
    public DrawerLayout drawer;
    public ImageView logo, search;
    public TextView head_title;
    private EditText searchName;
    private ArrayList<String> arrayList = new ArrayList<>();
    private PreferenceHelper preferenceHelper;
    private static int cart_count = 0;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceHelper = new PreferenceHelper(this);

        initialize();
        setUpToggle();
//        search.setOnClickListener(v -> {
//
//   //         performSearch();
//            /// Hidden keyboard  after click
//            HiddenKeyboard(v);
//        });
//        searchName.setOnEditorActionListener((v, actionId, event) -> {
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//          //      performSearch();
//                /// Hidden keyboard  after click
//                HiddenKeyboard(v);
//                return true;
//            }
//
//            return false;
//        });
         head_title.setVisibility(View.INVISIBLE);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new homeFragment()).commit();

    }
private void HiddenKeyboard(View view ){
    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
}
    private void initialize() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        search = findViewById(R.id.search);
        head_title = findViewById(R.id.head_title);
        searchName = findViewById(R.id.searchName);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        alldepartsinNavigation = findViewById(R.id.all_departs);
        logo = findViewById(R.id.logo);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        mainActivityViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(MainActivityViewModel.class);
        mainActivityViewModel.sidemenuMutableLiveData.observe(this, sidemenu ->
                alldepartsinNavigation.setAdapter(new AllDepartsAdapter(this, sidemenu.getCategory())));
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.CALL_PHONE,Manifest.permission.READ_CONTACTS
                        ,Manifest.permission.WRITE_CONTACTS}, 112);

    }

    private void performSearch() {
        if (!searchName.getText().toString().matches("")) {
            Fragment fragment = new ProductsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", searchName.getText().toString());
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, fragment).addToBackStack(null).commit();
        } else
            searchName.setError(getText(R.string.nosearchname));
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
        MenuItem menuItem = menu.findItem(R.id.action_cart);
        cart_count = PreferenceHelper.retriveCartItemsSize();
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.shoppcart));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new CartFragment()).addToBackStack(null).commit();
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
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new homeFragment()).addToBackStack(null).commit();
                break;

            case R.id.notifications:
                if (PreferenceHelper.getUserId() > 0) {
                    drawer.closeDrawers();
                    popupFragments();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new FavoritsFragment()).addToBackStack(null).commit();
                } else
                    Toast.makeText(MainActivity.this, getText(R.string.loginfirst), Toast.LENGTH_SHORT).show();
                break;
            case R.id.main:
                drawer.closeDrawers();
                popupFragments();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new homeFragment()).addToBackStack(null).commit();
                break;

            case R.id.myorders:
                if (PreferenceHelper.getUserId() > 0) {
                    drawer.closeDrawers();
                    popupFragments();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new MyOrdersFragment()).addToBackStack(null).commit();
                } else
                    Toast.makeText(MainActivity.this, getText(R.string.loginfirst), Toast.LENGTH_SHORT).show();
                break;

            case R.id.offers:
                drawer.closeDrawers();
                popupFragments();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new OffersFragment()).addToBackStack(null).commit();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void  popupFragments()
    {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
    @Override
    public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();
    }

    @Override
    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();
    }

    @Override
    public void onClearCart() {
        PreferenceHelper.clearCart();
        cart_count = 0;
        invalidateOptionsMenu();
    }

    @SuppressLint("ResourceType")
    public void setUpToggle() {
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        toggle.setDrawerIndicatorEnabled(false);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.list, this.getTheme());
        toggle.setHomeAsUpIndicator(drawable);

        drawer.addDrawerListener(toggle);
        toggle.setToolbarNavigationClickListener(v -> {
            if (drawer.isDrawerVisible(GravityCompat.START)) {

                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        toggle.syncState();
    }

}
