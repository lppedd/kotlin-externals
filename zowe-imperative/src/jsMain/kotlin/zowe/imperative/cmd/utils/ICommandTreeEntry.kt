package zowe.imperative.cmd.utils

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * Command tree entry describes an entry of a command in the full command tree - used when
 * flattening the command tree to build fully qualified commands for searching and display purposes
 */
external interface ICommandTreeEntry {
  var command: ICommandDefinition
  var fullName: String
  var tree: ICommandDefinition
}
