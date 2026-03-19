package com.example.test_app.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.test_app.ui.screens.Show1
import com.example.test_app.ui.screens.Show2
import com.example.test_app.ui.screens.Show3
import com.example.test_app.ui.theme.Color_PageBackground

enum class PageOpt(
    val id: Int,
    val weight: Float,
    val title: String,
    val color: Color
) {
    Page1(1, 1f, "Page 1", Color_PageBackground),
    Page2(2, 1f, "Page 2", Color_PageBackground),
    Page3(3, 1f, "Page 3", Color_PageBackground);
}

@Composable
fun PageBody1(modifier: Modifier = Modifier) {
    /*BoxItem(
        modifier = modifier
            .fillMaxSize()
            .zIndex(-1f),
        Color(0xFFFFD400),
        "Page 1 Background",
    )*/
    Show1()
}

@Composable
fun PageBody2(modifier: Modifier = Modifier) {
    BoxItem(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp)
            .zIndex(-1f),
        Color(0xFFFF9760),
        "Page 2 Background",
    )
    Show2()
}

@Composable
fun PageBody3(modifier: Modifier = Modifier) {
    BoxItem(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp)
            .zIndex(-1f),
        Color(0xFFFF5F00),
        "Page 3 Background",
    )
    Show3()
}