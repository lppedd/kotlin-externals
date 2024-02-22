import { IWebDiffManager } from "./doc/IWebDiffManager";
/**
 * Imperative Web Differences Manager handles the opening of diffs and
 * constructs the dirs and files if necessary
 * @export
 * @class WebDiffManager
 */
export declare class WebDiffManager implements IWebDiffManager {
    /**
     * Singleton instance of this class
     * @private
     * @static
     * @type {WebDiffManager}
     * @memberof WebDiffManager
     */
    private static mInstance;
    /**
     * Return a singleton instance of this class
     * @static
     * @readonly
     */
    static get instance(): WebDiffManager;
    /**
     * Launch diffs page in browser.
     * @memberof WebDiffManager
     */
    openDiffs(patchDiff: string): Promise<void>;
    /**
     * Gets the directory where built copy of web diff launcher is stored
     * @readonly
     * @private
     * @returns {string} Absolute path of directory
     */
    private get webDiffDir();
    /**
     * Returns header HTML for web diff page
     * @private
     * @param htmlDiff - html diffs of the file changes
     * @param unifiedStringDiff - unified string of difference between two files
     */
    private genHtmlForDiffs;
}
