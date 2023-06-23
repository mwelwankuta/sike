// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import composables.Clip
import composables.Header
import utils.getScreenSize
import utils.interceptCurrentClipboardItem
import java.awt.SystemColor.text
import java.awt.Toolkit

val toolkit: Toolkit = Toolkit.getDefaultToolkit();

@Composable
@Preview
fun App() {
    val screenSize = getScreenSize()
    val paneDisplayHeight = screenSize.height * 60 / 100 // 40 percent of display height size
    val clipboardItems = interceptCurrentClipboardItem()

    MaterialTheme {
        Column(
            modifier = Modifier.size(width = screenSize.width.dp, height = paneDisplayHeight.dp)
        ) {
            Header()
            Text(text = clipboardItems)
            LazyColumn(
            ) {
//                items(clipboardItems) { clip->
//                    Clip(clip)
//                }
            }
        }
    }
}

fun main() = application {
    val screenSize = getScreenSize()
    Window(
        onCloseRequest = ::exitApplication,
        undecorated = true,
        state = WindowState(
            placement = WindowPlacement.Floating,
            position = WindowPosition(screenSize.height.dp, screenSize.height.dp),
            width = toolkit.screenSize.width.dp
        ),
    ) {
        App()
    }
}
