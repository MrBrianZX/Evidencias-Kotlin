package com.sotosoft.p20_ubicacion

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.tasks.OnSuccessListener
import java.util.*
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private val permisoFineLocation = android.Manifest.permission.ACCESS_FINE_LOCATION
    private val permisoCoarseLocation = android.Manifest.permission.ACCESS_COARSE_LOCATION
    var callback :LocationCallback? = null

    private val CODIGO_SOLICITUD_PERMISO = 100

    var fLocationProviderClient : FusedLocationProviderClient? = null
    var locationRequest: LocationRequest? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fLocationProviderClient = FusedLocationProviderClient(this)
        inicializarLocationRequest()

    }

    @SuppressLint("RestrictedApi")
    private fun inicializarLocationRequest(){
        locationRequest = LocationRequest()
        locationRequest?.interval = 1000
        locationRequest?.fastestInterval = 5000
        locationRequest?.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    private fun validarPermisosUbicacion():Boolean{
        val hayUbicacionPrecisa = ActivityCompat.checkSelfPermission(this, permisoFineLocation) == PackageManager.PERMISSION_GRANTED
        val hayUbicacionOrdinaria = ActivityCompat.checkSelfPermission(this, permisoFineLocation) == PackageManager.PERMISSION_GRANTED

        return hayUbicacionOrdinaria && hayUbicacionPrecisa
    }

    @SuppressLint("MissingPermission")
    private fun obtenerUbicacion(){
       /*fLocationProviderClient?.lastLocation?.addOnSuccessListener (this, object : OnSuccessListener<Location>{
            override fun onSuccess(location: Location?) {
                if(location != null){
                    Toast.makeText(applicationContext, location?.latitude.toString() + "-" + location.longitude.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        })*/
        callback =  object: LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)

                for (ubicacion in locationResult?.locations!!){
                    Toast.makeText(applicationContext, ubicacion?.latitude.toString() + "-" + ubicacion.longitude.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        }
        fLocationProviderClient?.requestLocationUpdates(locationRequest, callback, null)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun perdirPermisos(){
        val needContext = ActivityCompat.shouldShowRequestPermissionRationale(this, permisoFineLocation)

        if (needContext){
            Toast.makeText(applicationContext, "TG", Toast.LENGTH_SHORT).show()
            solicitudPermiso()
        }else{
            solicitudPermiso()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun solicitudPermiso(){
        requestPermissions(arrayOf(permisoFineLocation, permisoCoarseLocation), CODIGO_SOLICITUD_PERMISO)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CODIGO_SOLICITUD_PERMISO -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    obtenerUbicacion()
                }else{
                    Toast.makeText(this, "No diste permiso a la ubicacion", Toast.LENGTH_SHORT)
                }
            }
        }
    }

    private fun detenerActualizacionUbicacion(){
        fLocationProviderClient?.removeLocationUpdates(callback)
    }

    override fun onStart() {
        super.onStart()

        if(validarPermisosUbicacion()){
            obtenerUbicacion()
        }else{
            perdirPermisos()
        }
    }

    override fun onPause() {
        super.onPause()

        detenerActualizacionUbicacion()
    }
}