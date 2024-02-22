package zowe.imperative.profiles.doc.parms

import zowe.imperative.cmd.doc.args.ICommandArguments
import kotlin.js.plain.JsPlainObject

/**
 * TODO - wasn't this moved???
 */
@JsPlainObject
external interface IUpdateProfileFromCliArgs : IUpdateProfile {
  var args: ICommandArguments
}
