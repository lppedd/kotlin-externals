/// <reference types="node" />
/// <reference types="node" />
import { Duplex, Writable } from "stream";
import { ContentEncoding } from "./Headers";
export declare class CompressionUtils {
    /**
     * Decompress a buffer using the specified algorithm.
     * @param data Compressed buffer
     * @param encoding Value of Content-Encoding header
     * @throws {ImperativeError}
     */
    static decompressBuffer(data: Buffer, encoding: ContentEncoding): Buffer;
    /**
     * Add zlib decompression transform to a Writable stream. Any compressed
     * data written to the returned stream will be decompressed using the
     * specified algorithm.
     *
     * The returned stream should only be used internally by a REST client to
     * write to. Use the original stream to read back the decompressed output
     * and handle decompression errors.
     * @param responseStream Writable stream that will receive compressed data
     * @param encoding Value of Content-Encoding header
     * @param normalizeNewLines Specifies if line endings should be converted
     * @throws {ImperativeError}
     */
    static decompressStream(responseStream: Writable, encoding: ContentEncoding, normalizeNewLines?: boolean): Duplex;
    /**
     * Return ImperativeError populated with details of decompression error
     * @param err Thrown error object
     * @param source Type of object being decompressed
     * @param encoding Value of Content-Encoding header
     */
    private static decompressError;
    /**
     * Return a transform to normalize line endings in response text.
     */
    private static newLinesTransform;
    /**
     * Return zlib transform for the specified decompression algorithm.
     * @param encoding Value of Content-Encoding header
     */
    private static zlibTransform;
}
