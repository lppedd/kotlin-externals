@file:JsModule("@zowe/cli")

package zowe.cli.workflows.delete.deleteActiveWorkflow

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the delete active workflow commands.
 */
external val DeleteWorkflowOptions: Record<String, ICommandOptionDefinition>
