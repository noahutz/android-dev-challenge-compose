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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PuppyViewModel : ViewModel() {
    var viewList by mutableStateOf(true)
    val puppies by mutableStateOf(getPuppyList())

    private fun getPuppyList(): List<Puppy> {
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
            ),
            Puppy(
                name = "Bolt",
                age = "8 weeks",
                breed = "German Shepherd",
                imageResourceId = R.drawable.img_pet_bolt
            ),
            Puppy(
                name = "Clifford",
                age = "10 years",
                breed = "Labrador Retriever",
                imageResourceId = R.drawable.img_pet_clifford
            ),

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
            ),
            Puppy(
                name = "Bolt",
                age = "8 weeks",
                breed = "German Shepherd",
                imageResourceId = R.drawable.img_pet_bolt
            ),
            Puppy(
                name = "Clifford",
                age = "10 years",
                breed = "Labrador Retriever",
                imageResourceId = R.drawable.img_pet_clifford
            ),
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
            ),
            Puppy(
                name = "Bolt",
                age = "8 weeks",
                breed = "German Shepherd",
                imageResourceId = R.drawable.img_pet_bolt
            ),
            Puppy(
                name = "Clifford",
                age = "10 years",
                breed = "Labrador Retriever",
                imageResourceId = R.drawable.img_pet_clifford
            ),
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
            ),
            Puppy(
                name = "Bolt",
                age = "8 weeks",
                breed = "German Shepherd",
                imageResourceId = R.drawable.img_pet_bolt
            ),
            Puppy(
                name = "Clifford",
                age = "10 years",
                breed = "Labrador Retriever",
                imageResourceId = R.drawable.img_pet_clifford
            ),
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
            ),
            Puppy(
                name = "Bolt",
                age = "8 weeks",
                breed = "German Shepherd",
                imageResourceId = R.drawable.img_pet_bolt
            ),
            Puppy(
                name = "Clifford",
                age = "10 years",
                breed = "Labrador Retriever",
                imageResourceId = R.drawable.img_pet_clifford
            )
        )
    }
}
