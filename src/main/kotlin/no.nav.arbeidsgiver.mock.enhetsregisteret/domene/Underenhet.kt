package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.dto.UnderenhetDTO

@Serializable
class UnderenhetLenker(
    val self: Link,
    val overordnetEnhet: Link,
)

data class Underenhet(
    private val organisasjonsnummer: String,
    private val navn: String,
    private val organisasjonsform: Organisasjonsform,
    private val postadresse: Adresse,
    private val registreringsdatoEnhetsregisteret: String,
    private val registrertIMvaregisteret: Boolean,
    private val naeringskode1: Næringskode,
    private val antallAnsatte: Int,
    private val overordnetEnhet: String,
    private val oppstartsdato: String,
    private val datoEierskifte: String,
    private val beliggenhetsadresse: Adresse,
    private val _links: UnderenhetLenker,
) {
    fun tilDto() = UnderenhetDTO(
        organisasjonsnummer = organisasjonsnummer,
        navn = navn,
        organisasjonsform = organisasjonsform,
        postadresse = postadresse,
        registreringsdatoEnhetsregisteret = registreringsdatoEnhetsregisteret,
        registrertIMvaregisteret = registrertIMvaregisteret,
        naeringskode1 = naeringskode1,
        antallAnsatte = antallAnsatte,
        overordnetEnhet = overordnetEnhet,
        oppstartsdato = oppstartsdato,
        datoEierskifte = datoEierskifte,
        beliggenhetsadresse = beliggenhetsadresse,
        _links = _links
    )
}
