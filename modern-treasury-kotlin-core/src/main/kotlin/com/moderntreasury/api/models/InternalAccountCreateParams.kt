package com.moderntreasury.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.moderntreasury.api.core.ExcludeMissing
import com.moderntreasury.api.core.JsonField
import com.moderntreasury.api.core.JsonValue
import com.moderntreasury.api.core.NoAutoDetect
import com.moderntreasury.api.core.toUnmodifiable
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import com.moderntreasury.api.models.*
import java.util.Objects

class InternalAccountCreateParams
constructor(
    private val connectionId: String,
    private val currency: Currency,
    private val name: String,
    private val partyName: String,
    private val counterpartyId: String?,
    private val parentAccountId: String?,
    private val partyAddress: PartyAddress?,
    private val vendorAttributes: VendorAttributes?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun connectionId(): String = connectionId

    fun currency(): Currency = currency

    fun name(): String = name

    fun partyName(): String = partyName

    fun counterpartyId(): String? = counterpartyId

    fun parentAccountId(): String? = parentAccountId

    fun partyAddress(): PartyAddress? = partyAddress

    fun vendorAttributes(): VendorAttributes? = vendorAttributes

    internal fun getBody(): InternalAccountCreateBody {
        return InternalAccountCreateBody(
            connectionId,
            currency,
            name,
            partyName,
            counterpartyId,
            parentAccountId,
            partyAddress,
            vendorAttributes,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = InternalAccountCreateBody.Builder::class)
    @NoAutoDetect
    class InternalAccountCreateBody
    internal constructor(
        private val connectionId: String?,
        private val currency: Currency?,
        private val name: String?,
        private val partyName: String?,
        private val counterpartyId: String?,
        private val parentAccountId: String?,
        private val partyAddress: PartyAddress?,
        private val vendorAttributes: VendorAttributes?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The identifier of the financial institution the account belongs to. */
        @JsonProperty("connection_id") fun connectionId(): String? = connectionId

        /** Either "USD" or "CAD". Internal accounts created at Increase only supports "USD". */
        @JsonProperty("currency") fun currency(): Currency? = currency

        /** The nickname of the account. */
        @JsonProperty("name") fun name(): String? = name

        /** The legal name of the entity which owns the account. */
        @JsonProperty("party_name") fun partyName(): String? = partyName

        /** The Counterparty associated to this account. */
        @JsonProperty("counterparty_id") fun counterpartyId(): String? = counterpartyId

        /** The parent internal account of this new account. */
        @JsonProperty("parent_account_id") fun parentAccountId(): String? = parentAccountId

        /** The address associated with the owner or null. */
        @JsonProperty("party_address") fun partyAddress(): PartyAddress? = partyAddress

        /**
         * A hash of vendor specific attributes that will be used when creating the account at the
         * vendor specified by the given connection.
         */
        @JsonProperty("vendor_attributes")
        fun vendorAttributes(): VendorAttributes? = vendorAttributes

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is InternalAccountCreateBody &&
                this.connectionId == other.connectionId &&
                this.currency == other.currency &&
                this.name == other.name &&
                this.partyName == other.partyName &&
                this.counterpartyId == other.counterpartyId &&
                this.parentAccountId == other.parentAccountId &&
                this.partyAddress == other.partyAddress &&
                this.vendorAttributes == other.vendorAttributes &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        connectionId,
                        currency,
                        name,
                        partyName,
                        counterpartyId,
                        parentAccountId,
                        partyAddress,
                        vendorAttributes,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "InternalAccountCreateBody{connectionId=$connectionId, currency=$currency, name=$name, partyName=$partyName, counterpartyId=$counterpartyId, parentAccountId=$parentAccountId, partyAddress=$partyAddress, vendorAttributes=$vendorAttributes, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var connectionId: String? = null
            private var currency: Currency? = null
            private var name: String? = null
            private var partyName: String? = null
            private var counterpartyId: String? = null
            private var parentAccountId: String? = null
            private var partyAddress: PartyAddress? = null
            private var vendorAttributes: VendorAttributes? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(internalAccountCreateBody: InternalAccountCreateBody) = apply {
                this.connectionId = internalAccountCreateBody.connectionId
                this.currency = internalAccountCreateBody.currency
                this.name = internalAccountCreateBody.name
                this.partyName = internalAccountCreateBody.partyName
                this.counterpartyId = internalAccountCreateBody.counterpartyId
                this.parentAccountId = internalAccountCreateBody.parentAccountId
                this.partyAddress = internalAccountCreateBody.partyAddress
                this.vendorAttributes = internalAccountCreateBody.vendorAttributes
                additionalProperties(internalAccountCreateBody.additionalProperties)
            }

            /** The identifier of the financial institution the account belongs to. */
            @JsonProperty("connection_id")
            fun connectionId(connectionId: String) = apply { this.connectionId = connectionId }

            /** Either "USD" or "CAD". Internal accounts created at Increase only supports "USD". */
            @JsonProperty("currency")
            fun currency(currency: Currency) = apply { this.currency = currency }

            /** The nickname of the account. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The legal name of the entity which owns the account. */
            @JsonProperty("party_name")
            fun partyName(partyName: String) = apply { this.partyName = partyName }

            /** The Counterparty associated to this account. */
            @JsonProperty("counterparty_id")
            fun counterpartyId(counterpartyId: String) = apply {
                this.counterpartyId = counterpartyId
            }

            /** The parent internal account of this new account. */
            @JsonProperty("parent_account_id")
            fun parentAccountId(parentAccountId: String) = apply {
                this.parentAccountId = parentAccountId
            }

            /** The address associated with the owner or null. */
            @JsonProperty("party_address")
            fun partyAddress(partyAddress: PartyAddress) = apply {
                this.partyAddress = partyAddress
            }

            /**
             * A hash of vendor specific attributes that will be used when creating the account at
             * the vendor specified by the given connection.
             */
            @JsonProperty("vendor_attributes")
            fun vendorAttributes(vendorAttributes: VendorAttributes) = apply {
                this.vendorAttributes = vendorAttributes
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): InternalAccountCreateBody =
                InternalAccountCreateBody(
                    checkNotNull(connectionId) { "`connectionId` is required but was not set" },
                    checkNotNull(currency) { "`currency` is required but was not set" },
                    checkNotNull(name) { "`name` is required but was not set" },
                    checkNotNull(partyName) { "`partyName` is required but was not set" },
                    counterpartyId,
                    parentAccountId,
                    partyAddress,
                    vendorAttributes,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InternalAccountCreateParams &&
            this.connectionId == other.connectionId &&
            this.currency == other.currency &&
            this.name == other.name &&
            this.partyName == other.partyName &&
            this.counterpartyId == other.counterpartyId &&
            this.parentAccountId == other.parentAccountId &&
            this.partyAddress == other.partyAddress &&
            this.vendorAttributes == other.vendorAttributes &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            connectionId,
            currency,
            name,
            partyName,
            counterpartyId,
            parentAccountId,
            partyAddress,
            vendorAttributes,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "InternalAccountCreateParams{connectionId=$connectionId, currency=$currency, name=$name, partyName=$partyName, counterpartyId=$counterpartyId, parentAccountId=$parentAccountId, partyAddress=$partyAddress, vendorAttributes=$vendorAttributes, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var connectionId: String? = null
        private var currency: Currency? = null
        private var name: String? = null
        private var partyName: String? = null
        private var counterpartyId: String? = null
        private var parentAccountId: String? = null
        private var partyAddress: PartyAddress? = null
        private var vendorAttributes: VendorAttributes? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(internalAccountCreateParams: InternalAccountCreateParams) = apply {
            this.connectionId = internalAccountCreateParams.connectionId
            this.currency = internalAccountCreateParams.currency
            this.name = internalAccountCreateParams.name
            this.partyName = internalAccountCreateParams.partyName
            this.counterpartyId = internalAccountCreateParams.counterpartyId
            this.parentAccountId = internalAccountCreateParams.parentAccountId
            this.partyAddress = internalAccountCreateParams.partyAddress
            this.vendorAttributes = internalAccountCreateParams.vendorAttributes
            additionalQueryParams(internalAccountCreateParams.additionalQueryParams)
            additionalHeaders(internalAccountCreateParams.additionalHeaders)
            additionalBodyProperties(internalAccountCreateParams.additionalBodyProperties)
        }

        /** The identifier of the financial institution the account belongs to. */
        fun connectionId(connectionId: String) = apply { this.connectionId = connectionId }

        /** Either "USD" or "CAD". Internal accounts created at Increase only supports "USD". */
        fun currency(currency: Currency) = apply { this.currency = currency }

        /** The nickname of the account. */
        fun name(name: String) = apply { this.name = name }

        /** The legal name of the entity which owns the account. */
        fun partyName(partyName: String) = apply { this.partyName = partyName }

        /** The Counterparty associated to this account. */
        fun counterpartyId(counterpartyId: String) = apply { this.counterpartyId = counterpartyId }

        /** The parent internal account of this new account. */
        fun parentAccountId(parentAccountId: String) = apply {
            this.parentAccountId = parentAccountId
        }

        /** The address associated with the owner or null. */
        fun partyAddress(partyAddress: PartyAddress) = apply { this.partyAddress = partyAddress }

        /**
         * A hash of vendor specific attributes that will be used when creating the account at the
         * vendor specified by the given connection.
         */
        fun vendorAttributes(vendorAttributes: VendorAttributes) = apply {
            this.vendorAttributes = vendorAttributes
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): InternalAccountCreateParams =
            InternalAccountCreateParams(
                checkNotNull(connectionId) { "`connectionId` is required but was not set" },
                checkNotNull(currency) { "`currency` is required but was not set" },
                checkNotNull(name) { "`name` is required but was not set" },
                checkNotNull(partyName) { "`partyName` is required but was not set" },
                counterpartyId,
                parentAccountId,
                partyAddress,
                vendorAttributes,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class Currency
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Currency && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val USD = Currency(JsonField.of("USD"))

            val CAD = Currency(JsonField.of("CAD"))

            fun of(value: String) = Currency(JsonField.of(value))
        }

        enum class Known {
            USD,
            CAD,
        }

        enum class Value {
            USD,
            CAD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                USD -> Value.USD
                CAD -> Value.CAD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                USD -> Known.USD
                CAD -> Known.CAD
                else -> throw ModernTreasuryInvalidDataException("Unknown Currency: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** The address associated with the owner or null. */
    @JsonDeserialize(builder = PartyAddress.Builder::class)
    @NoAutoDetect
    class PartyAddress
    private constructor(
        private val line1: String?,
        private val line2: String?,
        private val locality: String?,
        private val region: String?,
        private val postalCode: String?,
        private val country: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("line1") fun line1(): String? = line1

        @JsonProperty("line2") fun line2(): String? = line2

        /** Locality or City. */
        @JsonProperty("locality") fun locality(): String? = locality

        /** Region or State. */
        @JsonProperty("region") fun region(): String? = region

        /** The postal code of the address. */
        @JsonProperty("postal_code") fun postalCode(): String? = postalCode

        /** Country code conforms to [ISO 3166-1 alpha-2] */
        @JsonProperty("country") fun country(): String? = country

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PartyAddress &&
                this.line1 == other.line1 &&
                this.line2 == other.line2 &&
                this.locality == other.locality &&
                this.region == other.region &&
                this.postalCode == other.postalCode &&
                this.country == other.country &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        line1,
                        line2,
                        locality,
                        region,
                        postalCode,
                        country,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PartyAddress{line1=$line1, line2=$line2, locality=$locality, region=$region, postalCode=$postalCode, country=$country, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var line1: String? = null
            private var line2: String? = null
            private var locality: String? = null
            private var region: String? = null
            private var postalCode: String? = null
            private var country: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(partyAddress: PartyAddress) = apply {
                this.line1 = partyAddress.line1
                this.line2 = partyAddress.line2
                this.locality = partyAddress.locality
                this.region = partyAddress.region
                this.postalCode = partyAddress.postalCode
                this.country = partyAddress.country
                additionalProperties(partyAddress.additionalProperties)
            }

            @JsonProperty("line1") fun line1(line1: String) = apply { this.line1 = line1 }

            @JsonProperty("line2") fun line2(line2: String) = apply { this.line2 = line2 }

            /** Locality or City. */
            @JsonProperty("locality")
            fun locality(locality: String) = apply { this.locality = locality }

            /** Region or State. */
            @JsonProperty("region") fun region(region: String) = apply { this.region = region }

            /** The postal code of the address. */
            @JsonProperty("postal_code")
            fun postalCode(postalCode: String) = apply { this.postalCode = postalCode }

            /** Country code conforms to [ISO 3166-1 alpha-2] */
            @JsonProperty("country") fun country(country: String) = apply { this.country = country }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): PartyAddress =
                PartyAddress(
                    checkNotNull(line1) { "`line1` is required but was not set" },
                    line2,
                    checkNotNull(locality) { "`locality` is required but was not set" },
                    checkNotNull(region) { "`region` is required but was not set" },
                    checkNotNull(postalCode) { "`postalCode` is required but was not set" },
                    checkNotNull(country) { "`country` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    /**
     * A hash of vendor specific attributes that will be used when creating the account at the
     * vendor specified by the given connection.
     */
    @JsonDeserialize(builder = VendorAttributes.Builder::class)
    @NoAutoDetect
    class VendorAttributes
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is VendorAttributes &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() = "VendorAttributes{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(vendorAttributes: VendorAttributes) = apply {
                additionalProperties(vendorAttributes.additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): VendorAttributes = VendorAttributes(additionalProperties.toUnmodifiable())
        }
    }
}
