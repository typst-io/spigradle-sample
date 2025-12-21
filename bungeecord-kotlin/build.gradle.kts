plugins {
    kotlin("jvm")
    alias(bungees.plugins.bungee)
}

group = "dev.entree"
version = "1.0-SNAPSHOT"

tasks.compileJava.get().options.encoding = "UTF-8"

repositories {
    mavenCentral()
    bungeeRepos {
        sonatype()
        minecraftLibraries()
    }
}

dependencies {
    compileOnly(bungees.bungeecord.api)
    testImplementation(platform(commons.junit.bom))
    testImplementation(commons.junit.jupiter)
    testRuntimeOnly(commons.junit.platform.launcher)
    testImplementation(kotlin("stdlib-jdk8"))
}

bungee {
    description.set("A sample Bungeecord plugin")
    author = "Me"
    softDepend = listOf("DepPlugin", "DepPlugin2")
}
