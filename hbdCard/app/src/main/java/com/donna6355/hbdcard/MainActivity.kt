package com.donna6355.hbdcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.donna6355.hbdcard.ui.theme.HbdCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HbdCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_isaac),
                        from= stringResource(R.string.from_donna),
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message:String,from:String,modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 132.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize =32.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun GreetingImage(message:String, from:String, modifier: Modifier=Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.3f
        )
        GreetingText(message = message, from = from)
    }
}

@Composable
fun Article(title:String, paraOne:String, paraTwo:String,modifier:Modifier=Modifier){
    Column (modifier){
        Image(painter = painterResource(
            id = R.drawable.bg_compose_background),
            contentDescription = null,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)

        )
        Text(
            text = paraOne,
            textAlign = TextAlign.Justify,
            modifier=modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = paraTwo,
            textAlign = TextAlign.Justify,
            modifier=modifier.padding(16.dp)
        )
    }

}

@Composable
fun CompletionCard(header:String, desc:String, modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_task_completed) , contentDescription = null)
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top=24.dp, bottom=8.dp)
        )
        Text(
            text = desc,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ComposeCard(label:String, body:String,backgroundColor:Color, modifier: Modifier= Modifier){
    Column(
        modifier = modifier.fillMaxSize()
            .background(color = backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
        )

    }
}
@Composable
fun ComposeQuadrant(){
    Column() {
        Row(Modifier.weight(1f)) {
            ComposeCard(
                label = stringResource(R.string.text_composable),
                body = stringResource(R.string.text_composable_body),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                label = stringResource(R.string.image_composable),
                body = stringResource(R.string.image_composable_body),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)){
            ComposeCard(label = stringResource(R.string.row_composable),
                body = stringResource(R.string.row_composable_body),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                label = stringResource(R.string.column_composable),
                body = stringResource(R.string.column_composable_boy),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
                )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayCardPreview() {
    HbdCardTheme {
        ComposeQuadrant()
    }
}