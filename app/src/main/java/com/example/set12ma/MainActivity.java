package com.example.set12ma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.set12ma.ui.main.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ResultReceiverAddressSpace, ResultReceiverMemorySpace {

    // Адресное пространство приложения
    AddressSpace addressSpace;
    // Пространство памяти для загрузки бинарных файлов в железо
    MemorySpace memorySpace;
    // SET12MA
    TabLayout tabsSET12MA;
    ViewPager viewPagerDataExchange;
    // LoadSoftware
    ViewPager viewPagerLoadingSoftware;
    // Logging
    ViewPager viewPagerLogging;
    // Connection
    ViewPager viewPagerConnecting;

    MainActivitySectionsPagerAdapterDataExchange sectionsPagerAdapterDataExchange;
    MainActivitySectionsPagerAdapterLoadingSoftware sectionsPagerAdapterLoadingSoftware;
    MainActivitySectionsPagerAdapterLogging sectionsPagerAdapterLogging;
    MainActivitySectionsPagerAdapterConnecting sectionsPagerAdapterConnecting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPagerAdapterDataExchange = new MainActivitySectionsPagerAdapterDataExchange(this, getSupportFragmentManager());
        sectionsPagerAdapterLoadingSoftware = new MainActivitySectionsPagerAdapterLoadingSoftware(this, getSupportFragmentManager());
        sectionsPagerAdapterLogging = new MainActivitySectionsPagerAdapterLogging(this, getSupportFragmentManager());
        sectionsPagerAdapterConnecting = new MainActivitySectionsPagerAdapterConnecting(this, getSupportFragmentManager());

        // Terminal
        viewPagerDataExchange = findViewById(R.id.view_pager_dataExchange);
        viewPagerDataExchange.setAdapter(sectionsPagerAdapterDataExchange);
        // LoadingSoftware
        viewPagerLoadingSoftware = findViewById(R.id.view_pager_loadingSoftware);
        viewPagerLoadingSoftware.setAdapter(sectionsPagerAdapterLoadingSoftware);
        viewPagerLoadingSoftware.setVisibility(View.INVISIBLE);
        // Logging
        viewPagerLogging = findViewById(R.id.view_pager_logging);
        viewPagerLogging.setAdapter(sectionsPagerAdapterLogging);
        viewPagerLogging.setVisibility(View.INVISIBLE);
        // Connecting
        viewPagerConnecting = findViewById(R.id.view_pager_connecting);
        viewPagerConnecting.setAdapter(sectionsPagerAdapterConnecting);
        viewPagerConnecting.setVisibility(View.INVISIBLE);

        // main tab
        tabsSET12MA = findViewById(R.id.tabs_SET12MA);
        tabsSET12MA.setupWithViewPager(viewPagerDataExchange);


        FloatingActionButton fab = findViewById(R.id.fab_SET12MA);

        addressSpace = new AddressSpace(300);
        memorySpace = new MemorySpace();
//        addressSpace.setAddressSpace(150, 1);
//        addressSpace.setAddressSpace(210, 150);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                1);
//        ActivityCompat.requestPermissions(MainActivity.this,
//                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Необходимо разрешить в настройках телефона доступ к местоположению для использования приложения", Toast.LENGTH_SHORT).show();
//                    startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        TextView headerView = findViewById(R.id.selectedMenuItem);
        switch(id){
            case R.id.menu_dataExchange:
                tabsSET12MA.setupWithViewPager(viewPagerDataExchange);
                viewPagerConnecting.setVisibility(View.INVISIBLE);
                viewPagerLogging.setVisibility(View.INVISIBLE);
                viewPagerLoadingSoftware.setVisibility(View.INVISIBLE);
                viewPagerDataExchange.setVisibility(View.VISIBLE);
                getSupportActionBar().setTitle("Данные");
                return true;
            case R.id.menu_connecting:
                tabsSET12MA.setupWithViewPager(viewPagerConnecting);
                viewPagerConnecting.setVisibility(View.VISIBLE);
                viewPagerLogging.setVisibility(View.INVISIBLE);
                viewPagerLoadingSoftware.setVisibility(View.INVISIBLE);
                viewPagerDataExchange.setVisibility(View.INVISIBLE);
                getSupportActionBar().setTitle("Подключение");
                return true;
            case R.id.menu_logging:
                tabsSET12MA.setupWithViewPager(viewPagerLogging);
                viewPagerConnecting.setVisibility(View.INVISIBLE);
                viewPagerLogging.setVisibility(View.VISIBLE);
                viewPagerLoadingSoftware.setVisibility(View.INVISIBLE);
                viewPagerDataExchange.setVisibility(View.INVISIBLE);
                getSupportActionBar().setTitle("Логирование");
                return true;
            case R.id.menu_loadingSoftware:
                tabsSET12MA.setupWithViewPager(viewPagerLoadingSoftware);
                viewPagerConnecting.setVisibility(View.INVISIBLE);
                viewPagerLogging.setVisibility(View.INVISIBLE);
                viewPagerLoadingSoftware.setVisibility(View.VISIBLE);
                viewPagerDataExchange.setVisibility(View.INVISIBLE);
                getSupportActionBar().setTitle("Загрузка ПО");
                return true;
        }
//        headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public AddressSpace getAddressSpace() {
        return addressSpace;
    }

    @Override
    public MemorySpace getMemorySpace() {
        return memorySpace;
    }
}