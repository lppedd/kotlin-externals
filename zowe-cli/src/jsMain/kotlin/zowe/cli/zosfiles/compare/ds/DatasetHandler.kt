@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.compare.ds

import js.promise.Promise
import node.buffer.Buffer
import zowe.cli.zosfiles.compare.CompareBaseHandler
import zowe.cli.zosfiles.compare.CompareBaseHelper
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.rest.session.AbstractSession
import kotlin.ts.Union

/**
 * Handler to view a data set's content
 */
external class DatasetHandler : CompareBaseHandler {
  override fun getFile1(
    session: AbstractSession,
    args: ICommandArguments,
    helper: CompareBaseHelper,
  ): Promise<Union<String, Buffer>>

  override fun getFile2(
    session: AbstractSession,
    args: ICommandArguments,
    helper: CompareBaseHelper,
  ): Promise<Union<String, Buffer>>
}
