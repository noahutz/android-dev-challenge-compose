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
package com.example.androiddevchallenge.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Puppy

@Composable
fun PuppyList(puppies: List<Puppy>, onItemSelected: (Puppy) -> Unit) {
    LazyColumn {
        items(puppies) { puppy ->
            PuppyCard(puppy = puppy, modifier = Modifier.clickable { onItemSelected(puppy) })
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyPhotoGrid(puppies: List<Puppy>, onItemSelected: (Puppy) -> Unit) {
    Card(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(cells = GridCells.Fixed(3)) {
            items(puppies) { puppy ->
                PuppyPhoto(
                    puppy = puppy,
                    modifier = Modifier
                        .clickable { onItemSelected(puppy) }
                        .size(128.dp)
                        .padding(2.dp)
                )
            }
        }
    }
}

@Composable
private fun PuppyCard(puppy: Puppy, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
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
