
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
String? access_comments, String? lat_lng, String? state_or_province, String? address_line_1, String? address_line_2, Country? country, String? country_id, Coordinates? location, String? postcode, String? title, String? town,})
@Serializable
internal data class EvchargersBoundingBox({Coordinates? top_right, Coordinates? bottom_left,})
@Serializable
internal data class EvchargersChargerType({String? comments, String? id, /// Is this 40KW+
bool? is_fast_charge_capable, String? title,})
@Serializable
internal data class EvchargersCheckinStatusType({String? id, bool? is_automated, bool? is_positive, String? title,})
@Serializable
internal data class EvchargersConnection({ConnectionType? connection_type, /// The ID of the connection type
String? connection_type_id, /// The power in KW
double? power, String? reference, /// The amps offered
double? amps, /// The current
String? current, ChargerType? level, /// The level of charging power available
String? level_id, /// The voltage offered
double? voltage,})
@Serializable
internal data class EvchargersConnectionType({String? id, bool? is_discontinued, bool? is_obsolete, String? title, String? formal_name,})
@Serializable
internal data class EvchargersCoordinates({double? latitude, double? longitude,})
@Serializable
internal data class EvchargersCountry({String? continent_code, String? id, String? iso_code, String? title,})
@Serializable
internal data class EvchargersCurrentType({String? description, String? id, String? title,})
@Serializable
internal data class EvchargersDataProvider({String? comments, DataProviderStatusType? data_provider_status_type, String? id, /// How is this data licensed
String? license, String? title, String? website,})
@Serializable
internal data class EvchargersDataProviderStatusType({String? id, bool? is_provider_enabled, String? title,})
@Serializable
internal data class EvchargersOperator({String? id, String? phone_secondary, String? title, String? website, String? contact_email, String? fault_report_email, String? phone_primary, String? comments, /// Is this operator a private individual vs a company
bool? is_private_individual,})
@Serializable
internal data class EvchargersPoi({/// The connections available at this charge point
List<Connection>? connections, /// The cost of charging
String? cost, /// The ID of the data provider
String? data_provider_id, /// The ID of the charger
String? id, /// The number of charging points

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? num_points
	, /// The operator
Operator? operator, /// The type of usage
UsageType? usage_type, /// The type of usage for this charger point (is it public, membership required, etc)
String? usage_type_id, /// The address
Address? address, /// The ID of the operator of the charger
String? operator_id,})
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse({/// The countries
List<Country>? countries, /// The companies operating the chargers
List<Operator>? operators, /// The status of a submission
List<SubmissionStatusType>? submission_status_types, /// The different types of usage
List<UsageType>? usage_types, /// The types of user comment
List<UserCommentType>? user_comment_types, /// The types of charger
List<ChargerType>? charger_types, /// The types of connection
List<ConnectionType>? connection_types, /// The types of current
List<CurrentType>? current_types, /// The providers of the charger data
List<DataProvider>? data_providers, /// The status of the charger
List<StatusType>? status_types, /// The types of checkin status
List<CheckinStatusType>? checkin_status_types,})
@Serializable
internal data class EvchargersSearchRequest({/// IDs of the connection type
List<String>? connection_types, /// Supported charging levels
List<String>? levels, /// Minimum power in KW. Note: data not available for many chargers

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? min_power
	, /// Usage of the charge point (is it public, membership required, etc)
List<String>? usage_types, /// IDs of the the EV charger operator
List<String>? operators, /// Bounding box to search within (top left and bottom right coordinates)
BoundingBox? box, /// Country ID
String? country_id, /// Search distance from point in metres, defaults to 5000m

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? distance
	, /// Coordinates from which to begin search
Coordinates? location, /// Maximum number of results to return, defaults to 100

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? max_results
	,})
@Serializable
data class EvchargersSearchResponse({List<Poi>? pois,})
@Serializable
internal data class EvchargersStatusType({String? id, bool? is_operational, String? title,})
@Serializable
internal data class EvchargersSubmissionStatusType({String? id, bool? is_live, String? title,})
@Serializable
internal data class EvchargersUsageType({String? id, bool? is_access_key_required, bool? is_membership_required, bool? is_pay_at_location, String? title,})
@Serializable
internal data class EvchargersUserCommentType({String? id, String? title,})
