package composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Search() {
    var searchInputVisibile by remember { mutableStateOf(false) }
    var searchTerm: String by remember { mutableStateOf("") }

    Row(modifier = Modifier.padding(5.dp).clickable { searchInputVisibile = !searchInputVisibile  }) {
        Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
        AnimatedVisibility(visible = searchInputVisibile) {
            TextField(
                value = searchTerm,
                onValueChange = {searchTerm = it},
                modifier = Modifier.background(Color.White)
            )
        }
    }
}

@Composable
@Preview
fun Header() {
    Row {
        Search()
        Tabs()
    }
}