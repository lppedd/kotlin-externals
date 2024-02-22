package zowe.imperative.imperative.plugins.doc

/**
 * Object to hold a plugin's peer dependencies version numbers.
 */
external interface IPluginPeerDepends {
  /**
   * Each object key is the name of a plugin's peer dependency and the value is the version string
   * for that dependency.
   */
  var peerDepName: String
  var peerDepVer: String
}
