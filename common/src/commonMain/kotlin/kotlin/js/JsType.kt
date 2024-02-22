package kotlin.js

/**
 * Specifies that the property is of a certain type when the
 * Kotlin type system does not allow further specialization.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class JsType(val value: String)
