package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.InstitusjonellSektorkode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.Default
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.Default.Companion.OVERORDNET_ENHET
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log


class OverordnetEnhetRepository {

    fun hentForOverordnetEnhet(orgnr: String): OverordnetEnhet {
        log("hentForOverordnetEnhet").info("Henter opplysninger for overordnetEnhet '${orgnr}'")

        return OVERORDNET_ENHETER.getOrDefault(orgnr, Default.OVERORDNET_ENHET)
    }

    companion object {

        val KOMMUNE_MED_KOMMUNENR_1142 = OVERORDNET_ENHET.copy(
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
            )
        )

        val SPISS_SJOKKERT_TIGER_AS = OVERORDNET_ENHET.copy(
            organisasjonsnummer = "310529915",
            navn = "SPISS SJOKKERT TIGER AS",
            organisasjonsform = Organisasjonsform.forAksjeselskap(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem"
            ),
            antallAnsatte = 2550,
            overordnetEnhet = "999999999"
        )

        val TILLITSFULL_PEN_TIGER_AS = OVERORDNET_ENHET.copy(
            organisasjonsnummer = "313068420",
            navn = "TILLITSFULL PEN TIGER AS",
            organisasjonsform = Organisasjonsform.forAksjeselskap(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem"
            ),
            antallAnsatte = 2550,
            overordnetEnhet = "999999999"
        )

        val KVART_ALLSIDIG_TIGER_AS = OVERORDNET_ENHET.copy(
            organisasjonsnummer = "312305755",
            navn = "KVART ALLSIDIG TIGER AS",
            organisasjonsform = Organisasjonsform.forAksjeselskap(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem"
            ),
            antallAnsatte = 2550,
            overordnetEnhet = "999999999"
        )

        val INNBRINGENDE_LATTERMILD_APE = OVERORDNET_ENHET.copy(
            organisasjonsnummer = "310721263",
            navn = "INNBRINGENDE LATTERMILD APE",
            organisasjonsform = Organisasjonsform.forAksjeselskap(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem"
            ),
            antallAnsatte = 2550,
            overordnetEnhet = "999999999"
        )

        val OVERORDNET_ENHETER = mapOf(
            KOMMUNE_MED_KOMMUNENR_1142.organisasjonsnummer to KOMMUNE_MED_KOMMUNENR_1142,
            SPISS_SJOKKERT_TIGER_AS.organisasjonsnummer to SPISS_SJOKKERT_TIGER_AS,
            TILLITSFULL_PEN_TIGER_AS.organisasjonsnummer to TILLITSFULL_PEN_TIGER_AS,
            KVART_ALLSIDIG_TIGER_AS.organisasjonsnummer to KVART_ALLSIDIG_TIGER_AS,
            INNBRINGENDE_LATTERMILD_APE.organisasjonsnummer to INNBRINGENDE_LATTERMILD_APE,
        )
    }
}
