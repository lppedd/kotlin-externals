package zowe.sdk.zos.files.methods.create

external interface DataSet {
  /**
   * Specifies the defaults used by the Zos Files API to create a partitioned data set
   */
  var PARTITIONED: PartitionedDataSet

  /**
   * Specifies the defaults used by the Zos Files API to create a sequential data set
   */
  var SEQUENTIAL: SequentialDataSet

  /**
   * Specifies the defaults used by the Zos Files API to create a classic data set
   */
  var CLASSIC: ClassicDataSet

  /**
   * Specifies the defaults used by the Zos Files API to create a data set used for C code
   */
  var C: CDataSet

  /**
   * Specifies the defaults used by the Zos Files API to create a data set used for binaries
   */
  var BINARY: BinaryDataSet

  /**
   * Specifies the defaults used by the Zos Files API to create a blank data set
   */
  var BLANK: BlankDataSet
}
