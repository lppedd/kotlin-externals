package zowe.imperative.profiles.validation.doc

import kotlin.js.plain.JsPlainObject

/**
 * An overall plan for validating a profile, composed of multiple tasks
 */
@JsPlainObject
external interface IProfileValidationPlan {
  /**
   * The tasks to run to validate the profile. They will be run sequentially in the order specified.
   */
  var tasks: Array<IProfileValidationTask>

  /**
   * Suggestions to the user that will be displayed in the validation report in the event profile
   * validation is not successful.
   */
  var failureSuggestions: String?
}
