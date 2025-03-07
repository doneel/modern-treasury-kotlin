@file:JvmName("Utils")

package com.moderntreasury.api.core

import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import com.google.common.collect.Multimaps
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import java.util.Collections

internal fun <T : Any> T?.getOrThrow(name: String): T {
    if (this == null) {
        throw ModernTreasuryInvalidDataException("'${name}' is not present")
    }

    return this
}

internal fun <T> List<T>.toUnmodifiable(): List<T> {
    if (isEmpty()) {
        return Collections.emptyList()
    }

    return Collections.unmodifiableList(this)
}

internal fun <K, V> Map<K, V>.toUnmodifiable(): Map<K, V> {
    if (isEmpty()) {
        return Collections.emptyMap()
    }

    return Collections.unmodifiableMap(this)
}

internal fun <K, V> ListMultimap<K, V>.toUnmodifiable(): ListMultimap<K, V> {
    if (isEmpty()) {
        return ImmutableListMultimap.of()
    }

    return Multimaps.unmodifiableListMultimap(this)
}
