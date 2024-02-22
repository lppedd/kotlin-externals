package zowe.imperative.cmd.doc.profiles.definition

import zowe.imperative.cmd.doc.ICommandExampleDefinition
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration
import zowe.imperative.profiles.doc.definition.IProfileSchema
import kotlin.js.plain.JsPlainObject

/**
 * Cmd packages additions to the profile manager type configuration document. Used by the
 * CliProfileManager. Allows profiles to be built from command arguments. See the
 * "CliProfileManager" for more information.
 */
@JsPlainObject
external interface ICommandProfileTypeConfiguration : IProfileTypeConfiguration {
  /**
   * A handler module which Imperative will require(). The module's default export should be a
   * handler that calls appendResponseObject on the provided commandParameters.response You do NOT
   * have to implement writing the profile to disk -- you only have to produce the final profile
   * object that you would like to be written.
   *
   * This is only required if finished profile can't be created directly from the arguments, e.g. if
   * you have --user and --password and need to always transform it into a basic auth
   *
   * If omitted, Imperative will just write all fields present from the schema into the profile
   * without requiring a module
   */
  var createProfileFromArgumentsHandler: String?

  /**
   * The module's default export should be a handler that calls appendResponseObject on the provided
   * commandParameters.response You do NOT have to implement writing the profile to disk -- you only
   * have to produce the final profile object that you would like to be written.
   *
   * This is only required if finished updated profile can't be created directly from the arguments,
   * e.g. if certain fields that the user might specify mean that other fields should be deleted or
   * updated.
   *
   * If omitted, Imperative will load the old profile, overwrite any fields specified by the user,
   * and write the updated profile to disk.
   */
  var updateProfileFromArgumentsHandler: String?

  /**
   * Examples to be displayed in the help text for the auto generated create profile command.
   */
  var createProfileExamples: Array<ICommandExampleDefinition>?

  /**
   * Examples to be displayed in the help text for the auto generated update profile command.
   */
  var updateProfileExamples: Array<ICommandExampleDefinition>?

  /**
   * The JSON schema document. The schema document provides a way to enforce the contents of a
   * profile. The schema conforms exactly to the JSON schema specification. You must supply all
   * properties you would like validated for correctness on the schema, except for "dependencies".
   * Dependency schema checking is generated automatically if you populate the dependencies property
   * of this document.
   */
  @JsType("ICommandProfileSchema")
  override var schema: IProfileSchema

  /**
   * Configuration for authentication services to associate with this profile type.
   */
  var authConfig: Array<ICommandProfileAuthConfig>?
}
