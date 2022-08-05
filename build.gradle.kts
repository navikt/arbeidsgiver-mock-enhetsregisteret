import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    application
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

application {
    mainClass.set("no.nav.arbeidsgiver.mock.enhetsregisteret.MainKt")
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(kotlin("test"))

    val ktorVersion = "2.0.3"
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("net.logstash.logback:logstash-logback-encoder:7.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.register<JavaExec>("generate-mock-files") {
    classpath = sourceSets.test.get().runtimeClasspath
    main = "no.nav.arbeidsgiver.mock.enhetsregisteret.GradleTasks"
}
