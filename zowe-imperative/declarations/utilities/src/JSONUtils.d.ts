/**
 * JSON utility to wrap and throw ImperativeErrors
 * @export
 * @class JSONUtils
 */
export declare class JSONUtils {
    /**
     * Throw imperative error or return parsed data
     * @template T - type to parse
     * @param {string} data - string input data to parse as JSON
     * @param {string} [failMessage="Parse of " + data + " failed"] - failure message
     *
     * @returns {T} - parsed object. If data length is 0 then this method will return a null object
     *
     * @throws {ImperativeError} When there was a failure trying to parse a non-zero length data string.
     */
    static parse<T extends object>(data: string, failMessage?: string): T;
}
