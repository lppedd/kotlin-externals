package zowe.cli.daemon.doc

import kotlin.js.plain.JsPlainObject

/**
 * Specifies wwhether questions can be asked of the user, and if not,
 * what value should be used for a question when we do not ask.
 */
@JsPlainObject
external interface IDaemonEnableQuestions {
  var canAskUser: Boolean
  var addBinToPathVal: String
}
