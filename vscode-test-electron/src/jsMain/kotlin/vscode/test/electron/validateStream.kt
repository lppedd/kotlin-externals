@file:JsModule("@vscode/test-electron")

package vscode.test.electron

import js.promise.Promise
import node.ReadableStream

/**
 * Validates the stream data matches the given length and checksum, if any.
 *
 * Note: md5 is not ideal, but it's what we get from the CDN, and for the
 * purposes of self-reported content verification is sufficient.
 */
external fun validateStream(
  readable: ReadableStream,
  length: Int,
  sha256: String = definedExternally,
): Promise<Unit>
