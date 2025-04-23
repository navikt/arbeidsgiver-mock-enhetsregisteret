package no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class UnderenhetRepositoryTest {
    @Test
    fun `Skal hente mock underenhet fra test dataset`() {
        val result = UnderenhetRepository().hentForUnderenhet("311545795").tilDto()

        result.navn shouldBe "INNBRINGENDE LATTERMILD APE"
        result.organisasjonsnummer shouldBe "311545795"
    }

    @Test
    fun `Noen underenheter har ikke næringskode`() {
        val result = UnderenhetRepository().hentForUnderenhet("314620127").tilDto()

        result.navn shouldBe "AUTONOM VIS FJELLREV"
        result.organisasjonsnummer shouldBe "314620127"
        result.naeringskode1 shouldBe null
    }

    @Test
    fun `Dersom ingen underenhet er funnet skal det returneres en default underenhet med samme orgnr som er i request parameter`() {
        UnderenhetRepository().hentForUnderenhet("000000000").organisasjonsnummer shouldBe "000000000"
    }
}
