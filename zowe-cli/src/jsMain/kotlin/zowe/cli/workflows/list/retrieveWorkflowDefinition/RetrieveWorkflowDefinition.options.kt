@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.retrieveWorkflowDefinition

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the retrieve workflow definition commands.
 */
external val RetrieveWorkflowDefinitionCommonOptions: Record<String, ICommandOptionDefinition>
