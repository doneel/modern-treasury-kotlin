@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.blocking

import com.fasterxml.jackson.annotation.JsonCreator
import com.moderntreasury.api.core.JsonField
import com.moderntreasury.api.core.JsonValue
import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import com.moderntreasury.api.models.RoutingDetail
import com.moderntreasury.api.models.RoutingDetailCreateParams
import com.moderntreasury.api.models.RoutingDetailDeleteParams
import com.moderntreasury.api.models.RoutingDetailListPage
import com.moderntreasury.api.models.RoutingDetailListParams
import com.moderntreasury.api.models.RoutingDetailRetrieveParams

interface RoutingDetailService {

    /** Create a routing detail for a single external account. */
    fun create(
        params: RoutingDetailCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RoutingDetail

    /** Get a single routing detail for a single internal or external account. */
    fun retrieve(
        params: RoutingDetailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RoutingDetail

    /** Get a list of routing details for a single internal or external account. */
    fun list(
        params: RoutingDetailListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RoutingDetailListPage

    /** Delete a routing detail for a single external account. */
    fun delete(
        params: RoutingDetailDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    class AccountsType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AccountsType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val EXTERNAL_ACCOUNTS = AccountsType(JsonField.of("external_accounts"))

            fun of(value: String) = AccountsType(JsonField.of(value))
        }

        enum class Known {
            EXTERNAL_ACCOUNTS,
        }

        enum class Value {
            EXTERNAL_ACCOUNTS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EXTERNAL_ACCOUNTS -> Value.EXTERNAL_ACCOUNTS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EXTERNAL_ACCOUNTS -> Known.EXTERNAL_ACCOUNTS
                else -> throw ModernTreasuryInvalidDataException("Unknown AccountsType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
