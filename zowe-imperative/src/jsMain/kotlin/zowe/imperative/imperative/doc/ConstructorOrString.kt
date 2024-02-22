package zowe.imperative.imperative.doc

/**
 * Converts {@link ImperativeOverrides} to an object where all keys are optional and can be of
 * either constructor or string type.
 */
// TODO(Edoardo): what to do with this?
external interface ConstructorOrString<T : IOverridesRestriction> {
  @seskar.js.JsNative
  operator fun <K : Any /* keyof T */> get(key: K): (Any /* T[K] | string */)?

  @seskar.js.JsNative
  operator fun <K : Any /* keyof T */> set(key: K, value: (Any /* T[K] | string */)?)
}
