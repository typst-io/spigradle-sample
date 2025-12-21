plugins {
    kotlin("jvm")
    id("io.typst.spigradle.paper")
}

repositories {
    mavenCentral()
    paperRepos {
        papermc()
    }
}

dependencies {
    compileOnly(spigots.paper.api)
}

paper {
    apiVersion = "1.21.8"
}

debugPaper {
    eula = true
    version = "1.21.8"
}