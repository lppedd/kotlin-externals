package zowe.imperative.cmd.doc.profiles.definition

import js.objects.Record
import zowe.imperative.profiles.doc.definition.IProfileSchema
import kotlin.js.plain.JsPlainObject

/**
 * Externally exposed version of the profile schema with command options for auto-generated commands
 */
@JsPlainObject
external interface ICommandProfileSchema : IProfileSchema {
  /**
   * Command version of the properties field on the schema
   */
  @Suppress("VAR_TYPE_MISMATCH_ON_OVERRIDE")
  override var properties: Record<String, ICommandProfileProperty>
}
