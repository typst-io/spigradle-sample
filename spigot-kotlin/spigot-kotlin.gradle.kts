import io.typst.spigradle.spigot.Load
import io.typst.spigradle.spigot.*
import io.typst.spigradle.*

plugins {
    kotlin("jvm") version "2.2.0"
    id("io.typst.spigradle") version "3.1.2"
}

group = "kr.entree"
version = "1.0-SNAPSHOT"

tasks.compileJava.get().options.encoding = "UTF-8"

repositories {
    mavenCentral()
    spigotmc()
    jitpack() // For vault
}

dependencies {
    implementation(kotlin("stdlib-jdk8")) // Maybe you need to apply the plugin 'shadowJar' for shading 'kotlin-stdlib'.
    compileOnly(spigot())
    compileOnly(protocolLib())
    compileOnly(vault()) { // instead of vault() for the dependency resolve by debug task 'prepareSpigotPlugins'.
        isTransitive = false // No want to import vault's internal dependencies.
    }
    testImplementation("junit:junit:4.12")
    testImplementation(kotlin("stdlib-jdk8"))
}

spigot {
    description.set("A sample plugin")
    depends = listOf("ProtocolLib", "Vault")
    load = Load.STARTUP
    commands {
        create("give") {
            aliases = listOf("giv", "i")
            description = "A give command."
            permission = "sample.give"
            permissionMessage = "You do not have the permission!"
        }
    }
    permissions {
        create("sample.give") {
            description = "Allows give command"
            defaults = "true"
        }
        create("sample.*") {
            description = "Wildcard permission"
            defaults = "op"
            children = mapOf("test.foo" to true)
        }
    }
}
