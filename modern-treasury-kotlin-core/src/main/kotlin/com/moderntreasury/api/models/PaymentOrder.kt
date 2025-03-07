package com.moderntreasury.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.moderntreasury.api.core.ExcludeMissing
import com.moderntreasury.api.core.JsonField
import com.moderntreasury.api.core.JsonMissing
import com.moderntreasury.api.core.JsonValue
import com.moderntreasury.api.core.NoAutoDetect
import com.moderntreasury.api.core.toUnmodifiable
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Objects

@JsonDeserialize(builder = PaymentOrder.Builder::class)
@NoAutoDetect
class PaymentOrder
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val liveMode: JsonField<Boolean>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val type: JsonField<PaymentOrderType>,
    private val subtype: JsonField<PaymentOrderSubtype>,
    private val amount: JsonField<Long>,
    private val direction: JsonField<Direction>,
    private val priority: JsonField<Priority>,
    private val originatingAccountId: JsonField<String>,
    private val receivingAccountId: JsonField<String>,
    private val accounting: JsonField<Accounting>,
    private val accountingCategoryId: JsonField<String>,
    private val accountingLedgerClassId: JsonField<String>,
    private val currency: JsonField<Currency>,
    private val effectiveDate: JsonField<LocalDate>,
    private val description: JsonField<String>,
    private val statementDescriptor: JsonField<String>,
    private val remittanceInformation: JsonField<String>,
    private val purpose: JsonField<String>,
    private val metadata: JsonField<Metadata>,
    private val chargeBearer: JsonField<ChargeBearer>,
    private val foreignExchangeIndicator: JsonField<ForeignExchangeIndicator>,
    private val foreignExchangeContract: JsonField<String>,
    private val nsfProtected: JsonField<Boolean>,
    private val originatingPartyName: JsonField<String>,
    private val ultimateOriginatingPartyName: JsonField<String>,
    private val ultimateOriginatingPartyIdentifier: JsonField<String>,
    private val ultimateReceivingPartyName: JsonField<String>,
    private val ultimateReceivingPartyIdentifier: JsonField<String>,
    private val sendRemittanceAdvice: JsonField<Boolean>,
    private val expiresAt: JsonField<OffsetDateTime>,
    private val status: JsonField<Status>,
    private val receivingAccountType: JsonField<ReceivingAccountType>,
    private val counterpartyId: JsonField<String>,
    private val transactionIds: JsonField<List<String>>,
    private val ledgerTransactionId: JsonField<String>,
    private val currentReturn: JsonField<ReturnObject>,
    private val transactionMonitoringEnabled: JsonField<Boolean>,
    private val complianceRuleMetadata: JsonField<ComplianceRuleMetadata>,
    private val referenceNumbers: JsonField<List<PaymentReference>>,
    private val vendorFailureReason: JsonField<String>,
    private val decisionId: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun id(): String = id.getRequired("id")

    fun object_(): String = object_.getRequired("object")

    /**
     * This field will be true if this object exists in the live environment or false if it exists
     * in the test environment.
     */
    fun liveMode(): Boolean = liveMode.getRequired("live_mode")

    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * One of `ach`, `eft`, `wire`, `check`, `sen`, `book`, `rtp`, `sepa`, `bacs`, `au_becs`,
     * `interac`, `signet`, `provexchange`.
     */
    fun type(): PaymentOrderType = type.getRequired("type")

    /**
     * An additional layer of classification for the type of payment order you are doing. This field
     * is only used for `ach` payment orders currently. For `ach` payment orders, the `subtype`
     * represents the SEC code. We currently support `CCD`, `PPD`, `IAT`, `CTX`, `WEB`, `CIE`, and
     * `TEL`.
     */
    fun subtype(): PaymentOrderSubtype? = subtype.getNullable("subtype")

    /**
     * Value in specified currency's smallest unit. e.g. $10 would be represented as 1000 (cents).
     * For RTP, the maximum amount allowed by the network is $100,000.
     */
    fun amount(): Long = amount.getRequired("amount")

    /**
     * One of `credit`, `debit`. Describes the direction money is flowing in the transaction. A
     * `credit` moves money from your account to someone else's. A `debit` pulls money from someone
     * else's account to your own. Note that wire, rtp, and check payments will always be `credit`.
     */
    fun direction(): Direction = direction.getRequired("direction")

    /**
     * Either `normal` or `high`. For ACH and EFT payments, `high` represents a same-day ACH or EFT
     * transfer, respectively. For check payments, `high` can mean an overnight check rather than
     * standard mail.
     */
    fun priority(): Priority = priority.getRequired("priority")

    /** The ID of one of your organization's internal accounts. */
    fun originatingAccountId(): String = originatingAccountId.getRequired("originating_account_id")

    /** The receiving account ID. Can be an `external_account` or `internal_account`. */
    fun receivingAccountId(): String = receivingAccountId.getRequired("receiving_account_id")

    fun accounting(): Accounting = accounting.getRequired("accounting")

    /**
     * The ID of one of your accounting categories. Note that these will only be accessible if your
     * accounting system has been connected.
     */
    fun accountingCategoryId(): String? = accountingCategoryId.getNullable("accounting_category_id")

    /**
     * The ID of one of your accounting ledger classes. Note that these will only be accessible if
     * your accounting system has been connected.
     */
    fun accountingLedgerClassId(): String? =
        accountingLedgerClassId.getNullable("accounting_ledger_class_id")

    /** Defaults to the currency of the originating account. */
    fun currency(): Currency? = currency.getNullable("currency")

    /**
     * Date transactions are to be posted to the participants' account. Defaults to the current
     * business day or the next business day if the current day is a bank holiday or weekend.
     * Format: yyyy-mm-dd.
     */
    fun effectiveDate(): LocalDate = effectiveDate.getRequired("effective_date")

    /** An optional description for internal use. */
    fun description(): String? = description.getNullable("description")

    /**
     * An optional descriptor which will appear in the receiver's statement. For `check` payments
     * this field will be used as the memo line. For `ach` the maximum length is 10 characters. Note
     * that for ACH payments, the name on your bank account will be included automatically by the
     * bank, so you can use the characters for other useful information. For `eft` the maximum
     * length is 15 characters.
     */
    fun statementDescriptor(): String? = statementDescriptor.getNullable("statement_descriptor")

    /**
     * For `ach`, this field will be passed through on an addenda record. For `wire` payments the
     * field will be passed through as the "Originator to Beneficiary Information", also known as
     * OBI or Fedwire tag 6000.
     */
    fun remittanceInformation(): String? =
        remittanceInformation.getNullable("remittance_information")

    /**
     * For `wire`, this is usually the purpose which is transmitted via the "InstrForDbtrAgt" field
     * in the ISO20022 file. If you are using Currencycloud, this is the `payment.purpose_code`
     * field. For `eft`, this field is the 3 digit CPA Code that will be attached to the payment.
     */
    fun purpose(): String? = purpose.getNullable("purpose")

    /** Additional data represented as key-value pairs. Both the key and value must be strings. */
    fun metadata(): Metadata = metadata.getRequired("metadata")

    /**
     * The party that will pay the fees for the payment order. Only applies to wire payment orders.
     * Can be one of shared, sender, or receiver, which correspond respectively with the SWIFT 71A
     * values `SHA`, `OUR`, `BEN`.
     */
    fun chargeBearer(): ChargeBearer? = chargeBearer.getNullable("charge_bearer")

    /**
     * Indicates the type of FX transfer to initiate, can be either `variable_to_fixed`,
     * `fixed_to_variable`, or `null` if the payment order currency matches the originating account
     * currency.
     */
    fun foreignExchangeIndicator(): ForeignExchangeIndicator? =
        foreignExchangeIndicator.getNullable("foreign_exchange_indicator")

    /**
     * If present, indicates a specific foreign exchange contract number that has been generated by
     * your financial institution.
     */
    fun foreignExchangeContract(): String? =
        foreignExchangeContract.getNullable("foreign_exchange_contract")

    /**
     * A boolean to determine if NSF Protection is enabled for this payment order. Note that this
     * setting must also be turned on in your organization settings page.
     */
    fun nsfProtected(): Boolean = nsfProtected.getRequired("nsf_protected")

    /**
     * If present, this will replace your default company name on receiver's bank statement. This
     * field can only be used for ACH payments currently. For ACH, only the first 16 characters of
     * this string will be used. Any additional characters will be truncated.
     */
    fun originatingPartyName(): String? = originatingPartyName.getNullable("originating_party_name")

    /** Name of the ultimate originator of the payment order. */
    fun ultimateOriginatingPartyName(): String? =
        ultimateOriginatingPartyName.getNullable("ultimate_originating_party_name")

    /** Identifier of the ultimate originator of the payment order. */
    fun ultimateOriginatingPartyIdentifier(): String? =
        ultimateOriginatingPartyIdentifier.getNullable("ultimate_originating_party_identifier")

    fun ultimateReceivingPartyName(): String? =
        ultimateReceivingPartyName.getNullable("ultimate_receiving_party_name")

    fun ultimateReceivingPartyIdentifier(): String? =
        ultimateReceivingPartyIdentifier.getNullable("ultimate_receiving_party_identifier")

    /**
     * Send an email to the counterparty when the payment order is sent to the bank. If `null`,
     * `send_remittance_advice` on the Counterparty is used.
     */
    fun sendRemittanceAdvice(): Boolean? =
        sendRemittanceAdvice.getNullable("send_remittance_advice")

    /** RFP payments require an expires_at. This value must be past the effective_date. */
    fun expiresAt(): OffsetDateTime? = expiresAt.getNullable("expires_at")

    /** The current status of the payment order. */
    fun status(): Status = status.getRequired("status")

    fun receivingAccountType(): ReceivingAccountType =
        receivingAccountType.getRequired("receiving_account_type")

    /**
     * If the payment order is tied to a specific Counterparty, their id will appear, otherwise
     * `null`.
     */
    fun counterpartyId(): String? = counterpartyId.getNullable("counterparty_id")

    /**
     * The IDs of all the transactions associated to this payment order. Usually, you will only have
     * a single transaction ID. However, if a payment order initially results in a Return, but gets
     * redrafted and is later successfully completed, it can have many transactions.
     */
    fun transactionIds(): List<String> = transactionIds.getRequired("transaction_ids")

    /** The ID of the ledger transaction linked to the payment order. */
    fun ledgerTransactionId(): String? = ledgerTransactionId.getNullable("ledger_transaction_id")

    /** If the payment order's status is `returned`, this will include the return object's data. */
    fun currentReturn(): ReturnObject? = currentReturn.getNullable("current_return")

    /** A flag that determines whether a payment order should go through transaction monitoring. */
    fun transactionMonitoringEnabled(): Boolean =
        transactionMonitoringEnabled.getRequired("transaction_monitoring_enabled")

    /**
     * Custom key-value pair for usage in compliance rules. Please contact support before making
     * changes to this field.
     */
    fun complianceRuleMetadata(): ComplianceRuleMetadata? =
        complianceRuleMetadata.getNullable("compliance_rule_metadata")

    fun referenceNumbers(): List<PaymentReference> =
        referenceNumbers.getRequired("reference_numbers")

    /**
     * This field will be populated if a vendor (e.g. Currencycloud) failure occurs. Logic shouldn't
     * be built on its value as it is free-form.
     */
    fun vendorFailureReason(): String? = vendorFailureReason.getNullable("vendor_failure_reason")

    /**
     * The ID of the compliance decision for the payment order, if transaction monitoring is
     * enabled.
     */
    fun decisionId(): String? = decisionId.getNullable("decision_id")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /**
     * This field will be true if this object exists in the live environment or false if it exists
     * in the test environment.
     */
    @JsonProperty("live_mode") @ExcludeMissing fun _liveMode() = liveMode

    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt() = updatedAt

    /**
     * One of `ach`, `eft`, `wire`, `check`, `sen`, `book`, `rtp`, `sepa`, `bacs`, `au_becs`,
     * `interac`, `signet`, `provexchange`.
     */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /**
     * An additional layer of classification for the type of payment order you are doing. This field
     * is only used for `ach` payment orders currently. For `ach` payment orders, the `subtype`
     * represents the SEC code. We currently support `CCD`, `PPD`, `IAT`, `CTX`, `WEB`, `CIE`, and
     * `TEL`.
     */
    @JsonProperty("subtype") @ExcludeMissing fun _subtype() = subtype

    /**
     * Value in specified currency's smallest unit. e.g. $10 would be represented as 1000 (cents).
     * For RTP, the maximum amount allowed by the network is $100,000.
     */
    @JsonProperty("amount") @ExcludeMissing fun _amount() = amount

    /**
     * One of `credit`, `debit`. Describes the direction money is flowing in the transaction. A
     * `credit` moves money from your account to someone else's. A `debit` pulls money from someone
     * else's account to your own. Note that wire, rtp, and check payments will always be `credit`.
     */
    @JsonProperty("direction") @ExcludeMissing fun _direction() = direction

    /**
     * Either `normal` or `high`. For ACH and EFT payments, `high` represents a same-day ACH or EFT
     * transfer, respectively. For check payments, `high` can mean an overnight check rather than
     * standard mail.
     */
    @JsonProperty("priority") @ExcludeMissing fun _priority() = priority

    /** The ID of one of your organization's internal accounts. */
    @JsonProperty("originating_account_id")
    @ExcludeMissing
    fun _originatingAccountId() = originatingAccountId

    /** The receiving account ID. Can be an `external_account` or `internal_account`. */
    @JsonProperty("receiving_account_id")
    @ExcludeMissing
    fun _receivingAccountId() = receivingAccountId

    @JsonProperty("accounting") @ExcludeMissing fun _accounting() = accounting

    /**
     * The ID of one of your accounting categories. Note that these will only be accessible if your
     * accounting system has been connected.
     */
    @JsonProperty("accounting_category_id")
    @ExcludeMissing
    fun _accountingCategoryId() = accountingCategoryId

    /**
     * The ID of one of your accounting ledger classes. Note that these will only be accessible if
     * your accounting system has been connected.
     */
    @JsonProperty("accounting_ledger_class_id")
    @ExcludeMissing
    fun _accountingLedgerClassId() = accountingLedgerClassId

    /** Defaults to the currency of the originating account. */
    @JsonProperty("currency") @ExcludeMissing fun _currency() = currency

    /**
     * Date transactions are to be posted to the participants' account. Defaults to the current
     * business day or the next business day if the current day is a bank holiday or weekend.
     * Format: yyyy-mm-dd.
     */
    @JsonProperty("effective_date") @ExcludeMissing fun _effectiveDate() = effectiveDate

    /** An optional description for internal use. */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /**
     * An optional descriptor which will appear in the receiver's statement. For `check` payments
     * this field will be used as the memo line. For `ach` the maximum length is 10 characters. Note
     * that for ACH payments, the name on your bank account will be included automatically by the
     * bank, so you can use the characters for other useful information. For `eft` the maximum
     * length is 15 characters.
     */
    @JsonProperty("statement_descriptor")
    @ExcludeMissing
    fun _statementDescriptor() = statementDescriptor

    /**
     * For `ach`, this field will be passed through on an addenda record. For `wire` payments the
     * field will be passed through as the "Originator to Beneficiary Information", also known as
     * OBI or Fedwire tag 6000.
     */
    @JsonProperty("remittance_information")
    @ExcludeMissing
    fun _remittanceInformation() = remittanceInformation

    /**
     * For `wire`, this is usually the purpose which is transmitted via the "InstrForDbtrAgt" field
     * in the ISO20022 file. If you are using Currencycloud, this is the `payment.purpose_code`
     * field. For `eft`, this field is the 3 digit CPA Code that will be attached to the payment.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose() = purpose

    /** Additional data represented as key-value pairs. Both the key and value must be strings. */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    /**
     * The party that will pay the fees for the payment order. Only applies to wire payment orders.
     * Can be one of shared, sender, or receiver, which correspond respectively with the SWIFT 71A
     * values `SHA`, `OUR`, `BEN`.
     */
    @JsonProperty("charge_bearer") @ExcludeMissing fun _chargeBearer() = chargeBearer

    /**
     * Indicates the type of FX transfer to initiate, can be either `variable_to_fixed`,
     * `fixed_to_variable`, or `null` if the payment order currency matches the originating account
     * currency.
     */
    @JsonProperty("foreign_exchange_indicator")
    @ExcludeMissing
    fun _foreignExchangeIndicator() = foreignExchangeIndicator

    /**
     * If present, indicates a specific foreign exchange contract number that has been generated by
     * your financial institution.
     */
    @JsonProperty("foreign_exchange_contract")
    @ExcludeMissing
    fun _foreignExchangeContract() = foreignExchangeContract

    /**
     * A boolean to determine if NSF Protection is enabled for this payment order. Note that this
     * setting must also be turned on in your organization settings page.
     */
    @JsonProperty("nsf_protected") @ExcludeMissing fun _nsfProtected() = nsfProtected

    /**
     * If present, this will replace your default company name on receiver's bank statement. This
     * field can only be used for ACH payments currently. For ACH, only the first 16 characters of
     * this string will be used. Any additional characters will be truncated.
     */
    @JsonProperty("originating_party_name")
    @ExcludeMissing
    fun _originatingPartyName() = originatingPartyName

    /** Name of the ultimate originator of the payment order. */
    @JsonProperty("ultimate_originating_party_name")
    @ExcludeMissing
    fun _ultimateOriginatingPartyName() = ultimateOriginatingPartyName

    /** Identifier of the ultimate originator of the payment order. */
    @JsonProperty("ultimate_originating_party_identifier")
    @ExcludeMissing
    fun _ultimateOriginatingPartyIdentifier() = ultimateOriginatingPartyIdentifier

    @JsonProperty("ultimate_receiving_party_name")
    @ExcludeMissing
    fun _ultimateReceivingPartyName() = ultimateReceivingPartyName

    @JsonProperty("ultimate_receiving_party_identifier")
    @ExcludeMissing
    fun _ultimateReceivingPartyIdentifier() = ultimateReceivingPartyIdentifier

    /**
     * Send an email to the counterparty when the payment order is sent to the bank. If `null`,
     * `send_remittance_advice` on the Counterparty is used.
     */
    @JsonProperty("send_remittance_advice")
    @ExcludeMissing
    fun _sendRemittanceAdvice() = sendRemittanceAdvice

    /** RFP payments require an expires_at. This value must be past the effective_date. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt() = expiresAt

    /** The current status of the payment order. */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("receiving_account_type")
    @ExcludeMissing
    fun _receivingAccountType() = receivingAccountType

    /**
     * If the payment order is tied to a specific Counterparty, their id will appear, otherwise
     * `null`.
     */
    @JsonProperty("counterparty_id") @ExcludeMissing fun _counterpartyId() = counterpartyId

    /**
     * The IDs of all the transactions associated to this payment order. Usually, you will only have
     * a single transaction ID. However, if a payment order initially results in a Return, but gets
     * redrafted and is later successfully completed, it can have many transactions.
     */
    @JsonProperty("transaction_ids") @ExcludeMissing fun _transactionIds() = transactionIds

    /** The ID of the ledger transaction linked to the payment order. */
    @JsonProperty("ledger_transaction_id")
    @ExcludeMissing
    fun _ledgerTransactionId() = ledgerTransactionId

    /** If the payment order's status is `returned`, this will include the return object's data. */
    @JsonProperty("current_return") @ExcludeMissing fun _currentReturn() = currentReturn

    /** A flag that determines whether a payment order should go through transaction monitoring. */
    @JsonProperty("transaction_monitoring_enabled")
    @ExcludeMissing
    fun _transactionMonitoringEnabled() = transactionMonitoringEnabled

    /**
     * Custom key-value pair for usage in compliance rules. Please contact support before making
     * changes to this field.
     */
    @JsonProperty("compliance_rule_metadata")
    @ExcludeMissing
    fun _complianceRuleMetadata() = complianceRuleMetadata

    @JsonProperty("reference_numbers") @ExcludeMissing fun _referenceNumbers() = referenceNumbers

    /**
     * This field will be populated if a vendor (e.g. Currencycloud) failure occurs. Logic shouldn't
     * be built on its value as it is free-form.
     */
    @JsonProperty("vendor_failure_reason")
    @ExcludeMissing
    fun _vendorFailureReason() = vendorFailureReason

    /**
     * The ID of the compliance decision for the payment order, if transaction monitoring is
     * enabled.
     */
    @JsonProperty("decision_id") @ExcludeMissing fun _decisionId() = decisionId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PaymentOrder = apply {
        if (!validated) {
            id()
            object_()
            liveMode()
            createdAt()
            updatedAt()
            type()
            subtype()
            amount()
            direction()
            priority()
            originatingAccountId()
            receivingAccountId()
            accounting().validate()
            accountingCategoryId()
            accountingLedgerClassId()
            currency()
            effectiveDate()
            description()
            statementDescriptor()
            remittanceInformation()
            purpose()
            metadata().validate()
            chargeBearer()
            foreignExchangeIndicator()
            foreignExchangeContract()
            nsfProtected()
            originatingPartyName()
            ultimateOriginatingPartyName()
            ultimateOriginatingPartyIdentifier()
            ultimateReceivingPartyName()
            ultimateReceivingPartyIdentifier()
            sendRemittanceAdvice()
            expiresAt()
            status()
            receivingAccountType()
            counterpartyId()
            transactionIds()
            ledgerTransactionId()
            currentReturn()?.validate()
            transactionMonitoringEnabled()
            complianceRuleMetadata()?.validate()
            referenceNumbers().forEach { it.validate() }
            vendorFailureReason()
            decisionId()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaymentOrder &&
            this.id == other.id &&
            this.object_ == other.object_ &&
            this.liveMode == other.liveMode &&
            this.createdAt == other.createdAt &&
            this.updatedAt == other.updatedAt &&
            this.type == other.type &&
            this.subtype == other.subtype &&
            this.amount == other.amount &&
            this.direction == other.direction &&
            this.priority == other.priority &&
            this.originatingAccountId == other.originatingAccountId &&
            this.receivingAccountId == other.receivingAccountId &&
            this.accounting == other.accounting &&
            this.accountingCategoryId == other.accountingCategoryId &&
            this.accountingLedgerClassId == other.accountingLedgerClassId &&
            this.currency == other.currency &&
            this.effectiveDate == other.effectiveDate &&
            this.description == other.description &&
            this.statementDescriptor == other.statementDescriptor &&
            this.remittanceInformation == other.remittanceInformation &&
            this.purpose == other.purpose &&
            this.metadata == other.metadata &&
            this.chargeBearer == other.chargeBearer &&
            this.foreignExchangeIndicator == other.foreignExchangeIndicator &&
            this.foreignExchangeContract == other.foreignExchangeContract &&
            this.nsfProtected == other.nsfProtected &&
            this.originatingPartyName == other.originatingPartyName &&
            this.ultimateOriginatingPartyName == other.ultimateOriginatingPartyName &&
            this.ultimateOriginatingPartyIdentifier == other.ultimateOriginatingPartyIdentifier &&
            this.ultimateReceivingPartyName == other.ultimateReceivingPartyName &&
            this.ultimateReceivingPartyIdentifier == other.ultimateReceivingPartyIdentifier &&
            this.sendRemittanceAdvice == other.sendRemittanceAdvice &&
            this.expiresAt == other.expiresAt &&
            this.status == other.status &&
            this.receivingAccountType == other.receivingAccountType &&
            this.counterpartyId == other.counterpartyId &&
            this.transactionIds == other.transactionIds &&
            this.ledgerTransactionId == other.ledgerTransactionId &&
            this.currentReturn == other.currentReturn &&
            this.transactionMonitoringEnabled == other.transactionMonitoringEnabled &&
            this.complianceRuleMetadata == other.complianceRuleMetadata &&
            this.referenceNumbers == other.referenceNumbers &&
            this.vendorFailureReason == other.vendorFailureReason &&
            this.decisionId == other.decisionId &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    object_,
                    liveMode,
                    createdAt,
                    updatedAt,
                    type,
                    subtype,
                    amount,
                    direction,
                    priority,
                    originatingAccountId,
                    receivingAccountId,
                    accounting,
                    accountingCategoryId,
                    accountingLedgerClassId,
                    currency,
                    effectiveDate,
                    description,
                    statementDescriptor,
                    remittanceInformation,
                    purpose,
                    metadata,
                    chargeBearer,
                    foreignExchangeIndicator,
                    foreignExchangeContract,
                    nsfProtected,
                    originatingPartyName,
                    ultimateOriginatingPartyName,
                    ultimateOriginatingPartyIdentifier,
                    ultimateReceivingPartyName,
                    ultimateReceivingPartyIdentifier,
                    sendRemittanceAdvice,
                    expiresAt,
                    status,
                    receivingAccountType,
                    counterpartyId,
                    transactionIds,
                    ledgerTransactionId,
                    currentReturn,
                    transactionMonitoringEnabled,
                    complianceRuleMetadata,
                    referenceNumbers,
                    vendorFailureReason,
                    decisionId,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "PaymentOrder{id=$id, object_=$object_, liveMode=$liveMode, createdAt=$createdAt, updatedAt=$updatedAt, type=$type, subtype=$subtype, amount=$amount, direction=$direction, priority=$priority, originatingAccountId=$originatingAccountId, receivingAccountId=$receivingAccountId, accounting=$accounting, accountingCategoryId=$accountingCategoryId, accountingLedgerClassId=$accountingLedgerClassId, currency=$currency, effectiveDate=$effectiveDate, description=$description, statementDescriptor=$statementDescriptor, remittanceInformation=$remittanceInformation, purpose=$purpose, metadata=$metadata, chargeBearer=$chargeBearer, foreignExchangeIndicator=$foreignExchangeIndicator, foreignExchangeContract=$foreignExchangeContract, nsfProtected=$nsfProtected, originatingPartyName=$originatingPartyName, ultimateOriginatingPartyName=$ultimateOriginatingPartyName, ultimateOriginatingPartyIdentifier=$ultimateOriginatingPartyIdentifier, ultimateReceivingPartyName=$ultimateReceivingPartyName, ultimateReceivingPartyIdentifier=$ultimateReceivingPartyIdentifier, sendRemittanceAdvice=$sendRemittanceAdvice, expiresAt=$expiresAt, status=$status, receivingAccountType=$receivingAccountType, counterpartyId=$counterpartyId, transactionIds=$transactionIds, ledgerTransactionId=$ledgerTransactionId, currentReturn=$currentReturn, transactionMonitoringEnabled=$transactionMonitoringEnabled, complianceRuleMetadata=$complianceRuleMetadata, referenceNumbers=$referenceNumbers, vendorFailureReason=$vendorFailureReason, decisionId=$decisionId, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<String> = JsonMissing.of()
        private var liveMode: JsonField<Boolean> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var type: JsonField<PaymentOrderType> = JsonMissing.of()
        private var subtype: JsonField<PaymentOrderSubtype> = JsonMissing.of()
        private var amount: JsonField<Long> = JsonMissing.of()
        private var direction: JsonField<Direction> = JsonMissing.of()
        private var priority: JsonField<Priority> = JsonMissing.of()
        private var originatingAccountId: JsonField<String> = JsonMissing.of()
        private var receivingAccountId: JsonField<String> = JsonMissing.of()
        private var accounting: JsonField<Accounting> = JsonMissing.of()
        private var accountingCategoryId: JsonField<String> = JsonMissing.of()
        private var accountingLedgerClassId: JsonField<String> = JsonMissing.of()
        private var currency: JsonField<Currency> = JsonMissing.of()
        private var effectiveDate: JsonField<LocalDate> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var statementDescriptor: JsonField<String> = JsonMissing.of()
        private var remittanceInformation: JsonField<String> = JsonMissing.of()
        private var purpose: JsonField<String> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var chargeBearer: JsonField<ChargeBearer> = JsonMissing.of()
        private var foreignExchangeIndicator: JsonField<ForeignExchangeIndicator> = JsonMissing.of()
        private var foreignExchangeContract: JsonField<String> = JsonMissing.of()
        private var nsfProtected: JsonField<Boolean> = JsonMissing.of()
        private var originatingPartyName: JsonField<String> = JsonMissing.of()
        private var ultimateOriginatingPartyName: JsonField<String> = JsonMissing.of()
        private var ultimateOriginatingPartyIdentifier: JsonField<String> = JsonMissing.of()
        private var ultimateReceivingPartyName: JsonField<String> = JsonMissing.of()
        private var ultimateReceivingPartyIdentifier: JsonField<String> = JsonMissing.of()
        private var sendRemittanceAdvice: JsonField<Boolean> = JsonMissing.of()
        private var expiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var receivingAccountType: JsonField<ReceivingAccountType> = JsonMissing.of()
        private var counterpartyId: JsonField<String> = JsonMissing.of()
        private var transactionIds: JsonField<List<String>> = JsonMissing.of()
        private var ledgerTransactionId: JsonField<String> = JsonMissing.of()
        private var currentReturn: JsonField<ReturnObject> = JsonMissing.of()
        private var transactionMonitoringEnabled: JsonField<Boolean> = JsonMissing.of()
        private var complianceRuleMetadata: JsonField<ComplianceRuleMetadata> = JsonMissing.of()
        private var referenceNumbers: JsonField<List<PaymentReference>> = JsonMissing.of()
        private var vendorFailureReason: JsonField<String> = JsonMissing.of()
        private var decisionId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(paymentOrder: PaymentOrder) = apply {
            this.id = paymentOrder.id
            this.object_ = paymentOrder.object_
            this.liveMode = paymentOrder.liveMode
            this.createdAt = paymentOrder.createdAt
            this.updatedAt = paymentOrder.updatedAt
            this.type = paymentOrder.type
            this.subtype = paymentOrder.subtype
            this.amount = paymentOrder.amount
            this.direction = paymentOrder.direction
            this.priority = paymentOrder.priority
            this.originatingAccountId = paymentOrder.originatingAccountId
            this.receivingAccountId = paymentOrder.receivingAccountId
            this.accounting = paymentOrder.accounting
            this.accountingCategoryId = paymentOrder.accountingCategoryId
            this.accountingLedgerClassId = paymentOrder.accountingLedgerClassId
            this.currency = paymentOrder.currency
            this.effectiveDate = paymentOrder.effectiveDate
            this.description = paymentOrder.description
            this.statementDescriptor = paymentOrder.statementDescriptor
            this.remittanceInformation = paymentOrder.remittanceInformation
            this.purpose = paymentOrder.purpose
            this.metadata = paymentOrder.metadata
            this.chargeBearer = paymentOrder.chargeBearer
            this.foreignExchangeIndicator = paymentOrder.foreignExchangeIndicator
            this.foreignExchangeContract = paymentOrder.foreignExchangeContract
            this.nsfProtected = paymentOrder.nsfProtected
            this.originatingPartyName = paymentOrder.originatingPartyName
            this.ultimateOriginatingPartyName = paymentOrder.ultimateOriginatingPartyName
            this.ultimateOriginatingPartyIdentifier =
                paymentOrder.ultimateOriginatingPartyIdentifier
            this.ultimateReceivingPartyName = paymentOrder.ultimateReceivingPartyName
            this.ultimateReceivingPartyIdentifier = paymentOrder.ultimateReceivingPartyIdentifier
            this.sendRemittanceAdvice = paymentOrder.sendRemittanceAdvice
            this.expiresAt = paymentOrder.expiresAt
            this.status = paymentOrder.status
            this.receivingAccountType = paymentOrder.receivingAccountType
            this.counterpartyId = paymentOrder.counterpartyId
            this.transactionIds = paymentOrder.transactionIds
            this.ledgerTransactionId = paymentOrder.ledgerTransactionId
            this.currentReturn = paymentOrder.currentReturn
            this.transactionMonitoringEnabled = paymentOrder.transactionMonitoringEnabled
            this.complianceRuleMetadata = paymentOrder.complianceRuleMetadata
            this.referenceNumbers = paymentOrder.referenceNumbers
            this.vendorFailureReason = paymentOrder.vendorFailureReason
            this.decisionId = paymentOrder.decisionId
            additionalProperties(paymentOrder.additionalProperties)
        }

        fun id(id: String) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        fun object_(object_: String) = object_(JsonField.of(object_))

        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        /**
         * This field will be true if this object exists in the live environment or false if it
         * exists in the test environment.
         */
        fun liveMode(liveMode: Boolean) = liveMode(JsonField.of(liveMode))

        /**
         * This field will be true if this object exists in the live environment or false if it
         * exists in the test environment.
         */
        @JsonProperty("live_mode")
        @ExcludeMissing
        fun liveMode(liveMode: JsonField<Boolean>) = apply { this.liveMode = liveMode }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        @JsonProperty("updated_at")
        @ExcludeMissing
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /**
         * One of `ach`, `eft`, `wire`, `check`, `sen`, `book`, `rtp`, `sepa`, `bacs`, `au_becs`,
         * `interac`, `signet`, `provexchange`.
         */
        fun type(type: PaymentOrderType) = type(JsonField.of(type))

        /**
         * One of `ach`, `eft`, `wire`, `check`, `sen`, `book`, `rtp`, `sepa`, `bacs`, `au_becs`,
         * `interac`, `signet`, `provexchange`.
         */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<PaymentOrderType>) = apply { this.type = type }

        /**
         * An additional layer of classification for the type of payment order you are doing. This
         * field is only used for `ach` payment orders currently. For `ach` payment orders, the
         * `subtype` represents the SEC code. We currently support `CCD`, `PPD`, `IAT`, `CTX`,
         * `WEB`, `CIE`, and `TEL`.
         */
        fun subtype(subtype: PaymentOrderSubtype) = subtype(JsonField.of(subtype))

        /**
         * An additional layer of classification for the type of payment order you are doing. This
         * field is only used for `ach` payment orders currently. For `ach` payment orders, the
         * `subtype` represents the SEC code. We currently support `CCD`, `PPD`, `IAT`, `CTX`,
         * `WEB`, `CIE`, and `TEL`.
         */
        @JsonProperty("subtype")
        @ExcludeMissing
        fun subtype(subtype: JsonField<PaymentOrderSubtype>) = apply { this.subtype = subtype }

        /**
         * Value in specified currency's smallest unit. e.g. $10 would be represented as 1000
         * (cents). For RTP, the maximum amount allowed by the network is $100,000.
         */
        fun amount(amount: Long) = amount(JsonField.of(amount))

        /**
         * Value in specified currency's smallest unit. e.g. $10 would be represented as 1000
         * (cents). For RTP, the maximum amount allowed by the network is $100,000.
         */
        @JsonProperty("amount")
        @ExcludeMissing
        fun amount(amount: JsonField<Long>) = apply { this.amount = amount }

        /**
         * One of `credit`, `debit`. Describes the direction money is flowing in the transaction. A
         * `credit` moves money from your account to someone else's. A `debit` pulls money from
         * someone else's account to your own. Note that wire, rtp, and check payments will always
         * be `credit`.
         */
        fun direction(direction: Direction) = direction(JsonField.of(direction))

        /**
         * One of `credit`, `debit`. Describes the direction money is flowing in the transaction. A
         * `credit` moves money from your account to someone else's. A `debit` pulls money from
         * someone else's account to your own. Note that wire, rtp, and check payments will always
         * be `credit`.
         */
        @JsonProperty("direction")
        @ExcludeMissing
        fun direction(direction: JsonField<Direction>) = apply { this.direction = direction }

        /**
         * Either `normal` or `high`. For ACH and EFT payments, `high` represents a same-day ACH or
         * EFT transfer, respectively. For check payments, `high` can mean an overnight check rather
         * than standard mail.
         */
        fun priority(priority: Priority) = priority(JsonField.of(priority))

        /**
         * Either `normal` or `high`. For ACH and EFT payments, `high` represents a same-day ACH or
         * EFT transfer, respectively. For check payments, `high` can mean an overnight check rather
         * than standard mail.
         */
        @JsonProperty("priority")
        @ExcludeMissing
        fun priority(priority: JsonField<Priority>) = apply { this.priority = priority }

        /** The ID of one of your organization's internal accounts. */
        fun originatingAccountId(originatingAccountId: String) =
            originatingAccountId(JsonField.of(originatingAccountId))

        /** The ID of one of your organization's internal accounts. */
        @JsonProperty("originating_account_id")
        @ExcludeMissing
        fun originatingAccountId(originatingAccountId: JsonField<String>) = apply {
            this.originatingAccountId = originatingAccountId
        }

        /** The receiving account ID. Can be an `external_account` or `internal_account`. */
        fun receivingAccountId(receivingAccountId: String) =
            receivingAccountId(JsonField.of(receivingAccountId))

        /** The receiving account ID. Can be an `external_account` or `internal_account`. */
        @JsonProperty("receiving_account_id")
        @ExcludeMissing
        fun receivingAccountId(receivingAccountId: JsonField<String>) = apply {
            this.receivingAccountId = receivingAccountId
        }

        fun accounting(accounting: Accounting) = accounting(JsonField.of(accounting))

        @JsonProperty("accounting")
        @ExcludeMissing
        fun accounting(accounting: JsonField<Accounting>) = apply { this.accounting = accounting }

        /**
         * The ID of one of your accounting categories. Note that these will only be accessible if
         * your accounting system has been connected.
         */
        fun accountingCategoryId(accountingCategoryId: String) =
            accountingCategoryId(JsonField.of(accountingCategoryId))

        /**
         * The ID of one of your accounting categories. Note that these will only be accessible if
         * your accounting system has been connected.
         */
        @JsonProperty("accounting_category_id")
        @ExcludeMissing
        fun accountingCategoryId(accountingCategoryId: JsonField<String>) = apply {
            this.accountingCategoryId = accountingCategoryId
        }

        /**
         * The ID of one of your accounting ledger classes. Note that these will only be accessible
         * if your accounting system has been connected.
         */
        fun accountingLedgerClassId(accountingLedgerClassId: String) =
            accountingLedgerClassId(JsonField.of(accountingLedgerClassId))

        /**
         * The ID of one of your accounting ledger classes. Note that these will only be accessible
         * if your accounting system has been connected.
         */
        @JsonProperty("accounting_ledger_class_id")
        @ExcludeMissing
        fun accountingLedgerClassId(accountingLedgerClassId: JsonField<String>) = apply {
            this.accountingLedgerClassId = accountingLedgerClassId
        }

        /** Defaults to the currency of the originating account. */
        fun currency(currency: Currency) = currency(JsonField.of(currency))

        /** Defaults to the currency of the originating account. */
        @JsonProperty("currency")
        @ExcludeMissing
        fun currency(currency: JsonField<Currency>) = apply { this.currency = currency }

        /**
         * Date transactions are to be posted to the participants' account. Defaults to the current
         * business day or the next business day if the current day is a bank holiday or weekend.
         * Format: yyyy-mm-dd.
         */
        fun effectiveDate(effectiveDate: LocalDate) = effectiveDate(JsonField.of(effectiveDate))

        /**
         * Date transactions are to be posted to the participants' account. Defaults to the current
         * business day or the next business day if the current day is a bank holiday or weekend.
         * Format: yyyy-mm-dd.
         */
        @JsonProperty("effective_date")
        @ExcludeMissing
        fun effectiveDate(effectiveDate: JsonField<LocalDate>) = apply {
            this.effectiveDate = effectiveDate
        }

        /** An optional description for internal use. */
        fun description(description: String) = description(JsonField.of(description))

        /** An optional description for internal use. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * An optional descriptor which will appear in the receiver's statement. For `check`
         * payments this field will be used as the memo line. For `ach` the maximum length is 10
         * characters. Note that for ACH payments, the name on your bank account will be included
         * automatically by the bank, so you can use the characters for other useful information.
         * For `eft` the maximum length is 15 characters.
         */
        fun statementDescriptor(statementDescriptor: String) =
            statementDescriptor(JsonField.of(statementDescriptor))

        /**
         * An optional descriptor which will appear in the receiver's statement. For `check`
         * payments this field will be used as the memo line. For `ach` the maximum length is 10
         * characters. Note that for ACH payments, the name on your bank account will be included
         * automatically by the bank, so you can use the characters for other useful information.
         * For `eft` the maximum length is 15 characters.
         */
        @JsonProperty("statement_descriptor")
        @ExcludeMissing
        fun statementDescriptor(statementDescriptor: JsonField<String>) = apply {
            this.statementDescriptor = statementDescriptor
        }

        /**
         * For `ach`, this field will be passed through on an addenda record. For `wire` payments
         * the field will be passed through as the "Originator to Beneficiary Information", also
         * known as OBI or Fedwire tag 6000.
         */
        fun remittanceInformation(remittanceInformation: String) =
            remittanceInformation(JsonField.of(remittanceInformation))

        /**
         * For `ach`, this field will be passed through on an addenda record. For `wire` payments
         * the field will be passed through as the "Originator to Beneficiary Information", also
         * known as OBI or Fedwire tag 6000.
         */
        @JsonProperty("remittance_information")
        @ExcludeMissing
        fun remittanceInformation(remittanceInformation: JsonField<String>) = apply {
            this.remittanceInformation = remittanceInformation
        }

        /**
         * For `wire`, this is usually the purpose which is transmitted via the "InstrForDbtrAgt"
         * field in the ISO20022 file. If you are using Currencycloud, this is the
         * `payment.purpose_code` field. For `eft`, this field is the 3 digit CPA Code that will be
         * attached to the payment.
         */
        fun purpose(purpose: String) = purpose(JsonField.of(purpose))

        /**
         * For `wire`, this is usually the purpose which is transmitted via the "InstrForDbtrAgt"
         * field in the ISO20022 file. If you are using Currencycloud, this is the
         * `payment.purpose_code` field. For `eft`, this field is the 3 digit CPA Code that will be
         * attached to the payment.
         */
        @JsonProperty("purpose")
        @ExcludeMissing
        fun purpose(purpose: JsonField<String>) = apply { this.purpose = purpose }

        /**
         * Additional data represented as key-value pairs. Both the key and value must be strings.
         */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * Additional data represented as key-value pairs. Both the key and value must be strings.
         */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /**
         * The party that will pay the fees for the payment order. Only applies to wire payment
         * orders. Can be one of shared, sender, or receiver, which correspond respectively with the
         * SWIFT 71A values `SHA`, `OUR`, `BEN`.
         */
        fun chargeBearer(chargeBearer: ChargeBearer) = chargeBearer(JsonField.of(chargeBearer))

        /**
         * The party that will pay the fees for the payment order. Only applies to wire payment
         * orders. Can be one of shared, sender, or receiver, which correspond respectively with the
         * SWIFT 71A values `SHA`, `OUR`, `BEN`.
         */
        @JsonProperty("charge_bearer")
        @ExcludeMissing
        fun chargeBearer(chargeBearer: JsonField<ChargeBearer>) = apply {
            this.chargeBearer = chargeBearer
        }

        /**
         * Indicates the type of FX transfer to initiate, can be either `variable_to_fixed`,
         * `fixed_to_variable`, or `null` if the payment order currency matches the originating
         * account currency.
         */
        fun foreignExchangeIndicator(foreignExchangeIndicator: ForeignExchangeIndicator) =
            foreignExchangeIndicator(JsonField.of(foreignExchangeIndicator))

        /**
         * Indicates the type of FX transfer to initiate, can be either `variable_to_fixed`,
         * `fixed_to_variable`, or `null` if the payment order currency matches the originating
         * account currency.
         */
        @JsonProperty("foreign_exchange_indicator")
        @ExcludeMissing
        fun foreignExchangeIndicator(
            foreignExchangeIndicator: JsonField<ForeignExchangeIndicator>
        ) = apply { this.foreignExchangeIndicator = foreignExchangeIndicator }

        /**
         * If present, indicates a specific foreign exchange contract number that has been generated
         * by your financial institution.
         */
        fun foreignExchangeContract(foreignExchangeContract: String) =
            foreignExchangeContract(JsonField.of(foreignExchangeContract))

        /**
         * If present, indicates a specific foreign exchange contract number that has been generated
         * by your financial institution.
         */
        @JsonProperty("foreign_exchange_contract")
        @ExcludeMissing
        fun foreignExchangeContract(foreignExchangeContract: JsonField<String>) = apply {
            this.foreignExchangeContract = foreignExchangeContract
        }

        /**
         * A boolean to determine if NSF Protection is enabled for this payment order. Note that
         * this setting must also be turned on in your organization settings page.
         */
        fun nsfProtected(nsfProtected: Boolean) = nsfProtected(JsonField.of(nsfProtected))

        /**
         * A boolean to determine if NSF Protection is enabled for this payment order. Note that
         * this setting must also be turned on in your organization settings page.
         */
        @JsonProperty("nsf_protected")
        @ExcludeMissing
        fun nsfProtected(nsfProtected: JsonField<Boolean>) = apply {
            this.nsfProtected = nsfProtected
        }

        /**
         * If present, this will replace your default company name on receiver's bank statement.
         * This field can only be used for ACH payments currently. For ACH, only the first 16
         * characters of this string will be used. Any additional characters will be truncated.
         */
        fun originatingPartyName(originatingPartyName: String) =
            originatingPartyName(JsonField.of(originatingPartyName))

        /**
         * If present, this will replace your default company name on receiver's bank statement.
         * This field can only be used for ACH payments currently. For ACH, only the first 16
         * characters of this string will be used. Any additional characters will be truncated.
         */
        @JsonProperty("originating_party_name")
        @ExcludeMissing
        fun originatingPartyName(originatingPartyName: JsonField<String>) = apply {
            this.originatingPartyName = originatingPartyName
        }

        /** Name of the ultimate originator of the payment order. */
        fun ultimateOriginatingPartyName(ultimateOriginatingPartyName: String) =
            ultimateOriginatingPartyName(JsonField.of(ultimateOriginatingPartyName))

        /** Name of the ultimate originator of the payment order. */
        @JsonProperty("ultimate_originating_party_name")
        @ExcludeMissing
        fun ultimateOriginatingPartyName(ultimateOriginatingPartyName: JsonField<String>) = apply {
            this.ultimateOriginatingPartyName = ultimateOriginatingPartyName
        }

        /** Identifier of the ultimate originator of the payment order. */
        fun ultimateOriginatingPartyIdentifier(ultimateOriginatingPartyIdentifier: String) =
            ultimateOriginatingPartyIdentifier(JsonField.of(ultimateOriginatingPartyIdentifier))

        /** Identifier of the ultimate originator of the payment order. */
        @JsonProperty("ultimate_originating_party_identifier")
        @ExcludeMissing
        fun ultimateOriginatingPartyIdentifier(
            ultimateOriginatingPartyIdentifier: JsonField<String>
        ) = apply { this.ultimateOriginatingPartyIdentifier = ultimateOriginatingPartyIdentifier }

        fun ultimateReceivingPartyName(ultimateReceivingPartyName: String) =
            ultimateReceivingPartyName(JsonField.of(ultimateReceivingPartyName))

        @JsonProperty("ultimate_receiving_party_name")
        @ExcludeMissing
        fun ultimateReceivingPartyName(ultimateReceivingPartyName: JsonField<String>) = apply {
            this.ultimateReceivingPartyName = ultimateReceivingPartyName
        }

        fun ultimateReceivingPartyIdentifier(ultimateReceivingPartyIdentifier: String) =
            ultimateReceivingPartyIdentifier(JsonField.of(ultimateReceivingPartyIdentifier))

        @JsonProperty("ultimate_receiving_party_identifier")
        @ExcludeMissing
        fun ultimateReceivingPartyIdentifier(ultimateReceivingPartyIdentifier: JsonField<String>) =
            apply {
                this.ultimateReceivingPartyIdentifier = ultimateReceivingPartyIdentifier
            }

        /**
         * Send an email to the counterparty when the payment order is sent to the bank. If `null`,
         * `send_remittance_advice` on the Counterparty is used.
         */
        fun sendRemittanceAdvice(sendRemittanceAdvice: Boolean) =
            sendRemittanceAdvice(JsonField.of(sendRemittanceAdvice))

        /**
         * Send an email to the counterparty when the payment order is sent to the bank. If `null`,
         * `send_remittance_advice` on the Counterparty is used.
         */
        @JsonProperty("send_remittance_advice")
        @ExcludeMissing
        fun sendRemittanceAdvice(sendRemittanceAdvice: JsonField<Boolean>) = apply {
            this.sendRemittanceAdvice = sendRemittanceAdvice
        }

        /** RFP payments require an expires_at. This value must be past the effective_date. */
        fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

        /** RFP payments require an expires_at. This value must be past the effective_date. */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply { this.expiresAt = expiresAt }

        /** The current status of the payment order. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The current status of the payment order. */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun receivingAccountType(receivingAccountType: ReceivingAccountType) =
            receivingAccountType(JsonField.of(receivingAccountType))

        @JsonProperty("receiving_account_type")
        @ExcludeMissing
        fun receivingAccountType(receivingAccountType: JsonField<ReceivingAccountType>) = apply {
            this.receivingAccountType = receivingAccountType
        }

        /**
         * If the payment order is tied to a specific Counterparty, their id will appear, otherwise
         * `null`.
         */
        fun counterpartyId(counterpartyId: String) = counterpartyId(JsonField.of(counterpartyId))

        /**
         * If the payment order is tied to a specific Counterparty, their id will appear, otherwise
         * `null`.
         */
        @JsonProperty("counterparty_id")
        @ExcludeMissing
        fun counterpartyId(counterpartyId: JsonField<String>) = apply {
            this.counterpartyId = counterpartyId
        }

        /**
         * The IDs of all the transactions associated to this payment order. Usually, you will only
         * have a single transaction ID. However, if a payment order initially results in a Return,
         * but gets redrafted and is later successfully completed, it can have many transactions.
         */
        fun transactionIds(transactionIds: List<String>) =
            transactionIds(JsonField.of(transactionIds))

        /**
         * The IDs of all the transactions associated to this payment order. Usually, you will only
         * have a single transaction ID. However, if a payment order initially results in a Return,
         * but gets redrafted and is later successfully completed, it can have many transactions.
         */
        @JsonProperty("transaction_ids")
        @ExcludeMissing
        fun transactionIds(transactionIds: JsonField<List<String>>) = apply {
            this.transactionIds = transactionIds
        }

        /** The ID of the ledger transaction linked to the payment order. */
        fun ledgerTransactionId(ledgerTransactionId: String) =
            ledgerTransactionId(JsonField.of(ledgerTransactionId))

        /** The ID of the ledger transaction linked to the payment order. */
        @JsonProperty("ledger_transaction_id")
        @ExcludeMissing
        fun ledgerTransactionId(ledgerTransactionId: JsonField<String>) = apply {
            this.ledgerTransactionId = ledgerTransactionId
        }

        /**
         * If the payment order's status is `returned`, this will include the return object's data.
         */
        fun currentReturn(currentReturn: ReturnObject) = currentReturn(JsonField.of(currentReturn))

        /**
         * If the payment order's status is `returned`, this will include the return object's data.
         */
        @JsonProperty("current_return")
        @ExcludeMissing
        fun currentReturn(currentReturn: JsonField<ReturnObject>) = apply {
            this.currentReturn = currentReturn
        }

        /**
         * A flag that determines whether a payment order should go through transaction monitoring.
         */
        fun transactionMonitoringEnabled(transactionMonitoringEnabled: Boolean) =
            transactionMonitoringEnabled(JsonField.of(transactionMonitoringEnabled))

        /**
         * A flag that determines whether a payment order should go through transaction monitoring.
         */
        @JsonProperty("transaction_monitoring_enabled")
        @ExcludeMissing
        fun transactionMonitoringEnabled(transactionMonitoringEnabled: JsonField<Boolean>) = apply {
            this.transactionMonitoringEnabled = transactionMonitoringEnabled
        }

        /**
         * Custom key-value pair for usage in compliance rules. Please contact support before making
         * changes to this field.
         */
        fun complianceRuleMetadata(complianceRuleMetadata: ComplianceRuleMetadata) =
            complianceRuleMetadata(JsonField.of(complianceRuleMetadata))

        /**
         * Custom key-value pair for usage in compliance rules. Please contact support before making
         * changes to this field.
         */
        @JsonProperty("compliance_rule_metadata")
        @ExcludeMissing
        fun complianceRuleMetadata(complianceRuleMetadata: JsonField<ComplianceRuleMetadata>) =
            apply {
                this.complianceRuleMetadata = complianceRuleMetadata
            }

        fun referenceNumbers(referenceNumbers: List<PaymentReference>) =
            referenceNumbers(JsonField.of(referenceNumbers))

        @JsonProperty("reference_numbers")
        @ExcludeMissing
        fun referenceNumbers(referenceNumbers: JsonField<List<PaymentReference>>) = apply {
            this.referenceNumbers = referenceNumbers
        }

        /**
         * This field will be populated if a vendor (e.g. Currencycloud) failure occurs. Logic
         * shouldn't be built on its value as it is free-form.
         */
        fun vendorFailureReason(vendorFailureReason: String) =
            vendorFailureReason(JsonField.of(vendorFailureReason))

        /**
         * This field will be populated if a vendor (e.g. Currencycloud) failure occurs. Logic
         * shouldn't be built on its value as it is free-form.
         */
        @JsonProperty("vendor_failure_reason")
        @ExcludeMissing
        fun vendorFailureReason(vendorFailureReason: JsonField<String>) = apply {
            this.vendorFailureReason = vendorFailureReason
        }

        /**
         * The ID of the compliance decision for the payment order, if transaction monitoring is
         * enabled.
         */
        fun decisionId(decisionId: String) = decisionId(JsonField.of(decisionId))

        /**
         * The ID of the compliance decision for the payment order, if transaction monitoring is
         * enabled.
         */
        @JsonProperty("decision_id")
        @ExcludeMissing
        fun decisionId(decisionId: JsonField<String>) = apply { this.decisionId = decisionId }

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

        fun build(): PaymentOrder =
            PaymentOrder(
                id,
                object_,
                liveMode,
                createdAt,
                updatedAt,
                type,
                subtype,
                amount,
                direction,
                priority,
                originatingAccountId,
                receivingAccountId,
                accounting,
                accountingCategoryId,
                accountingLedgerClassId,
                currency,
                effectiveDate,
                description,
                statementDescriptor,
                remittanceInformation,
                purpose,
                metadata,
                chargeBearer,
                foreignExchangeIndicator,
                foreignExchangeContract,
                nsfProtected,
                originatingPartyName,
                ultimateOriginatingPartyName,
                ultimateOriginatingPartyIdentifier,
                ultimateReceivingPartyName,
                ultimateReceivingPartyIdentifier,
                sendRemittanceAdvice,
                expiresAt,
                status,
                receivingAccountType,
                counterpartyId,
                transactionIds.map { it.toUnmodifiable() },
                ledgerTransactionId,
                currentReturn,
                transactionMonitoringEnabled,
                complianceRuleMetadata,
                referenceNumbers.map { it.toUnmodifiable() },
                vendorFailureReason,
                decisionId,
                additionalProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = Accounting.Builder::class)
    @NoAutoDetect
    class Accounting
    private constructor(
        private val accountId: JsonField<String>,
        private val classId: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /**
         * The ID of one of your accounting categories. Note that these will only be accessible if
         * your accounting system has been connected.
         */
        fun accountId(): String? = accountId.getNullable("account_id")

        /**
         * The ID of one of the class objects in your accounting system. Class objects track
         * segments of your business independent of client or project. Note that these will only be
         * accessible if your accounting system has been connected.
         */
        fun classId(): String? = classId.getNullable("class_id")

        /**
         * The ID of one of your accounting categories. Note that these will only be accessible if
         * your accounting system has been connected.
         */
        @JsonProperty("account_id") @ExcludeMissing fun _accountId() = accountId

        /**
         * The ID of one of the class objects in your accounting system. Class objects track
         * segments of your business independent of client or project. Note that these will only be
         * accessible if your accounting system has been connected.
         */
        @JsonProperty("class_id") @ExcludeMissing fun _classId() = classId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Accounting = apply {
            if (!validated) {
                accountId()
                classId()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Accounting &&
                this.accountId == other.accountId &&
                this.classId == other.classId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        accountId,
                        classId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Accounting{accountId=$accountId, classId=$classId, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var accountId: JsonField<String> = JsonMissing.of()
            private var classId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(accounting: Accounting) = apply {
                this.accountId = accounting.accountId
                this.classId = accounting.classId
                additionalProperties(accounting.additionalProperties)
            }

            /**
             * The ID of one of your accounting categories. Note that these will only be accessible
             * if your accounting system has been connected.
             */
            fun accountId(accountId: String) = accountId(JsonField.of(accountId))

            /**
             * The ID of one of your accounting categories. Note that these will only be accessible
             * if your accounting system has been connected.
             */
            @JsonProperty("account_id")
            @ExcludeMissing
            fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

            /**
             * The ID of one of the class objects in your accounting system. Class objects track
             * segments of your business independent of client or project. Note that these will only
             * be accessible if your accounting system has been connected.
             */
            fun classId(classId: String) = classId(JsonField.of(classId))

            /**
             * The ID of one of the class objects in your accounting system. Class objects track
             * segments of your business independent of client or project. Note that these will only
             * be accessible if your accounting system has been connected.
             */
            @JsonProperty("class_id")
            @ExcludeMissing
            fun classId(classId: JsonField<String>) = apply { this.classId = classId }

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

            fun build(): Accounting =
                Accounting(
                    accountId,
                    classId,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    class ChargeBearer
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ChargeBearer && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val SHARED = ChargeBearer(JsonField.of("shared"))

            val SENDER = ChargeBearer(JsonField.of("sender"))

            val RECEIVER = ChargeBearer(JsonField.of("receiver"))

            fun of(value: String) = ChargeBearer(JsonField.of(value))
        }

        enum class Known {
            SHARED,
            SENDER,
            RECEIVER,
        }

        enum class Value {
            SHARED,
            SENDER,
            RECEIVER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SHARED -> Value.SHARED
                SENDER -> Value.SENDER
                RECEIVER -> Value.RECEIVER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SHARED -> Known.SHARED
                SENDER -> Known.SENDER
                RECEIVER -> Known.RECEIVER
                else -> throw ModernTreasuryInvalidDataException("Unknown ChargeBearer: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /**
     * Custom key-value pair for usage in compliance rules. Please contact support before making
     * changes to this field.
     */
    @JsonDeserialize(builder = ComplianceRuleMetadata.Builder::class)
    @NoAutoDetect
    class ComplianceRuleMetadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): ComplianceRuleMetadata = apply {
            if (!validated) {
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ComplianceRuleMetadata &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "ComplianceRuleMetadata{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(complianceRuleMetadata: ComplianceRuleMetadata) = apply {
                additionalProperties(complianceRuleMetadata.additionalProperties)
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

            fun build(): ComplianceRuleMetadata =
                ComplianceRuleMetadata(additionalProperties.toUnmodifiable())
        }
    }

    class Direction
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Direction && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val CREDIT = Direction(JsonField.of("credit"))

            val DEBIT = Direction(JsonField.of("debit"))

            fun of(value: String) = Direction(JsonField.of(value))
        }

        enum class Known {
            CREDIT,
            DEBIT,
        }

        enum class Value {
            CREDIT,
            DEBIT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CREDIT -> Value.CREDIT
                DEBIT -> Value.DEBIT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CREDIT -> Known.CREDIT
                DEBIT -> Known.DEBIT
                else -> throw ModernTreasuryInvalidDataException("Unknown Direction: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ForeignExchangeIndicator
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ForeignExchangeIndicator && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val FIXED_TO_VARIABLE = ForeignExchangeIndicator(JsonField.of("fixed_to_variable"))

            val VARIABLE_TO_FIXED = ForeignExchangeIndicator(JsonField.of("variable_to_fixed"))

            fun of(value: String) = ForeignExchangeIndicator(JsonField.of(value))
        }

        enum class Known {
            FIXED_TO_VARIABLE,
            VARIABLE_TO_FIXED,
        }

        enum class Value {
            FIXED_TO_VARIABLE,
            VARIABLE_TO_FIXED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FIXED_TO_VARIABLE -> Value.FIXED_TO_VARIABLE
                VARIABLE_TO_FIXED -> Value.VARIABLE_TO_FIXED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FIXED_TO_VARIABLE -> Known.FIXED_TO_VARIABLE
                VARIABLE_TO_FIXED -> Known.VARIABLE_TO_FIXED
                else ->
                    throw ModernTreasuryInvalidDataException(
                        "Unknown ForeignExchangeIndicator: $value"
                    )
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** Additional data represented as key-value pairs. Both the key and value must be strings. */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Metadata = apply {
            if (!validated) {
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(metadata: Metadata) = apply {
                additionalProperties(metadata.additionalProperties)
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

            fun build(): Metadata = Metadata(additionalProperties.toUnmodifiable())
        }
    }

    class Priority
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Priority && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val HIGH = Priority(JsonField.of("high"))

            val NORMAL = Priority(JsonField.of("normal"))

            fun of(value: String) = Priority(JsonField.of(value))
        }

        enum class Known {
            HIGH,
            NORMAL,
        }

        enum class Value {
            HIGH,
            NORMAL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                HIGH -> Value.HIGH
                NORMAL -> Value.NORMAL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                HIGH -> Known.HIGH
                NORMAL -> Known.NORMAL
                else -> throw ModernTreasuryInvalidDataException("Unknown Priority: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class ReceivingAccountType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ReceivingAccountType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val INTERNAL_ACCOUNT = ReceivingAccountType(JsonField.of("internal_account"))

            val EXTERNAL_ACCOUNT = ReceivingAccountType(JsonField.of("external_account"))

            fun of(value: String) = ReceivingAccountType(JsonField.of(value))
        }

        enum class Known {
            INTERNAL_ACCOUNT,
            EXTERNAL_ACCOUNT,
        }

        enum class Value {
            INTERNAL_ACCOUNT,
            EXTERNAL_ACCOUNT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                INTERNAL_ACCOUNT -> Value.INTERNAL_ACCOUNT
                EXTERNAL_ACCOUNT -> Value.EXTERNAL_ACCOUNT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                INTERNAL_ACCOUNT -> Known.INTERNAL_ACCOUNT
                EXTERNAL_ACCOUNT -> Known.EXTERNAL_ACCOUNT
                else ->
                    throw ModernTreasuryInvalidDataException("Unknown ReceivingAccountType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = PaymentReference.Builder::class)
    @NoAutoDetect
    class PaymentReference
    private constructor(
        private val id: JsonField<String>,
        private val object_: JsonField<String>,
        private val liveMode: JsonField<Boolean>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val referenceNumber: JsonField<String>,
        private val referenceNumberType: JsonField<ReferenceNumberType>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun id(): String = id.getRequired("id")

        fun object_(): String = object_.getRequired("object")

        /**
         * This field will be true if this object exists in the live environment or false if it
         * exists in the test environment.
         */
        fun liveMode(): Boolean = liveMode.getRequired("live_mode")

        fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

        fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

        /** The vendor reference number. */
        fun referenceNumber(): String = referenceNumber.getRequired("reference_number")

        /** The type of the reference number. Referring to the vendor payment id. */
        fun referenceNumberType(): ReferenceNumberType =
            referenceNumberType.getRequired("reference_number_type")

        @JsonProperty("id") @ExcludeMissing fun _id() = id

        @JsonProperty("object") @ExcludeMissing fun _object_() = object_

        /**
         * This field will be true if this object exists in the live environment or false if it
         * exists in the test environment.
         */
        @JsonProperty("live_mode") @ExcludeMissing fun _liveMode() = liveMode

        @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

        @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt() = updatedAt

        /** The vendor reference number. */
        @JsonProperty("reference_number") @ExcludeMissing fun _referenceNumber() = referenceNumber

        /** The type of the reference number. Referring to the vendor payment id. */
        @JsonProperty("reference_number_type")
        @ExcludeMissing
        fun _referenceNumberType() = referenceNumberType

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): PaymentReference = apply {
            if (!validated) {
                id()
                object_()
                liveMode()
                createdAt()
                updatedAt()
                referenceNumber()
                referenceNumberType()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PaymentReference &&
                this.id == other.id &&
                this.object_ == other.object_ &&
                this.liveMode == other.liveMode &&
                this.createdAt == other.createdAt &&
                this.updatedAt == other.updatedAt &&
                this.referenceNumber == other.referenceNumber &&
                this.referenceNumberType == other.referenceNumberType &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        object_,
                        liveMode,
                        createdAt,
                        updatedAt,
                        referenceNumber,
                        referenceNumberType,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "PaymentReference{id=$id, object_=$object_, liveMode=$liveMode, createdAt=$createdAt, updatedAt=$updatedAt, referenceNumber=$referenceNumber, referenceNumberType=$referenceNumberType, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<String> = JsonMissing.of()
            private var object_: JsonField<String> = JsonMissing.of()
            private var liveMode: JsonField<Boolean> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var referenceNumber: JsonField<String> = JsonMissing.of()
            private var referenceNumberType: JsonField<ReferenceNumberType> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(paymentReference: PaymentReference) = apply {
                this.id = paymentReference.id
                this.object_ = paymentReference.object_
                this.liveMode = paymentReference.liveMode
                this.createdAt = paymentReference.createdAt
                this.updatedAt = paymentReference.updatedAt
                this.referenceNumber = paymentReference.referenceNumber
                this.referenceNumberType = paymentReference.referenceNumberType
                additionalProperties(paymentReference.additionalProperties)
            }

            fun id(id: String) = id(JsonField.of(id))

            @JsonProperty("id")
            @ExcludeMissing
            fun id(id: JsonField<String>) = apply { this.id = id }

            fun object_(object_: String) = object_(JsonField.of(object_))

            @JsonProperty("object")
            @ExcludeMissing
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            /**
             * This field will be true if this object exists in the live environment or false if it
             * exists in the test environment.
             */
            fun liveMode(liveMode: Boolean) = liveMode(JsonField.of(liveMode))

            /**
             * This field will be true if this object exists in the live environment or false if it
             * exists in the test environment.
             */
            @JsonProperty("live_mode")
            @ExcludeMissing
            fun liveMode(liveMode: JsonField<Boolean>) = apply { this.liveMode = liveMode }

            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            @JsonProperty("created_at")
            @ExcludeMissing
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

            @JsonProperty("updated_at")
            @ExcludeMissing
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
            }

            /** The vendor reference number. */
            fun referenceNumber(referenceNumber: String) =
                referenceNumber(JsonField.of(referenceNumber))

            /** The vendor reference number. */
            @JsonProperty("reference_number")
            @ExcludeMissing
            fun referenceNumber(referenceNumber: JsonField<String>) = apply {
                this.referenceNumber = referenceNumber
            }

            /** The type of the reference number. Referring to the vendor payment id. */
            fun referenceNumberType(referenceNumberType: ReferenceNumberType) =
                referenceNumberType(JsonField.of(referenceNumberType))

            /** The type of the reference number. Referring to the vendor payment id. */
            @JsonProperty("reference_number_type")
            @ExcludeMissing
            fun referenceNumberType(referenceNumberType: JsonField<ReferenceNumberType>) = apply {
                this.referenceNumberType = referenceNumberType
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

            fun build(): PaymentReference =
                PaymentReference(
                    id,
                    object_,
                    liveMode,
                    createdAt,
                    updatedAt,
                    referenceNumber,
                    referenceNumberType,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class ReferenceNumberType
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ReferenceNumberType && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val ACH_ORIGINAL_TRACE_NUMBER =
                    ReferenceNumberType(JsonField.of("ach_original_trace_number"))

                val ACH_TRACE_NUMBER = ReferenceNumberType(JsonField.of("ach_trace_number"))

                val BANKPROV_PAYMENT_ACTIVITY_DATE =
                    ReferenceNumberType(JsonField.of("bankprov_payment_activity_date"))

                val BANKPROV_PAYMENT_ID = ReferenceNumberType(JsonField.of("bankprov_payment_id"))

                val BNK_DEV_PRENOTIFICATION_ID =
                    ReferenceNumberType(JsonField.of("bnk_dev_prenotification_id"))

                val BNK_DEV_TRANSFER_ID = ReferenceNumberType(JsonField.of("bnk_dev_transfer_id"))

                val BOFA_END_TO_END_ID = ReferenceNumberType(JsonField.of("bofa_end_to_end_id"))

                val BOFA_TRANSACTION_ID = ReferenceNumberType(JsonField.of("bofa_transaction_id"))

                val CHECK_NUMBER = ReferenceNumberType(JsonField.of("check_number"))

                val COLUMN_FX_QUOTE_ID = ReferenceNumberType(JsonField.of("column_fx_quote_id"))

                val COLUMN_REVERSAL_PAIR_TRANSFER_ID =
                    ReferenceNumberType(JsonField.of("column_reversal_pair_transfer_id"))

                val COLUMN_TRANSFER_ID = ReferenceNumberType(JsonField.of("column_transfer_id"))

                val CROSS_RIVER_PAYMENT_ID =
                    ReferenceNumberType(JsonField.of("cross_river_payment_id"))

                val CROSS_RIVER_TRANSACTION_ID =
                    ReferenceNumberType(JsonField.of("cross_river_transaction_id"))

                val CURRENCYCLOUD_CONVERSION_ID =
                    ReferenceNumberType(JsonField.of("currencycloud_conversion_id"))

                val CURRENCYCLOUD_PAYMENT_ID =
                    ReferenceNumberType(JsonField.of("currencycloud_payment_id"))

                val DC_BANK_TRANSACTION_ID =
                    ReferenceNumberType(JsonField.of("dc_bank_transaction_id"))

                val DWOLLA_TRANSACTION_ID =
                    ReferenceNumberType(JsonField.of("dwolla_transaction_id"))

                val EFT_TRACE_NUMBER = ReferenceNumberType(JsonField.of("eft_trace_number"))

                val EVOLVE_TRANSACTION_ID =
                    ReferenceNumberType(JsonField.of("evolve_transaction_id"))

                val FEDWIRE_IMAD = ReferenceNumberType(JsonField.of("fedwire_imad"))

                val FEDWIRE_OMAD = ReferenceNumberType(JsonField.of("fedwire_omad"))

                val FIRST_REPUBLIC_INTERNAL_ID =
                    ReferenceNumberType(JsonField.of("first_republic_internal_id"))

                val GOLDMAN_SACHS_COLLECTION_REQUEST_ID =
                    ReferenceNumberType(JsonField.of("goldman_sachs_collection_request_id"))

                val GOLDMAN_SACHS_END_TO_END_ID =
                    ReferenceNumberType(JsonField.of("goldman_sachs_end_to_end_id"))

                val GOLDMAN_SACHS_PAYMENT_REQUEST_ID =
                    ReferenceNumberType(JsonField.of("goldman_sachs_payment_request_id"))

                val GOLDMAN_SACHS_REQUEST_ID =
                    ReferenceNumberType(JsonField.of("goldman_sachs_request_id"))

                val GOLDMAN_SACHS_UNIQUE_PAYMENT_ID =
                    ReferenceNumberType(JsonField.of("goldman_sachs_unique_payment_id"))

                val INTERAC_MESSAGE_ID = ReferenceNumberType(JsonField.of("interac_message_id"))

                val JPMC_CCN = ReferenceNumberType(JsonField.of("jpmc_ccn"))

                val JPMC_CUSTOMER_REFERENCE_ID =
                    ReferenceNumberType(JsonField.of("jpmc_customer_reference_id"))

                val JPMC_END_TO_END_ID = ReferenceNumberType(JsonField.of("jpmc_end_to_end_id"))

                val JPMC_FIRM_ROOT_ID = ReferenceNumberType(JsonField.of("jpmc_firm_root_id"))

                val JPMC_P3_ID = ReferenceNumberType(JsonField.of("jpmc_p3_id"))

                val JPMC_PAYMENT_BATCH_ID =
                    ReferenceNumberType(JsonField.of("jpmc_payment_batch_id"))

                val JPMC_PAYMENT_INFORMATION_ID =
                    ReferenceNumberType(JsonField.of("jpmc_payment_information_id"))

                val JPMC_PAYMENT_RETURNED_DATETIME =
                    ReferenceNumberType(JsonField.of("jpmc_payment_returned_datetime"))

                val LOB_CHECK_ID = ReferenceNumberType(JsonField.of("lob_check_id"))

                val OTHER = ReferenceNumberType(JsonField.of("other"))

                val PARTIAL_SWIFT_MIR = ReferenceNumberType(JsonField.of("partial_swift_mir"))

                val PNC_CLEARING_REFERENCE =
                    ReferenceNumberType(JsonField.of("pnc_clearing_reference"))

                val PNC_INSTRUCTION_ID = ReferenceNumberType(JsonField.of("pnc_instruction_id"))

                val PNC_MULTIPAYMENT_ID = ReferenceNumberType(JsonField.of("pnc_multipayment_id"))

                val PNC_PAYMENT_TRACE_ID = ReferenceNumberType(JsonField.of("pnc_payment_trace_id"))

                val RSPEC_VENDOR_PAYMENT_ID =
                    ReferenceNumberType(JsonField.of("rspec_vendor_payment_id"))

                val RTP_INSTRUCTION_ID = ReferenceNumberType(JsonField.of("rtp_instruction_id"))

                val SIGNET_API_REFERENCE_ID =
                    ReferenceNumberType(JsonField.of("signet_api_reference_id"))

                val SIGNET_CONFIRMATION_ID =
                    ReferenceNumberType(JsonField.of("signet_confirmation_id"))

                val SIGNET_REQUEST_ID = ReferenceNumberType(JsonField.of("signet_request_id"))

                val SILVERGATE_PAYMENT_ID =
                    ReferenceNumberType(JsonField.of("silvergate_payment_id"))

                val SWIFT_MIR = ReferenceNumberType(JsonField.of("swift_mir"))

                val SWIFT_UETR = ReferenceNumberType(JsonField.of("swift_uetr"))

                val USBANK_PAYMENT_ID = ReferenceNumberType(JsonField.of("usbank_payment_id"))

                val WELLS_FARGO_PAYMENT_ID =
                    ReferenceNumberType(JsonField.of("wells_fargo_payment_id"))

                val WELLS_FARGO_TRACE_NUMBER =
                    ReferenceNumberType(JsonField.of("wells_fargo_trace_number"))

                fun of(value: String) = ReferenceNumberType(JsonField.of(value))
            }

            enum class Known {
                ACH_ORIGINAL_TRACE_NUMBER,
                ACH_TRACE_NUMBER,
                BANKPROV_PAYMENT_ACTIVITY_DATE,
                BANKPROV_PAYMENT_ID,
                BNK_DEV_PRENOTIFICATION_ID,
                BNK_DEV_TRANSFER_ID,
                BOFA_END_TO_END_ID,
                BOFA_TRANSACTION_ID,
                CHECK_NUMBER,
                COLUMN_FX_QUOTE_ID,
                COLUMN_REVERSAL_PAIR_TRANSFER_ID,
                COLUMN_TRANSFER_ID,
                CROSS_RIVER_PAYMENT_ID,
                CROSS_RIVER_TRANSACTION_ID,
                CURRENCYCLOUD_CONVERSION_ID,
                CURRENCYCLOUD_PAYMENT_ID,
                DC_BANK_TRANSACTION_ID,
                DWOLLA_TRANSACTION_ID,
                EFT_TRACE_NUMBER,
                EVOLVE_TRANSACTION_ID,
                FEDWIRE_IMAD,
                FEDWIRE_OMAD,
                FIRST_REPUBLIC_INTERNAL_ID,
                GOLDMAN_SACHS_COLLECTION_REQUEST_ID,
                GOLDMAN_SACHS_END_TO_END_ID,
                GOLDMAN_SACHS_PAYMENT_REQUEST_ID,
                GOLDMAN_SACHS_REQUEST_ID,
                GOLDMAN_SACHS_UNIQUE_PAYMENT_ID,
                INTERAC_MESSAGE_ID,
                JPMC_CCN,
                JPMC_CUSTOMER_REFERENCE_ID,
                JPMC_END_TO_END_ID,
                JPMC_FIRM_ROOT_ID,
                JPMC_P3_ID,
                JPMC_PAYMENT_BATCH_ID,
                JPMC_PAYMENT_INFORMATION_ID,
                JPMC_PAYMENT_RETURNED_DATETIME,
                LOB_CHECK_ID,
                OTHER,
                PARTIAL_SWIFT_MIR,
                PNC_CLEARING_REFERENCE,
                PNC_INSTRUCTION_ID,
                PNC_MULTIPAYMENT_ID,
                PNC_PAYMENT_TRACE_ID,
                RSPEC_VENDOR_PAYMENT_ID,
                RTP_INSTRUCTION_ID,
                SIGNET_API_REFERENCE_ID,
                SIGNET_CONFIRMATION_ID,
                SIGNET_REQUEST_ID,
                SILVERGATE_PAYMENT_ID,
                SWIFT_MIR,
                SWIFT_UETR,
                USBANK_PAYMENT_ID,
                WELLS_FARGO_PAYMENT_ID,
                WELLS_FARGO_TRACE_NUMBER,
            }

            enum class Value {
                ACH_ORIGINAL_TRACE_NUMBER,
                ACH_TRACE_NUMBER,
                BANKPROV_PAYMENT_ACTIVITY_DATE,
                BANKPROV_PAYMENT_ID,
                BNK_DEV_PRENOTIFICATION_ID,
                BNK_DEV_TRANSFER_ID,
                BOFA_END_TO_END_ID,
                BOFA_TRANSACTION_ID,
                CHECK_NUMBER,
                COLUMN_FX_QUOTE_ID,
                COLUMN_REVERSAL_PAIR_TRANSFER_ID,
                COLUMN_TRANSFER_ID,
                CROSS_RIVER_PAYMENT_ID,
                CROSS_RIVER_TRANSACTION_ID,
                CURRENCYCLOUD_CONVERSION_ID,
                CURRENCYCLOUD_PAYMENT_ID,
                DC_BANK_TRANSACTION_ID,
                DWOLLA_TRANSACTION_ID,
                EFT_TRACE_NUMBER,
                EVOLVE_TRANSACTION_ID,
                FEDWIRE_IMAD,
                FEDWIRE_OMAD,
                FIRST_REPUBLIC_INTERNAL_ID,
                GOLDMAN_SACHS_COLLECTION_REQUEST_ID,
                GOLDMAN_SACHS_END_TO_END_ID,
                GOLDMAN_SACHS_PAYMENT_REQUEST_ID,
                GOLDMAN_SACHS_REQUEST_ID,
                GOLDMAN_SACHS_UNIQUE_PAYMENT_ID,
                INTERAC_MESSAGE_ID,
                JPMC_CCN,
                JPMC_CUSTOMER_REFERENCE_ID,
                JPMC_END_TO_END_ID,
                JPMC_FIRM_ROOT_ID,
                JPMC_P3_ID,
                JPMC_PAYMENT_BATCH_ID,
                JPMC_PAYMENT_INFORMATION_ID,
                JPMC_PAYMENT_RETURNED_DATETIME,
                LOB_CHECK_ID,
                OTHER,
                PARTIAL_SWIFT_MIR,
                PNC_CLEARING_REFERENCE,
                PNC_INSTRUCTION_ID,
                PNC_MULTIPAYMENT_ID,
                PNC_PAYMENT_TRACE_ID,
                RSPEC_VENDOR_PAYMENT_ID,
                RTP_INSTRUCTION_ID,
                SIGNET_API_REFERENCE_ID,
                SIGNET_CONFIRMATION_ID,
                SIGNET_REQUEST_ID,
                SILVERGATE_PAYMENT_ID,
                SWIFT_MIR,
                SWIFT_UETR,
                USBANK_PAYMENT_ID,
                WELLS_FARGO_PAYMENT_ID,
                WELLS_FARGO_TRACE_NUMBER,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ACH_ORIGINAL_TRACE_NUMBER -> Value.ACH_ORIGINAL_TRACE_NUMBER
                    ACH_TRACE_NUMBER -> Value.ACH_TRACE_NUMBER
                    BANKPROV_PAYMENT_ACTIVITY_DATE -> Value.BANKPROV_PAYMENT_ACTIVITY_DATE
                    BANKPROV_PAYMENT_ID -> Value.BANKPROV_PAYMENT_ID
                    BNK_DEV_PRENOTIFICATION_ID -> Value.BNK_DEV_PRENOTIFICATION_ID
                    BNK_DEV_TRANSFER_ID -> Value.BNK_DEV_TRANSFER_ID
                    BOFA_END_TO_END_ID -> Value.BOFA_END_TO_END_ID
                    BOFA_TRANSACTION_ID -> Value.BOFA_TRANSACTION_ID
                    CHECK_NUMBER -> Value.CHECK_NUMBER
                    COLUMN_FX_QUOTE_ID -> Value.COLUMN_FX_QUOTE_ID
                    COLUMN_REVERSAL_PAIR_TRANSFER_ID -> Value.COLUMN_REVERSAL_PAIR_TRANSFER_ID
                    COLUMN_TRANSFER_ID -> Value.COLUMN_TRANSFER_ID
                    CROSS_RIVER_PAYMENT_ID -> Value.CROSS_RIVER_PAYMENT_ID
                    CROSS_RIVER_TRANSACTION_ID -> Value.CROSS_RIVER_TRANSACTION_ID
                    CURRENCYCLOUD_CONVERSION_ID -> Value.CURRENCYCLOUD_CONVERSION_ID
                    CURRENCYCLOUD_PAYMENT_ID -> Value.CURRENCYCLOUD_PAYMENT_ID
                    DC_BANK_TRANSACTION_ID -> Value.DC_BANK_TRANSACTION_ID
                    DWOLLA_TRANSACTION_ID -> Value.DWOLLA_TRANSACTION_ID
                    EFT_TRACE_NUMBER -> Value.EFT_TRACE_NUMBER
                    EVOLVE_TRANSACTION_ID -> Value.EVOLVE_TRANSACTION_ID
                    FEDWIRE_IMAD -> Value.FEDWIRE_IMAD
                    FEDWIRE_OMAD -> Value.FEDWIRE_OMAD
                    FIRST_REPUBLIC_INTERNAL_ID -> Value.FIRST_REPUBLIC_INTERNAL_ID
                    GOLDMAN_SACHS_COLLECTION_REQUEST_ID -> Value.GOLDMAN_SACHS_COLLECTION_REQUEST_ID
                    GOLDMAN_SACHS_END_TO_END_ID -> Value.GOLDMAN_SACHS_END_TO_END_ID
                    GOLDMAN_SACHS_PAYMENT_REQUEST_ID -> Value.GOLDMAN_SACHS_PAYMENT_REQUEST_ID
                    GOLDMAN_SACHS_REQUEST_ID -> Value.GOLDMAN_SACHS_REQUEST_ID
                    GOLDMAN_SACHS_UNIQUE_PAYMENT_ID -> Value.GOLDMAN_SACHS_UNIQUE_PAYMENT_ID
                    INTERAC_MESSAGE_ID -> Value.INTERAC_MESSAGE_ID
                    JPMC_CCN -> Value.JPMC_CCN
                    JPMC_CUSTOMER_REFERENCE_ID -> Value.JPMC_CUSTOMER_REFERENCE_ID
                    JPMC_END_TO_END_ID -> Value.JPMC_END_TO_END_ID
                    JPMC_FIRM_ROOT_ID -> Value.JPMC_FIRM_ROOT_ID
                    JPMC_P3_ID -> Value.JPMC_P3_ID
                    JPMC_PAYMENT_BATCH_ID -> Value.JPMC_PAYMENT_BATCH_ID
                    JPMC_PAYMENT_INFORMATION_ID -> Value.JPMC_PAYMENT_INFORMATION_ID
                    JPMC_PAYMENT_RETURNED_DATETIME -> Value.JPMC_PAYMENT_RETURNED_DATETIME
                    LOB_CHECK_ID -> Value.LOB_CHECK_ID
                    OTHER -> Value.OTHER
                    PARTIAL_SWIFT_MIR -> Value.PARTIAL_SWIFT_MIR
                    PNC_CLEARING_REFERENCE -> Value.PNC_CLEARING_REFERENCE
                    PNC_INSTRUCTION_ID -> Value.PNC_INSTRUCTION_ID
                    PNC_MULTIPAYMENT_ID -> Value.PNC_MULTIPAYMENT_ID
                    PNC_PAYMENT_TRACE_ID -> Value.PNC_PAYMENT_TRACE_ID
                    RSPEC_VENDOR_PAYMENT_ID -> Value.RSPEC_VENDOR_PAYMENT_ID
                    RTP_INSTRUCTION_ID -> Value.RTP_INSTRUCTION_ID
                    SIGNET_API_REFERENCE_ID -> Value.SIGNET_API_REFERENCE_ID
                    SIGNET_CONFIRMATION_ID -> Value.SIGNET_CONFIRMATION_ID
                    SIGNET_REQUEST_ID -> Value.SIGNET_REQUEST_ID
                    SILVERGATE_PAYMENT_ID -> Value.SILVERGATE_PAYMENT_ID
                    SWIFT_MIR -> Value.SWIFT_MIR
                    SWIFT_UETR -> Value.SWIFT_UETR
                    USBANK_PAYMENT_ID -> Value.USBANK_PAYMENT_ID
                    WELLS_FARGO_PAYMENT_ID -> Value.WELLS_FARGO_PAYMENT_ID
                    WELLS_FARGO_TRACE_NUMBER -> Value.WELLS_FARGO_TRACE_NUMBER
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ACH_ORIGINAL_TRACE_NUMBER -> Known.ACH_ORIGINAL_TRACE_NUMBER
                    ACH_TRACE_NUMBER -> Known.ACH_TRACE_NUMBER
                    BANKPROV_PAYMENT_ACTIVITY_DATE -> Known.BANKPROV_PAYMENT_ACTIVITY_DATE
                    BANKPROV_PAYMENT_ID -> Known.BANKPROV_PAYMENT_ID
                    BNK_DEV_PRENOTIFICATION_ID -> Known.BNK_DEV_PRENOTIFICATION_ID
                    BNK_DEV_TRANSFER_ID -> Known.BNK_DEV_TRANSFER_ID
                    BOFA_END_TO_END_ID -> Known.BOFA_END_TO_END_ID
                    BOFA_TRANSACTION_ID -> Known.BOFA_TRANSACTION_ID
                    CHECK_NUMBER -> Known.CHECK_NUMBER
                    COLUMN_FX_QUOTE_ID -> Known.COLUMN_FX_QUOTE_ID
                    COLUMN_REVERSAL_PAIR_TRANSFER_ID -> Known.COLUMN_REVERSAL_PAIR_TRANSFER_ID
                    COLUMN_TRANSFER_ID -> Known.COLUMN_TRANSFER_ID
                    CROSS_RIVER_PAYMENT_ID -> Known.CROSS_RIVER_PAYMENT_ID
                    CROSS_RIVER_TRANSACTION_ID -> Known.CROSS_RIVER_TRANSACTION_ID
                    CURRENCYCLOUD_CONVERSION_ID -> Known.CURRENCYCLOUD_CONVERSION_ID
                    CURRENCYCLOUD_PAYMENT_ID -> Known.CURRENCYCLOUD_PAYMENT_ID
                    DC_BANK_TRANSACTION_ID -> Known.DC_BANK_TRANSACTION_ID
                    DWOLLA_TRANSACTION_ID -> Known.DWOLLA_TRANSACTION_ID
                    EFT_TRACE_NUMBER -> Known.EFT_TRACE_NUMBER
                    EVOLVE_TRANSACTION_ID -> Known.EVOLVE_TRANSACTION_ID
                    FEDWIRE_IMAD -> Known.FEDWIRE_IMAD
                    FEDWIRE_OMAD -> Known.FEDWIRE_OMAD
                    FIRST_REPUBLIC_INTERNAL_ID -> Known.FIRST_REPUBLIC_INTERNAL_ID
                    GOLDMAN_SACHS_COLLECTION_REQUEST_ID -> Known.GOLDMAN_SACHS_COLLECTION_REQUEST_ID
                    GOLDMAN_SACHS_END_TO_END_ID -> Known.GOLDMAN_SACHS_END_TO_END_ID
                    GOLDMAN_SACHS_PAYMENT_REQUEST_ID -> Known.GOLDMAN_SACHS_PAYMENT_REQUEST_ID
                    GOLDMAN_SACHS_REQUEST_ID -> Known.GOLDMAN_SACHS_REQUEST_ID
                    GOLDMAN_SACHS_UNIQUE_PAYMENT_ID -> Known.GOLDMAN_SACHS_UNIQUE_PAYMENT_ID
                    INTERAC_MESSAGE_ID -> Known.INTERAC_MESSAGE_ID
                    JPMC_CCN -> Known.JPMC_CCN
                    JPMC_CUSTOMER_REFERENCE_ID -> Known.JPMC_CUSTOMER_REFERENCE_ID
                    JPMC_END_TO_END_ID -> Known.JPMC_END_TO_END_ID
                    JPMC_FIRM_ROOT_ID -> Known.JPMC_FIRM_ROOT_ID
                    JPMC_P3_ID -> Known.JPMC_P3_ID
                    JPMC_PAYMENT_BATCH_ID -> Known.JPMC_PAYMENT_BATCH_ID
                    JPMC_PAYMENT_INFORMATION_ID -> Known.JPMC_PAYMENT_INFORMATION_ID
                    JPMC_PAYMENT_RETURNED_DATETIME -> Known.JPMC_PAYMENT_RETURNED_DATETIME
                    LOB_CHECK_ID -> Known.LOB_CHECK_ID
                    OTHER -> Known.OTHER
                    PARTIAL_SWIFT_MIR -> Known.PARTIAL_SWIFT_MIR
                    PNC_CLEARING_REFERENCE -> Known.PNC_CLEARING_REFERENCE
                    PNC_INSTRUCTION_ID -> Known.PNC_INSTRUCTION_ID
                    PNC_MULTIPAYMENT_ID -> Known.PNC_MULTIPAYMENT_ID
                    PNC_PAYMENT_TRACE_ID -> Known.PNC_PAYMENT_TRACE_ID
                    RSPEC_VENDOR_PAYMENT_ID -> Known.RSPEC_VENDOR_PAYMENT_ID
                    RTP_INSTRUCTION_ID -> Known.RTP_INSTRUCTION_ID
                    SIGNET_API_REFERENCE_ID -> Known.SIGNET_API_REFERENCE_ID
                    SIGNET_CONFIRMATION_ID -> Known.SIGNET_CONFIRMATION_ID
                    SIGNET_REQUEST_ID -> Known.SIGNET_REQUEST_ID
                    SILVERGATE_PAYMENT_ID -> Known.SILVERGATE_PAYMENT_ID
                    SWIFT_MIR -> Known.SWIFT_MIR
                    SWIFT_UETR -> Known.SWIFT_UETR
                    USBANK_PAYMENT_ID -> Known.USBANK_PAYMENT_ID
                    WELLS_FARGO_PAYMENT_ID -> Known.WELLS_FARGO_PAYMENT_ID
                    WELLS_FARGO_TRACE_NUMBER -> Known.WELLS_FARGO_TRACE_NUMBER
                    else ->
                        throw ModernTreasuryInvalidDataException(
                            "Unknown ReferenceNumberType: $value"
                        )
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val APPROVED = Status(JsonField.of("approved"))

            val CANCELLED = Status(JsonField.of("cancelled"))

            val COMPLETED = Status(JsonField.of("completed"))

            val DENIED = Status(JsonField.of("denied"))

            val FAILED = Status(JsonField.of("failed"))

            val NEEDS_APPROVAL = Status(JsonField.of("needs_approval"))

            val PENDING = Status(JsonField.of("pending"))

            val PROCESSING = Status(JsonField.of("processing"))

            val RETURNED = Status(JsonField.of("returned"))

            val REVERSED = Status(JsonField.of("reversed"))

            val SENT = Status(JsonField.of("sent"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            APPROVED,
            CANCELLED,
            COMPLETED,
            DENIED,
            FAILED,
            NEEDS_APPROVAL,
            PENDING,
            PROCESSING,
            RETURNED,
            REVERSED,
            SENT,
        }

        enum class Value {
            APPROVED,
            CANCELLED,
            COMPLETED,
            DENIED,
            FAILED,
            NEEDS_APPROVAL,
            PENDING,
            PROCESSING,
            RETURNED,
            REVERSED,
            SENT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                APPROVED -> Value.APPROVED
                CANCELLED -> Value.CANCELLED
                COMPLETED -> Value.COMPLETED
                DENIED -> Value.DENIED
                FAILED -> Value.FAILED
                NEEDS_APPROVAL -> Value.NEEDS_APPROVAL
                PENDING -> Value.PENDING
                PROCESSING -> Value.PROCESSING
                RETURNED -> Value.RETURNED
                REVERSED -> Value.REVERSED
                SENT -> Value.SENT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                APPROVED -> Known.APPROVED
                CANCELLED -> Known.CANCELLED
                COMPLETED -> Known.COMPLETED
                DENIED -> Known.DENIED
                FAILED -> Known.FAILED
                NEEDS_APPROVAL -> Known.NEEDS_APPROVAL
                PENDING -> Known.PENDING
                PROCESSING -> Known.PROCESSING
                RETURNED -> Known.RETURNED
                REVERSED -> Known.REVERSED
                SENT -> Known.SENT
                else -> throw ModernTreasuryInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
