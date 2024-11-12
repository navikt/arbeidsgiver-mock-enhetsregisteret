package no.nav.arbeidsgiver.mock.enhetsregisteret.api.dto

import kotlinx.serialization.Serializable
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Adresse
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.InstitusjonellSektorkode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Målform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Næringskode
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Organisasjonsform
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhetLenker

@Serializable
data class OverordnetEnhetDTO(
    val organisasjonsnummer: String,
    val navn: String,
    val organisasjonsform: Organisasjonsform,
    val hjemmeside: String,
    val postadresse: Adresse,
    val registreringsdatoEnhetsregisteret: String,
    val registrertIMvaregisteret: Boolean,
    val naeringskode1: Næringskode,
    val antallAnsatte: Int,
    val overordnetEnhet: String,
    val forretningsadresse: Adresse,
    val stiftelsesdato: String,
    val institusjonellSektorkode: InstitusjonellSektorkode,
    val registrertIForetaksregisteret: Boolean,
    val registrertIStiftelsesregisteret: Boolean,
    val registrertIFrivillighetsregisteret: Boolean,
    val konkurs: Boolean,
    val underAvvikling: Boolean,
    val underTvangsavviklingEllerTvangsopplosning: Boolean,
    val maalform: Målform,
    val _links: OverordnetEnhetLenker,
)
