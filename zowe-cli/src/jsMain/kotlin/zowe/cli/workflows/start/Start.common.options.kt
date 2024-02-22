@file:JsModule("@zowe/cli")

package zowe.cli.workflows.start

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the start workflow commands.
 */
external val StartCommonOptions: Record<String, ICommandOptionDefinition>
