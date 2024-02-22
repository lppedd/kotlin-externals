package zowe.imperative.interfaces.types

import zowe.imperative.error.ImperativeError

/**
 * Definition for a promise rejection method that provides an [ImperativeError] (or subclass)
 */
typealias ImperativeReject = (error: ImperativeError) -> Unit
