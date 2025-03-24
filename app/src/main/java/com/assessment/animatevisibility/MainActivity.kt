package com.assessment.animatevisibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assessment.animatevisibility.ui.theme.AnimateVisibilityTheme
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.animation.*
import androidx.compose.animation.core.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimateVisibilityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
/*
fun MainScreen(modifier: Modifier = Modifier) {
    var boxVisible by remember { mutableStateOf(true) }
    val onClick = { newState : Boolean -> boxVisible = newState }
    val state = remember { MutableTransitionState(false) }
    state.apply { targetState = true }
    Column(modifier.padding(20.dp),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            CustomButton(text = "Show", targetState = true, onClick = onClick)
            CustomButton(text = "Hide", targetState = false, onClick = onClick)
        }
        Spacer(modifier = Modifier.height(20.dp))
       */
       /* AnimatedVisibility(visible = boxVisible,
                           //enter = fadeIn() + expandHorizontally(),
                           //enter = fadeIn(animationSpec = tween(durationMillis = 5000)),
                           *//*
*/
                         /*enter = slideInHorizontally(animationSpec = tween(durationMillis = 5000,
                                                                             easing = LinearOutSlowInEasing)),*//*
*/
/*
                           *//*
*/
                         /*enter = slideInHorizontally(animationSpec = tween(durationMillis = 5000,
                                                                              easing = CubicBezierEasing(0f, 1f, 0.5f,1f))),*//*
*/
/*
                           enter = fadeIn(animationSpec = repeatable(10,
                                          animation = tween(durationMillis = 2000),
                                          repeatMode = RepeatMode.Reverse)),
                           exit = slideOutVertically()) {
            Box(modifier = Modifier.size(height = 200.dp, width = 200.dp).background(Color.Blue))
        }*//*

        */
        /*AnimatedVisibility(visible = boxVisible,
                           enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
                           exit = fadeOut(animationSpec = tween(durationMillis = 5500))){
            Row {
                Box(Modifier.size(width = 150.dp , height = 150.dp )
                            .background(Color.Blue))
                Spacer(modifier = Modifier.width(20.dp))
                Box(Modifier.animateEnterExit(enter = slideInVertically(animationSpec = tween(durationMillis = 5500)),
                                              exit = slideOutVertically(
                                              animationSpec = tween(durationMillis = 5500)))
                            .size(width = 150.dp, height = 150.dp)
                            .background(Color.Green))
            }
        }*//*

        */
         /*AnimatedVisibility(
            visible = boxVisible,
            enter = EnterTransition.None ,
            exit = ExitTransition.None
        ) {
            Row {
                Box(Modifier.animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
                                              exit = fadeOut(animationSpec = tween(durationMillis = 5500)))
                            .size(width = 150.dp, height = 150.dp)
                            .background(Color.Blue))
                Spacer(modifier = Modifier.width(20.dp))
                Box(Modifier.animateEnterExit(enter = slideInVertically(animationSpec = tween(durationMillis = 5500)),
                                              exit = slideOutVertically(animationSpec = tween(durationMillis = 5500)))
                            .size(width = 150.dp, height = 150.dp)
                            .background(Color.Green))
            }
        }*//*

        AnimatedVisibility(visibleState = state ,
                           enter = fadeIn(animationSpec = tween(5000)),
                           exit = slideOutVertically()) {
            Row {
                Box(Modifier.animateEnterExit(enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
                                              exit = fadeOut(animationSpec = tween(durationMillis = 5500)))
                            .size(width = 150.dp, height = 150.dp)
                            .background(Color.Blue))
                Spacer(modifier = Modifier.width(20.dp))
                Box(Modifier.animateEnterExit(enter = slideInVertically(animationSpec = tween(durationMillis = 5500)),
                                              exit = slideOutVertically(animationSpec = tween(durationMillis = 5500)))
                            .size(width = 150.dp, height = 150.dp)
                            .background(Color.Green))
            }
        }
    }
}
*/
fun MainScreen(modifier: Modifier = Modifier){
    var boxVisible by remember { mutableStateOf(true) }
    val onClick = { newState : Boolean -> boxVisible = newState }

    Column(modifier.padding(20.dp),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Crossfade(targetState = boxVisible,
                      animationSpec = tween(5000), label = "crossFade") { visible ->
                when (visible) {
                    true -> CustomButton(text = "Hide", targetState = false,
                                         onClick = onClick, bgColor = Color.Gray)
                    false -> CustomButton(text = "Show", targetState = true,
                                         onClick = onClick, bgColor = Color.Magenta)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        AnimatedVisibility(visible = boxVisible,
                           enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
                           exit = fadeOut(animationSpec = tween(durationMillis = 5500))) {
            Box(modifier = Modifier.size(height = 200.dp, width = 200.dp).background(Color.Blue))
        }
    }
}

@Composable
fun CustomButton(text: String, targetState: Boolean,
                 onClick: (Boolean) -> Unit, bgColor: Color = Color.Blue) {
    Button(onClick = { onClick(targetState) }, colors = ButtonDefaults.buttonColors(
                       containerColor = bgColor,
                       contentColor = Color.White)) {
        Text(text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AnimateVisibilityTheme {
        MainScreen()
    }
}