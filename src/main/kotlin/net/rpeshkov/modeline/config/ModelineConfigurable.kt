package net.rpeshkov.modeline.config

import com.intellij.openapi.options.Configurable
import net.rpeshkov.modeline.config.ModelineConfig.Companion.settings

class ModelineConfigurable : Configurable {
    private val panel by lazy(::ModelineSettingsUi)

    override fun createComponent() = panel.root
    override fun getDisplayName() = "Modeline"

    override fun isModified(): Boolean {
        return panel.backgroundColor != settings.backgroundColor || panel.foregroundColor != settings.foregroundColor
    }

    override fun apply() {
        panel.backgroundColor?.let { settings.backgroundColor = it }
        panel.foregroundColor?.let { settings.foregroundColor = it }
    }

    override fun reset() = panel.reset(settings)
}