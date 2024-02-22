@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.plugins.utilities

import js.promise.Promise
import zowe.imperative.imperative.plugins.utilities.npm.PackageInfo

/**
 * Fetch name and version of NPM package that was installed
 *
 * @param pkgSpec The package name as specified on NPM install
 */
external fun getPackageInfo(pkgSpec: String): Promise<PackageInfo>
