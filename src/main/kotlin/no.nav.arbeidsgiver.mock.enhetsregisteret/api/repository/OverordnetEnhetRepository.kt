package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Adresse
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.InstitusjonellSektorkode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Link
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Målform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform.Companion.forOrganisasjonsledd
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhetLenker
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log


class OverordnetEnhetRepository {

    fun hentForOverordnetEnhet(orgnr: String): OverordnetEnhet {
        log("hentForOverordnetEnhet").info("Henter opplysninger for overordnetEnhet '${orgnr}'")

        return OverordnetEnhet(
            organisasjonsnummer = "910562223",
            navn = "Kommune med kommunenr 1142",
            organisasjonsform = forOrganisasjonsledd(),
            hjemmeside = "www.test.com",
            postadresse = Adresse(
                land = "Norge",
                landkode = "NO",
                postnummer = "0130",
                poststed = "OSLO",
                adresse = arrayOf("Postboks 6944 St Olavs Plass"),
                kommune = "OSLO",
                kommunenummer = "0301"
            ),
            registreringsdatoEnhetsregisteret = "2012-12-12",
            registrertIMvaregisteret = false,
            naeringskode1 = Næringskode(
                beskrivelse = "Trygdeordninger underlagt offentlig forvaltning",
                kode = "84.300",
            ),
            antallAnsatte = 1621,
            overordnetEnhet = "991012206",
            forretningsadresse = Adresse(
                land = "Norge",
                landkode = "NO",
                postnummer = "0164",
                poststed = "OSLO",
                adresse = arrayOf("C. J. Hambros Plass 2A"),
                kommune = "OSLO",
                kommunenummer = "0301"
            ),
            stiftelsesdato = "2010-01-01",
            institusjonellSektorkode = InstitusjonellSektorkode(
                kode = "8300",
                beskrivelse = "Statsforvaltningen"
            ),
            registrertIForetaksregisteret = false,
            registrertIStiftelsesregisteret = false,
            registrertIFrivillighetsregisteret = false,
            konkurs = false,
            underAvvikling = false,
            underTvangsavviklingEllerTvangsopplosning = false,
            maalform = Målform.Bokmål,
            _links = OverordnetEnhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/910562223"
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/991012206"
                )
            )
        )
    }
}
