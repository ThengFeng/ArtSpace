package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Dimension
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}
@Preview
@Composable
fun ArtSpaceLayout(){
    ArtSpace(modifier = Modifier.wrapContentSize(Alignment.Center))
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    var step by remember { mutableStateOf(1) }
    var image = when(step){
        1->R.drawable.download
        2->R.drawable._14a5b77_1882_43ea_a9bb_f776ce333270
        3->R.drawable._1479599_615
        else -> R.drawable.f5707cae_550f_464b_aab3_57e6dbcc062f
    }
    var title = when(step){
        1 -> R.string.pic1
        2 -> R.string.pic2
        3 -> R.string.pic3
        else -> R.string.pic4
    }
    var des = when(step){
        1 -> R.string.des1
        2 -> R.string.des2
        3 -> R.string.des3
        else -> R.string.des4
    }
    if(step < 1){
        step = 4
    }else if(step > 4){
        step = 1
    }

    Box(modifier = modifier) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.grey),
        ) {
            Column(
                modifier = modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = colorResource(id = R.color.purple_200),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = null,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        color = colorResource(id = R.color.white),
                        shape = MaterialTheme.shapes.medium

                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(title),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Cursive,
                                modifier = Modifier.padding(vertical = 8.dp) // Adjust padding as needed
                            )
                            Text(
                                text = stringResource(des),
                                fontWeight = FontWeight.Light,
                                fontFamily = FontFamily.Cursive,
                                modifier = Modifier.padding(vertical = 8.dp) // Adjust padding as needed
                            )
                        }
                    }
                }



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly // Evenly space the buttons
                ) {
                    Button(
                        onClick = { step--},
                        modifier = Modifier.weight(0.5f) // Make the first button occupy equal space
                    ) {
                        Text(text = "Previous")
                    }
                    Spacer(modifier = Modifier.width(30.dp)) // Add space of 16dp between the buttons

                    Button(
                        onClick = { step++ },
                        modifier = Modifier.weight(0.5f) // Make the second button occupy equal space
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}


