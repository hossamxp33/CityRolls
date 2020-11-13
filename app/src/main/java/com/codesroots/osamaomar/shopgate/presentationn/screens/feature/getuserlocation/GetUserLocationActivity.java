package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.getuserlocation;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.codesroots.osamaomar.shopgate.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
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

import static com.codesroots.osamaomar.shopgate.entities.names.FULL_ADDRESS;
import static com.codesroots.osamaomar.shopgate.entities.names.USER_LANG;
import static com.codesroots.osamaomar.shopgate.entities.names.USER_LAT;

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
        search.setOnClickListener(view -> {
            try {
                Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                        .build(this);
                startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
            } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                Snackbar.make(view, "Can't search for address now", Snackbar.LENGTH_LONG).show();
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
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
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
                setResult(RESULT_OK, data);
                finish();
            }
            else
                Snackbar.make(findViewById(R.id.usermap), getText(R.string.adddetailsaddress), Snackbar.LENGTH_LONG).show();
        }
        else
        Snackbar.make(findViewById(R.id.usermap), getText(R.string.noaddress), Snackbar.LENGTH_LONG).show();

    }
}
