plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.16.0"
    id("org.jetbrains.changelog") version "2.2.0"

    kotlin("kapt") version "1.9.20"
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.serialization") version "1.9.20"
}

group = "jp.s6n.idea"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

intellij {
    version.set("2023.2.3")
    type.set("IC")

    plugins.set(listOf(
        "com.jetbrains.sh",
        "org.jetbrains.plugins.yaml",
    ))
}

changelog {
    groups.empty()
    repositoryUrl = "https://github.com/siketyan/intellij-github-actions"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")
    implementation("org.yaml:snakeyaml:2.2")
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

sourceSets["main"].java.srcDirs("src/main/gen")

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("232")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
