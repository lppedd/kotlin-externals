@file:JsModule("@zowe/cli")

package zowe.cli.workflows.archive

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the archive workflow commands.
 */
external val ArchiveOptions: Record<String, ICommandOptionDefinition>
