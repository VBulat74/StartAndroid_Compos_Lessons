package ru.com.bulat.startandroidlessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.weight(1f)
                ){
                    composable("home") { HomeScreen()}
                    composable("orders") { OrdersScreen()}
                    composable("users") { UsersScreen()}
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Text(text = "Home", modifier = Modifier.clickable { navController.navigate("home")})
                    Text(text = "Orders", modifier = Modifier.clickable { navController.navigate("orders")})
                    Text(text = "Users", modifier = Modifier.clickable { navController.navigate("users")})
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Text(
        text = "Home screen",
        fontSize = 30.sp
    )
}

@Composable
fun OrdersScreen() {
    Text(
        text = "Orders screen",
        fontSize = 30.sp
    )
}

@Composable
fun UsersScreen() {
    Text(
        text = "Users screen",
        fontSize = 30.sp
    )
}