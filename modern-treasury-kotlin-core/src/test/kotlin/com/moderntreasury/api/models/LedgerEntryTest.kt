package com.moderntreasury.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LedgerEntryTest {

    @Test
    fun createLedgerEntry() {
        val ledgerEntry =
            LedgerEntry.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .amount(123L)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .direction(LedgerEntry.Direction.CREDIT)
                .discardedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .ledgerAccountCurrency("string")
                .ledgerAccountCurrencyExponent(123L)
                .ledgerAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .ledgerAccountLockVersion(123L)
                .ledgerTransactionId("string")
                .liveMode(true)
                .metadata(LedgerEntry.Metadata.builder().build())
                .object_("string")
                .resultingLedgerAccountBalances(
                    LedgerEntry.LedgerBalances.builder()
                        .availableBalance(
                            LedgerEntry.LedgerBalances.LedgerBalance.builder()
                                .amount(123L)
                                .credits(123L)
                                .currency("string")
                                .currencyExponent(123L)
                                .debits(123L)
                                .build()
                        )
                        .pendingBalance(
                            LedgerEntry.LedgerBalances.LedgerBalance.builder()
                                .amount(123L)
                                .credits(123L)
                                .currency("string")
                                .currencyExponent(123L)
                                .debits(123L)
                                .build()
                        )
                        .postedBalance(
                            LedgerEntry.LedgerBalances.LedgerBalance.builder()
                                .amount(123L)
                                .credits(123L)
                                .currency("string")
                                .currencyExponent(123L)
                                .debits(123L)
                                .build()
                        )
                        .build()
                )
                .status(LedgerEntry.Status.ARCHIVED)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        assertThat(ledgerEntry).isNotNull
        assertThat(ledgerEntry.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerEntry.amount()).isEqualTo(123L)
        assertThat(ledgerEntry.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(ledgerEntry.direction()).isEqualTo(LedgerEntry.Direction.CREDIT)
        assertThat(ledgerEntry.discardedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(ledgerEntry.ledgerAccountCurrency()).isEqualTo("string")
        assertThat(ledgerEntry.ledgerAccountCurrencyExponent()).isEqualTo(123L)
        assertThat(ledgerEntry.ledgerAccountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerEntry.ledgerAccountLockVersion()).isEqualTo(123L)
        assertThat(ledgerEntry.ledgerTransactionId()).isEqualTo("string")
        assertThat(ledgerEntry.liveMode()).isEqualTo(true)
        assertThat(ledgerEntry.metadata()).isEqualTo(LedgerEntry.Metadata.builder().build())
        assertThat(ledgerEntry.object_()).isEqualTo("string")
        assertThat(ledgerEntry.resultingLedgerAccountBalances())
            .isEqualTo(
                LedgerEntry.LedgerBalances.builder()
                    .availableBalance(
                        LedgerEntry.LedgerBalances.LedgerBalance.builder()
                            .amount(123L)
                            .credits(123L)
                            .currency("string")
                            .currencyExponent(123L)
                            .debits(123L)
                            .build()
                    )
                    .pendingBalance(
                        LedgerEntry.LedgerBalances.LedgerBalance.builder()
                            .amount(123L)
                            .credits(123L)
                            .currency("string")
                            .currencyExponent(123L)
                            .debits(123L)
                            .build()
                    )
                    .postedBalance(
                        LedgerEntry.LedgerBalances.LedgerBalance.builder()
                            .amount(123L)
                            .credits(123L)
                            .currency("string")
                            .currencyExponent(123L)
                            .debits(123L)
                            .build()
                    )
                    .build()
            )
        assertThat(ledgerEntry.status()).isEqualTo(LedgerEntry.Status.ARCHIVED)
        assertThat(ledgerEntry.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }
}
