package zowe.cli.zosfiles.strings

external interface Create {
  var DESCRIPTION: String
  var ACTIONS: CreateActions
  var POSITIONALS: CreatePositionals
  var OPTIONS: CreateOptions
}
