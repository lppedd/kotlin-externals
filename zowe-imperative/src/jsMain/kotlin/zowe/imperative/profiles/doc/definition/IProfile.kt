package zowe.imperative.profiles.doc.definition

import kotlin.js.plain.JsPlainObject

/**
 * Profiles are a user configuration mechanism built into the Imperative framework and profiles are
 * intended to be exploited on commands that require large sets of configuration items (more than
 * would be feasible on the command line). In addition, profiles allow users to dynamically and
 * easily switch configuration for the invocation of a particular command. One common use case for
 * profiles, is storing "connection details" (host, user, API version, port, credentials, etc.)
 * required by a command to communicate with a remote instance/service.
 *
 * Another feature of profiles are "dependencies". A profile can "point to" any number of additional
 * profiles, which will be loaded when the original is loaded. A common use case for this feature is
 * if you need "connection details" (to communicate with a remote instance), but the unique serivce
 * you are invoking also requires additional input/configuration. You can "point to", via the
 * dependencies, the "connection details" profile.
 *
 * Profiles also help you segregate/isolate portions of your CLI (if it is complex enough to
 * warrent). For example, a common pattern is to organize your CLI via "groups", where each group is
 * isolated and requires seperate configuration.
 *
 * Profiles are loaded (sometimes automatically, by definition on your commands) for the invocation
 * of that command. Meaning, they are only loaded when needed/required.
 *
 * See the "ProfileManager" for profile management details.
 */
@JsPlainObject
external interface IProfile {
  /**
   * The list of profile that this profile is dependent on. Can be explicitly named (for tight
   * coupling of interdependent profiles). Profile dependencies are useful to help complex CLIs
   * segregate/isolate profile (and for example, command groups) configurations, while allowing for
   * reuse of configuration where needed. A profile can have any number of dependencies of any type.
   */
  var dependencies: Array<IProfileDependencies>?

  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
