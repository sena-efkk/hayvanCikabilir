package com.sena.hayvancikabilir.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    animals: List<AnimalUiModel>,
    onAnimalClick: (String) -> Unit,
    onCreateAnimalClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item {
            UserProfileHeader()
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Hayvanlarım",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                OutlinedButton(
                    onClick = onCreateAnimalClick
                ) {
                    Text("+ Yeni hayvan")
                }
            }
        }

        if (animals.isEmpty()) {

            item {
                Text(
                    text = "Henüz bir dost eklemedin 🐾",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

        } else {

            items(animals) { animal ->

                AnimalCard(
                    animal = animal,
                    onClick = {
                        onAnimalClick(animal.name)
                    }
                )
            }
        }
    }
}

@Composable
private fun UserProfileHeader() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Surface(
            modifier = Modifier.size(76.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "👤",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        Column {

            Text(
                text = "Sena",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "@sena",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Hayvanları görünce fotoğraf çekmeden geçemem 🐾"
            )
        }
    }
}

@Composable
private fun AnimalCard(
    animal: AnimalUiModel,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Surface(
                modifier = Modifier.size(64.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = animal.emoji,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = animal.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = animal.species,
                    color = MaterialTheme.colorScheme.primary
                )

                if (animal.bio.isNotBlank()) {
                    Text(
                        text = animal.bio,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Text("›")
        }
    }
}