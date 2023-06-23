package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchInput() {
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.width(355.dp)
            .padding(2.dp)
            .height(36.dp)
            .background(color = Color(0xFFD1D1D1), shape = RoundedCornerShape(size = 6.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF868686), modifier = Modifier.size(24.dp))
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.padding().weight(1f)
        )
        if (searchText.isNotEmpty()) {
            Icon(
                Icons.Default.Close,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.clip(CircleShape).background(Color(0xFFA3A3A3)).size(16.dp).clickable {
                    searchText = ""
                }
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}