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
import androidx.lifecycle.ViewModel

class PuppyViewModel : ViewModel() {
    val puppies by mutableStateOf(getPuppyList())

    private fun getPuppyList(): List<Puppy> {
        return listOf(
            Puppy(
                name = "Beethoven",
                age = "12 years",
                breed = "St. Bernard",
                imageResourceId = R.drawable.img_beethoven,
                details = "Beethoven is the main character in the Beethoven film series. He is a St Bernard dog named after the German composer Ludwig van Beethoven."
            ),
            Puppy(
                name = "Benji",
                age = "4 months",
                breed = "Cocker Spaniel/Schnauzer/Poodle",
                imageResourceId = R.drawable.img_benji,
                details = "Benji is the main protagonist of the Benji franchise. He has had a dozen movies, a Saturday morning TV series, two documentaries on his celebrated life, and even a sci-fi video game for the Commodore 64."
            ),
            Puppy(
                name = "Bolt",
                age = "8 weeks",
                breed = "German Shepherd",
                imageResourceId = R.drawable.img_bolt,
                details = "Bolt is a very fervent, lively, and impulsive individual, often seen performing dangerous stunts, even in the real world, like when he jumped from a bridge onto a speeding locomotive."
            ),
            Puppy(
                name = "Clifford",
                age = "2 years",
                breed = "Labrador Retriever",
                imageResourceId = R.drawable.img_clifford,
                details = "Clifford was the runt of the litter, and was chosen by a city child named Emily Elizabeth Howard as her birthday present. No one expected Clifford to grow, but Emily Elizabeth's love for her tiny red puppy changed Clifford dramatically. "
            ),
            Puppy(
                name = "Fly",
                age = "5 years",
                breed = "Border Collie",
                imageResourceId = R.drawable.img_fly,
                details = "Fly is a female border collie in the 1995 acclaimed family film Babe. Fly adopts the titular pig Babe and teaches him how to herd sheep Fly is at first reluctant but quickly eager to teach Babe to herd sheep while her mate Rex is hesitant. She also learns more about sheep herself along the way."
            ),
            Puppy(
                name = "Old Yeller",
                age = "7 years",
                breed = "Labrador (mix)",
                imageResourceId = R.drawable.img_old_yeller,
                details = "Old Yeller is the title character of the film of the same name. He is a Labrador Retriever and a hero."
            ),
            Puppy(
                name = "Slinky",
                age = "10 years",
                breed = "Dachshund",
                imageResourceId = R.drawable.img_slinky,
                details = "Slinky Dog (better known as Slinky or by his nickname Slink) is a supporting character in the Disney•Pixar Toy Story franchise. He is a wooden toy dachshund who speaks with a graveled Southern accent. He is extremely loyal to Woody and is often the first to side with him."
            )
        )
    }
}
