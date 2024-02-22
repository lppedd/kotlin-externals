package zowe.imperative.profiles.doc.parms

import zowe.imperative.profiles.doc.definition.IProfileSchema
import kotlin.js.plain.JsPlainObject

/**
 * Input to the "validateProfile" internal API. Indicates the schema document to be used for the validation.
 */
@JsPlainObject
external interface IValidateProfileWithSchema : IValidateProfile {
  /**
   * The profile JSON schema document.
   */
  var schema: IProfileSchema
}
