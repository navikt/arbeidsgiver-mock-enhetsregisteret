package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable

@Serializable
class Adresse(
    val land: String,
    val landkode: String,
    val postnummer: String,
    val poststed: String,
    val adresse: Array<String>,
    val kommune: String,
    val kommunenummer: String,
)
