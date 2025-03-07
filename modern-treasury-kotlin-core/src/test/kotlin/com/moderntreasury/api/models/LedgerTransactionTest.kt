package com.moderntreasury.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LedgerTransactionTest {

    @Test
    fun createLedgerTransaction() {
        val ledgerTransaction =
            LedgerTransaction.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("string")
                .effectiveAt(LocalDate.parse("2019-12-27"))
                .effectiveDate(LocalDate.parse("2019-12-27"))
                .externalId("string")
                .ledgerEntries(
                    listOf(
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
                    )
                )
                .ledgerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .ledgerableId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .ledgerableType(LedgerTransaction.LedgerableType.COUNTERPARTY)
                .liveMode(true)
                .metadata(LedgerTransaction.Metadata.builder().build())
                .object_("string")
                .postedAt("string")
                .reversesLedgerTransactionId("string")
                .status(LedgerTransaction.Status.ARCHIVED)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()
        assertThat(ledgerTransaction).isNotNull
        assertThat(ledgerTransaction.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerTransaction.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(ledgerTransaction.description()).isEqualTo("string")
        assertThat(ledgerTransaction.effectiveAt()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(ledgerTransaction.effectiveDate()).isEqualTo(LocalDate.parse("2019-12-27"))
        assertThat(ledgerTransaction.externalId()).isEqualTo("string")
        assertThat(ledgerTransaction.ledgerEntries())
            .containsExactly(
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
            )
        assertThat(ledgerTransaction.ledgerId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerTransaction.ledgerableId())
            .isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(ledgerTransaction.ledgerableType())
            .isEqualTo(LedgerTransaction.LedgerableType.COUNTERPARTY)
        assertThat(ledgerTransaction.liveMode()).isEqualTo(true)
        assertThat(ledgerTransaction.metadata())
            .isEqualTo(LedgerTransaction.Metadata.builder().build())
        assertThat(ledgerTransaction.object_()).isEqualTo("string")
        assertThat(ledgerTransaction.postedAt()).isEqualTo("string")
        assertThat(ledgerTransaction.reversesLedgerTransactionId()).isEqualTo("string")
        assertThat(ledgerTransaction.status()).isEqualTo(LedgerTransaction.Status.ARCHIVED)
        assertThat(ledgerTransaction.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }
}
