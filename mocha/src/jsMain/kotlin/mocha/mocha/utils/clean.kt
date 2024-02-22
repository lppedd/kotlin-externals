@file:JsModule("mocha")

package mocha.mocha.utils

/**
 * Strip the function definition from `str`, and re-indent for pre whitespace.
 *
 * See https://mochajs.org/api/module-utils.html#.clean
 */
external fun clean(str: String): String
