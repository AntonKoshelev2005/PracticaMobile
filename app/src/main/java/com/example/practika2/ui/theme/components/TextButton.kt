package com.example.practika2.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.practika2.ui.theme.TextButtonColor

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},

    ) {
    Text(
        text = text,
        modifier = modifier
            .clickable { onClick() },
        color = TextButtonColor,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
}

@Preview
@Composable
private fun TextButtonPreview() {
    TextButton(text = "Текст, на который можно нажать")
}