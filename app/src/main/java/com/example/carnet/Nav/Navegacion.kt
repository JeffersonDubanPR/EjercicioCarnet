package com.example.carnet.Nav

import android.telephony.TelephonyCallback
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController






@Composable
fun Carnet() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "registro") {
        composable("registro") {
            RegistroMascota { mascota ->
                var mascotaRegistrada = mascota
                navController.navigate("detalle")
            }
        }
        composable("detalle") {
            val mascotaRegistrada = null
            mascotaRegistrada?.let { mascota ->
                DetalleMascota(mascota)
            }
        }
    }
}
