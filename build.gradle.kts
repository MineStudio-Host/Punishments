plugins {
    kotlin("jvm") version "2.0.21"
}

group = "host.minestudio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains:annotations:26.0.1")

    implementation("net.minestom:minestom-snapshots:1058d88552")
    implementation("org.slf4j:slf4j-simple:2.0.16")
    implementation("net.kyori:adventure-text-minimessage:4.18.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}