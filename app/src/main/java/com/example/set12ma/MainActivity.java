package com.example.set12ma;

import android.content.Intent;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.set12ma.ui.main.AddressSpace;
import com.example.set12ma.ui.main.ResultReceiver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import com.example.set12ma.ui.main.MainActivitySectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements ResultReceiver {

    AddressSpace addressSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivitySectionsPagerAdapter sectionsPagerAdapter = new MainActivitySectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
//        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        FloatingActionButton fab = findViewById(R.id.fab);

        addressSpace = new AddressSpace(300);
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
            case R.id.menu_connection:
//                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
//                intent.putExtra("addressSpace", (Parcelable) addressSpace);
//                startActivity(intent);
                return true;
            case R.id.menu_logging:
                return true;
//            case R.id.menu_open:
////                headerView.setText("Сохранить");
//                return true;
        }
//        headerView.setText(item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public AddressSpace getAddressSpace() {
        return addressSpace;
    }
}