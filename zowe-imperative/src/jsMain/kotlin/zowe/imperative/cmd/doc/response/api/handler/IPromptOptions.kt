package zowe.imperative.cmd.doc.response.api.handler

import kotlin.js.plain.JsPlainObject

/**
 * Interface for prompt options
 */
@JsPlainObject
external interface IPromptOptions {
  /**
   * Whether or not to obscure answered prompt (e.g. for passwords)
   */
  var hideText: Boolean?

  /**
   * How long to wait in seconds for prompting
   */
  var secToWait: Int?

  /**
   * Character to use for masking hidden text
   */
  var maskChar: String?
}
