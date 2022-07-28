package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable

enum class OrganisasjonsformKode { BEDR, AS }

@Serializable
class OrganisasjonsformLenker (
    val self: Link
)

@Serializable
class Organisasjonsform (
    val kode: OrganisasjonsformKode,
    val beskrivelse: String,
    val _links: OrganisasjonsformLenker,
)
