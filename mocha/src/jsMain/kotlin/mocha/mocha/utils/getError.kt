@file:JsModule("mocha")

package mocha.mocha.utils

/**
 * Generate an undefined error if `err` is not defined.
 *
 * See https://mochajs.org/api/module-utils.html#.getError
 */
external fun getError(err: Error?): Error
