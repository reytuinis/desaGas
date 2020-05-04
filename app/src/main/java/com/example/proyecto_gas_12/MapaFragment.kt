package com.example.proyecto_gas_12

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_mapa.*

class MapaFragment : Fragment(), OnMapReadyCallback  {

    private lateinit var googleMap: GoogleMap

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        map.onCreate(savedInstanceState)
        map.onResume()
        map.getMapAsync(this)

    }
    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it
        }

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        map?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12.0f))

    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa, container, false)
    }



}
