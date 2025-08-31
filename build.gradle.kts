plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.shadow)
    alias(libs.plugins.runPaper)
}

group = "com.sysnote8"
version = "0.1.0-beta"
val targetJavaVersion = 21

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://repo.minebench.de/") {
        name = "minebench-repo"
    }
}

dependencies {
    // system
    compileOnly(libs.paperApi)
    implementation(libs.kotlinStdlib)

    // dependencies
    compileOnly(libs.kunectron)
}

kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks {
    runServer {
        minecraftVersion("1.21.8")
    }

    build {
        dependsOn("shadowJar")
    }

    processResources {
        filteringCharset = "UTF-8"

        val props =
            mapOf(
                "version" to version,
            )
        inputs.properties(props)

        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }
}
