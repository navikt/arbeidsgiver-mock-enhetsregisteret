package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable

@Serializable
class Næringskode (
    val beskrivelse: String,
    val kode: String
)
