package com.leahnjambi.morningintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.leahnjambi.morningintents.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val Nairobi = LatLng(-1.3028618, 36.7073061)
        mMap.addMarker(MarkerOptions().position(Nairobi).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Nairobi))

        val Mombasa = LatLng(-4.0350145, 39.5962216)
        mMap.addMarker(MarkerOptions().position(Mombasa).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mombasa))


        val Nakuru = LatLng(-0.3154676, 35.9387696)
        mMap.addMarker(MarkerOptions().position(Nakuru).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Nakuru))


        val Kisumu = LatLng( 0.0746293,34.5980778)
        mMap.addMarker(MarkerOptions().position(Kisumu).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kisumu))


    }
}