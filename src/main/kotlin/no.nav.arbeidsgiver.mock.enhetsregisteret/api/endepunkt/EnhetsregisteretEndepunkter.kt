package no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import no.nav.arbeidsgiver.mock.enhetsregisteret.EnhetsregisteretService
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet

val ENHETSREGISTERET_API_PATH = "/enhetsregisteret/api"

fun Route.enhetsregisteretEndepunkter(enhetsregisteretService: EnhetsregisteretService) {
    get("$ENHETSREGISTERET_API_PATH/underenheter/{orgnr}") {
        val orgnr = call.parameters["orgnr"] ?: return@get call.respond(HttpStatusCode.NotFound)
        val underenhet: Underenhet = enhetsregisteretService.hentForUnderenhet(orgnr)
        call.respond(underenhet.tilDto())
    }

    get("$ENHETSREGISTERET_API_PATH/enheter/{orgnr}") {
        val orgnr = call.parameters["orgnr"] ?: return@get call.respond(HttpStatusCode.NotFound)
        val overordnetEnhet: OverordnetEnhet = enhetsregisteretService.hentForOverordnetEnhet(orgnr)
        call.respond(overordnetEnhet.tilDto())
    }
}
