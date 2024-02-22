package mocha.mocha.reporters.base

import js.objects.Record

/**
 * Default color map
 *
 * See https://mochajs.org/api/module-base#.colors
 */
external interface ColorMap : Record<String, Int> {
  // added by Base
  var pass: Int
  var fail: Int
  var `bright pass`: Int
  var `bright fail`: Int
  var `bright yellow`: Int
  var pending: Int
  var suite: Int
  var `error title`: Int
  var `error message`: Int
  var `error stack`: Int
  var checkmark: Int
  var fast: Int
  var medium: Int
  var slow: Int
  var green: Int
  var light: Int
  var `diff gutter`: Int
  var `diff added`: Int
  var `diff removed`: Int

  // added by Progress
  var progress: Int

  // added by Landing
  var plane: Int
  var `plane crash`: Int
  var runway: Int
}
