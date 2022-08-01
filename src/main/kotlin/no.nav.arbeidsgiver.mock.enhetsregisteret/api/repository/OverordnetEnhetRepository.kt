package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.InstitusjonellSektorkode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Link
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhetLenker
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.Default
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log


class OverordnetEnhetRepository {

    fun hentForOverordnetEnhet(orgnr: String): OverordnetEnhet {
        log("hentForOverordnetEnhet").info("Henter opplysninger for overordnetEnhet '${orgnr}'")

        return OVERORDNET_ENHETER.getOrDefault(orgnr, Default.OVERORDNET_ENHET)
    }

    companion object {

        val KOMMUNE_MED_KOMMUNENR_1142 = Default.OVERORDNET_ENHET.copy(
            organisasjonsnummer = "910562223",
            navn = "Kommune med kommunenr 1142",
            antallAnsatte = 1621,
            overordnetEnhet = "991012206",
            naeringskode1 = Næringskode(
                beskrivelse = "Trygdeordninger underlagt offentlig forvaltning",
                kode = "84.300",
            ),
            institusjonellSektorkode = InstitusjonellSektorkode(
                kode = "8300",
                beskrivelse = "Statsforvaltningen"
            ),
            _links = OverordnetEnhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/910562223"
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/991012206"
                )
            )
        )

        val SPISS_SJOKKERT_TIGER_AS = Default.OVERORDNET_ENHET.copy(
            organisasjonsnummer = "310529915",
            navn = "SPISS SJOKKERT TIGER AS",
            organisasjonsform = Organisasjonsform.forAksjeselskap(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem"
            ),
            antallAnsatte = 2550,
            overordnetEnhet = "999999999",
            _links = OverordnetEnhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/310529915"
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/999999999"
                )
            )
        )

        val OVERORDNET_ENHETER = mapOf(
            "910562223" to KOMMUNE_MED_KOMMUNENR_1142,
            "310529915" to SPISS_SJOKKERT_TIGER_AS
        )
    }
}
