@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.blocking

import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.models.Ledger
import com.moderntreasury.api.models.LedgerCreateParams
import com.moderntreasury.api.models.LedgerDeleteParams
import com.moderntreasury.api.models.LedgerListPage
import com.moderntreasury.api.models.LedgerListParams
import com.moderntreasury.api.models.LedgerRetrieveParams
import com.moderntreasury.api.models.LedgerUpdateParams

interface LedgerService {

    /** Create a ledger. */
    fun create(
        params: LedgerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Ledger

    /** Get details on a single ledger. */
    fun retrieve(
        params: LedgerRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Ledger

    /** Update the details of a ledger. */
    fun update(
        params: LedgerUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Ledger

    /** Get a list of ledgers. */
    fun list(
        params: LedgerListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerListPage

    /** Delete a ledger. */
    fun delete(
        params: LedgerDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Ledger
}
