@file:JsModule("mocha")

package mocha.mocha.reporters.base

import mocha.mocha.Test

/**
 * Output the given `failures` as a list.
 *
 * See https://mochajs.org/api/Mocha.reporters.Base.html#.exports.list1
 */
external fun list(failures: Array<Test>)
