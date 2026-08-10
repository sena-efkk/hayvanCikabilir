package com.sena.hayvancikabilir.ui.shell
import com.sena.hayvancikabilir.feature.activity.ActivityScreen
import com.sena.hayvancikabilir.feature.createpost.CreatePostScreen
import com.sena.hayvancikabilir.feature.explore.ExploreScreen
import com.sena.hayvancikabilir.feature.feed.FeedScreen
import com.sena.hayvancikabilir.feature.profile.ProfileScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

private enum class MainDestination(
    val title: String,
    val symbol: String
) {
    FEED(
        title = "Ana Akış",
        symbol = "🐾"
    ),
    EXPLORE(
        title = "Keşfet",
        symbol = "🔎"
    ),
    CREATE_POST(
        title = "Paylaş",
        symbol = "+"
    ),
    ACTIVITY(
        title = "Aktivite",
        symbol = "♡"
    ),
    PROFILE(
        title = "Profil",
        symbol = "☺"
    )
}

@Composable
fun AppShell() {

    var selectedDestination by rememberSaveable {
        mutableStateOf(MainDestination.FEED)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                MainDestination.entries.forEach { destination ->

                    NavigationBarItem(
                        selected = selectedDestination == destination,
                        onClick = {
                            selectedDestination = destination
                        },
                        icon = {
                            Text(destination.symbol)
                        },
                        label = {
                            Text(destination.title)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        AppShellContent(
            destination = selectedDestination,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun AppShellContent(
    destination: MainDestination,
    modifier: Modifier = Modifier
) {
    when (destination) {
        MainDestination.FEED ->
            FeedScreen(modifier)

        MainDestination.EXPLORE ->
            ExploreScreen(modifier)

        MainDestination.CREATE_POST ->
            CreatePostScreen(modifier)

        MainDestination.ACTIVITY ->
            ActivityScreen(modifier)

        MainDestination.PROFILE ->
            ProfileScreen(modifier)
    }
}