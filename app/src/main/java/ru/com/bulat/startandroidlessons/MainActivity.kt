package ru.com.bulat.startandroidlessons

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.com.bulat.startandroidlessons.ui.lessons.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "userList",
                    modifier = Modifier.weight(1f)
                ) {
                    composable("userList") { UserListScreen(
                        onUser1Click = { navController.navigate("user/1") },
                        onUser2Click = { navController.navigate("user/2") }
                    ) }
                    composable(
                        route = "user/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) {
                        val userId = it.arguments?.getString("id")
                        UserScreen(userId)
                    }
                }

                Text(
                    text = "Users",
                    modifier = Modifier.clickable { navController.navigate("userList") }
                )
            }
        }
    }
}

@Composable
fun UserListScreen(
    onUser1Click: () -> Unit,
    onUser2Click: () -> Unit,
) {
    Column {
        Text(text = "Users screen")
        Text(
            text = "User 1",
            modifier = Modifier.clickable(onClick = onUser1Click)
        )
        Text(
            text = "User 2",
            modifier = Modifier.clickable(onClick = onUser2Click)
        )
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun UserScreen(
    id: String?,
    userViewModel: UserViewModel = viewModel()
) {
    Text(text = "User $id")
    Log.d("AAA","user $id")
    Log.d("AAA","viewModel ${userViewModel.hashCode().toHexString()}")
    Log.d("AAA","viewModelStoreOwner ${LocalViewModelStoreOwner.current?.javaClass?.simpleName}")
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