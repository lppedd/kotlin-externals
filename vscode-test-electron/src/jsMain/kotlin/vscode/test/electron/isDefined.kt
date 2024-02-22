@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/** Predicates whether arg is undefined or null */
// TODO(Edoardo): move this to a function with a contract
external fun <T> isDefined(arg: T?): Boolean // arg is T
