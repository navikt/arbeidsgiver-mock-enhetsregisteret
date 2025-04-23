package no.nav.arbeidsgiver.mock.enhetsregisteret.api.dto

import kotlinx.serialization.Serializable
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Adresse
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.UnderenhetLenker

@Serializable
data class UnderenhetDTO(
    val organisasjonsnummer: String,
    val navn: String,
    val organisasjonsform: Organisasjonsform,
    val postadresse: Adresse,
    val registreringsdatoEnhetsregisteret: String,
    val registrertIMvaregisteret: Boolean,
    val naeringskode1: Næringskode? = null,
    val antallAnsatte: Int,
    val overordnetEnhet: String,
    val oppstartsdato: String,
    val datoEierskifte: String,
    val beliggenhetsadresse: Adresse,
    val _links: UnderenhetLenker,
)
