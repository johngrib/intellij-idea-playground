plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.13.2"
}

group = "com.johngrib"
version = "0.0.0"

repositories {
    mavenCentral()
}

intellij {
    version.set("2022.1.4")
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("221")
        untilBuild.set("223.*")
    }
}
