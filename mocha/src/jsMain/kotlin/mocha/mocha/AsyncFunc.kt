package mocha.mocha

import js.promise.PromiseLike

/**
 * Async callback function used for tests and hooks.
 */
typealias AsyncFunc = (/* this: Context, */) -> PromiseLike<Any?>
