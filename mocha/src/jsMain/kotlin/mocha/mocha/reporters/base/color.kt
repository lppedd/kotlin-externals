@file:JsModule("mocha")

package mocha.mocha.reporters.base

/**
 * Color `str` with the given `type` (from `colors`)
 *
 * See https://mochajs.org/api/module-base#.color
 */
external fun color(
  type: String,
  str: String,
): String
