@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.activeWorkflows

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the command for listing workflow instance(s) in zOSMF.
 * This is not something that is intended to be used outside of this npm package.
 */
external val ActiveWorkflows: ICommandDefinition
