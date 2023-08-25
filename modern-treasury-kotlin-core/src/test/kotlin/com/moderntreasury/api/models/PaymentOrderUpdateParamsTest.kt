package com.moderntreasury.api.models

import com.moderntreasury.api.models.*
import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentOrderUpdateParamsTest {

    @Test
    fun createPaymentOrderUpdateParams() {
        PaymentOrderUpdateParams.builder()
            .id("string")
            .accounting(
                PaymentOrderUpdateParams.Accounting.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .classId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
            .accountingCategoryId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .accountingLedgerClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .amount(123L)
            .chargeBearer(PaymentOrderUpdateParams.ChargeBearer.SHARED)
            .counterpartyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .currency(Currency.AED)
            .description("string")
            .direction(PaymentOrderUpdateParams.Direction.CREDIT)
            .effectiveDate(LocalDate.parse("2019-12-27"))
            .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .fallbackType(PaymentOrderUpdateParams.FallbackType.ACH)
            .foreignExchangeContract("string")
            .foreignExchangeIndicator(
                PaymentOrderUpdateParams.ForeignExchangeIndicator.FIXED_TO_VARIABLE
            )
            .lineItems(
                listOf(
                    PaymentOrderUpdateParams.LineItemRequest.builder()
                        .amount(123L)
                        .accountingCategoryId("string")
                        .description("string")
                        .metadata(
                            PaymentOrderUpdateParams.LineItemRequest.Metadata.builder().build()
                        )
                        .build()
                )
            )
            .metadata(PaymentOrderUpdateParams.Metadata.builder().build())
            .nsfProtected(true)
            .originatingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .originatingPartyName("string")
            .priority(PaymentOrderUpdateParams.Priority.HIGH)
            .purpose("string")
            .receivingAccount(
                PaymentOrderUpdateParams.ReceivingAccount.builder()
                    .accountDetails(
                        listOf(
                            PaymentOrderUpdateParams.ReceivingAccount.AccountDetail.builder()
                                .accountNumber("string")
                                .accountNumberType(
                                    PaymentOrderUpdateParams.ReceivingAccount.AccountDetail
                                        .AccountNumberType
                                        .IBAN
                                )
                                .build()
                        )
                    )
                    .accountType(ExternalAccountType.CASH)
                    .contactDetails(
                        listOf(
                            PaymentOrderUpdateParams.ReceivingAccount.ContactDetailCreateRequest
                                .builder()
                                .contactIdentifier("string")
                                .contactIdentifierType(
                                    PaymentOrderUpdateParams.ReceivingAccount
                                        .ContactDetailCreateRequest
                                        .ContactIdentifierType
                                        .EMAIL
                                )
                                .build()
                        )
                    )
                    .ledgerAccount(
                        PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                            .builder()
                            .currency("string")
                            .ledgerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .name("string")
                            .normalBalance(
                                PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                    .NormalBalance
                                    .CREDIT
                            )
                            .currencyExponent(123L)
                            .description("string")
                            .ledgerableId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .ledgerableType(
                                PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                    .LedgerableType
                                    .EXTERNAL_ACCOUNT
                            )
                            .metadata(
                                PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                    .Metadata
                                    .builder()
                                    .build()
                            )
                            .build()
                    )
                    .metadata(PaymentOrderUpdateParams.ReceivingAccount.Metadata.builder().build())
                    .name("string")
                    .partyAddress(
                        PaymentOrderUpdateParams.ReceivingAccount.AddressRequest.builder()
                            .country("string")
                            .line1("string")
                            .line2("string")
                            .locality("string")
                            .postalCode("string")
                            .region("string")
                            .build()
                    )
                    .partyIdentifier("string")
                    .partyName("string")
                    .partyType(PaymentOrderUpdateParams.ReceivingAccount.PartyType.BUSINESS)
                    .plaidProcessorToken("string")
                    .routingDetails(
                        listOf(
                            PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail.builder()
                                .routingNumber("string")
                                .routingNumberType(
                                    PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail
                                        .RoutingNumberType
                                        .ABA
                                )
                                .paymentType(
                                    PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail
                                        .PaymentType
                                        .ACH
                                )
                                .build()
                        )
                    )
                    .build()
            )
            .receivingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .remittanceInformation("string")
            .sendRemittanceAdvice(true)
            .statementDescriptor("string")
            .status(PaymentOrderUpdateParams.Status.APPROVED)
            .subtype(PaymentOrderSubtype.BACS_NEW_INSTRUCTION)
            .type(PaymentOrderType.ACH)
            .ultimateOriginatingPartyIdentifier("string")
            .ultimateOriginatingPartyName("string")
            .ultimateReceivingPartyIdentifier("string")
            .ultimateReceivingPartyName("string")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            PaymentOrderUpdateParams.builder()
                .id("string")
                .accounting(
                    PaymentOrderUpdateParams.Accounting.builder()
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .classId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .build()
                )
                .accountingCategoryId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountingLedgerClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .amount(123L)
                .chargeBearer(PaymentOrderUpdateParams.ChargeBearer.SHARED)
                .counterpartyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .currency(Currency.AED)
                .description("string")
                .direction(PaymentOrderUpdateParams.Direction.CREDIT)
                .effectiveDate(LocalDate.parse("2019-12-27"))
                .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fallbackType(PaymentOrderUpdateParams.FallbackType.ACH)
                .foreignExchangeContract("string")
                .foreignExchangeIndicator(
                    PaymentOrderUpdateParams.ForeignExchangeIndicator.FIXED_TO_VARIABLE
                )
                .lineItems(
                    listOf(
                        PaymentOrderUpdateParams.LineItemRequest.builder()
                            .amount(123L)
                            .accountingCategoryId("string")
                            .description("string")
                            .metadata(
                                PaymentOrderUpdateParams.LineItemRequest.Metadata.builder().build()
                            )
                            .build()
                    )
                )
                .metadata(PaymentOrderUpdateParams.Metadata.builder().build())
                .nsfProtected(true)
                .originatingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .originatingPartyName("string")
                .priority(PaymentOrderUpdateParams.Priority.HIGH)
                .purpose("string")
                .receivingAccount(
                    PaymentOrderUpdateParams.ReceivingAccount.builder()
                        .accountDetails(
                            listOf(
                                PaymentOrderUpdateParams.ReceivingAccount.AccountDetail.builder()
                                    .accountNumber("string")
                                    .accountNumberType(
                                        PaymentOrderUpdateParams.ReceivingAccount.AccountDetail
                                            .AccountNumberType
                                            .IBAN
                                    )
                                    .build()
                            )
                        )
                        .accountType(ExternalAccountType.CASH)
                        .contactDetails(
                            listOf(
                                PaymentOrderUpdateParams.ReceivingAccount.ContactDetailCreateRequest
                                    .builder()
                                    .contactIdentifier("string")
                                    .contactIdentifierType(
                                        PaymentOrderUpdateParams.ReceivingAccount
                                            .ContactDetailCreateRequest
                                            .ContactIdentifierType
                                            .EMAIL
                                    )
                                    .build()
                            )
                        )
                        .ledgerAccount(
                            PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                .builder()
                                .currency("string")
                                .ledgerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .name("string")
                                .normalBalance(
                                    PaymentOrderUpdateParams.ReceivingAccount
                                        .LedgerAccountCreateRequest
                                        .NormalBalance
                                        .CREDIT
                                )
                                .currencyExponent(123L)
                                .description("string")
                                .ledgerableId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .ledgerableType(
                                    PaymentOrderUpdateParams.ReceivingAccount
                                        .LedgerAccountCreateRequest
                                        .LedgerableType
                                        .EXTERNAL_ACCOUNT
                                )
                                .metadata(
                                    PaymentOrderUpdateParams.ReceivingAccount
                                        .LedgerAccountCreateRequest
                                        .Metadata
                                        .builder()
                                        .build()
                                )
                                .build()
                        )
                        .metadata(
                            PaymentOrderUpdateParams.ReceivingAccount.Metadata.builder().build()
                        )
                        .name("string")
                        .partyAddress(
                            PaymentOrderUpdateParams.ReceivingAccount.AddressRequest.builder()
                                .country("string")
                                .line1("string")
                                .line2("string")
                                .locality("string")
                                .postalCode("string")
                                .region("string")
                                .build()
                        )
                        .partyIdentifier("string")
                        .partyName("string")
                        .partyType(PaymentOrderUpdateParams.ReceivingAccount.PartyType.BUSINESS)
                        .plaidProcessorToken("string")
                        .routingDetails(
                            listOf(
                                PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail.builder()
                                    .routingNumber("string")
                                    .routingNumberType(
                                        PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail
                                            .RoutingNumberType
                                            .ABA
                                    )
                                    .paymentType(
                                        PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail
                                            .PaymentType
                                            .ACH
                                    )
                                    .build()
                            )
                        )
                        .build()
                )
                .receivingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .remittanceInformation("string")
                .sendRemittanceAdvice(true)
                .statementDescriptor("string")
                .status(PaymentOrderUpdateParams.Status.APPROVED)
                .subtype(PaymentOrderSubtype.BACS_NEW_INSTRUCTION)
                .type(PaymentOrderType.ACH)
                .ultimateOriginatingPartyIdentifier("string")
                .ultimateOriginatingPartyName("string")
                .ultimateReceivingPartyIdentifier("string")
                .ultimateReceivingPartyName("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accounting())
            .isEqualTo(
                PaymentOrderUpdateParams.Accounting.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .classId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(body.accountingCategoryId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.accountingLedgerClassId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.amount()).isEqualTo(123L)
        assertThat(body.chargeBearer()).isEqualTo(PaymentOrderUpdateParams.ChargeBearer.SHARED)
        assertThat(body.counterpartyId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.currency()).isEqualTo(Currency.AED)
        assertThat(body.description()).isEqualTo("string")
        assertThat(body.direction()).isEqualTo(PaymentOrderUpdateParams.Direction.CREDIT)
        assertThat(body.effectiveDate()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(body.expiresAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(body.fallbackType()).isEqualTo(PaymentOrderUpdateParams.FallbackType.ACH)
        assertThat(body.foreignExchangeContract()).isEqualTo("string")
        assertThat(body.foreignExchangeIndicator())
            .isEqualTo(PaymentOrderUpdateParams.ForeignExchangeIndicator.FIXED_TO_VARIABLE)
        assertThat(body.lineItems())
            .isEqualTo(
                listOf(
                    PaymentOrderUpdateParams.LineItemRequest.builder()
                        .amount(123L)
                        .accountingCategoryId("string")
                        .description("string")
                        .metadata(
                            PaymentOrderUpdateParams.LineItemRequest.Metadata.builder().build()
                        )
                        .build()
                )
            )
        assertThat(body.metadata()).isEqualTo(PaymentOrderUpdateParams.Metadata.builder().build())
        assertThat(body.nsfProtected()).isEqualTo(true)
        assertThat(body.originatingAccountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.originatingPartyName()).isEqualTo("string")
        assertThat(body.priority()).isEqualTo(PaymentOrderUpdateParams.Priority.HIGH)
        assertThat(body.purpose()).isEqualTo("string")
        assertThat(body.receivingAccount())
            .isEqualTo(
                PaymentOrderUpdateParams.ReceivingAccount.builder()
                    .accountDetails(
                        listOf(
                            PaymentOrderUpdateParams.ReceivingAccount.AccountDetail.builder()
                                .accountNumber("string")
                                .accountNumberType(
                                    PaymentOrderUpdateParams.ReceivingAccount.AccountDetail
                                        .AccountNumberType
                                        .IBAN
                                )
                                .build()
                        )
                    )
                    .accountType(ExternalAccountType.CASH)
                    .contactDetails(
                        listOf(
                            PaymentOrderUpdateParams.ReceivingAccount.ContactDetailCreateRequest
                                .builder()
                                .contactIdentifier("string")
                                .contactIdentifierType(
                                    PaymentOrderUpdateParams.ReceivingAccount
                                        .ContactDetailCreateRequest
                                        .ContactIdentifierType
                                        .EMAIL
                                )
                                .build()
                        )
                    )
                    .ledgerAccount(
                        PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                            .builder()
                            .currency("string")
                            .ledgerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .name("string")
                            .normalBalance(
                                PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                    .NormalBalance
                                    .CREDIT
                            )
                            .currencyExponent(123L)
                            .description("string")
                            .ledgerableId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .ledgerableType(
                                PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                    .LedgerableType
                                    .EXTERNAL_ACCOUNT
                            )
                            .metadata(
                                PaymentOrderUpdateParams.ReceivingAccount.LedgerAccountCreateRequest
                                    .Metadata
                                    .builder()
                                    .build()
                            )
                            .build()
                    )
                    .metadata(PaymentOrderUpdateParams.ReceivingAccount.Metadata.builder().build())
                    .name("string")
                    .partyAddress(
                        PaymentOrderUpdateParams.ReceivingAccount.AddressRequest.builder()
                            .country("string")
                            .line1("string")
                            .line2("string")
                            .locality("string")
                            .postalCode("string")
                            .region("string")
                            .build()
                    )
                    .partyIdentifier("string")
                    .partyName("string")
                    .partyType(PaymentOrderUpdateParams.ReceivingAccount.PartyType.BUSINESS)
                    .plaidProcessorToken("string")
                    .routingDetails(
                        listOf(
                            PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail.builder()
                                .routingNumber("string")
                                .routingNumberType(
                                    PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail
                                        .RoutingNumberType
                                        .ABA
                                )
                                .paymentType(
                                    PaymentOrderUpdateParams.ReceivingAccount.RoutingDetail
                                        .PaymentType
                                        .ACH
                                )
                                .build()
                        )
                    )
                    .build()
            )
        assertThat(body.receivingAccountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.remittanceInformation()).isEqualTo("string")
        assertThat(body.sendRemittanceAdvice()).isEqualTo(true)
        assertThat(body.statementDescriptor()).isEqualTo("string")
        assertThat(body.status()).isEqualTo(PaymentOrderUpdateParams.Status.APPROVED)
        assertThat(body.subtype()).isEqualTo(PaymentOrderSubtype.BACS_NEW_INSTRUCTION)
        assertThat(body.type()).isEqualTo(PaymentOrderType.ACH)
        assertThat(body.ultimateOriginatingPartyIdentifier()).isEqualTo("string")
        assertThat(body.ultimateOriginatingPartyName()).isEqualTo("string")
        assertThat(body.ultimateReceivingPartyIdentifier()).isEqualTo("string")
        assertThat(body.ultimateReceivingPartyName()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = PaymentOrderUpdateParams.builder().id("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = PaymentOrderUpdateParams.builder().id("string").build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
