@file:JsModule("mocha")

package mocha.mocha.utils

/**
 * Stringify `value`. Different behavior depending on type of value:
 *
 * - If `value` is undefined or null, return `'[undefined]'` or `'[null]'`, respectively.
 * - If `value` is not an object, function or array, return result of `value.toString()` wrapped in double-quotes.
 * - If `value` is an *empty* object, function, or array, returns `'{}'`, `'[Function]'`, or `'[]'` respectively.
 * - If `value` has properties, call canonicalize} on it, then return result of `JSON.stringify()`
 *
 * See https://mochajs.org/api/module-utils.html#.stringify
 */
external fun stringify(value: Any?): String
