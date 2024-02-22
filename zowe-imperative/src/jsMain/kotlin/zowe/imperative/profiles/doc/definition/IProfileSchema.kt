package zowe.imperative.profiles.doc.definition

import js.objects.Record
import kotlin.js.plain.JsPlainObject

/**
 * The JSON Validation schema for your profile type. Use this to describe the expected structure and
 * contents of your profile, as well as provide option definitions for create & update profile
 * commands
 */
@JsPlainObject
external interface IProfileSchema {
  /**
   * A short, descriptive title of your profile type
   */
  var title: String

  /**
   * A description of your type of profile
   */
  var description: String

  /**
   * Specify "object". This is not the type name of the profile, but rather a description of the
   * type of data structure (e.g. string, array). Your profile will be an object with one or more
   * properties.
   */
  var type: String

  /**
   * These are the properties of your profile object. If your profile deals with information about
   * bananas, some properties might be "color", "sweetness", and "origin" of type "string". For each
   * one, you can provide an Imperative option definition (The same format as your normal command
   * option definitions) which will be used for auto-generating profile commands.
   */
  var properties: Record<String, IProfileProperty>
  var version: String?

  /**
   * An array of properties that must be present in the finished profile. If any of these fields are
   * missing, profile validation will fail.
   */
  var required: Array<String>?

  /**
   * Any other advanced options available from the JSON schema specification
   * http://json-schema.org/latest/json-schema-validation.html
   */
  @seskar.js.JsNative
  operator fun get(key: String): Any?

  @seskar.js.JsNative
  operator fun set(
    key: String,
    value: Any?,
  )
}
