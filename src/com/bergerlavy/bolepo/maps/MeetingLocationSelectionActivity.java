package com.bergerlavy.bolepo.maps;

import java.io.IOException;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.bergerlavy.bolepo.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;

public class MeetingLocationSelectionActivity extends Activity {
	
	// Data Members
	private GoogleMap mMap;
	private static MarkerOptions markOptions = new MarkerOptions();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meeting_location_selection);
		
		initMap();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_meeting_location_selection, menu);
		return true;
	}
	
	public static BoleLocation getMeetingLocation() {
		return null;
	}
	
	// --------------------------------------
	// Initialization Methods
	// --------------------------------------
	
	/**
	 * Initializes the map.
	 */
	private void initMap()
	{
		// Do a null check to confirm that we have not already instantiated the map.
	    if (mMap == null) 
	    {
	        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
	                            .getMap();
	        // Check if we were successful in obtaining the map.
	        if (mMap != null)
	        {
	        	// sets basic settings
	        	setInitialMapSettings();
	        	setLocationToCurrent();
	        }
	        // Displays an error for the user
	        else
	        {
	        	// To fill error notification
	        }
	    }
	}

	/**
	 * Sets the basic properties for the map object.
	 */
	private void setInitialMapSettings()
	{
		mMap.setTrafficEnabled(true);
		mMap.setMyLocationEnabled(true);
		
		// Gets the settings object
		UiSettings mpSettings = mMap.getUiSettings();
		
		// Define basic settings
		mpSettings.setAllGesturesEnabled(true);
		mpSettings.setCompassEnabled(true);
		mpSettings.setMyLocationButtonEnabled(true);
		mpSettings.setZoomControlsEnabled(true);
		
		mMap.setOnMapClickListener(lisMapClickListener);
	}
	
	// --------------------------------------
	// Location Methods
	// --------------------------------------
	// Centrelized the map on the user current location
	private void setLocationToCurrent()
	{
		
	}
	
	/**
	 *  A sub methods for the "setLocationToCurrent" method.
	 *  Used to get the current location.
	 */
	private void getCurrentLocation()
	{
		LocationManager locMan = (LocationManager)getSystemService(LOCATION_SERVICE);
		
	}
	
	// --------------------------------------
	// UI Methods
	// --------------------------------------
	
	/**
	 * This sub method handles the click on the screen
	 */
	OnMapClickListener lisMapClickListener = new OnMapClickListener() {
		
		// The only avilable marker
		
		
		public void onMapClick(LatLng arg0)
		{
			mMap.clear();
			
			// Puts a marker on the map
			mMap.addMarker(new MarkerOptions().position(arg0)
											.title("Moti Je taime!"));
			
			
		}
	};
}
