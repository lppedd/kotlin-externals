@file:JsModule("vscode")

package vscode

/**
 * A class that contains information about a covered resource. A count can
 * be give for lines, branches, and declarations in a file.
 */
external class TestCoverageCount {
  /**
   * Number of items covered in the file.
   */
  var covered: Int

  /**
   * Total number of covered items in the file.
   */
  var total: Int

  /**
   * @param covered Value for [TestCoverageCount.covered]
   * @param total Value for [TestCoverageCount.total]
   */
  constructor(covered: Int, total: Int)
}
