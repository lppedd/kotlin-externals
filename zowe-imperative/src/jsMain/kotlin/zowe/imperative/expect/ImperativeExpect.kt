@file:JsModule("@zowe/imperative")

package zowe.imperative.expect

import js.objects.Record
import zowe.imperative.error.ImperativeError

/**
 * Helper class for paramter validation.
 * Expectations that fail will throw an ImperativeError with a validation error message.
 *
 * All methods allow keys to be specified as "property1.prop.lastprop" for example.
 */
external class ImperativeExpect {
  companion object {
    /**
     * The error tag to append to each error message.
     */
    val ERROR_TAG: String

    /**
     * Expect a situation and transform the error (if expect fails). Accepts two methods of your
     * implementation to: A) Test the expect (which is intended to throw an ImperativeError) B)
     * Transform and return a new ImperativeError This allows you complete control over the contents
     * of the error. If you are only interested in influencing the message displayed, then use the
     * msg parm on each of the expect functions.
     *
     * @param expect The method that contains your ImperativeExpect invocation
     * @param transform Passed the error thrown by the expect
     *   and expects you to return the ImperativeError you would like thrown.
     */
    fun expectAndTransform(
      expect: () -> Unit,
      transform: (error: Any?) -> ImperativeError,
    )

    /**
     * Expect that values are equal (via "!==" operator).
     *
     * @param value1 Value 1
     * @param value2 Value 2
     * @param msg The message to throw - overrides the default message
     */
    fun toBeEqual(
      value1: Any?,
      value2: Any?,
      msg: String = definedExternally,
    )

    /**
     * Expect that value matches the regular expression (via ".test()" method).
     *
     * @param value Value
     * @param myRegex Regular expression
     * @param msg The message to throw - overrides the default message
     */
    fun toMatchRegExp(
      value: Any?,
      myRegex: String,
      msg: String = definedExternally,
    )

    /**
     * Expect the object passed to be defined.
     *
     * @param obj The object to check
     * @param msg The message to throw - overrides the default message
     */
    fun toNotBeNullOrUndefined(
      obj: Any?,
      msg: String = definedExternally,
    )

    /**
     * Expect the object passed to be an array that contains a particular entry. Your compare method
     * is invoked to determine if the entry you're looking for is found within the array.
     *
     * @param arr the array to search
     * @param compare compare method (passed the parms) - return true if the entry is found within the array.
     * @param msg The message to throw - overrides the default message
     * @return If a match is found, it will return the match.
     */
    fun arrayToContain(
      arr: Array<Any?>,
      compare: (entry: Any?) -> Boolean,
      msg: String = definedExternally,
    ): Any?

    /**
     * Check if the input is one of several possibilities in a list.
     *
     * @param value The value to find in following array
     * @param arr The array of possible items we could be expecting
     * @param msg The message - overrides the default message
     * @return If a match is found, it will return the match.
     */
    fun toBeOneOf(
      value: Any?,
      arr: Array<Any?>,
      msg: String = definedExternally,
    ): Any?

    /**
     * Check if the input object is an array.
     *
     * @param arr The array to check
     * @param msg The message to throw - overrides the default message
     */
    fun toBeAnArray(
      arr: Array<Any?>,
      msg: String = definedExternally,
    )

    /**
     * Expect a set of keys (by name) to be defined, of type array, and optionally a non-zero length array.
     *
     * @param obj the object for which you would like to assert that certain fields
     * @param nonZeroLength if true, the length of the array must be non zero
     * @param keys keys in object that should be arrays
     * @param msg The message to throw - overrides the default message
     */
    fun keysToBeAnArray(
      obj: Record<String, Any>,
      nonZeroLength: Boolean,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    fun keysToBeAnArray(
      obj: Any?,
      nonZeroLength: Boolean,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    /**
     * Expect a set of keys (by name) are defined.
     *
     * @param obj `{{[key: string]: any}}` object to test existence
     * @param keys keys in object
     * @param msg The message to throw - overrides the default message
     */
    fun keysToBeDefined(
      obj: Record<String, Any>,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    fun keysToBeDefined(
      obj: Any?,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    /**
     * Expect two values to be equal (via "===" operator).
     *
     * @param value1 Value 1
     * @param value2 Value 2
     * @param msg The message to throw - overrides the default message
     */
    fun toNotBeEqual(
      value1: Any?,
      value2: Any?,
      msg: String = definedExternally,
    )

    /**
     * Expect that a set of keys are defined, of type string, and are non-blank (after trimming).
     *
     * @param obj `{{[key: string]: string}}` object to test existence
     * @param keys keys in object
     * @param msg The message to throw - overrides the default message
     */
    fun keysToBeDefinedAndNonBlank(
      obj: Record<String, String>,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    fun keysToBeDefinedAndNonBlank(
      obj: Any?,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    fun toBeDefinedAndNonBlank(
      item: String,
      label: String,
      msg: String = definedExternally,
    )

    /**
     * Expect a set of keys to be of a certain type.
     *
     * @param obj `{{ [key: string]: any }}` The input object
     * @param type The type to check for (only primatives - uses "typeof")
     * @param keys A list of keys to check in the object
     * @param msg The message to throw - overrides the default message
     */
    fun keysToBeOfType(
      obj: Record<String, Any>,
      type: String,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    fun keysToBeOfType(
      obj: Any?,
      type: String,
      keys: Array<String>,
      msg: String = definedExternally,
    )

    /**
     * Expect a set of keys to be undefined.
     *
     * @param obj `{{[key: string]: any}}` object to test existence
     * @param keys keys in object
     * @param msg The message to throw - overrides the default message
     */
    fun keysToBeUndefined(
      obj: Record<String, Any>,
      keys: Array<String>,
      msg: String = definedExternally,
    )
  }
}
