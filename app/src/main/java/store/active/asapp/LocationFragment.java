package store.active.asapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;

public class LocationFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    static final LatLng Arpaia = new LatLng(41.0367800,14.5517500);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // inflate and return the layout
        final View rootView = inflater.inflate(R.layout.location_fragment, container,false);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        //mMapView.onResume();

        try {
            MapsInitializer.initialize(this.getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        //adding the view of the construction
        googleMap.setBuildingsEnabled(true);
        //adding the marker to the point
        Marker Arp = googleMap.addMarker(new MarkerOptions().position(Arpaia));
        //moving the camera close to the marker
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Arpaia, 14));

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}