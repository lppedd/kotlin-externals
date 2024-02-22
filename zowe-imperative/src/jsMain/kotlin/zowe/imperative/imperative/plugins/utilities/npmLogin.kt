@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities

/**
 * NPM login to be able to install from secure registry
 *
 * @param registry The npm registry to install from.
 */
external fun npmLogin(registry: String)
