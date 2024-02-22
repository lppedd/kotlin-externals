package zowe.imperative.profiles.doc.parms

import kotlin.js.plain.JsPlainObject

/**
 * Input to the "validateProfile" internal API. Indicates the schema document to be used for the
 * validation. Used with the CLI Profile manager - validation is skipped until the profile is fully
 * built
 */
@JsPlainObject
external interface IValidateProfileForCLI : IValidateProfileWithSchema {
  /**
   * If false/undefined, validation will be skipped until validation is called again with "true"
   * (indicating that the profile building is complete)
   */
  var readyForValidation: Boolean
}
