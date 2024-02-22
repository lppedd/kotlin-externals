import { IDiffOptions } from "./doc/IDiffOptions";
import { IDiffNameOptions } from "./doc/IDiffNameOptions";
/**
 * Utilities to get the diff strings and open the diff strings in terminal and in browser
 * @export
 * @class DiffUtils
 */
export declare class DiffUtils {
    /**
     * Get the difference between two string in the form of html, unifiedString and terminal output depending upon the
     * options passed into the functions
     * @param {string} string1
     * @param {string} string2
     * @param {IDiffOptions} options
     * @returns {Promise<string>}
     */
    static getDiffString(string1: string, string2: string, options: IDiffOptions): Promise<string>;
    /**
     * Get the difference between two string in browser
     * @param {string} string1
     * @param {string} string2
     * @param {IDiffOptions} options
     * @return {Promise<void>}
     */
    static openDiffInbrowser(string1: string, string2: string, options?: IDiffNameOptions): Promise<void>;
}
