package net.rpeshkov.modeline.config

import com.intellij.ui.ColorPanel
import com.intellij.ui.layout.panel
import java.awt.Color
import javax.swing.JPanel
import kotlin.reflect.KProperty

@Suppress("UsePropertyAccessSyntax")
internal class ModelineSettingsUi {
    private val backgroundColorPanel = ColorPanel()
    private val foregroundColorPanel = ColorPanel()

    internal val root: JPanel = panel {
        titledRow("Colors") {
            row("Background:") { backgroundColorPanel(pushX) }
            row("Foreground:") { foregroundColorPanel(pushX) }
        }
    }

    fun reset(settings: ModelineSettings) {
        backgroundColor = settings.backgroundColor
        foregroundColor = settings.foregroundColor
    }

    internal var backgroundColor by backgroundColorPanel
    internal var foregroundColor by foregroundColorPanel

    private operator fun ColorPanel.getValue(a: ModelineSettingsUi, p: KProperty<*>) = selectedColor
    private operator fun ColorPanel.setValue(a: ModelineSettingsUi, p: KProperty<*>, c: Color?) = setSelectedColor(c)
}