@file:JsModule("@zowe/cli")

package zowe.cli.workflows.list.activeWorkflowDetails

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the list active workflow details commands.
 */
external val ActiveWorkflowDetailsCommonOptions: Record<String, ICommandOptionDefinition>
