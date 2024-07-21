package kotlin.js

inline fun <T : Any> dynamic(block: dynamic.() -> Unit): T =
  js("({})").unsafeCast<T>().apply(block)
