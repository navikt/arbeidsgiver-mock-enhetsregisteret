package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable

enum class OrganisasjonsformKode { AS, BEDR, ORGL }

@Serializable
class OrganisasjonsformLenker(
    val self: Link,
)

@Serializable
class Organisasjonsform(
    val kode: OrganisasjonsformKode,
    val beskrivelse: String,
    val _links: OrganisasjonsformLenker,
) {
    companion object {
        fun forBedrift() =
            Organisasjonsform(
                OrganisasjonsformKode.BEDR,
                "Bedrift",
                OrganisasjonsformLenker(
                    Link("https://data.brreg.no/enhetsregisteret/api/organisasjonsformer/BEDR"),
                ),
            )

        fun forOrganisasjonsledd() =
            Organisasjonsform(
                OrganisasjonsformKode.ORGL,
                "Organisasjonsledd",
                OrganisasjonsformLenker(
                    Link("https://data.brreg.no/enhetsregisteret/api/organisasjonsformer/ORGL"),
                ),
            )

        fun forAksjeselskap() =
            Organisasjonsform(
                OrganisasjonsformKode.AS,
                "Aksjeselskap",
                OrganisasjonsformLenker(
                    Link("https://data.brreg.no/enhetsregisteret/api/organisasjonsformer/AS"),
                ),
            )
    }
}
