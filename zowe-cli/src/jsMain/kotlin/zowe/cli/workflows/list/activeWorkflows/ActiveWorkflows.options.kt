@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.activeWorkflows

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the list active-workflow commands.
 */
external val ListActiveWorkflowsOptions: Record<String, ICommandOptionDefinition>
