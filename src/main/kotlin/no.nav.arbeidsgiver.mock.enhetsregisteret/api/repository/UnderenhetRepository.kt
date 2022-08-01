package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Link
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform.Companion.forBedrift
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.UnderenhetLenker
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.Default.Companion.UNDERENHET
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log


class UnderenhetRepository {

    fun hentForUnderenhet(orgnr: String): Underenhet {
        log("hentForUnderenhet").info("Henter opplysninger for underenhet '${orgnr}'")

        return UNDERENHETER.getOrDefault(orgnr, UNDERENHET)
    }

    companion object {

        val ORKANGER_OG_BREMNES = UNDERENHET.copy(
            organisasjonsnummer = "910562452",
            navn = "Orkanger og Bremnes barnehage",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                beskrivelse = "Barnehager",
                kode = "88.911",
            ),
            antallAnsatte = 143,
            overordnetEnhet = "910562223",
            _links = UnderenhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/underenheter/894834412"
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/910562223"
                )
            )
        )

        val SPISS_SJOKKERT_TIGER_AS_UNDERENHET = UNDERENHET.copy(
            organisasjonsnummer = "311874411",
            navn = "SPISS SJOKKERT TIGER AS",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem"
            ),
            antallAnsatte = 1621,
            overordnetEnhet = "310529915",
            _links = UnderenhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/underenheter/311874411"
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/310529915"
                )
            )
        )

        val UNDERENHETER = mapOf(
            "910562452" to ORKANGER_OG_BREMNES,
            "311874411" to SPISS_SJOKKERT_TIGER_AS_UNDERENHET
        )
    }
}
