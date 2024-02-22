@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import kotlin.ts.Union

external interface IConfigOpts {
  /**
   * Directory where global config files are located. Defaults to `~/.appName`.
   */
  var homeDir: String?

  /**
   * Directory where project config files are located.
   * Defaults to working directory.
   *
   * Specify `false` to disable loading of project config files.
   */
  var projectDir: Union<String, `false`>?

  /**
   * Vault object with methods for loading and saving secure credentials
   */
  var vault: IConfigVault?

  /**
   * Do not attempt to load the config, meant for when the config is broken
   */
  var noLoad: Boolean?
}
