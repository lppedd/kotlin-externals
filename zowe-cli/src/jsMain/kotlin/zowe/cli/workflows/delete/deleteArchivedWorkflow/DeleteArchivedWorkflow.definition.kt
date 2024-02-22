@file:JsModule("@zowe/cli")

package zowe.cli.workflows.delete.deleteArchivedWorkflow

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the command for delete workflow using workflow key within zosworkflows.
 * This is not something that is intended to be used outside of this npm package.
 */
external val DeleteArchivedWorkflow: ICommandDefinition
