package zowe.sdk.zosmf.doc

import js.array.JsTuple1

/**
 * The Z/OSMF info API response.
 */
external interface IZosmfInfoResponse {
  var zos_version: String?
  var zosmf_port: String?
  var zosmf_version: String?
  var zosmf_hostname: String?
  var zosmf_saf_realm: String?
  var zosmf_full_version: String?
  var api_version: String?
  var plugins: JsTuple1<IZosmfPluginInfo>?
}
