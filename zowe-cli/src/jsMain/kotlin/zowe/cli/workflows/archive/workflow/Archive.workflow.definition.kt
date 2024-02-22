@file:JsModule("@zowe/cli")

package zowe.cli.workflows.archive.workflow

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the command for archiving workflow instance on zOSMF.
 * This is not something that is intended to be used outside of this npm package.
 */
external val Workflow: ICommandDefinition
