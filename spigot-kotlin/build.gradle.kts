plugins {
    kotlin("jvm")
    alias(spigots.plugins.spigot)
    alias(spigots.plugins.paperweight.userdev)
}

description = "A sample plugin"

repositories {
    mavenLocal()
    mavenCentral()
    spigotRepos {
        spigotmc()
        protocolLib()
        jitpack()
        papermc()
    }
}

dependencies {
    paperweight.paperDevBundle(spigots.versions.spigot.api)
    compileOnly(spigots.protocolLib)
    compileOnly(spigots.vault.api) { // instead of vault() for the dependency resolve by debug task 'prepareSpigotPlugins'.
        isTransitive = false // No want to import vault's internal dependencies.
    }
    compileOnlySpigot(commons.ahocorasick)
    testImplementation(platform(commons.junit.bom))
    testImplementation(commons.junit.jupiter)
    testRuntimeOnly(commons.junit.platform.launcher)
    testImplementation(kotlin("stdlib-jdk8"))
}

spigot {
    depend = listOf("ProtocolLib", "Vault")
    apiVersion = "1.21"
    load = "STARTUP"
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

tasks {
    assemble {
        dependsOn(reobfJar)
    }
}

debugSpigot {
    version = "1.21.10"
    eula = true
    jarFile = tasks.reobfJar.flatMap { it.outputJar }
}
