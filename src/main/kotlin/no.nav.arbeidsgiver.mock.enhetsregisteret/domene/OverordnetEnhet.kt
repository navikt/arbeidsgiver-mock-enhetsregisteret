package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.dto.OverordnetEnhetDTO

@Serializable
class OverordnetEnhetLenker(
    val self: Link,
    val overordnetEnhet: Link,
)

enum class Målform { Bokmål }

@Serializable
data class OverordnetEnhet(
    internal val organisasjonsnummer: String,
    private val navn: String,
    private val organisasjonsform: Organisasjonsform,
    private val hjemmeside: String,
    private val postadresse: Adresse,
    private val registreringsdatoEnhetsregisteret: String,
    private val registrertIMvaregisteret: Boolean,
    private val naeringskode1: Næringskode,
    private val antallAnsatte: Int,
    private val overordnetEnhet: String,
    private val forretningsadresse: Adresse,
    private val stiftelsesdato: String,
    private val institusjonellSektorkode: InstitusjonellSektorkode,
    private val registrertIForetaksregisteret: Boolean,
    private val registrertIStiftelsesregisteret: Boolean,
    private val registrertIFrivillighetsregisteret: Boolean,
    private val konkurs: Boolean,
    private val underAvvikling: Boolean,
    private val underTvangsavviklingEllerTvangsopplosning: Boolean,
    private val maalform: Målform,
) {
    fun tilDto() =
        OverordnetEnhetDTO(
            organisasjonsnummer = organisasjonsnummer,
            navn = navn,
            organisasjonsform = organisasjonsform,
            hjemmeside = hjemmeside,
            postadresse = postadresse,
            registreringsdatoEnhetsregisteret = registreringsdatoEnhetsregisteret,
            registrertIMvaregisteret = registrertIMvaregisteret,
            naeringskode1 = naeringskode1,
            antallAnsatte = antallAnsatte,
            overordnetEnhet = overordnetEnhet,
            forretningsadresse = forretningsadresse,
            stiftelsesdato = stiftelsesdato,
            institusjonellSektorkode = institusjonellSektorkode,
            registrertIForetaksregisteret = registrertIForetaksregisteret,
            registrertIStiftelsesregisteret = registrertIStiftelsesregisteret,
            registrertIFrivillighetsregisteret = registrertIFrivillighetsregisteret,
            konkurs = konkurs,
            underAvvikling = underAvvikling,
            underTvangsavviklingEllerTvangsopplosning = underTvangsavviklingEllerTvangsopplosning,
            maalform = maalform,
            _links = OverordnetEnhetLenker(
                self = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/$organisasjonsnummer",
                ),
                overordnetEnhet = Link(
                    href = "https://data.brreg.no/enhetsregisteret/api/enheter/$overordnetEnhet",
                ),
            ),
        )
}
