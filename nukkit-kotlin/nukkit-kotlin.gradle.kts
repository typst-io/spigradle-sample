import io.typst.spigradle.spigot.Load
import io.typst.spigradle.nukkit.*

plugins {
    kotlin("jvm") version "2.2.0"
    id("io.typst.spigradle.nukkit") version "3.1.2"
}

group = "kr.entree"
version = "1.0-SNAPSHOT"

tasks.compileJava.get().options.encoding = "UTF-8"

repositories {
    mavenCentral()
    openCollabRelease()
    openCollabSnapshot()
}

dependencies {
    compileOnly(nukkit())
    implementation(kotlin("stdlib-jdk8")) // Maybe you need to apply the plugin 'shadowJar' for shading 'kotlin-stdlib'.
    testImplementation("junit:junit:4.12")
}

nukkit {
    description.set("A sample NukitX plugin")
    load = Load.STARTUP
    api = listOf("1.0.5")
    commands {
        create("give") {
            aliases = listOf("giv", "i")
            description = "A give command."
            permission = "sample.give"
            permissionMessage = "You do not have the permission."
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