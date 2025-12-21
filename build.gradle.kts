plugins {
    `java-base`
    // Declaring all plugins here is the recommended approach. See: https://docs.gradle.org/current/userguide/plugins_intermediate.html#sec:subprojects_plugins_dsl
    alias(commons.plugins.ideaExt)
    alias(libs.plugins.kotlin.jvm) apply false
    alias(spigots.plugins.spigot) apply false
    alias(bungees.plugins.bungee) apply false
    alias(nukkits.plugins.nukkit) apply false
}

val javaVersion = providers.gradleProperty("java.version").map {
    JavaLanguageVersion.of(it)
}

allprojects {
    group = "dev.entree"
    version = "1.0.0"
}

subprojects {
    afterEvaluate {
        java {
            toolchain {
                languageVersion = javaVersion
            }
        }
    }
}