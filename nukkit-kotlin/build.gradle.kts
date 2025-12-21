plugins {
    kotlin("jvm")
    alias(nukkits.plugins.nukkit)
}

repositories {
    mavenCentral()
    nukkitRepos {
        openCollabRelease()
        openCollabSnapshot()
    }
}

dependencies {
    compileOnly(nukkits.nukkitX)
    testImplementation(platform(commons.junit.bom))
    testImplementation(commons.junit.jupiter)
    testRuntimeOnly(commons.junit.platform.launcher)
    testImplementation(kotlin("stdlib-jdk8"))
}

nukkit {
    description.set("A sample NukitX plugin")
    load = "STARTUP"
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