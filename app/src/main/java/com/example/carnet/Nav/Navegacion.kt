package com.example.carnet.Nav

import android.annotation.SuppressLint
import android.telephony.TelephonyCallback
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlin.properties.ReadWriteProperty

import androidx.compose.runtime.*

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Carnet() {
    val navController = rememberNavController()

    // Lista de carnets registrados (inmutable, se actualiza con una nueva lista)
    var listaMascotas by remember { mutableStateOf(listOf<Mascota>()) }

    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(
                onRegistrar = { mascota ->
                    listaMascotas = listaMascotas + mascota // Nueva lista con el nuevo elemento
                    navController.navigate("screenB")
                },
                onVerCarnets = {
                    navController.navigate("screenB")
                }
            )
        }

        composable("screenB") {
            ScreenB(
                listaMascotas = listaMascotas,
                onEliminar = { mascota ->
                    listaMascotas = listaMascotas - mascota // Eliminar mascota
                },
                onVolver = {
                    navController.navigate("screenA")
                }
            )
        }
    }
}

@Composable
fun ScreenA(onRegistrar: (ERROR) -> Unit, onVerCarnets: () -> Unit) {
    TODO("Not yet implemented")
}








