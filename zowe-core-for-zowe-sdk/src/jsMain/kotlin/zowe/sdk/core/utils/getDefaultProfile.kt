@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.utils

import js.promise.Promise
import zowe.imperative.profiles.doc.definition.IProfile

/**
 * Loads default z/OSMF profile. The profile must have already been
 * created using Zowe CLI, and not rely on base profiles
 *
 * @param profileType The name of the profile type
 * @param mergeWithBase Whether or not to merge with the base profile
 * @return The default profile (or merged profile, if requested)
 */
external fun getDefaultProfile(
  profileType: String,
  mergeWithBase: Boolean = definedExternally,
): Promise<IProfile>
