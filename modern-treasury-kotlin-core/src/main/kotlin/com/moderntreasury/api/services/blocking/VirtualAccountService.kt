@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.blocking

import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.models.VirtualAccount
import com.moderntreasury.api.models.VirtualAccountCreateParams
import com.moderntreasury.api.models.VirtualAccountDeleteParams
import com.moderntreasury.api.models.VirtualAccountListPage
import com.moderntreasury.api.models.VirtualAccountListParams
import com.moderntreasury.api.models.VirtualAccountRetrieveParams
import com.moderntreasury.api.models.VirtualAccountUpdateParams

interface VirtualAccountService {

    /** create virtual_account */
    fun create(
        params: VirtualAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VirtualAccount

    /** get virtual_account */
    fun retrieve(
        params: VirtualAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VirtualAccount

    /** update virtual_account */
    fun update(
        params: VirtualAccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VirtualAccount

    /** Get a list of virtual accounts. */
    fun list(
        params: VirtualAccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VirtualAccountListPage

    /** delete virtual_account */
    fun delete(
        params: VirtualAccountDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): VirtualAccount
}
