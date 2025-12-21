pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://repo.papermc.io/repository/maven-public/")
        gradlePluginPortal()
    }
    versionCatalogs {
        create("spigots") {
            from("io.typst:spigot-catalog:1.0.0")
        }
        create("bungees") {
            from("io.typst:bungee-catalog:1.0.0")
        }
        create("nukkits") {
            from("io.typst:nukkit-catalog:1.0.0")
        }
        create("commons") {
            from("io.typst:common-catalog:1.0.1")
        }
    }
}

rootProject.name = "spigradle-sample"

include("spigot-kotlin", "spigot", "bungeecord", "bungeecord-kotlin", "nukkit", "nukkit-kotlin")

rootProject.children.forEach { project ->
    project.name = "spigradle-sample-${project.name}"
}
