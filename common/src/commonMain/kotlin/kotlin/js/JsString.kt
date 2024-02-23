package kotlin.js

/**
 * Specifies the literal value of a string, e.g. `"example"`
 *
 * That can be expressed in TypeScript, but not in Kotlin.
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.BINARY)
annotation class JsString(val value: String)
