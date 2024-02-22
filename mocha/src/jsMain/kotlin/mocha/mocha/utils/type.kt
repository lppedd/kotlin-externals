@file:JsModule("mocha")

package mocha.mocha.utils

/**
 * Takes some variable and asks `Object.prototype.toString()` what it thinks it is.
 */
external fun type(value: Any?): String
