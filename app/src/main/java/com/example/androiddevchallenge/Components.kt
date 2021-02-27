package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PuppyCard(puppy: Puppy) {
    Card(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            PetImage(puppy)
            PetShortDetails(puppy)
        }
    }
}

@Composable
fun PetImage(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.imageResourceId),
        contentDescription = puppy.name,
        modifier = Modifier.size(128.dp)
    )
}

@Composable
fun PetShortDetails(puppy: Puppy) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        Text(text = "Name: ${puppy.name}")
        Text(text = "Age: ${puppy.age}")
        Text(text = "Breed: ${puppy.breed}")
    }
}
