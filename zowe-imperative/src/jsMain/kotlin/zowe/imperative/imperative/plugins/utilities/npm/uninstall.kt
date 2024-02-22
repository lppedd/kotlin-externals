@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities.npm

/**
 * Updates `extenders.json` and returns a list of types to remove from the schema, if applicable.
 *
 * @param npmPackage The package name for the plug-in that's being uninstalled
 * @return A list of types to remove from the schema
 */
external val updateAndGetRemovedTypes: (npmPackage: String) -> Array<String>

/**
 * TODO - allow multiple packages to be uninstalled?
 *
 * Common function that abstracts the uninstall process.
 *
 * @param packageName A package name. This value is a valid npm package name.
 */
external fun uninstall(packageName: String)
