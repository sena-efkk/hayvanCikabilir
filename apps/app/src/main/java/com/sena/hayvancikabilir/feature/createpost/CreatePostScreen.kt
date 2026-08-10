package com.sena.hayvancikabilir.feature.createpost

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CreatePostScreen(
    modifier: Modifier = Modifier
) {
    var selectedType by rememberSaveable {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        Text(
            text = "Yeni Paylaşım 🐾",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Bugün hangi dostun hikâyesini paylaşmak istiyorsun?",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        ShareTypeCard(
            emoji = "🐶",
            title = "Kendi hayvanımı paylaş",
            description = "Profilini oluşturduğun hayvanlardan biri adına gönderi paylaş.",
            onClick = {
                selectedType = "Kendi hayvanım"
            }
        )

        ShareTypeCard(
            emoji = "📍",
            title = "Karşılaştığım bir hayvan",
            description = "Sokakta, parkta veya günlük hayatında gördüğün bir dostu paylaş.",
            onClick = {
                selectedType = "Karşılaştığım hayvan"
            }
        )

        selectedType?.let {
            Text(
                text = "Seçtin: $it ✓",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun ShareTypeCard(
    emoji: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = emoji,
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}