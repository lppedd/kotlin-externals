package zowe.imperative.profiles.doc.config

import zowe.imperative.profiles.doc.definition.IProfileDependency
import zowe.imperative.profiles.doc.definition.IProfileSchema
import kotlin.js.plain.JsPlainObject

/**
 * The profile "type" configuration document. Provides all configuration information for the "type".
 * A profile "type" is an arbirarty (implementation defined) category used to isolate configuration
 * documents, provide ease of configuration for complex CLIs (user only configures what they'll
 * use), and allows the CLI to be extendable in an isolated fashion. See the "IProfile" and
 * "BasicProfileManager" for more detailed profile info.
 */
@JsPlainObject
external interface IProfileTypeConfiguration {
  /**
   * The name of the profile "type" (e.g. "banana"). The type should be indicative of the profile
   * contents (defined by the profile schema on this document). A "type" is analogous to a category.
   */
  var type: String

  /**
   * The JSON schema document. The schema document provides a way to enforce the contents of a
   * profile. The schema conforms exactly to the JSON schema specification. You must supply all
   * properties you would like validated for correctness on the schema, except for "dependencies".
   * Dependency schema checking is generated automatically if you populate the dependencies property
   * of this document.
   */
  var schema: IProfileSchema

  /**
   * The profile dependency specification. Indicates the required or optional profiles that a
   * profile is depedent on. Dependencies are written as part of the profile, but you do NOT need to
   * specify dependencies in your schema document - this is automatically generated based on your
   * specifications.
   */
  var dependencies: Array<IProfileDependency>?

  /**
   * Path to a module that contains an object that matches the interface IProfileValidationPlan.
   * This is optional, but if provided a "validate profile" command will be generated to give the
   * user a report on the validity of their profile.
   */
  var validationPlanModule: String?
}
