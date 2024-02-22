package kotlin.ts

/**
 * Indicates that a type should be wrapped in a TypeScript `Partial<T>`,
 * so that all of its properties are optional.
 */
@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
annotation class Partial
