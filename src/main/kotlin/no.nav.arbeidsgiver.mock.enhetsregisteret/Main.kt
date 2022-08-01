package no.nav.arbeidsgiver.mock.enhetsregisteret

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt.enhetsregisteretEndepunkter
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt.helseEndepunkter
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.OverordnetEnhetRepository
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.UnderenhetRepository
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log

fun main() {
    bootstrapServer()
}

fun bootstrapServer() {
    val enhetsregisteretService = EnhetsregisteretService(
        overordnetEnhetRepository = OverordnetEnhetRepository(),
        underenhetRepository = UnderenhetRepository()
    )
    val port = System.getenv("SERVER_PORT")?.toInt() ?: 8080

    embeddedServer(factory = Netty, port = port) {
        log("bootstrapServer").info("Starter applikasjon on port '${port}'")
        install(ContentNegotiation) {
            json()
        }
        routing {
            helseEndepunkter()
            enhetsregisteretEndepunkter(enhetsregisteretService)
        }
    }.start(wait = true)
}

