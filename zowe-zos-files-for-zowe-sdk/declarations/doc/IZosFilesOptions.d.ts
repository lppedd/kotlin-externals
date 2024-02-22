/**
 * This interface defines the global options that apply to all zosfiles APIs
 * @export
 * @interface IZosFilesOptions
 */
export interface IZosFilesOptions {
    /**
     * The maximum amount of time for the TSO servlet to wait for a response before returning an error
     * @type {number}
     */
    responseTimeout?: number;
}
