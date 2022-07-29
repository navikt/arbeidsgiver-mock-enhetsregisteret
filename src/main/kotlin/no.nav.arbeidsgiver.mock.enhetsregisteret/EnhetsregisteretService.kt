package no.nav.arbeidsgiver.mock.enhetsregisteret

import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.OverordnetEnhetRepository
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.UnderenhetRepository


class EnhetsregisteretService(
    private val overordnetEnhetRepository: OverordnetEnhetRepository,
    private val underenhetRepository: UnderenhetRepository,
) {

    fun hentForUnderenhet(orgnr: String) =
        underenhetRepository.hentForUnderenhet(orgnr = orgnr)

    fun hentForOverordnetEnhet(orgnr: String) =
        overordnetEnhetRepository.hentForOverordnetEnhet(orgnr = orgnr)
}
