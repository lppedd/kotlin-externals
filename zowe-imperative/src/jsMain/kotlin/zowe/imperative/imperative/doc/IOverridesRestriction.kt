package zowe.imperative.imperative.doc

import zowe.imperative.interfaces.doc.IConstructor

/**
 * Type of the [ImperativeOverrides] interface.
 * This ensures that all keys of the interface reference a proper constructor definition.
 */
external interface IOverridesRestriction {
  @seskar.js.JsNative
  operator fun get(key: String): IConstructor<Any?>?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: IConstructor<Any?>?,
  )
}
