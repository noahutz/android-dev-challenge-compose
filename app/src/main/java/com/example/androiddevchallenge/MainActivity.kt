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
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.components.PuppyFullDetails
import com.example.androiddevchallenge.components.PuppyList
import com.example.androiddevchallenge.components.PuppyPhotoGrid
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {
    private val viewModel: PuppyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(
                    puppies = viewModel.puppies,
                    viewList = viewModel.viewList,
                    onToggleGridView = { viewModel.viewList = it }
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun MyApp(
    puppies: List<Puppy>,
    viewList: Boolean,
    onToggleGridView: (Boolean) -> Unit
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "puppyList") {
        composable("puppyList") {
            if (viewList) {
                PuppyList(puppies) { selectedPuppy ->
                    navController.navigate("puppyDetails/${selectedPuppy.id}")
                }
            } else {
                PuppyPhotoGrid(puppies) { selectedPuppy ->
                    navController.navigate("puppyDetails/${selectedPuppy.id}")
                }
            }
        }
        composable(
            route = "puppyDetails/{puppyId}",
            arguments = listOf(navArgument("puppyId") {})
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("puppyId")?.let { puppyId ->
                PuppyFullDetails(puppy = puppies.first { it.id == puppyId })
            }
        }
    }

//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Pup Adopt") },
//                actions = { TopBarActions(viewList) { onToggleGridView(it) } }
//            )
//        }
//    ) {
//        Surface(color = MaterialTheme.colors.background) {
//            selectedPuppy?.let {
//                PuppyFullDetails(puppy = it)
//            } ?: if (viewList) {
//                PuppyList(puppies) { selectedPuppy ->
//                    onItemSelected(selectedPuppy)
//                }
//            } else {
//                PuppyPhotoGrid(puppies) { selectedPuppy ->
//                    onItemSelected(selectedPuppy)
//                }
//            }
//        }
//    }
}

@ExperimentalAnimationApi
@Composable
fun TopBarActions(isViewGrid: Boolean, onToggleGridView: (Boolean) -> Unit) {
    val currentIcon = remember { MutableTransitionState(Icons.Default.ViewList) }.apply {
        targetState = if (isViewGrid) Icons.Default.GridView else Icons.Default.ViewList
    }
    val transition = updateTransition(targetState = currentIcon)

    IconButton(onClick = { onToggleGridView(!isViewGrid) }) {
        Icon(
            imageVector = transition.targetState.targetState,
            contentDescription = "Toggle Views"
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(getPreviewList(), true, onToggleGridView = {})
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(getPreviewList(), true, onToggleGridView = {})
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
