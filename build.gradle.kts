val kotestVerstion = "6.1.11"
val ktorVersion = "3.4.2"
val nettyCodecHttp2Version = "4.2.12.Final"
val logbackClassicVersion = "1.5.32"
val logstashLogbackEncoderVersion = "9.0"

plugins {
    java
    application
    kotlin("jvm") version "2.3.20"
    kotlin("plugin.serialization") version "2.3.20"
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

    constraints {
        implementation("tools.jackson.core:jackson-core") {
            version { require("3.1.1") }
            because("versjoner <= 3.1.0 har sårbarhet. inkludert i logstash-logback-encoder:9.0")
        }
    }
}

kotlin {
    jvmToolchain(21)
}

tasks.register<JavaExec>("generate-mock-files") {
    classpath = sourceSets.test.get().runtimeClasspath
    mainClass.set("no.nav.arbeidsgiver.mock.enhetsregisteret.GradleTasks")
}

tasks {
    test {
        dependsOn(installDist)
    }
}
