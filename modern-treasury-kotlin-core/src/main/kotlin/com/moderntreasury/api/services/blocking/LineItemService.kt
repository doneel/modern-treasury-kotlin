@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.blocking

import com.fasterxml.jackson.annotation.JsonCreator
import com.moderntreasury.api.core.JsonField
import com.moderntreasury.api.core.JsonValue
import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import com.moderntreasury.api.models.LineItem
import com.moderntreasury.api.models.LineItemListPage
import com.moderntreasury.api.models.LineItemListParams
import com.moderntreasury.api.models.LineItemRetrieveParams
import com.moderntreasury.api.models.LineItemUpdateParams

interface LineItemService {

    /** Get a single line item */
    fun retrieve(
        params: LineItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LineItem

    /** update line item */
    fun update(
        params: LineItemUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LineItem

    /** Get a list of line items */
    fun list(
        params: LineItemListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LineItemListPage

    class ItemizableType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ItemizableType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val EXPECTED_PAYMENTS = ItemizableType(JsonField.of("expected_payments"))

            val PAYMENT_ORDERS = ItemizableType(JsonField.of("payment_orders"))

            fun of(value: String) = ItemizableType(JsonField.of(value))
        }

        enum class Known {
            EXPECTED_PAYMENTS,
            PAYMENT_ORDERS,
        }

        enum class Value {
            EXPECTED_PAYMENTS,
            PAYMENT_ORDERS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EXPECTED_PAYMENTS -> Value.EXPECTED_PAYMENTS
                PAYMENT_ORDERS -> Value.PAYMENT_ORDERS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EXPECTED_PAYMENTS -> Known.EXPECTED_PAYMENTS
                PAYMENT_ORDERS -> Known.PAYMENT_ORDERS
                else -> throw ModernTreasuryInvalidDataException("Unknown ItemizableType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
