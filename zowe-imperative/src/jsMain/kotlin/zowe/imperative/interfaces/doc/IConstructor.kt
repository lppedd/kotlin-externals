package zowe.imperative.interfaces.doc

/**
 * A type that defines a class constructor
 */
typealias IConstructor<T> = (args: Array<Any?>) -> T // new (...args: any[]) => T
