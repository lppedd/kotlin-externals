@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.create

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.sdk.zos.files.methods.create.doc.ICreateDataSetOptions

/**
 * Generate the appropriate options object to create a dataset before sending it to the z/OS MF APIs
 * @param commandArguments The provided command arguments
 * @return Object to be sent
 */
// TODO(Edoardo): replace with Arguments from yargs
external fun generateZosmfOptions(commandArguments: ICommandArguments): ICreateDataSetOptions
