package com.sena.hayvancikabilir.feature.animalprofile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AnimalProfileScreen(
    animalName: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item {
            TextButton(
                onClick = onBack
            ) {
                Text("‹ Geri")
            }
        }

        item {
            AnimalHeader(
                animalName = animalName
            )
        }

        item {
            AnimalStats()
        }

        item {
            Text(
                text = "Hakkında",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = when (animalName) {
                    "Pamuk" ->
                        "Güneş görünce bütün planlarını iptal edip uyuyan, meraklı bir ev kedisi. 🐱"

                    "Tarçın" ->
                        "Parkta koşmayı ve yeni arkadaşlar edinmeyi çok seven enerjik bir dost. 🐶"

                    else ->
                        "Bu dostun hikâyesi yakında burada olacak. 🐾"
                },
                style = MaterialTheme.typography.bodyLarge
            )
        }

        item {
            Text(
                text = "Gönderiler",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            FakeAnimalPost(
                emoji = if (animalName == "Pamuk") "🐱" else "🐶",
                text = "Bugünün en güzel anı ✨"
            )
        }

        item {
            FakeAnimalPost(
                emoji = if (animalName == "Pamuk") "🐱" else "🐶",
                text = "Biraz daha uyuyabilirim sanırım 😴"
            )
        }
    }
}

@Composable
private fun AnimalHeader(
    animalName: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        Surface(
            modifier = Modifier.size(96.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (animalName == "Pamuk") "🐱" else "🐶",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = animalName,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = if (animalName == "Pamuk")
                    "@pamuk"
                else
                    "@tarcin",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = if (animalName == "Pamuk")
                    "Kedi • 3 yaşında"
                else
                    "Köpek • 4 yaşında"
            )
        }
    }
}

@Composable
private fun AnimalStats() {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatItem("27", "Gönderi")
            StatItem("842", "Takipçi")
            StatItem("126", "Takip")
        }
    }
}

@Composable
private fun StatItem(
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun FakeAnimalPost(
    emoji: String,
    text: String
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = emoji,
                style = MaterialTheme.typography.displayLarge
            )

            Text(text)
        }
    }
}