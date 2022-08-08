package no.nav.arbeidsgiver.mock.enhetsregisteret.utils

import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Adresse
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.InstitusjonellSektorkode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Link
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Målform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform.Companion.forOrganisasjonsledd
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhetLenker
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.UnderenhetLenker

class Default {
    companion object {
        val DATO = "2010-01-01"
        val ADRESSE = Adresse(
            land = "Norge",
            landkode = "NO",
            postnummer = "0661",
            poststed = "OSLO",
            adresse = arrayOf("Default adresse"),
            kommune = "OSLO",
            kommunenummer = "0301"
        )
        val NÆRINGSKODE = Næringskode(
            beskrivelse = "Barnehager",
            kode = "88.911",
        )

        val UNDERENHET = Underenhet(
            organisasjonsnummer = "888888888",
            navn = "DEFAULT UNDERENHET",
            organisasjonsform = Organisasjonsform.forBedrift(),
            postadresse = ADRESSE,
            registreringsdatoEnhetsregisteret = DATO,
            registrertIMvaregisteret = false,
            naeringskode1 = NÆRINGSKODE,
            antallAnsatte = 143,
            overordnetEnhet = "999999999",
            oppstartsdato = DATO,
            datoEierskifte = DATO,
            beliggenhetsadresse = ADRESSE
        )

        val OVERORDNET_ENHET = OverordnetEnhet(
            organisasjonsnummer = "999999999",
            navn = "DEFAULT OVERORDNET ENHET",
            organisasjonsform = forOrganisasjonsledd(),
            hjemmeside = "www.test.com",
            postadresse = ADRESSE,
            registreringsdatoEnhetsregisteret = DATO,
            registrertIMvaregisteret = false,
            naeringskode1 = Næringskode(
                beskrivelse = "Trygdeordninger underlagt offentlig forvaltning",
                kode = "84.300",
            ),
            antallAnsatte = 1999,
            overordnetEnhet = "999999998",
            forretningsadresse = ADRESSE,
            stiftelsesdato = DATO,
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
            maalform = Målform.Bokmål
        )
    }
}
