/**
 * Web diff manager API that handles launching of web diff and generating it if necessary.
 * @export
 * @interface IWebDiffManager
 */
export interface IWebDiffManager {
    /**
     * launch the diff of two file in web
     * @param {string} content Html content string to launch in web
     */
    openDiffs(content: string): void;
}
