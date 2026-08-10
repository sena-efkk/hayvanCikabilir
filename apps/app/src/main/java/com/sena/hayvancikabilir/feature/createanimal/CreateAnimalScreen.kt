package com.sena.hayvancikabilir.feature.createanimal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CreateAnimalScreen(
    onBack: () -> Unit,
    onSave: (
        name: String,
        species: String,
        bio: String
    ) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by rememberSaveable { mutableStateOf("") }
    var species by rememberSaveable { mutableStateOf("") }
    var bio by rememberSaveable { mutableStateOf("") }

    val speciesOptions = listOf(
        "Kedi",
        "Köpek",
        "Kuş",
        "Diğer"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        TextButton(
            onClick = onBack
        ) {
            Text("‹ Geri")
        }

        Text(
            text = "Yeni Hayvan 🐾",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Dostunun profilini oluşturalım.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        OutlinedButton(
            onClick = {
                // Gerçek fotoğraf seçimini backend aşamasından
                // hemen önce bağlayacağız.
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📷 Profil fotoğrafı ekle")
        }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text("Hayvanın adı")
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Text(
            text = "Türü",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            speciesOptions.forEach { option ->

                FilterChip(
                    selected = species == option,
                    onClick = {
                        species = option
                    },
                    label = {
                        Text(option)
                    }
                )
            }
        }

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = {
                Text("Kısa hikâyesi")
            },
            placeholder = {
                Text("Onu biraz anlatsana...")
            },
            modifier = Modifier.fillMaxWidth(),
            minLines = 4
        )

        Button(
            onClick = {
                onSave(
                    name.trim(),
                    species,
                    bio.trim()
                )
            },
            enabled = name.isNotBlank() && species.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Profili oluştur 🐾")
        }
    }
}