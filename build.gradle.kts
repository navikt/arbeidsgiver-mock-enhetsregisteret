val kotestVerstion = "6.1.0"
val ktorVersion = "3.3.3"
val nettyCodecHttp2Version = "4.2.9.Final"
val logbackClassicVersion = "1.5.25"
val logstashLogbackEncoderVersion = "9.0"

plugins {
    java
    application
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.serialization") version "2.2.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
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

    testImplementation("io.kotest:kotest-assertions-core:$kotestVerstion")

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.netty:netty-codec-http2:$nettyCodecHttp2Version")

    implementation("ch.qos.logback:logback-classic:$logbackClassicVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashLogbackEncoderVersion")
}

kotlin {
    jvmToolchain(21)
}

tasks.register<JavaExec>("generate-mock-files") {
    classpath = sourceSets.test.get().runtimeClasspath
    mainClass.set("no.nav.arbeidsgiver.mock.enhetsregisteret.GradleTasks")
}
