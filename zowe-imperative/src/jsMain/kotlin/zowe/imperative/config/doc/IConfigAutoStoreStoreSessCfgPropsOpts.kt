package zowe.imperative.config.doc

import js.objects.Record

/**
 * Defines the options used by the ConfigAutoStore._storeSessCfgProps function
 */
external interface IConfigAutoStoreStoreSessCfgPropsOpts : IConfigAutoStoreFindAuthHandlerForProfileOpts {
  /**
   * Session config containing properties to store
   */
  var sessCfg: Record<String, Any>?

  /**
   * Names of properties that should be stored
   */
  var propsToStore: Array<String>?

  /**
   * Name of the profile where we want to store the properties Used if params == null
   */
  var profileName: String?

  /**
   * Type of the profile where we want to store the properties Used if params == null
   */
  var profileType: String?

  /**
   * Indicates whether or not the property should be stored securely
   */
  var setSecure: Boolean?
}
