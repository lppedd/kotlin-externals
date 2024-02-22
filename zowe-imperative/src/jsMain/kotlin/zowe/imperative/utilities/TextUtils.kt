@file:JsModule("@zowe/imperative")

package zowe.imperative.utilities

import js.errors.JsError
import js.objects.Record
import kotlin.js.RegExp

/**
 * Lightweight utilities for text manipulation/coloring. Low import impact
 */
external class TextUtils {
  companion object {
    @JsInt(80)
    val DEFAULT_WRAP_WIDTH: Int
    val AVAILABLE_CHALK_COLORS: Array<String>

    /**
     * Get the recommended width to wrap text. You can specify a preferred width, but this method
     * width return
     *
     * @param preferredWidth the width you would like to use if supported by the user's terminal
     * @return the width that will work best for the user's terminal
     */
    fun getRecommendedWidth(preferredWidth: Int = definedExternally): Int

    fun renderWithMustache(
      template: String,
      values: Any?,
    ): String

    /**
     * Replace keys from an object with string explanations for those keys, primarily so that they
     * can be printed for the user to read.
     *
     * @param original the original object e.g. a response from a z/OSMF API {wrdKy4U: "weirdkeyvalue"}
     * @param explanationMap an object that maps the original to the new format
     * @param includeUnexplainedKeys should keys not covered by the explanation object be included in the result?
     * @return the explained object
     */
    fun explainObject(
      original: Any?,
      explanationMap: IExplanationMap,
      includeUnexplainedKeys: Boolean = definedExternally,
    ): Any?

    /**
     * Get a json object in tabular form
     *
     * @param object Any JSON object
     * @param options Any JSON object to specify printing
     * @param color use color on the result?
     */
    fun prettyJson(
      `object`: Any?,
      options: Any? = definedExternally,
      color: Boolean = definedExternally,
      append: String = definedExternally,
    ): String

    /**
     * @param objects the key-value objects to convert to a
     * @param primaryHighlightColor the main color to highlight headings of the table with. e.g. "blue"
     * @param maxColumnWidth override the default column width of the table?
     * @param includeHeader should the table include a header of the field names of the objects
     * @param includeBorders should the table have borders between the cells?
     * @param hardWrap hard wrap the text within the width of the table cells (defaults to false)
     * @param headers specify which headers in which order to display. if omitted, loops through
     *   the rows and adds object properties as headers in their enumeration order
     * @return the rendered table
     */
    fun getTable(
      objects: Array<Any?>,
      primaryHighlightColor: String,
      maxColumnWidth: Int = definedExternally,
      includeHeader: Boolean = definedExternally,
      includeBorders: Boolean = definedExternally,
      hardWrap: Boolean = definedExternally,
      headers: Array<String> = definedExternally,
    ): String

    /**
     * Build table headers from an array of key-value objects
     *
     * @param objects the key-value objects from which to build headers
     * @return the headers array
     */
    fun buildHeaders(objects: Array<Any?>): Array<String>

    /**
     * Wrap some text so that it fits within a certain width with the wrap-ansi package
     *
     * @param text The text you would like to wrap
     * @param width The width you would like to wrap to - we'll try to determine the
     *   optimal width based on this (the resulting wrap may be wrapped to fewer columns, but not more)
     * @param indent Add this string to every line of the result
     * @param hardWrap do not allow any letters past the requested width - defaults to false
     */
    fun wordWrap(
      text: String,
      width: Int = definedExternally,
      indent: String = definedExternally,
      hardWrap: Boolean = definedExternally,
      trim: Boolean = definedExternally,
    ): String

    /**
     * Indent some text
     *
     * @param text The text you would like to indent
     * @param indent Add this string to every line of the result
     */
    fun indentLines(
      text: String,
      indent: String = definedExternally,
    ): String

    /**
     * Highlight all matches of a full regex with TextUtils.chalk
     *
     * @param text the text you'd like to search for matches
     * @param term a regular expression of terms to highlight
     * @return the highlighted string
     */
    fun highlightMatches(
      text: String,
      term: RegExp,
    ): String

    /**
     * Auto-detect whether a message should be formatted with printf-style formatting or mustache
     * (but don't try to use both!) and format the string accordingly
     *
     * @param message the string message with %s or {{mustache}} style variables
     * @param values the fields that will resolve the printf or mustache template
     * @return a formatted string with the variables inserted
     */
    fun formatMessage(
      message: String,
      vararg values: Any?,
    ): String

    val chalk: Any?

    /**
     * Parse a key value string into an object
     *
     * @param keysAndValues a string in the format key1=value1,key2=value2,key3=value3.
     *   Note: the key names are case sensitive
     * @return the parsed object
     */
    fun parseKeyValueString(keysAndValues: String): Record<String, String>

    /**
     * Render a mustache template based on arguments from the user
     *
     * @param template the mustache-style template string into which you would like to insert your values
     * @param keysAndValues a string in the format key1=value1,key2=value2,key3=value3.
     *   Note: the key names are case sensitive
     * @return the rendered template
     * @throws JsError if the keysAndValues are not in the expected format
     */
    fun renderTemplateFromKeyValueArguments(
      template: String,
      keysAndValues: String,
    ): String
  }
}
