package zowe.imperative.profiles.doc.definition

import kotlin.js.plain.JsPlainObject

/**
 * Definition for a dependency on another profile. For example you can have a "fruit-ordering"
 * profile which depends on a particular instance of a "banana" type profile. This way when you are
 * issuing commands that require a "fruit-ordering" profile, you can associate a particular set of
 * settings of type "banana".
 */
@JsPlainObject
external interface IProfileDependency {
  /**
   * The name of the profile type
   */
  var type: String

  /**
   * Can the user use your profile without associating a dependent profile with it? If so, it is not
   * required.
   */
  var required: Boolean

  /**
   * The description to expose on the auto-generated command line options on profile create and
   * update commands.
   */
  var description: String?
}
