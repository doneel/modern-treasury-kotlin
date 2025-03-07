package com.moderntreasury.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LedgerAccountTest {

    @Test
    fun createLedgerAccount() {
        val ledgerAccount =
            LedgerAccount.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .balances(
                    LedgerAccount.LedgerBalancesWithEffectiveAt.builder()
                        .availableBalance(
                            LedgerAccount.LedgerBalancesWithEffectiveAt.LedgerBalance.builder()
                                .amount(123L)
                                .credits(123L)
                                .currency("string")
                                .currencyExponent(123L)
                                .debits(123L)
                                .build()
                        )
                        .effectiveAtLowerBound("string")
                        .effectiveAtUpperBound("string")
                        .pendingBalance(
                            LedgerAccount.LedgerBalancesWithEffectiveAt.LedgerBalance.builder()
                                .amount(123L)
                                .credits(123L)
                                .currency("string")
                                .currencyExponent(123L)
                                .debits(123L)
                                .build()
                        )
                        .postedBalance(
                            LedgerAccount.LedgerBalancesWithEffectiveAt.LedgerBalance.builder()
                                .amount(123L)
                                .credits(123L)
                                .currency("string")
                                .currencyExponent(123L)
                                .debits(123L)
                                .build()
                        )
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("string")
                .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ledgerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .ledgerableId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .ledgerableType(LedgerAccount.LedgerableType.EXTERNAL_ACCOUNT)
                .liveMode(true)
                .lockVersion(123L)
                .metadata(LedgerAccount.Metadata.builder().build())
                .name("string")
                .normalBalance(LedgerAccount.NormalBalance.CREDIT)
                .object_("string")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        assertThat(ledgerAccount).isNotNull
        assertThat(ledgerAccount.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerAccount.balances())
            .isEqualTo(
                LedgerAccount.LedgerBalancesWithEffectiveAt.builder()
                    .availableBalance(
                        LedgerAccount.LedgerBalancesWithEffectiveAt.LedgerBalance.builder()
                            .amount(123L)
                            .credits(123L)
                            .currency("string")
                            .currencyExponent(123L)
                            .debits(123L)
                            .build()
                    )
                    .effectiveAtLowerBound("string")
                    .effectiveAtUpperBound("string")
                    .pendingBalance(
                        LedgerAccount.LedgerBalancesWithEffectiveAt.LedgerBalance.builder()
                            .amount(123L)
                            .credits(123L)
                            .currency("string")
                            .currencyExponent(123L)
                            .debits(123L)
                            .build()
                    )
                    .postedBalance(
                        LedgerAccount.LedgerBalancesWithEffectiveAt.LedgerBalance.builder()
                            .amount(123L)
                            .credits(123L)
                            .currency("string")
                            .currencyExponent(123L)
                            .debits(123L)
                            .build()
                    )
                    .build()
            )
        assertThat(ledgerAccount.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(ledgerAccount.description()).isEqualTo("string")
        assertThat(ledgerAccount.discardedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(ledgerAccount.ledgerId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerAccount.ledgerableId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerAccount.ledgerableType())
            .isEqualTo(LedgerAccount.LedgerableType.EXTERNAL_ACCOUNT)
        assertThat(ledgerAccount.liveMode()).isEqualTo(true)
        assertThat(ledgerAccount.lockVersion()).isEqualTo(123L)
        assertThat(ledgerAccount.metadata()).isEqualTo(LedgerAccount.Metadata.builder().build())
        assertThat(ledgerAccount.name()).isEqualTo("string")
        assertThat(ledgerAccount.normalBalance()).isEqualTo(LedgerAccount.NormalBalance.CREDIT)
        assertThat(ledgerAccount.object_()).isEqualTo("string")
        assertThat(ledgerAccount.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }
}
