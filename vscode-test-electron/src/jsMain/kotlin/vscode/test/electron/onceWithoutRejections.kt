@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise

/**
 * Wraps a function so that it's called once, and never again, memoizing
 * the result unless it rejects.
 */
external fun <T, Args : Array<Any?>> onceWithoutRejections(fn: (args: Args) -> Promise<T>): (args: Args) -> Promise<T>
