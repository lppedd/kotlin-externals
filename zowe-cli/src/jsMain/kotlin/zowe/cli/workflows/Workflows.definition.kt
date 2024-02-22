@file:JsModule("@zowe/cli")

package zowe.cli.workflows

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * This object defines the top level command group for zosworkflows. This is not
 * something that is intended to be used outside of this npm package.
 */
external val definition: ICommandDefinition
