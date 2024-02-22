@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.compare.lf_ds

import js.promise.Promise
import node.buffer.Buffer
import zowe.cli.zosfiles.compare.CompareBaseHandler
import zowe.cli.zosfiles.compare.CompareBaseHelper
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.rest.session.AbstractSession

/**
 * Handler to compare a localfile and a dataset content
 */
external class LocalfileDatasetHandler : CompareBaseHandler {
  override fun getFile1(
    session: AbstractSession,
    args: ICommandArguments,
    helper: CompareBaseHelper,
  ): Promise<Buffer>

  override fun getFile2(
    session: AbstractSession,
    args: ICommandArguments,
    helper: CompareBaseHelper,
  ): Promise<Buffer>
}
