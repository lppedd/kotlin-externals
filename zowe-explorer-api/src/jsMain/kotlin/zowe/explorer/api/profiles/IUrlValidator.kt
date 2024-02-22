package zowe.explorer.api.profiles

external interface IUrlValidator {
  var valid: Boolean
  var protocol: String
  var host: String
  var port: Int
}
