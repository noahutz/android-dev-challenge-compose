package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
        LazyVerticalGrid(cells = GridCells.Fixed(3)) {
            items(puppies) { puppy ->
                PuppyPhoto(puppy = puppy, modifier = Modifier.padding(2.dp))
            }
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            PuppyPhoto(puppy = puppy, shape = RoundedCornerShape(CornerSize(8.dp)))
            PetShortDetails(puppy = puppy, modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}

@Composable
fun PuppyPhoto(puppy: Puppy, modifier: Modifier = Modifier, shape: Shape = RectangleShape) {
    Surface(modifier = modifier.size(128.dp), shape = shape) {
        Image(
            painter = painterResource(id = puppy.imageResourceId),
            contentDescription = puppy.name
        )
    }
}

@Composable
fun PetShortDetails(puppy: Puppy, modifier: Modifier = Modifier) {
    val color = MaterialTheme.colors.secondaryVariant
    val age = remember { buildDetailAnnotation("Age", puppy.age, color = color) }
    val breed = remember { buildDetailAnnotation("Breed", puppy.breed, color = color) }

    Column(modifier = modifier.padding(8.dp)) {
        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primaryVariant,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = modifier.padding(4.dp))
        Text(text = age, style = MaterialTheme.typography.body2)
        Text(text = breed, style = MaterialTheme.typography.body2)
    }
}

private fun buildDetailAnnotation(title: String, value: String, color: Color): AnnotatedString {
    return buildAnnotatedString {
        append("$title: ")
        pushStyle(style = SpanStyle(fontStyle = FontStyle.Italic, color = color))
        append(value)
        pop()
    }
}


@Preview(showBackground = true)
@Composable
fun PuppyCardPreview() {
    PuppyCard(puppy = Puppy("Bingo", "12", "breed", R.drawable.img_pet_benji))
}