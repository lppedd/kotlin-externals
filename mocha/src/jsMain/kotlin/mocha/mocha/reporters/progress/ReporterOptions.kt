package mocha.mocha.reporters.progress

external interface ReporterOptions {
  var open: String?
  var complete: String?
  var incomplete: String?
  var close: String?
  var verbose: Boolean?
}
