package com.donna6355.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.donna6355.tipcalculator.ui.theme.TIpCalculatorTheme
import org.jetbrains.annotations.VisibleForTesting
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TIpCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
//                    TipLayout()
                    ArtSpaceLayout()
                }

            }
        }
    }
}

@Composable
fun TipLayout() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var amountInput by remember { mutableStateOf("") }
        var tipInput by remember { mutableStateOf("") }
        var roundUp by remember { mutableStateOf(false) }
        val amount: Double = amountInput.toDoubleOrNull() ?: 0.0
        val tipPercentage: Double = tipInput.toDoubleOrNull() ?: 0.0
        val tip: String = tipCalculate(amount, tipPercentage, roundUp)

        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = R.string.bill_amount,
            value = amountInput,
            onValueChange = { amountInput = it },
            icon = R.drawable.money,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            label = R.string.how_was_the_service,
            value = tipInput,
            onValueChange = { tipInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            icon = R.drawable.percent,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@VisibleForTesting
internal fun tipCalculate(
    bill: Double,
    tip: Double = 15.0,
    roundUp: Boolean,

    ): String {
    var tip: Double = bill / 100 * tip
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)

}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes icon: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Next
    ),
    modifier: Modifier = Modifier,
) {
    TextField(
        leadingIcon = { Icon(painter = painterResource(icon), contentDescription = null) },
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(text = stringResource(label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions

    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.round_up_tip)
        )
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun TipLayoutPreview() {
//    TipLayout()
//}

@Composable
fun ArtSpaceLayout() {
    var currentIdx by remember { mutableIntStateOf(0) }
    val image = when (currentIdx) {
        0 -> R.drawable.meow
        1 -> R.drawable.zzz
        else -> R.drawable.analyze_meow
    }
    val title = when (currentIdx) {
        0 -> R.string.meow
        1 -> R.string.zzz
        else -> R.string.analyze_meow
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CatPicture(image)
        CatName(title)
        SelectButton(
            onPrevClicked = { if (currentIdx > 0) currentIdx -= 1 else currentIdx = 2 },
            onNextClicked = { if (currentIdx > 1) currentIdx = 0 else currentIdx += 1 },
        )
    }

}

@Composable
fun CatPicture(
    @DrawableRes img: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(img),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(248.dp)
    )
}

@Composable
fun CatName(
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(title),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier.padding(vertical = 32.dp)
    )
}

@Composable
fun SelectButton(
    onPrevClicked: () -> Unit,
    onNextClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        Button(
            onClick = onPrevClicked,
        ) {
            Text("Prev")
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(onClick = onNextClicked) {
            Text("Next")
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun ArtSpacePreview() {
    ArtSpaceLayout()
}