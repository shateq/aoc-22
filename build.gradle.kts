plugins {
    kotlin("jvm") version "1.7.21"
    application
}

allprojects {
    this.plugins.apply("org.jetbrains.kotlin.jvm")
    this.plugins.apply("org.gradle.application")
    group = "shateq.kotlin"
    version = "1.0-SNAPSHOT"
    description = "My approach to adventofcode in 2022"

    repositories.mavenCentral()

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        processResources {
            filteringCharset = "UTF-8"
        }
    }

    application {
        mainClass.set("MainKt")
    }

    if (this.name != "common") {
        dependencies {
            implementation(project(":common"))
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}