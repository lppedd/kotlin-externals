package zowe.imperative.cmd.types

import js.promise.Promise

/**
 * This type defines the signature for a function taht calls the credential manager. This is used by
 * the TypeScript compiler to verify that any function that wants to call the credential manager
 * have the necessary arguments sent to it.
 */
typealias SecureOperationFunction =
/**
   * @param propNamePath The path to a child property
   * @param propValue The value of said property
   * @param optional Set to true if failure to find credentials should be ignored
   * @return The processed value after the secure operation function runs
   */
  (
    propNamePath: String,
    propValue: Any?, // use undefined for default
    optional: Boolean?, // use undefined for default
  ) -> Promise<Any?>
