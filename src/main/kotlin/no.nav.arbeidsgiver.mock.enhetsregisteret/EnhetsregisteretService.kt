package no.nav.arbeidsgiver.mock.enhetsregisteret

import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.UnderenhetRepository


class EnhetsregisteretService(private val underenhetRepository: UnderenhetRepository) {

    fun hentAktiviteterForVirksomhet(orgnr: String) =
        underenhetRepository.hentForUnderenhet(orgnr = orgnr)
}
