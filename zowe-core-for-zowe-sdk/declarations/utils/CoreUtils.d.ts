/// <reference types="node" />
/**
 * Adds padding in case you want a longer string.
 *
 * @param {string} str              - string to add the padding to
 * @param {number} len              - final length of the padded string
 * @param {string} [padChar=" "]    - Padding character
 * @return {string} Padded string
 */
export declare function padLeft(str: string, len: number, padChar?: string): string;
/**
 * Trims a given line based on the terminal's width. It also replaces tabs with spaces.
 *
 * @param {string} str - string to be trimmed
 * @return {string} Trimmed string
 */
export declare function trimLineToTerminalWidth(str: string): string;
/**
 * Produces formatted context of a given error in the specified location of the contents
 *
 * NOTE:
 *      The lineIndex is zero-based indexed
 *
 * @param {string | string[]} content   - Indicates the contents or the file path to the file containing the contents to get the error from
 * @param {number} lineIndex            - Zero-basd indexed location of the error to be printed
 * @return {string} Few lines (separated by \n) containing error context
 */
export declare function getErrorContext(content: string | string[], lineIndex: number): string;
/**
 * This is a simple sleep function to help when waiting for a certain period of
 * time before continuing.
 *
 * @param {number} [ms=1000] The number of milliseconds to sleep.
 *
 * @returns {Promise<void>} Resolves after the specified time is up.
 *
 * @example <caption>Sleeping within code</caption>
 *
 * async function doStuff() {
 *   await CoreUtils.sleep(10000);
 *   console.log("You will see this message 10 seconds after function was entered");
 * }
 */
export declare function sleep(ms?: number): Promise<void>;
/**
 * Utility function to read complete standard in contents from a handler
 * Can be awaited from async methods
 */
export declare function readStdin(): Promise<Buffer>;
/**
 * Execute multiple promises in a pool with a maximum number of promises
 * executing at once
 * @param poolLimit - limit of how many promises should execute at once
 * @param array - array of objects to convert to promises with iteratorFn
 * @param iteratorFn - the function that turns an entry in the array into a promise
 */
export declare function asyncPool(poolLimit: number, array: any[], iteratorFn: (item: any, array: any[]) => Promise<any>): Promise<any>;
