@file:Suppress("NOTHING_TO_INLINE", "UnsafeCastFromDynamic")

package kotlin.js

/**
 * Adds the specified [value] to the end of the array and returns the new length of the array.
 */
inline fun <T> Array<T>.push(value: T): Int =
  asDynamic().push(value)

/**
 * Removes the last element from the array and returns that element.
 */
inline fun <T> Array<T>.pop(): T =
  asDynamic().pop()
