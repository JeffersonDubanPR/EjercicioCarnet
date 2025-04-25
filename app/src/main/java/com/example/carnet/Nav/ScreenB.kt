package com.example.carnet.Nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*

@Composable
fun ScreenB(
    listaMascotas: List<Mascota>,
    onEliminar: (Mascota) -> Unit,
    onVolver: () -> Unit
) {
    var mostrarConfirmacion by remember { mutableStateOf(false) }
    var mascotaAEliminar by remember { mutableStateOf<Mascota?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Lista de Carnets Registrados", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        if (listaMascotas.isEmpty()) {
            Text("No hay carnets registrados.")
        } else {
            listaMascotas.forEach { mascota ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color(0xFFE0E0E0))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(mascota.nombre, style = MaterialTheme.typography.titleMedium)
                    IconButton(onClick = {
                        mascotaAEliminar = mascota
                        mostrarConfirmacion = true
                    }) {
                        Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onVolver) {
            Text("Volver")
        }

        if (mostrarConfirmacion && mascotaAEliminar != null) {
            AlertDialog(
                onDismissRequest = { mostrarConfirmacion = false },
                title = {
                    Text("Confirmar Eliminación")
                },
                text = {
                    Text("¿Estás seguro de eliminar a ${mascotaAEliminar?.nombre}?")
                },
                confirmButton = {
                    TextButton(onClick = {
                        mascotaAEliminar?.let { onEliminar(it) }
                        mostrarConfirmacion = false
                    }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        mostrarConfirmacion = false
                    }) {
                        Text("No")
                    }
                }
            )
        }
    }
}
