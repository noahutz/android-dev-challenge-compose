package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PuppyList(puppies: List<Puppy>) {
    LazyColumn {
        items(puppies) { puppy ->
            PuppyCard(puppy)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyPhotoGrid(puppies: List<Puppy>) {
    Card(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            modifier = Modifier.padding(8.dp),
            cells = GridCells.Fixed(3)
        ) {
            items(puppies) { puppy ->
                PuppyPhoto(puppy)
            }
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy) {
    Card(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            PuppyPhoto(puppy)
            PetShortDetails(puppy)
        }
    }
}

@Composable
fun PuppyPhoto(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.imageResourceId),
        contentDescription = puppy.name,
        modifier = Modifier
            .size(128.dp)
            .padding(8.dp)
    )
}

@Composable
fun PetShortDetails(puppy: Puppy) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Name: ${puppy.name}")
        Text(text = "Age: ${puppy.age}")
        Text(text = "Breed: ${puppy.breed}")
    }
}
