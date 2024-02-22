@file:JsModule("@zowe/cli")

package zowe.cli.workflows.create

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the create workflow commands.
 */
external val CreateCommonOptions: Record<String, ICommandOptionDefinition>
