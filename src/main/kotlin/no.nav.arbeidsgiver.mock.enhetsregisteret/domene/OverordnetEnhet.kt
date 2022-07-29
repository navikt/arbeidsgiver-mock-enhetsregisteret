package no.nav.arbeidsgiver.mock.enhetsregisteret.domene

import kotlinx.serialization.Serializable
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.dto.OverordnetEnhetDTO

@Serializable
class OverordnetEnhetLenker(
    val self: Link,
    val overordnetEnhet: Link,
)

enum class Målform { Bokmål }

class OverordnetEnhet(
    private val organisasjonsnummer: String,
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
    private val _links: OverordnetEnhetLenker

) {
    fun tilDto() = OverordnetEnhetDTO(
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
        _links = _links
    )
}

/*
{
  "organisasjonsnummer": "910562223",
  "navn": "(devmock) )NAV ARBEID OG YTELSER",
  "organisasjonsform": {
    "kode": "ORGL",
    "beskrivelse": "Organisasjonsledd",
    "_links": {
      "self": {
        "href": "https://data.brreg.no/enhetsregisteret/api/organisasjonsformer/ORGL"
      }
    }
  },
  "hjemmeside": "www.nav.no",
  "postadresse": {
    "land": "Norge",
    "landkode": "NO",
    "postnummer": "0130",
    "poststed": "OSLO",
    "adresse": [
      "Postboks 6944 St Olavs Plass"
    ],
    "kommune": "OSLO",
    "kommunenummer": "0301"
  },
  "registreringsdatoEnhetsregisteret": "2012-12-12",
  "registrertIMvaregisteret": false,
  "naeringskode1": {
    "beskrivelse": "Trygdeordninger underlagt offentlig forvaltning",
    "kode": "84.300"
  },
  "antallAnsatte": 1621,
  "overordnetEnhet": "991012206",
  "forretningsadresse": {
    "land": "Norge",
    "landkode": "NO",
    "postnummer": "0164",
    "poststed": "OSLO",
    "adresse": [
      "C. J. Hambros Plass 2A"
    ],
    "kommune": "OSLO",
    "kommunenummer": "0301"
  },
  "stiftelsesdato": "2012-06-18",
  "institusjonellSektorkode": {
    "kode": "8300",
    "beskrivelse": "Statsforvaltningen"
  },
  "registrertIForetaksregisteret": false,
  "registrertIStiftelsesregisteret": false,
  "registrertIFrivillighetsregisteret": false,
  "konkurs": false,
  "underAvvikling": false,
  "underTvangsavviklingEllerTvangsopplosning": false,
  "maalform": "Bokmål",
  "_links": {
    "self": {
      "href": "https://data.brreg.no/enhetsregisteret/api/enheter/999263550"
    },
    "overordnetEnhet": {
      "href": "https://data.brreg.no/enhetsregisteret/api/enheter/991012206"
    }
  }
}
 */
