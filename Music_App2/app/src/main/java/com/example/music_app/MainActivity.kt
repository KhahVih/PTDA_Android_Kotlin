package com.example.music_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.music_app.ui.theme.Music_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Music_AppTheme {
               MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Music_AppTheme {
        MainScreen()
    }
}
@Composable
fun MainScreen(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.background))
    ) {
        AppBar()
        Spacer(modifier = Modifier.height(5.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(5.dp))
        PlaylistSection()
        Spacer(modifier = Modifier.height(5.dp))
        AlbumSection()
        Spacer(modifier = Modifier.height(5.dp))
        BottomNavigation()
        Spacer(modifier = Modifier.height(5.dp))
    }
}
//AppBar
@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = colorResource(id = R.color.main_pink))
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(R.drawable.icons8_music_48__1_),
            contentDescription = null,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .border(2.dp, Color.White, CircleShape)
                .padding(10.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(1f)) // Đẩy các biểu tượng sang phải
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.main_pink))
        ) {

            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp),
                tint = Color.White
            )
        }

    }
}
//Search
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    val search = remember { mutableStateOf("") }

    TextField(
        value = search.value,
        onValueChange = { search.value = it },
        label = { Text("Search for music") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(1.dp, Color.Gray, CircleShape),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

//
@SuppressLint("ResourceType")
@Composable
fun PlaylistSection() {
        Row (
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(start = 20.dp)
                .border(
                    2.dp,
                    Color.White,
                    RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
                )
                .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))){
            Text(
                text = "YOUR PLAYLIST",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .background(color = colorResource(R.color.main_blue))
                    .fillMaxWidth()
                    .height(40.dp),
                textAlign = TextAlign.Start
            )
        }
}

//Item
@Composable
fun AlbumItem() {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(R.drawable.images),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
        )
        Text(
            text = stringResource(R.string.lorem_ipsum),
            fontSize = 13.sp,
        )
        Text(
            text = stringResource(R.string.lorem_ipsum),
            fontSize = 10.sp,
        )
        Text(
            text = stringResource(R.string.lorem_ipsum),
            fontSize = 10.sp,
        )
    }
}
//
@Composable
fun AlbumSection() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .border(
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.images),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .width(200.dp)
                .border(3.dp, Color.Gray, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp)),

        )
    }
    Column {
        Text(
            text = "ALBUM",
            modifier = Modifier.padding(start = 35.dp),
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            AlbumItem()
            AlbumItem()
            AlbumItem()
            AlbumItem()
        }
    }
}

//
@Composable
fun ButtonIcon(icon: ImageVector){
    Button(onClick = { /**/ },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.background)),
        modifier = Modifier.width(120.dp)
    )
    {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = colorResource(R.color.main_blue),
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        )
    }
}
//
@Composable
fun BottomNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .border(1.dp, Color.Gray, CircleShape)
    ) {
        ButtonIcon(Icons.Filled.Home)
        ButtonIcon(Icons.Filled.Search)
        ButtonIcon(Icons.Filled.Star)
    }
}