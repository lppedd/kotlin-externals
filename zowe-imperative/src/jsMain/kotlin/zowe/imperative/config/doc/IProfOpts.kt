@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import node.Module
import zowe.imperative.security.doc.ICredentialManagerInit

/**
 * Options that will affect the behavior of the ProfileInfo class.
 * They are supplied on the ProfileInfo constructor.
 */
external interface IProfOpts {
  /**
   * TODO? Disable loading of secure properties in profiles.
   *
   * Indicates if environment variables should override values stored in Zowe configuration profiles
   * on disk. The default is false.
   */
  var overrideWithEnv: Boolean?

  /**
   * Implements a custom method to require Keytar module which manages secure credentials. If
   * undefined, the default implementation is to `require("keytar")` from the caller app's
   * node_modules folder.
   */
  @Deprecated("")
  var requireKeytar: (() -> Module)?

  /**
   * Overrides the credential manager class used to load and store secure properties. If undefined,
   * the default implementation is to use the Imperative `KeytarCredentialManager` which will
   * `require("keytar")` from the caller app's node_modules folder.
   */
  var credMgrOverride: ICredentialManagerInit?
}
