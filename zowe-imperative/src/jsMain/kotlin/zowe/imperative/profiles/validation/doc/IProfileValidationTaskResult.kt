package zowe.imperative.profiles.validation.doc

import kotlin.js.plain.JsPlainObject

/**
 * Profile validation results for one particular task
 */
@JsPlainObject
external interface IProfileValidationTaskResult {
  /**
   * Outcome of this task, whether it succeeded, failed, or somewhere in between
   */
  var outcome: ValidationOutcome

  /**
   * Name of the task (will be automatically populated by the validation API)
   */
  var taskName: String?

  /**
   * A description of the result of the validation test, whether it succeeded or failed. Example:
   * Successfully submitted job USER(JOB00001) or Failed to submit job due to the following error:
   * Input was not recognized by the system as a job RC 4 RSN ...
   */
  var resultDescription: String

  /**
   * Same as the endpoints in the profile validation task. (will be automatically populated by the
   * validation API)
   */
  var associatedEndpoints: Array<String>?
}
