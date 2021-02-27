/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val viewModel: PuppyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel.puppies)
            }
        }
    }
}

@Composable
fun MyApp(puppies: List<Puppy>?) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            puppies?.forEach { puppy ->
                item {
                    Card(
                        Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        elevation = 4.dp
                    ) {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Image(
                                painter = painterResource(id = puppy.imageResourceId),
                                contentDescription = puppy.name,
                                modifier = Modifier.size(128.dp)
                            )
                            Column(modifier = Modifier.padding(start = 8.dp)) {
                                Text(text = "Name: ${puppy.name}")
                                Text(text = "Age: ${puppy.age}")
                                Text(text = "Breed: ${puppy.breed}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(getPreviewList())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(getPreviewList())
    }
}

private fun getPreviewList(): List<Puppy> {
    return listOf(
        Puppy(
            name = "Beethoven",
            age = "12 years",
            breed = "St. Bernard",
            imageResourceId = R.drawable.img_pet_beethoven
        ),
        Puppy(
            name = "Benji",
            age = "4 months",
            breed = "Cocker Spaniel/Schnauzer/Poodle",
            imageResourceId = R.drawable.img_pet_benji
        )
    )
}
