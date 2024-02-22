package zowe.imperative.cmd.doc.profiles.definition

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.imperative.profiles.doc.definition.IProfileProperty
import kotlin.js.plain.JsPlainObject

/**
 * Extended version of a team profile schema property that can include option definitions for
 * auto-generated commands.
 */
@JsPlainObject
external interface ICommandProfileProperty : IProfileProperty {
  /**
   * This option definition will be used to auto-generate profile commands. This is the same type
   * used by normal Imperative command definitions.
   */
  var optionDefinition: ICommandOptionDefinition?
  var optionDefinitions: Array<ICommandOptionDefinition>?
}
