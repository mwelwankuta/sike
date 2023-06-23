package utils

import java.awt.Dimension
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

fun getScreenSize(): Dimension {
    val toolkit: Toolkit = Toolkit.getDefaultToolkit();
    return toolkit.screenSize;
}


fun setToClipboard() {

}

fun interceptCurrentClipboardItem(): String {
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard

    if (!clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
        return ""
    }
    return clipboard.getData(DataFlavor.stringFlavor) as String
}