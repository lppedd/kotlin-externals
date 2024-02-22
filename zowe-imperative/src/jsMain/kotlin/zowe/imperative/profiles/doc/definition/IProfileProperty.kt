package zowe.imperative.profiles.doc.definition

import kotlin.js.plain.JsPlainObject
import kotlin.ts.Union

/**
 * A single field in a profile schema which can be serialized to a profile file
 */
@JsPlainObject
external interface IProfileProperty {
  /**
   * See ICommandProfileProperty.ts for how to include option definitions on your schema for
   * auto-generated commands
   */
  var type: Union<String, Array<String>>
  var items: Any?

  /**
   * Nested properties e.g. banana.origin.zipcode, banana.origin.country
   */
  var properties: Any?

  /**
   * Indicates if the given property should be securely stored
   */
  var secure: Boolean?

  /**
   * Should this property be defined in a new config JSON template?
   */
  var includeInTemplate: Boolean?
}
