package com.sena.hayvancikabilir.ui.shell
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.sena.hayvancikabilir.feature.profile.AnimalUiModel
import com.sena.hayvancikabilir.feature.createanimal.CreateAnimalScreen
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
import androidx.compose.ui.Modifier
import com.sena.hayvancikabilir.feature.activity.ActivityScreen
import com.sena.hayvancikabilir.feature.animalprofile.AnimalProfileScreen
import com.sena.hayvancikabilir.feature.createpost.CreatePostScreen
import com.sena.hayvancikabilir.feature.explore.ExploreScreen
import com.sena.hayvancikabilir.feature.feed.FeedScreen
import com.sena.hayvancikabilir.feature.profile.ProfileScreen

private enum class MainDestination(
    val title: String,
    val symbol: String
) {
    FEED("Ana Akış", "🐾"),
    EXPLORE("Keşfet", "🔎"),
    CREATE_POST("Paylaş", "+"),
    ACTIVITY("Aktivite", "♡"),
    PROFILE("Profil", "☺")
}

@Composable
fun AppShell() {
    val animals = remember {
        mutableStateListOf(
            AnimalUiModel(
                name = "Pamuk",
                species = "Kedi",
                bio = "Uykucu • Meraklı",
                emoji = "🐱"
            ),
            AnimalUiModel(
                name = "Tarçın",
                species = "Köpek",
                bio = "Enerjik • Park tutkunu",
                emoji = "🐶"
            )
        )
    }
    var selectedDestination by rememberSaveable {
        mutableStateOf(MainDestination.FEED)
    }

    var selectedAnimal by rememberSaveable {
        mutableStateOf<String?>(null)
    }
    var isCreatingAnimal by rememberSaveable {
        mutableStateOf(false)
    }

    if (isCreatingAnimal) {

        CreateAnimalScreen(
            onBack = {
                isCreatingAnimal = false
            },

            onSave = { name, species, bio ->

                val emoji = when (species) {
                    "Kedi" -> "🐱"
                    "Köpek" -> "🐶"
                    "Kuş" -> "🐦"
                    else -> "🐾"
                }

                animals.add(
                    AnimalUiModel(
                        name = name,
                        species = species,
                        bio = bio,
                        emoji = emoji
                    )
                )

                isCreatingAnimal = false
            }
        )

        return
    }
    if (selectedAnimal != null) {

        AnimalProfileScreen(
            animalName = selectedAnimal!!,
            onBack = {
                selectedAnimal = null
            }
        )

        return
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

        when (selectedDestination) {

            MainDestination.FEED ->
                FeedScreen(
                    modifier = Modifier.padding(innerPadding)
                )

            MainDestination.EXPLORE ->
                ExploreScreen(
                    modifier = Modifier.padding(innerPadding)
                )

            MainDestination.CREATE_POST ->
                CreatePostScreen(
                    modifier = Modifier.padding(innerPadding)
                )

            MainDestination.ACTIVITY ->
                ActivityScreen(
                    modifier = Modifier.padding(innerPadding)
                )

            MainDestination.PROFILE ->
                ProfileScreen(
                    modifier = Modifier.padding(innerPadding),
                    animals = animals,

                    onAnimalClick = { animalName ->
                        selectedAnimal = animalName
                    },

                    onCreateAnimalClick = {
                        isCreatingAnimal = true
                    }
                )
        }
    }
}