package zowe.sdk.zosmf.doc

/**
 * API response for list systems defined to z/OSMF.
 */
external interface IZosmfListDefinedSystemsResponse {
  /**
   * Total items returned.
   */
  var numRows: Int

  /**
   * Properties of each defined system.
   */
  var items: Array<IDefinedSystem>
}
