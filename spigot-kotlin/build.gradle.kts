import io.typst.spigradle.spigot.Load
import io.typst.spigradle.spigot.*
import io.typst.spigradle.*

plugins {
    kotlin("jvm")
    alias(libs.plugins.spigradle.spigot)
}

description = "A sample plugin"

repositories {
    mavenCentral()
    spigotmc()
    jitpack() // For vault
}

dependencies {
    compileOnly(spigot("1.21.8"))
    compileOnly(protocolLib("5.4.0"))
    compileOnly(vault()) { // instead of vault() for the dependency resolve by debug task 'prepareSpigotPlugins'.
        isTransitive = false // No want to import vault's internal dependencies.
    }
    testImplementation("junit:junit:4.12")
    testImplementation(kotlin("stdlib-jdk8"))
}

spigot {
    depends = listOf("ProtocolLib", "Vault")
    apiVersion = "1.21"
    load = Load.STARTUP
    commands {
        register("give") {
            aliases = listOf("giv", "i")
            description = "A give command."
            permission = "sample.give"
            permissionMessage = "You do not have the permission!"
        }
    }
    permissions {
        register("sample.give") {
            description = "Allows give command"
            defaults = "true"
        }
        register("sample.*") {
            description = "Wildcard permission"
            defaults = "op"
            children = mapOf("test.foo" to true)
        }
    }
}

debugSpigot {
    version.set("1.21.8")
    eula.set(true)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}