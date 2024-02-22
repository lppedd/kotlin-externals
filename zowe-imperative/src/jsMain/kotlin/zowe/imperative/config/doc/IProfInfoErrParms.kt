@file:JsModule("@zowe/imperative")

package zowe.imperative.config.doc

import zowe.imperative.error.doc.IImperativeErrorParms
import kotlin.js.plain.JsPlainObject

/**
 * Options that will affect the behavior of the ProfileInfo class.
 * They are supplied on the ProfileInfo constructor.
 */
@JsPlainObject
external interface IProfInfoErrParms : IImperativeErrorParms {
  /**
   * This property is used when an error is returned that is related to a number of configuration
   * items. For example, if a problem is identified that affects a subset of profiles, those
   * affected profiles can be identified in the itemsInError array. An app can easily identify each
   * affected profile by traversing itemsInError.
   */
  var itemsInError: Array<String>?
}
