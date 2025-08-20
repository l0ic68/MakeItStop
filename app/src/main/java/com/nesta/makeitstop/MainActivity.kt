package com.nesta.makeitstop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    color = Color(0XFFFAFAFA)
                ) {
                   // CravingScreen()
                    DashboardScreen()
                }
            }
        }
    }
}
