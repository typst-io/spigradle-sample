import io.typst.spigradle.bungee.*

plugins {
    kotlin("jvm") version "2.2.0"
    id("io.typst.spigradle.bungee") version "3.1.2"
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
    implementation(kotlin("stdlib-jdk8")) // Maybe you need to apply the plugin 'shadowJar' for shading 'kotlin-stdlib'.
    testImplementation("junit:junit:4.12")
}

bungee {
    description.set("A sample Bungeecord plugin")
    author = "Me"
    softDepends = listOf("DepPlugin", "DepPlugin2")
}
