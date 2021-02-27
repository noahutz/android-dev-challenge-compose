package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Puppy

@Composable
fun PuppyPhoto(puppy: Puppy, modifier: Modifier = Modifier, shape: Shape = RectangleShape) {
    Surface(modifier = modifier, shape = shape) {
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
