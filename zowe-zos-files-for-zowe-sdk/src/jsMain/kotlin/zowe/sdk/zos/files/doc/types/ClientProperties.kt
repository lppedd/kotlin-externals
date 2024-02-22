package zowe.sdk.zos.files.doc.types

external interface ClientProperties {
  var requestSuccess: ClientProperty
  var requestFailure: ClientProperty
  var data: ClientProperty
  var dataString: ClientProperty
  var response: ClientProperty
  var session: ClientProperty
  var log: ClientProperty
}
