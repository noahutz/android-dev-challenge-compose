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
