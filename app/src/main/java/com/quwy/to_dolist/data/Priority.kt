package com.quwy.to_dolist.data

import androidx.compose.ui.graphics.Color
import com.quwy.to_dolist.ui.theme.HighPriorityColor
import com.quwy.to_dolist.ui.theme.LowPriorityColor
import com.quwy.to_dolist.ui.theme.MediumPriorityColor

enum class Priority(val color: Color) {
    CRITICAL(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor)
}