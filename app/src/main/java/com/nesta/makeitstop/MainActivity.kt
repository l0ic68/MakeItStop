package com.nesta.makeitstop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.nesta.makeitstop.tutorial.WellnessScreen
import com.nesta.makeitstop.ui.theme.AppBackground
import com.nesta.makeitstop.ui.theme.MakeItStopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MakeItStopTheme {
              /*  Scaffold(
                    bottomBar = { BottomAppBar() }
                ) { padding ->
                    HomeScreen(Modifier.padding(padding))
                }*/
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppBackground
                ) {
                    CravingScreen()
                }
            }
        }
    }
}
