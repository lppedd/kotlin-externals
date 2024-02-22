package zowe.imperative.profiles.doc.parms

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * Parameters to the "validate()" profile manager APIs. Validates a profile structure (basic and schema)
 */
@JsPlainObject
external interface IValidateProfile {
  /**
   * The name of the profile to validate.
   */
  var name: String

  /**
   * The profile contents to validate.
   */
  var profile: IProfile

  /**
   * Specify true to indicate the "ban unknown properties" specification of JSON schema. Meaning,
   * any properties found on the input profile that are NOT specified on the schema cause the
   * validation to fail.
   */
  var strict: Boolean?
}
