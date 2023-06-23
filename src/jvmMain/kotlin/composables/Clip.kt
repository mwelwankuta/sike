package composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Clip(clipboardItems: String){
    Text(text=clipboardItems)
}