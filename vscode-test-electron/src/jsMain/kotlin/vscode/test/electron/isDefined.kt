package vscode.test.electron

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/** Predicates whether arg is undefined or null */
@JsModule("@vscode/test-electron")
@JsName("isDefined")
private external fun <T> isDefinedJs(arg: T?): Boolean // arg is T

@OptIn(ExperimentalContracts::class)
inline fun <reified T> isDefined(arg: T?): Boolean {
  contract {
    returns(true) implies (arg is T)
  }

  @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
  return isDefinedJs(arg)
}
