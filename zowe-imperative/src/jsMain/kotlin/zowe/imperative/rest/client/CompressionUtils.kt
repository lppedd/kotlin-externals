@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

import node.buffer.Buffer
import node.stream.Duplex
import node.stream.Writable
import zowe.imperative.error.ImperativeError

external class CompressionUtils {
  companion object {
    /**
     * Decompress a buffer using the specified algorithm.
     *
     * @param data Compressed buffer
     * @param encoding Value of Content-Encoding header
     * @throws ImperativeError
     */
    fun decompressBuffer(
      data: Buffer,
      encoding: ContentEncoding,
    ): Buffer

    /**
     * Add zlib decompression transform to a Writable stream. Any compressed data written to the
     * returned stream will be decompressed using the specified algorithm.
     *
     * The returned stream should only be used internally by a REST client to write to. Use the
     * original stream to read back the decompressed output and handle decompression errors.
     *
     * @param responseStream Writable stream that will receive compressed data
     * @param encoding Value of Content-Encoding header
     * @param normalizeNewLines Specifies if line endings should be converted
     * @throws ImperativeError
     */
    fun decompressStream(
      responseStream: Writable,
      encoding: ContentEncoding,
      normalizeNewLines: Boolean = definedExternally,
    ): Duplex
  }
}
