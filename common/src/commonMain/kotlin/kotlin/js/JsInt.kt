package kotlin.js

/**
 * Specified the literal value of an integer, e.g. `10`
 *
 * That can be expressed in TypeScript, but not in Kotlin.
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
annotation class JsInt(val value: Int)
