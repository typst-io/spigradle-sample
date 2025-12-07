import io.typst.spigradle.bungee.*

plugins {
    kotlin("jvm")
    alias(libs.plugins.spigradle.bungee)
}

group = "kr.entree"
version = "1.0-SNAPSHOT"

tasks.compileJava.get().options.encoding = "UTF-8"

repositories {
    mavenCentral()
    sonatype()
    minecraftLibraries()
}

dependencies {
    compileOnly(bungeecord())
    testImplementation("junit:junit:4.12")
}

bungee {
    description.set("A sample Bungeecord plugin")
    author = "Me"
    softDepends = listOf("DepPlugin", "DepPlugin2")
}
