package no.nav.arbeidsgiver.mock.enhetsregisteret

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt.aktivitetEndepunkter
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt.helseEndepunkter
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.UnderenhetRepository

fun main() {
    bootstrapServer()
}

fun bootstrapServer() {
    val enhetsregisteretService = EnhetsregisteretService(underenhetRepository = UnderenhetRepository())

    embeddedServer(factory = Netty, port = System.getenv("SERVER_PORT")?.toInt() ?: 8484 ) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            helseEndepunkter()
            aktivitetEndepunkter(enhetsregisteretService)
        }
    }.start(wait = true)
}

