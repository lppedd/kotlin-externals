@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import seskar.js.JsIntValue
import seskar.js.JsVirtual

/**
 * This enum represents the type of location for a property. Note that properties with location
 * types of ENV and DEFAULT cannot be stored back to disk. Thus the consumer app must make its own
 * decision about where to store the property.
 */
@JsVirtual
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ProfLocType {
  companion object {
    @JsIntValue(0)
    val OLD_PROFILE: ProfLocType

    @JsIntValue(1)
    val TEAM_CONFIG: ProfLocType

    @JsIntValue(2)
    val ENV: ProfLocType

    @JsIntValue(3)
    val DEFAULT: ProfLocType
  }
}
