package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.getuserlocation;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.codesroots.osamaomar.cityrolls.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.codesroots.osamaomar.cityrolls.entities.names.AddressDetails;
import static com.codesroots.osamaomar.cityrolls.entities.names.FULL_ADDRESS;
import static com.codesroots.osamaomar.cityrolls.entities.names.USER_LANG;
import static com.codesroots.osamaomar.cityrolls.entities.names.USER_LAT;

public class GetUserLocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "tag";

    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 115;
    private static final float DEFAULT_ZOOM = 15;
    protected Location location, myLocation;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private LocationRequest mLocationRequest;
    private double currentLatitude;
    private double currentLongitude;
    TextView search;
    ImageView mMarker;
    private LatLng curretLatLng;
    String address = "";
    Double longitude, latitude;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    boolean mLocationPermissionGranted ;
    EditText detatils_address;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Object mLastKnownLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_location);
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    getLocationPermission();

        search = findViewById(R.id.search);
        detatils_address = findViewById(R.id.detailsaddress);
     GetLocation();
        search.setOnClickListener(view -> {
            try {
                Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.RESULT_ERROR)
                        .build(this);
                startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
            } catch (Exception e) {
            }
        });

        ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.usermap)).getMapAsync(this);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
        //updateLocationUI();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111) {
            ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.usermap)).getMapAsync(this);
        } else if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i(TAG, "Place: " + place.getName());
                LatLng latLng = place.getLatLng();

                goToAddress(latLng.latitude, latLng.longitude);

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i(TAG, status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private void GetLocation() {
        LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }

        if (!gps_enabled && !network_enabled) {
            // notify user
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle(R.string.choice_location)
                        .setMessage(R.string.addlocation)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(new AppCompatActivity(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();
            }
            statusCheck();

        }


    }
    public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    private void getLocationPermission() {

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        goToAddress(location.getLatitude(),location.getLongitude());
                        // Logic to handle location object
                    }
                }
            });
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.CALL_PHONE,Manifest.permission.READ_CONTACTS
                            ,Manifest.permission.WRITE_CONTACTS}, 112);
        }
    }

    private void goToAddress(Double mlatitude, Double mLogitude) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mlatitude, mLogitude), 16.0f));
        mMap.setOnCameraIdleListener(() -> {
            latitude = mMap.getCameraPosition().target.latitude;
            longitude = mMap.getCameraPosition().target.longitude;
            address = getLocationAddress(latitude, longitude);
            if (address == null) {
                Toast.makeText(GetUserLocationActivity.this, getString(R.string.cannot_fetch_address), Toast.LENGTH_SHORT).show();
            } else {
                search.setText(address);
            }
        });
    }

    public String getLocationAddress(Double Lat, Double Lng) {
        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
        try {
            List<Address> listAddresses = geocoder.getFromLocation(Lat, Lng, 1);
            if (null != listAddresses && !listAddresses.isEmpty()) {
                StringBuilder address = new StringBuilder();
                if (listAddresses.get(0).getMaxAddressLineIndex() > 0) {
                    for (int i = 0; i < listAddresses.get(0).getMaxAddressLineIndex(); i++) {
                        address.append(listAddresses.get(0).getAddressLine(i)).append(", ");
                    }
                } else {
                    address.append(listAddresses.get(0).getAddressLine(0));
                }
                return address.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void send(View view) {

        if (!address.matches("")) {
            if (!detatils_address.getText().toString().matches("")) {
                Intent data = new Intent();
                data.putExtra(FULL_ADDRESS, address + detatils_address.getText().toString());
                data.putExtra(USER_LAT, String.valueOf(latitude));
                data.putExtra(USER_LANG, String.valueOf(longitude));
                data.putExtra(AddressDetails,  detatils_address.getText().toString());

                setResult(RESULT_OK, data);
                finish();
            }
            else

               //  GetLocation();
                Snackbar.make(findViewById(R.id.usermap), getText(R.string.adddetailsaddress), Snackbar.LENGTH_LONG).show();
        }
        else
            Snackbar.make(findViewById(R.id.usermap), getText(R.string.noaddress), Snackbar.LENGTH_LONG).show();

    }
}
