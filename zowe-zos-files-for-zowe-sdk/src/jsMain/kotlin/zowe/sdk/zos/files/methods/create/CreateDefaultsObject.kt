package zowe.sdk.zos.files.methods.create

external interface CreateDefaultsObject {
  /**
   * Specifies all the defaults to create non-vsam data sets
   */
  var DATA_SET: DataSet

  /**
   * Specifies the defaults used by the Zos Files API to create a VSAM cluster
   */
  var VSAM: VSAM
}
