@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.constants

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Option constants - includes static options built/added by request (on imperative config or
 * command definitions).
 */
external class OptionConstants {
  companion object {
    /**
     * The response format filter options allows users to filter (include) fields/properties in an
     * output table/object. Enable this option by specifying "outputFormatOptions: true" on your
     * ICommandDefinition document.
     */
    val RESPONSE_FORMAT_FILTER_OPTION: ICommandOptionDefinition

    /**
     * The response format header option allows users to include a table header (or not). Enable
     * this option by specifying "outputFormatOptions: true" on your ICommandDefinition document.
     */
    val RESPONSE_FORMAT_HEADER_OPTION: ICommandOptionDefinition

    /**
     * The array of available format types (for the response-format-type definition allowable
     * values).
     */
    val RESPONSE_FORMAT_TYPES: Array<String>

    /**
     * The response format type option allows users control over handler output (print/console) data
     * format. Enable this option by specifying "outputFormatOptions: true" on your
     * ICommandDefinition document.
     */
    val RESPONSE_FORMAT_OPTION: ICommandOptionDefinition
  }
}
