package com.example.androiddevchallenge.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Puppy

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
        LazyVerticalGrid(cells = GridCells.Fixed(3)) {
            items(puppies) { puppy ->
                PuppyPhoto(puppy = puppy, modifier = Modifier
                    .size(128.dp)
                    .padding(2.dp))
            }
        }
    }
}

@Composable
private fun PuppyCard(puppy: Puppy) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            PuppyPhoto(
                puppy = puppy,
                modifier = Modifier.size(128.dp),
                shape = RoundedCornerShape(CornerSize(8.dp))
            )
            PetShortDetails(puppy = puppy, modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}
