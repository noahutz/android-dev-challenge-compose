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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.R

@Composable
fun PuppyFullDetails(puppy: Puppy?) {
    puppy?.let {
        Column {
            PuppyPhoto(puppy = it, modifier = Modifier.fillMaxWidth())
            PetShortDetails(puppy = it)
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyPreview() {
    PuppyFullDetails(
        puppy = Puppy(
            name = "Name",
            age = "Age",
            breed = "Breed",
            imageResourceId = R.drawable.img_pet_benji
        )
    )
}
