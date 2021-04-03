import org.jetbrains.intellij.tasks.PatchPluginXmlTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea apply true
    kotlin("jvm") version "1.4.30"
    id("org.jetbrains.intellij") version "0.7.2"
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }

    withType<PatchPluginXmlTask> {
        untilBuild("211.*")
    }
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
}

repositories {
    mavenCentral()
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "211.6693-EAP-CANDIDATE-SNAPSHOT"
    pluginName = "intellij-modeline"
    updateSinceUntilBuild = true
    setPlugins("java")
}

group = "net.rpeshkov"
version = "1.0-SNAPSHOT"
