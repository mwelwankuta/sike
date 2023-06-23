package composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import utils.clipColors

class Clip(val id: String = "", val name: String ="", val color: Color? = clipColors["red"])

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ClipFolderList(){
    val clips = listOf<Clip>(Clip(id = "default", name = "Clipboard History", color = clipColors["red"]))

    LazyRow {
        items(clips) {
                clip ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {

            }) {
                Box(modifier = Modifier.size(16.dp).clip(CircleShape).background(clip.color!!))
                Spacer(Modifier.width(13.dp))
                Text(text = clip.name, color = Color.White)
            }
        }
    }
}