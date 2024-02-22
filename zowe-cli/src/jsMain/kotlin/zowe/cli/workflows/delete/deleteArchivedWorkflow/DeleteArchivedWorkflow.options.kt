@file:JsModule("@zowe/cli")

package zowe.cli.workflows.delete.deleteArchivedWorkflow

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the delete archived workflow commands.
 */
external val DeleteArchivedWorkflowOptions: Record<String, ICommandOptionDefinition>
