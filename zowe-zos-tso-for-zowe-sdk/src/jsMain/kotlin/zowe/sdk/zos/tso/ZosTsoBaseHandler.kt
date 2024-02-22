@file:JsModule("@zowe/zos-tso-for-zowe-sdk")

package zowe.sdk.zos.tso

import js.promise.Promise
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.sdk.zos.tso.doc.input.IStartTsoParms
import zowe.sdk.zosmf.ZosmfBaseHandler

abstract external class ZosTsoBaseHandler : ZosmfBaseHandler {
  /**
   * The parameter object required to issue start commands
   */
  var mTsoStart: IStartTsoParms

  /**
   * This will grab the arguments and create the tso parameter object for APIs before
   * invoking the actual TSO handler.
   * [ZosmfBaseHandler.processWithSession] method.
   *
   * @param commandParameters Command parameters sent by imperative.
   */
  override fun process(commandParameters: IHandlerParameters): Promise<Unit>
}
