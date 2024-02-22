@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities.npm

import js.promise.Promise

/**
 * @param packageName A package name. This value is a valid npm package name.
 * @param registry The npm registry.
 *
 * TODO - allow multiple packages to be updated? Common function that abstracts the update process.
 */
external fun update(
  packageName: String,
  registry: String,
): Promise<String>
