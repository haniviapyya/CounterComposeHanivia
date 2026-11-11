package com.example.countercomposehanivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countercomposehanivia.ui.theme.CounterComposeHaniviaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterComposeHaniviaTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "counter_screen",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("counter_screen") {
                            CounterApp(
                                onNextClicked = {
                                    navController.navigate("data_diri_screen")
                                }
                            )
                        }
                        composable("data_diri_screen") {
                            DataDiriScreen()
                        }
                    }
                }
            }
        }
    }
}