package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Adresse
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Link
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform.Companion.forBedrift
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OrganisasjonsformKode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OrganisasjonsformLenker
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.UnderenhetLenker
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log


class UnderenhetRepository {

    fun hentForUnderenhet(orgnr: String): Underenhet {
        log("hentForUnderenhet").info("Henter opplysninger for underenhet '${orgnr}'")

        return Underenhet(
            organisasjonsnummer = "910562452",
            navn = "Orkanger og Bremnes barnehage",
            organisasjonsform = forBedrift(),
            postadresse = Adresse(
                land = "Norge",
                landkode = "NO",
                postnummer = "0614",
                poststed = "OSLO",
                adresse = arrayOf("Postboks 325  Alnabru"),
                kommune = "OSLO",
                kommunenummer = "0301"
            ),
            registreringsdatoEnhetsregisteret = "2009-11-30",
            registrertIMvaregisteret = false,
            naeringskode1 = Næringskode(
                beskrivelse = "Barnehager",
                kode = "88.911",
            ),
            antallAnsatte = 143,
            overordnetEnhet = "910562223",
            oppstartsdato = "2010-01-01",
            datoEierskifte = "2013-01-01",
            beliggenhetsadresse = Adresse(
                land = "Norge",
                landkode = "NO",
                postnummer = "0663",
                poststed = "OSLO",
                adresse = arrayOf("Fredrik Selmers vei 2"),
                kommune = "OSLO",
                kommunenummer = "0301"
            ),
            _links = UnderenhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/underenheter/894834412"
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/910562223"
                )
            )
        )
    }
}
