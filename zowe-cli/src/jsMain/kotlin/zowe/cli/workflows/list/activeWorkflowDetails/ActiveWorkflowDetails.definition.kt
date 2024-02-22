@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.activeWorkflowDetails

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the command for listing active workflow details within zosworkflows.
 * This is not something that is intended to be used outside of this npm package.
 */
external val ActiveWorkflowDetails: ICommandDefinition
