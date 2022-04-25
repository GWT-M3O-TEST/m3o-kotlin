
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "translate"

object TranslateService {
    suspend fun text(name: String): TranslateTextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Text")) {
          body = TranslateTextRequest(name)
        }
    }
}
@Serializable
internal data class TranslateTextRequest({/// The contents to be translated
String? content, /// The string format, `text` or `html`
String? format, /// The model to use for translation, `nmt` or `base`,
/// See https://cloud.google.com/translate/docs/advanced/translating-text-v3#comparing-models for more information
String? model, /// Source language, format in ISO-639-1 codes
/// See https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes for more information
String? source, /// Target language, format in ISO-639-1 codes
/// See https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes for more information
String? target,})
@Serializable
data class TranslateTextResponse({/// The translated text
Translation? translation,})
@Serializable
internal data class TranslateTranslation({/// The model used in translation
String? model, /// The source of the query string
String? source, /// The translation result
String? text,})
