@file:JsModule("mocha")

package mocha.mocha.reporters.base

/**
 * Returns a diff between two strings with colored ANSI output.
 *
 * See https://mochajs.org/api/module-base#.generateDiff
 */
external fun generateDiff(
  actual: String,
  expected: String,
): String
