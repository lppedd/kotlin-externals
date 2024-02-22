package zowe.sdk.zosmf.doc

/**
 * The plugin information structure for plugin property of the z/OSMF info response
 */
external interface IZosmfPluginInfo {
  var pluginVersion: String?
  var pluginDefaultName: String?
  var pluginStatus: String?
}
