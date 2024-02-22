package zowe.imperative.profiles.doc.response

import zowe.imperative.profiles.doc.definition.IProfile
import kotlin.js.plain.JsPlainObject

/**
 * The success response to the profile "load()" API.
 */
@JsPlainObject
external interface IProfileLoaded {
  /**
   * API response message - for display and logging purposes
   */
  var message: String

  /**
   * The profile "type" of the profile loaded.
   */
  var type: String

  /**
   * The "failNotFound" specification value on original request.
   */
  var failNotFound: Boolean

  /**
   * Indicates the a profile type that references this profile - populated when the dependencies are
   * loaded for a particular profile chain
   *
   * TODO - this might no longer be necessary - will need to investigate the impact on the command processor (loading profs)
   */
  var referencedBy: String?

  /**
   * The name of the profile
   */
  var name: String?

  /**
   * The profile contents.
   */
  var profile: IProfile?

  /**
   * Indicates that mutliple profiles were loaded - due to dependencies.
   */
  var dependenciesLoaded: Boolean?

  /**
   * Full set of profile loaded responses.
   */
  var dependencyLoadResponses: Array<IProfileLoaded>?
}
