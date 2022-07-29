package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable

@Serializable
class InstitusjonellSektorkode (
    val kode: String,
    val beskrivelse: String
)
