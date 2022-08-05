@file:JvmName("GradleTasks")
package no.nav.arbeidsgiver.mock.enhetsregisteret

import kotlinx.serialization.json.Json
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.OverordnetEnhetRepository.Companion.OVERORDNET_ENHETER
import no.nav.arbeidsgiver.mock.enhetsregisteret.api.repository.UnderenhetRepository.Companion.UNDERENHETER
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.OverordnetEnhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.domene.Underenhet
import no.nav.arbeidsgiver.mock.enhetsregisteret.utils.log
import java.io.File

private val jsonFormatter = Json { prettyPrint = true }
private val PATH_TO_FILES = "./generated-mock-data"

fun main() {
    generateFiles()
}

fun generateFiles() {
    println("Generating mock files based on available mock data")
    UNDERENHETER.keys.forEach { generateJson(it, UNDERENHETER).let { jsonContent -> write("underenhet-${it}", jsonContent) } }
    OVERORDNET_ENHETER.keys.forEach { generateJsonForOverordnetEnhet(it, OVERORDNET_ENHETER).let { jsonContent -> write("overordnet_enhet-${it}", jsonContent) } }
    println("Done. Check files in the '${PATH_TO_FILES}' folder")
}

fun write(filename: String, content: String) {
    File("${PATH_TO_FILES}/${filename}.json").printWriter().use { out -> out.println(content) }
}


fun generateJson(orgnr: String, enheter: Map<String, Underenhet>): String {
    val underenhet = enheter.get(orgnr)
    return jsonFormatter.encodeToString(Underenhet.serializer(), underenhet!!)
}

fun generateJsonForOverordnetEnhet(orgnr: String, enheter: Map<String, OverordnetEnhet>): String {
    val overordnetEnhet = enheter.get(orgnr)
    return jsonFormatter.encodeToString(OverordnetEnhet.serializer(), overordnetEnhet!!)
}

