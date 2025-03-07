package com.moderntreasury.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExternalAccountTest {

    @Test
    fun createExternalAccount() {
        val externalAccount =
            ExternalAccount.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .accountDetails(
                    listOf(
                        AccountDetail.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .accountNumberSafe("string")
                            .accountNumberType(AccountDetail.AccountNumberType.CLABE)
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .liveMode(true)
                            .object_("string")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .accountNumber("string")
                            .build()
                    )
                )
                .accountType(ExternalAccountType.CASH)
                .contactDetails(
                    listOf(
                        ExternalAccount.ContactDetail.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .contactIdentifier("string")
                            .contactIdentifierType(
                                ExternalAccount.ContactDetail.ContactIdentifierType.EMAIL
                            )
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .liveMode(true)
                            .object_("string")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                )
                .counterpartyId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ledgerAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .liveMode(true)
                .metadata(ExternalAccount.Metadata.builder().build())
                .name("string")
                .object_("string")
                .partyAddress(
                    ExternalAccount.Address.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .country("string")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .line1("string")
                        .line2("string")
                        .liveMode(true)
                        .locality("string")
                        .object_("string")
                        .postalCode("string")
                        .region("string")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .partyName("string")
                .partyType(ExternalAccount.PartyType.BUSINESS)
                .routingDetails(
                    listOf(
                        RoutingDetail.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .bankAddress(
                                RoutingDetail.Address.builder()
                                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    .country("string")
                                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .line1("string")
                                    .line2("string")
                                    .liveMode(true)
                                    .locality("string")
                                    .object_("string")
                                    .postalCode("string")
                                    .region("string")
                                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .build()
                            )
                            .bankName("string")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .liveMode(true)
                            .object_("string")
                            .paymentType(RoutingDetail.PaymentType.ACH)
                            .routingNumber("string")
                            .routingNumberType(RoutingDetail.RoutingNumberType.ABA)
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                )
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .verificationStatus(ExternalAccount.VerificationStatus.PENDING_VERIFICATION)
                .build()
        assertThat(externalAccount).isNotNull
        assertThat(externalAccount.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(externalAccount.accountDetails())
            .containsExactly(
                AccountDetail.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .accountNumberSafe("string")
                    .accountNumberType(AccountDetail.AccountNumberType.CLABE)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .liveMode(true)
                    .object_("string")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .accountNumber("string")
                    .build()
            )
        assertThat(externalAccount.accountType()).isEqualTo(ExternalAccountType.CASH)
        assertThat(externalAccount.contactDetails())
            .containsExactly(
                ExternalAccount.ContactDetail.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .contactIdentifier("string")
                    .contactIdentifierType(
                        ExternalAccount.ContactDetail.ContactIdentifierType.EMAIL
                    )
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .liveMode(true)
                    .object_("string")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(externalAccount.counterpartyId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(externalAccount.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(externalAccount.discardedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(externalAccount.ledgerAccountId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(externalAccount.liveMode()).isEqualTo(true)
        assertThat(externalAccount.metadata()).isEqualTo(ExternalAccount.Metadata.builder().build())
        assertThat(externalAccount.name()).isEqualTo("string")
        assertThat(externalAccount.object_()).isEqualTo("string")
        assertThat(externalAccount.partyAddress())
            .isEqualTo(
                ExternalAccount.Address.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .country("string")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .line1("string")
                    .line2("string")
                    .liveMode(true)
                    .locality("string")
                    .object_("string")
                    .postalCode("string")
                    .region("string")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(externalAccount.partyName()).isEqualTo("string")
        assertThat(externalAccount.partyType()).isEqualTo(ExternalAccount.PartyType.BUSINESS)
        assertThat(externalAccount.routingDetails())
            .containsExactly(
                RoutingDetail.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .bankAddress(
                        RoutingDetail.Address.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .country("string")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .line1("string")
                            .line2("string")
                            .liveMode(true)
                            .locality("string")
                            .object_("string")
                            .postalCode("string")
                            .region("string")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .bankName("string")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .liveMode(true)
                    .object_("string")
                    .paymentType(RoutingDetail.PaymentType.ACH)
                    .routingNumber("string")
                    .routingNumberType(RoutingDetail.RoutingNumberType.ABA)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(externalAccount.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(externalAccount.verificationStatus())
            .isEqualTo(ExternalAccount.VerificationStatus.PENDING_VERIFICATION)
    }
}
