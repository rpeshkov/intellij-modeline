package net.rpeshkov.modeline.config

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "ModelineConfig", storages = [(Storage("\$APP_CONFIG\$/Modeline.xml"))])
class ModelineConfig: PersistentStateComponent<ModelineSettings> {
    private var modelineSettings = ModelineSettings()

    companion object {
        val settings get() = ServiceManager.getService(ModelineConfig::class.java).modelineSettings

        val backgroundColor get() = settings.backgroundColor
        val foregroundColor get() = settings.foregroundColor
    }

    override fun getState(): ModelineSettings = modelineSettings

    override fun loadState(state: ModelineSettings) {
        modelineSettings = state
    }
}