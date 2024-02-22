package kotlin.js

/**
 * Specified the literal value of a boolean: `true` or `false`.
 *
 * That can be expressed in TypeScript, but not in Kotlin.
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
annotation class JsBoolean(val value: Boolean)
