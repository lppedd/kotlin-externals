@file:JsModule("@zowe/cli")

package zowe.cli

import zowe.imperative.imperative.doc.IImperativeConfig

/**
 * Get the Imperative config object which defines properties of the CLI.
 * This allows it to be accessed without calling Imperative.init.
 */
external fun getImperativeConfig(): IImperativeConfig
