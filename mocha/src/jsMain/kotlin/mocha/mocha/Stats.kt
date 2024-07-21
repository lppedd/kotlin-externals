package mocha.mocha

import js.date.Date

/**
 * Test statistics
 */
external interface Stats {
  var suites: Int
  var tests: Int
  var passes: Int
  var pending: Int
  var failures: Int
  var start: Date?
  var end: Date?
  var duration: Int?
}
