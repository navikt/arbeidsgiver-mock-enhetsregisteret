val kotestVerstion = "6.2.6"
val ktorVersion = "3.6.1"
val logbackClassicVersion = "1.6.6"
val logstashLogbackEncoderVersion = "9.0"

plugins {
    java
    application
    kotlin("jvm") version "2.4.21"
    kotlin("plugin.serialization") version "2.4.21"
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

    implementation("ch.qos.logback:logback-classic:$logbackClassicVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashLogbackEncoderVersion")

    constraints {
        implementation("tools.jackson.core:jackson-core") {
            version { require("3.2.4") }
            because("versjoner <= 3.1.0 har sårbarhet inkludert i logstash-logback-encoder:9.0")
        }
    }
    implementation("io.netty:netty-codec-http2") {
        version {
            require("4.2.20.Final")
        }
        because(
            "ktor-server-netty har sårbar versjon",
        )
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
