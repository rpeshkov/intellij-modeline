package net.rpeshkov.modeline.config

import com.intellij.util.xmlb.Converter
import com.intellij.util.xmlb.annotations.OptionTag
import java.awt.Color

data class ModelineSettings(
        @OptionTag("backgroundColor", converter = ColorConverter::class)
        var backgroundColor: Color = Color.LIGHT_GRAY,

        @OptionTag("foregroundColor", converter = ColorConverter::class)
        var foregroundColor: Color = Color.BLACK
)

internal class ColorConverter : Converter<Color>() {
    override fun toString(value: Color) = value.rgb.toString()
    override fun fromString(value: String) = value.toIntOrNull()?.let(::Color)
}
