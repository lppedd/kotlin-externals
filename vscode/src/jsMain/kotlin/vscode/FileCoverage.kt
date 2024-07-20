@file:JsModule("vscode")

package vscode

import js.array.ReadonlyArray

/**
 * Contains coverage metadata for a file.
 */
external class FileCoverage {
  /**
   * File URI.
   */
  val uri: Uri

  /**
   * Statement coverage information. If the reporter does not provide statement
   * coverage information, this can instead be used to represent line coverage.
   */
  var statementCoverage: TestCoverageCount

  /**
   * Branch coverage information.
   */
  var branchCoverage: TestCoverageCount?

  /**
   * Declaration coverage information. Depending on the reporter and
   * language, this may be types such as functions, methods, or namespaces.
   */
  var declarationCoverage: TestCoverageCount?

  /**
   * @param uri Covered file URI
   * @param statementCoverage Statement coverage information. If the reporter
   *   does not provide statement coverage information, this can instead be
   *   used to represent line coverage.
   * @param branchCoverage Branch coverage information
   * @param declarationCoverage Declaration coverage information
   */
  constructor(
    uri: Uri,
    statementCoverage: TestCoverageCount,
    branchCoverage: TestCoverageCount = definedExternally,
    declarationCoverage: TestCoverageCount = definedExternally,
  )

  companion object {
    /**
     * Creates a [FileCoverage] instance with counts filled in from
     * the coverage details.
     *
     * @param uri Covered file URI
     * @param details Detailed coverage information
     */
    fun fromDetails(
      uri: Uri,
      details: ReadonlyArray<StatementCoverage>,
    ): FileCoverage

    /**
     * Creates a [FileCoverage] instance with counts filled in from
     * the coverage details.
     *
     * @param uri Covered file URI
     * @param details Detailed coverage information
     */
    fun fromDetails(
      uri: Uri,
      details: ReadonlyArray<DeclarationCoverage>,
    ): FileCoverage
  }
}
