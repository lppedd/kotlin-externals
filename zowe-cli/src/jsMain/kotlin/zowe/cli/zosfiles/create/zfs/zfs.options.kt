@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.create.zfs

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the Create API
 */
external val ZfsCreateOptions: Record<String, ICommandOptionDefinition>
