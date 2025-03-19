package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform.Companion.forBedrift
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.Default.Companion.UNDERENHET
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log

class UnderenhetRepository {
    fun hentForUnderenhet(orgnr: String): Underenhet {
        log("hentForUnderenhet").info("Henter opplysninger for underenhet '$orgnr'")

        return UNDERENHETER.getOrDefault(
            orgnr,
            UNDERENHET.copy(
                organisasjonsnummer = orgnr,
            ),
        )
    }

    companion object {
        val KOMPLETT_MOTIVERT_TIGER = UNDERENHET.copy(
            organisasjonsnummer = "311263315",
            navn = "KOMPLETT MOTIVERT TIGER AS",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                beskrivelse = "Produksjon av annet yttertøy",
                kode = "14.130",
            ),
            antallAnsatte = 4,
            overordnetEnhet = OverordnetEnhetRepository.KOMPLETT_MOTIVERT_TIGER_AS.organisasjonsnummer,
        )

        val ORKANGER_OG_BREMNES = UNDERENHET.copy(
            organisasjonsnummer = "910562452",
            navn = "Orkanger og Bremnes barnehage",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                beskrivelse = "Barnehager",
                kode = "88.911",
            ),
            antallAnsatte = 143,
            overordnetEnhet = OverordnetEnhetRepository.KOMMUNE_MED_KOMMUNENR_1142.organisasjonsnummer,
        )

        val SPISS_SJOKKERT_TIGER_AS_UNDERENHET = UNDERENHET.copy(
            organisasjonsnummer = "311874411",
            navn = "SPISS SJOKKERT TIGER AS",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem",
            ),
            antallAnsatte = 1621,
            overordnetEnhet = OverordnetEnhetRepository.SPISS_SJOKKERT_TIGER_AS.organisasjonsnummer,
        )

        val TILLITSFULL_PEN_TIGER_AS_UNDERENHET = UNDERENHET.copy(
            organisasjonsnummer = "315829062",
            navn = "TILLITSFULL PEN TIGER AS",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem",
            ),
            antallAnsatte = 1621,
            overordnetEnhet = OverordnetEnhetRepository.TILLITSFULL_PEN_TIGER_AS.organisasjonsnummer,
        )

        val KVART_ALLSIDIG_TIGER_AS_UNDERENHET = UNDERENHET.copy(
            organisasjonsnummer = "312679671",
            navn = "KVART ALLSIDIG TIGER AS",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem",
            ),
            antallAnsatte = 1621,
            overordnetEnhet = OverordnetEnhetRepository.KVART_ALLSIDIG_TIGER_AS.organisasjonsnummer,
        )

        val INNBRINGENDE_LATTERMILD_APE_UNDERENHET = UNDERENHET.copy(
            organisasjonsnummer = "311545795",
            navn = "INNBRINGENDE LATTERMILD APE",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem",
            ),
            antallAnsatte = 1621,
            overordnetEnhet = OverordnetEnhetRepository.INNBRINGENDE_LATTERMILD_APE.organisasjonsnummer,
        )
        val ARENDAL_OG_BØNES_REVISJON = UNDERENHET.copy(
            organisasjonsnummer = "810993502",
            navn = "ARENDAL OG BØNES REVISJON",
            organisasjonsform = forBedrift(),
            naeringskode1 = Næringskode(
                kode = "87.101",
                beskrivelse = "Sykehjem",
            ),
            antallAnsatte = 1621,
            overordnetEnhet = OverordnetEnhetRepository.INNBRINGENDE_LATTERMILD_APE.organisasjonsnummer,
        )

        val UNDERENHETER = mapOf(
            KOMPLETT_MOTIVERT_TIGER.organisasjonsnummer to KOMPLETT_MOTIVERT_TIGER,
            ORKANGER_OG_BREMNES.organisasjonsnummer to ORKANGER_OG_BREMNES,
            SPISS_SJOKKERT_TIGER_AS_UNDERENHET.organisasjonsnummer to SPISS_SJOKKERT_TIGER_AS_UNDERENHET,
            TILLITSFULL_PEN_TIGER_AS_UNDERENHET.organisasjonsnummer to TILLITSFULL_PEN_TIGER_AS_UNDERENHET,
            INNBRINGENDE_LATTERMILD_APE_UNDERENHET.organisasjonsnummer to INNBRINGENDE_LATTERMILD_APE_UNDERENHET,
            KVART_ALLSIDIG_TIGER_AS_UNDERENHET.organisasjonsnummer to KVART_ALLSIDIG_TIGER_AS_UNDERENHET,
            ARENDAL_OG_BØNES_REVISJON.organisasjonsnummer to ARENDAL_OG_BØNES_REVISJON,
        )
    }
}
