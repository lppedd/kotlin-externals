package zowe.imperative.rest.client.doc

import node.http.OutgoingHttpHeaders
import zowe.imperative.rest.client.types.HttpVerb
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IHTTPSOptions {
  var headers: OutgoingHttpHeaders
  var hostname: String
  var method: HttpVerb
  var path: String
  var port: String
  var rejectUnauthorized: Boolean
  var cert: String?
  var key: String?
  var hash: String?
}
