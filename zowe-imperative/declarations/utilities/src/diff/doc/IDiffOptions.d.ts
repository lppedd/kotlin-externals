import { IDiffNameOptions } from "./IDiffNameOptions";
declare type outputFormat = "html" | "unifiedstring" | "terminal";
/**
 * interface for diff options
 */
export interface IDiffOptions extends IDiffNameOptions {
    /**
     * Output format of differences between two, to be returned
     * @type {outputFormat}
     * @memberOf IDiffOptions
     */
    outputFormat: outputFormat;
    /**
     * Number of context line arguments
     * @type {number}
     * @memberOf IDiffOptions
     */
    contextLinesArg?: number;
}
export {};
