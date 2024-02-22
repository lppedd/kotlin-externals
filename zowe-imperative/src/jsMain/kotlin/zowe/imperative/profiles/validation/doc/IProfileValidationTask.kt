package zowe.imperative.profiles.validation.doc

import kotlin.js.plain.JsPlainObject

/**
 * Criterion/task used for testing the validity of a profile You can use any number of these
 * criteria to test different aspects of the profile
 */
@JsPlainObject
external interface IProfileValidationTask {
  /**
   * Long form description of the task you'll take using the specified profile to test its validity
   */
  var description: String

  /**
   * The short name of a task e.g. "Submitting a job"
   */
  var name: String

  /**
   * The REST endpoints associated with this task if any, e.g.
   * ["PUT /zosmf/restjobs/jobs", "GET /zosmf/restjobs/jobs"]
   */
  var associatedEndpoints: Array<String>?

  /**
   * A function which tests the profile with your tasks.
   * Ultimately the result of this function is what determines whether the profile is valid or not for this task
   */
  var taskFunction: IProfileValidationTaskFunction

  /**
   * Any tasks you would like to only run if the current task succeeds (skipped on warning or
   * failure of this, the parent task)
   */
  var dependentTasks: Array<IProfileValidationTask>?
}
