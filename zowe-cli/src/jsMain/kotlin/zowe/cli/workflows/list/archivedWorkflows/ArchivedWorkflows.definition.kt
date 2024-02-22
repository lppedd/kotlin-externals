@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.archivedWorkflows

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the command for listing archived z/OSMF workflows for a system or sysplex.
 * This is not something that is intended to be used outside of this npm package.
 */
external val ArchivedWorkflows: ICommandDefinition
