// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import androidx.compose.ui.window.*
import composables.Header
import utils.getScreenSize
import utils.interceptCurrentClipboardItem
import kotlin.system.exitProcess

@Composable
@Preview
fun App() {
    val clipboardItems = interceptCurrentClipboardItem()

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
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

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    val screenSize = getScreenSize()
    var windowVisible by remember { mutableStateOf(false) }
    Tray(
        icon = TrayIcon,
        menu = {
            Item(
                "Open",
                onClick = { windowVisible = true },
//                shortcut = KeyShortcut(Key.V, ctrl = true, shift = true)
            )
            Item(
                "Exit",
                onClick = { exitProcess(1) },
            )
        },
        tooltip = "Sike",
        onAction = { windowVisible = !windowVisible }
    )

    if (windowVisible) {
        Window(
            onCloseRequest = { windowVisible = false },
            undecorated = true,
            state = WindowState(
                placement = WindowPlacement.Floating,
                position = WindowPosition(screenSize.height.dp, screenSize.height.dp),
                width = screenSize.width.dp,
                height = screenSize.height * 0.4f.dp

            ),
        ) {
            App()
        }
    }
}

object TrayIcon : Painter() {
    override val intrinsicSize = Size(256f, 256f)
    override fun DrawScope.onDraw() {
        drawOval(Color.White)
    }
}