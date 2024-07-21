@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

import js.array.JsTuple3
import zowe.imperative.rest.client.doc.IHeaderContent

external class Headers {
  companion object {
    val CONTENT_TYPE: String
    val CONTENT_LENGTH: String
    val CONTENT_ENCODING: String
    val CONTENT_ENCODING_TYPES: JsTuple3<
      @JsString("br")
      String,
      @JsString("deflate")
      String,
      @JsString("gzip")
      String,
    >
    val APPLICATION_JSON: IHeaderContent
    val TEXT_PLAIN: IHeaderContent
    val TEXT_PLAIN_UTF8: Any
    val OCTET_STREAM: IHeaderContent
    val BASIC_AUTHORIZATION: Any
    val COOKIE_AUTHORIZATION: Any
  }
}
