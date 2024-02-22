@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.security

import node.Module

/**
 * Imports the necessary security modules
 */
external fun getSecurityModules(
  moduleName: String,
  isTheia: Boolean,
): Module?
