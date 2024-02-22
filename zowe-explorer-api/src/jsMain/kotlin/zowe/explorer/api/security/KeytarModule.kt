package zowe.explorer.api.security

import js.promise.Promise

external interface KeytarModule {
  var deletePassword: (service: String, account: String) -> Promise<Boolean>
  var findPassword: (service: String, account: String) -> Promise<String?>
  var findCredentials: (name: String) -> Promise<Array<KeytarCredentials>>
  var getPassword: (service: String, account: String) -> Promise<String?>
  var setPassword: (service: String, account: String, password: String) -> Promise<Unit>
}
