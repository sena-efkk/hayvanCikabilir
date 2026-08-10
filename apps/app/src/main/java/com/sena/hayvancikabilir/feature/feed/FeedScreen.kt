package com.sena.hayvancikabilir.feature.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        item {
            FeedHeader()
        }

        item {
            PostCard(
                animalEmoji = "🐱",
                animalName = "Pamuk",
                username = "@pamuk",
                description = "Bugün bütün gün güneşin altında uyudu. Hayat ona güzel 😴",
                likes = 128,
                comments = 14
            )
        }

        item {
            PostCard(
                animalEmoji = "🐶",
                animalName = "Tarçın",
                username = "@tarcin",
                description = "Parkta yeni arkadaşlar edinmiş. Eve dönmek istemiyor 🐾",
                likes = 246,
                comments = 31
            )
        }
    }
}

@Composable
private fun FeedHeader() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Story Kısmı Gelcek 🐾",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Bugün hangi dostlarla karşılaşacağız?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun PostCard(
    animalEmoji: String,
    animalName: String,
    username: String,
    description: String,
    likes: Int,
    comments: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {

            PostHeader(
                animalEmoji = animalEmoji,
                animalName = animalName,
                username = username
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = animalEmoji,
                        style = MaterialTheme.typography.displayLarge
                    )
                }
            }

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(
                    text = "♡ $likes    💬 $comments",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Yorumları gör",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun PostHeader(
    animalEmoji: String,
    animalName: String,
    username: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text(animalEmoji)
            }
        }

        Spacer(
            modifier = Modifier.size(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = animalName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = username,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            text = "•••",
            style = MaterialTheme.typography.titleMedium
        )
    }
}