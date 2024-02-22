package zowe.imperative.profiles.doc.definition

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IProfileDependencies {
  /**
   * The name of the profile this profile is dependent on - profile+type uniquely qualify a profile.
   */
  var name: String?

  /**
   * The type of the profile this profile is dependent on - profile+type uniquely qualify a profile.
   */
  var type: String
}
