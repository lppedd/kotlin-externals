@file:Suppress("UnsafeCastFromDynamic", "unused")

package kotlin.js

/**
 * Adds the specified [element] to the end of the array and returns the new length of the array.
 */
fun <T> Array<T>.add(element: T): Int =
  asDynamic().push(element)

/**
 * Adds the specified [element] to the end of the array and returns the new length of the array.
 *
 * @throws IndexOutOfBoundsException if the index is out of range
 */
fun <T> Array<T>.add(index: Int, element: T) {
  if (index < 0 || index > size) {
    throw IndexOutOfBoundsException("index: $index, size: $size")
  }

  asDynamic().splice(index, 0, element)
}

/**
 * Removes an element at the specified [index] from the array.
 *
 * @throws IndexOutOfBoundsException if the index is out of range
 */
fun <T> Array<T>.removeAt(index: Int): T {
  if (index < 0 || index >= size) {
    throw IndexOutOfBoundsException("index: $index, size: $size")
  }

  return asDynamic().splice(index, 1)[0]
}

/**
 * Removes the last element from the array and returns that element.
 *
 * @throws NoSuchElementException if the array is empty.
 */
fun <T> Array<T>.removeLast(): T {
  if (isEmpty()) {
    throw NoSuchElementException("Array is empty")
  }

  return asDynamic().pop()
}

/**
 * Removes the last element from the array and returns that element, if any.
 */
fun <T> Array<T>.removeLastOrNull(): T? =
  asDynamic().pop()
