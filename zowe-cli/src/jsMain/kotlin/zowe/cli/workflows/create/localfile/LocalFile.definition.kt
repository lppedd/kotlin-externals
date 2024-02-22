@file:JsModule("@zowe/cli")

package zowe.cli.workflows.create.localfile

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the command for creating workflow instance from local file within zosworkflows.
 * This is not something that is intended to be used outside of this npm package.
 */
external val LocalFile: ICommandDefinition
