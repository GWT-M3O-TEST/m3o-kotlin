
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "quran"

object QuranService {
    suspend fun chapters(name: String): QuranChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = QuranChaptersRequest(name)
        }
    }
    suspend fun search(name: String): QuranSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = QuranSearchRequest(name)
        }
    }
    suspend fun summary(name: String): QuranSummaryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Summary")) {
          body = QuranSummaryRequest(name)
        }
    }
    suspend fun verses(name: String): QuranVersesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Verses")) {
          body = QuranVersesRequest(name)
        }
    }
}
@Serializable
internal data class QuranChapter({/// The translated name
String? translated_name, /// The complex name of the chapter
String? complex_name, /// The id of the chapter as a number e.g 1
int? id, /// The simple name of the chapter
String? name, /// The pages from and to e.g 1, 1
List<int>? pages, /// Should the chapter start with bismillah
bool? prefix_bismillah, /// The order in which it was revealed
int? revelation_order, /// The arabic name of the chapter
String? arabic_name, /// The place of revelation
String? revelation_place, /// The number of verses in the chapter
int? verses,})
@Serializable
internal data class QuranChaptersRequest({/// Specify the language e.g en
String? language,})
@Serializable
data class QuranChaptersResponse({List<Chapter>? chapters,})
@Serializable
internal data class QuranInterpretation({/// The unique id of the interpretation
int? id, /// The source of the interpretation
String? source, /// The translated text
String? text,})
@Serializable
internal data class QuranResult({/// The verse key e.g 1:1
String? verse_key, /// The associated arabic text
String? text, /// The related translations to the text
List<Translation>? translations, /// The unique verse id across the Quran
int? verse_id,})
@Serializable
internal data class QuranSearchRequest({/// The language for translation
String? language, /// The number of results to return
int? limit, /// The pagination number
int? page, /// The query to ask
String? query,})
@Serializable
data class QuranSearchResponse({/// The current page
int? page, /// The question asked
String? query, /// The results for the query
List<Result>? results, /// The total pages
int? total_pages, /// The total results returned
int? total_results,})
@Serializable
internal data class QuranSummaryRequest({/// The chapter id e.g 1
int? chapter, /// Specify the language e.g en
String? language,})
@Serializable
data class QuranSummaryResponse({/// The source of the summary
String? source, /// The short summary for the chapter
String? summary, /// The full description for the chapter
String? text, /// The chapter id
int? chapter,})
@Serializable
internal data class QuranTranslation({/// The translated text
String? text, /// The unique id of the translation
int? id, /// The source of the translation
String? source,})
@Serializable
internal data class QuranVerse({/// The unique id of the verse in the whole book
int? id, /// The key of this verse (chapter:verse) e.g 1:1
String? key, /// The verse number in this chapter
int? number, /// The basic translation of the verse
String? translated_text, /// The alternative translations for the verse
List<Translation>? translations, /// The individual words within the verse (Ayah)
List<Word>? words, /// The interpretations of the verse
List<Interpretation>? interpretations, /// The page of the Quran this verse is on
int? page, /// The arabic text for this verse
String? text, /// The phonetic transliteration from arabic
String? transliteration,})
@Serializable
internal data class QuranVersesRequest({/// Return the individual words with the verses
bool? words, /// The chapter id to retrieve
int? chapter, /// Return the interpretation (tafsir)
bool? interpret, /// The language of translation
String? language, /// The verses per page
int? limit, /// The page number to request
int? page, /// Return alternate translations
bool? translate,})
@Serializable
data class QuranVersesResponse({/// The verses on the page
List<Verse>? verses, /// The chapter requested
int? chapter, /// The page requested
int? page, /// The total pages
int? total_pages,})
@Serializable
internal data class QuranWord({/// The character type e.g word, end
String? char_type, /// The id of the word within the verse
int? id, /// The transliteration text
String? transliteration, /// The QCF v2 font code
String? code, /// The line number
int? line, /// The page number
int? page, /// The position of the word
int? position, /// The arabic text for this word
String? text, /// The translated text
String? translation,})
