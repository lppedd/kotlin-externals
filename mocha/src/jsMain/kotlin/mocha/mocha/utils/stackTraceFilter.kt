@file:JsModule("mocha")

package mocha.mocha.utils

/**
 * When invoking this function you get a filter function that get the Error.stack as an
 * input, and return a prettify output. (i.e: strip Mocha and internal node functions from
 * stack trace).
 *
 * See https://mochajs.org/api/module-utils.html#.stackTraceFilter
 */
external fun stackTraceFilter(): (stack: String) -> String
