package com.example.androiddevchallenge.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.R

@Composable
fun PuppyFullDetails(puppy: Puppy) {
    Column {
        PuppyPhoto(puppy = puppy, modifier = Modifier.fillMaxWidth())
        PetShortDetails(puppy = puppy)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyPreview() {
    PuppyFullDetails(puppy = Puppy("Name", "Age", "Breed", R.drawable.img_pet_benji))
}
