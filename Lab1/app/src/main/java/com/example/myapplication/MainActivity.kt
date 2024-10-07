package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        modifier = Modifier.padding(innerPadding),
//                    )
                    BusinessCard(
                        name = "Full Name",
                        title = "Title",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.dalat)
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Đà Lạt",
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Đà Lạt là thành phố tỉnh lỵ trực thuộc tỉnh Lâm Đồng, " +
                    "nằm trên cao nguyên Lâm Viên, thuộc vùng Tây Nguyên, Việt Nam.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Với độ cao 1.500m so với mực nước biển và được các dãy núi cùng quần hệ thực vật rừng bao quanh," +
                    " Đà Lạt thừa hưởng một khí hậu miền núi ôn hòa và dịu mát quanh năm.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
//        Greeting()
        BusinessCard(name = "Full Name", title = "Title")
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier, name: String, title: String){
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(R.drawable.android),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.width(150.dp) .aspectRatio(4 / 4f).padding(start = 16.dp)
        )
        Text(
            text = "$name",
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 50.sp,
        )
        Text(
            text = "$title",
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 40.sp,

        )
        Spacer(modifier = Modifier.height(150.dp))
        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Center) {
            Icon(
                painter = painterResource(R.drawable.icons8_phone_50),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "+11 (123) 444 555 666",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 30.sp,
            )
        }
        Row ()
        {
            Icon(
                painter = painterResource(R.drawable.icons8_share_30),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "@AndroidDev",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 30.sp,
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.icons8_email_50),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "jen.doe@android.com",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                fontSize = 30.sp,
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}