package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.dto.UnderenhetDTO

@Serializable
class UnderenhetLenker(
    val self: Link,
    val overordnetEnhet: Link,
)

@Serializable
data class Underenhet(
    internal val organisasjonsnummer: String,
    private val navn: String,
    private val organisasjonsform: Organisasjonsform,
    private val postadresse: Adresse,
    private val registreringsdatoEnhetsregisteret: String,
    private val registrertIMvaregisteret: Boolean,
    private val naeringskode1: Næringskode?,
    private val antallAnsatte: Int,
    private val overordnetEnhet: String,
    private val oppstartsdato: String,
    private val datoEierskifte: String,
    private val beliggenhetsadresse: Adresse,
) {
    fun tilDto() =
        UnderenhetDTO(
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
            _links = UnderenhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/underenheter/$organisasjonsnummer",
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/$overordnetEnhet",
                ),
            ),
        )
}
