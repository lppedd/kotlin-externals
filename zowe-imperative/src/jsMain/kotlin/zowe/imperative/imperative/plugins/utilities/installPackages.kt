@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities

/**
 * Common function that installs a npm package using the local npm cli.
 *
 * @param prefix Path where to install npm the npm package.
 * @param registry The npm registry to install from.
 * @param npmPackage The name of package to install.
 * @return command response
 */
external fun installPackages(
  prefix: String,
  registry: String,
  npmPackage: String,
): String
