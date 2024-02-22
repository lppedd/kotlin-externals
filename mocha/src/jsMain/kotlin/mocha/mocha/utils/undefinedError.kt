@file:JsModule("mocha")

package mocha.mocha.utils

/**
 * Generate an undefined error with a message warning the user.
 *
 * See https://mochajs.org/api/module-utils.html#.undefinedError
 */
external fun undefinedError(): Error
