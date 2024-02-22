package zowe.imperative.cmd.doc.profiles.definition

import kotlin.js.plain.JsPlainObject

/**
 * Profile load specifications - causes profiles to auto-load for this command and will cause
 * options to be exposed on the command for the user to specify the desired profile by name.
 * Profiles specified by the user on the command line always take precedence over defaults.
 */
@JsPlainObject
external interface ICommandProfile {
  /**
   * An array of profile "types" that are required for the execution of this command. Imperative
   * will automatically attempt to load (the default OR the profile specified by name on the CLI).
   * If a profile of a required type cannot be found, the command will fail.
   */
  var required: Array<String>?

  /**
   * An array of profile "types" that are optional for the execution of this command. Imperative
   * will automatically attempt to load (the default OR the profile specified by name on the CLI).
   * If a profile of an optional type cannot be found, the command can still continue. It is the
   * responsiblity of the handler (for which this profile specification is defined) to properly
   * handle an optional profile not be present when the handler is invoked.
   */
  var optional: Array<String>?

  /**
   * An array of profile "types" to suppress automatic generation of options on the command. By
   * default, Imperative will generate an CLI option in the form "--<type>-profile" for each
   * required & optional profile specified on this object.
   */
  var suppressOptions: Array<String>?
}
