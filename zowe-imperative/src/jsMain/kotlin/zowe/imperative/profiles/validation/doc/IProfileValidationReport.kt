package zowe.imperative.profiles.validation.doc

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * Complete report of the results of profile validation
 */
@JsPlainObject
external interface IProfileValidationReport {
  /**
   * Is the profile valid overall?
   */
  var overallResult: ValidationOutcome

  /**
   * A final message explaining the general result of the report
   */
  var overallMessage: String

  /**
   * List of detailed task results from running the profile validation
   */
  var taskResults: Array<IProfileValidationTaskResult>

  /**
   * The profile that was validated
   */
  var profile: IProfile
}
