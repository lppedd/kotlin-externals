@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import js.promise.Promise
import zowe.imperative.profiles.doc.definition.IProfileProperty

external interface IConfigBuilderOpts {
  /**
   * Specify true to populate default values for profile properties with the
   * `IProfileProperty.includeInTemplate` flag set to true.
   */
  var populateProperties: Boolean?

  /**
   * Callback that prompts the user to enter a value for a profile property. The method will be
   * called to populate missing values in the base profile. It should return the value that the user
   * entered, or null or undefined if the prompt was cancelled.
   *
   * @param propName The name of the property
   * @param property The profile property definition
   */
  fun getValueBack(
    propName: String,
    property: IProfileProperty,
  ): Promise<Any?>
}
