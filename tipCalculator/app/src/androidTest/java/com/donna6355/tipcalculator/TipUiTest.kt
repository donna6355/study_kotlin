package com.donna6355.tipcalculator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.donna6355.tipcalculator.ui.theme.TIpCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTip_20_percent_tip() {
        composeTestRule.setContent {
            TIpCalculatorTheme {
                TipLayout()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount") //select the textfield by searching the node with text
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("NO NODE WITH THIS TEXT FOUND")
    }
}