package no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.helseEndepunkter() {
    get("/internal/isAlive") {
        call.respond("OK")
    }
    get("/internal/isReady") {
        call.respond("OK")
    }
}
