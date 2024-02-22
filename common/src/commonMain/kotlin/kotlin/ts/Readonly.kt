package kotlin.ts

/**
 * Marks a property that should not be modified, even if it is `var`.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
annotation class Readonly
