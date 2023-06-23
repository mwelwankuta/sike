package composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.SearchInput


@Composable
@Preview
fun Header() {
    Row(
        modifier = Modifier.background(color = Color(0xFF2C2C2C))
            .fillMaxWidth().height(62.dp).padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchInput()
        Tabs()
        Spacer(Modifier.width(33.dp))
        ClipFolderList()
    }
}