
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "evchargers"

object EvchargersService {
    suspend fun referenceData(name: String): EvchargersReferenceDataResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ReferenceData")) {
          body = EvchargersReferenceDataRequest(name)
        }
    }
    suspend fun search(name: String): EvchargersSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = EvchargersSearchRequest(name)
        }
    }
}
@Serializable
internal data class EvchargersAddress({/// Any comments about how to access the charger
String? access_comments, String? address_line_1, Country? country, String? postcode, String? state_or_province, String? title, String? address_line_2, String? country_id, String? lat_lng, Coordinates? location, String? town,})
@Serializable
internal data class EvchargersBoundingBox({Coordinates? bottom_left, Coordinates? top_right,})
@Serializable
internal data class EvchargersChargerType({String? comments, String? id, /// Is this 40KW+
bool? is_fast_charge_capable, String? title,})
@Serializable
internal data class EvchargersCheckinStatusType({String? title, String? id, bool? is_automated, bool? is_positive,})
@Serializable
internal data class EvchargersConnection({/// The level of charging power available
String? level_id, String? reference, /// The ID of the connection type
String? connection_type_id, /// The current
String? current, ChargerType? level, /// The power in KW
double? power, /// The voltage offered
double? voltage, /// The amps offered
double? amps, ConnectionType? connection_type,})
@Serializable
internal data class EvchargersConnectionType({bool? is_obsolete, String? title, String? formal_name, String? id, bool? is_discontinued,})
@Serializable
internal data class EvchargersCoordinates({double? latitude, double? longitude,})
@Serializable
internal data class EvchargersCountry({String? id, String? iso_code, String? title, String? continent_code,})
@Serializable
internal data class EvchargersCurrentType({String? description, String? id, String? title,})
@Serializable
internal data class EvchargersDataProvider({String? title, String? website, String? comments, DataProviderStatusType? data_provider_status_type, String? id, /// How is this data licensed
String? license,})
@Serializable
internal data class EvchargersDataProviderStatusType({String? id, bool? is_provider_enabled, String? title,})
@Serializable
internal data class EvchargersOperator({String? contact_email, /// Is this operator a private individual vs a company
bool? is_private_individual, String? phone_primary, String? phone_secondary, String? comments, String? fault_report_email, String? id, String? title, String? website,})
@Serializable
internal data class EvchargersPoi({/// The address
Address? address, /// The operator
Operator? operator, /// The type of usage
UsageType? usage_type, /// The type of usage for this charger point (is it public, membership required, etc)
String? usage_type_id, /// The connections available at this charge point
List<Connection>? connections, /// The cost of charging
String? cost, /// The ID of the data provider
String? data_provider_id, /// The ID of the charger
String? id, /// The number of charging points

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? num_points
	, /// The ID of the operator of the charger
String? operator_id,})
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse({/// The status of a submission
List<SubmissionStatusType>? submission_status_types, /// The different types of usage
List<UsageType>? usage_types, /// The types of user comment
List<UserCommentType>? user_comment_types, /// The types of checkin status
List<CheckinStatusType>? checkin_status_types, /// The types of connection
List<ConnectionType>? connection_types, /// The status of the charger
List<StatusType>? status_types, /// The providers of the charger data
List<DataProvider>? data_providers, /// The companies operating the chargers
List<Operator>? operators, /// The types of charger
List<ChargerType>? charger_types, /// The countries
List<Country>? countries, /// The types of current
List<CurrentType>? current_types,})
@Serializable
internal data class EvchargersSearchRequest({/// Minimum power in KW. Note: data not available for many chargers

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? min_power
	, /// Bounding box to search within (top left and bottom right coordinates)
BoundingBox? box, /// IDs of the connection type
List<String>? connection_types, /// Supported charging levels
List<String>? levels, /// Coordinates from which to begin search
Coordinates? location, /// Maximum number of results to return, defaults to 100

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? max_results
	, /// IDs of the the EV charger operator
List<String>? operators, /// Usage of the charge point (is it public, membership required, etc)
List<String>? usage_types, /// Country ID
String? country_id, /// Search distance from point in metres, defaults to 5000m

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? distance
	,})
@Serializable
data class EvchargersSearchResponse({List<Poi>? pois,})
@Serializable
internal data class EvchargersStatusType({String? id, bool? is_operational, String? title,})
@Serializable
internal data class EvchargersSubmissionStatusType({String? title, String? id, bool? is_live,})
@Serializable
internal data class EvchargersUsageType({String? title, String? id, bool? is_access_key_required, bool? is_membership_required, bool? is_pay_at_location,})
@Serializable
internal data class EvchargersUserCommentType({String? id, String? title,})
