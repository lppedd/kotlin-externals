@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.mount.fs

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the Mount API
 */
external val FsMountOptions: Record<String, ICommandOptionDefinition>
