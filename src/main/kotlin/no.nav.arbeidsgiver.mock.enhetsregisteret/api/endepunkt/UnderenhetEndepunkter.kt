package no.nav.arbeidsgiver.mock.enhetsregisteret.api.endepunkt

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import no.nav.arbeidsgiver.mock.enhetsregisteret.EnhetsregisteretService
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet

val ENHETSREGISTERET_API_PATH = "/enhetsregisteret/api"

fun Route.aktivitetEndepunkter(enhetsregisteretService: EnhetsregisteretService) {

    get("/$ENHETSREGISTERET_API_PATH/underenheter/{orgnr}") {
        val orgnr = call.parameters["orgnr"] ?: return@get call.respond(HttpStatusCode.NotFound)
        val underenhet: Underenhet = enhetsregisteretService.hentAktiviteterForVirksomhet(orgnr)
        call.respond(underenhet.tilDto())
    }
}
