@file:Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE", "NOTHING_TO_INLINE", "UnsafeCastFromDynamic")

package kotlin.js

inline fun <T : Any> dynamic(block: dynamic.() -> Unit): T =
  jso<T>().apply(block)

private inline fun <T : Any> jso(): T =
  js("({})")
