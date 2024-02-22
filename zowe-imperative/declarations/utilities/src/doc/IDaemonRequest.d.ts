/**
 * Option interface to construct request to daemon client
 * @export
 * @interface IDaemonRequest
 */
export interface IDaemonRequest {
    /**
     * Process exit code
     * @type {number}
     * @memberof IDaemonRequest
     */
    exitCode?: number;
    /**
     * Content is for stdout
     * @type {string}
     * @memberof IDaemonRequest
     */
    stdout?: string;
    /**
     * Content is for stderr
     * @type {string}
     * @memberof IDaemonRequest
     */
    stderr?: string;
    /**
     * Content is for prompting
     * @type {string}
     * @memberof IDaemonRequest
     */
    prompt?: string;
    /**
     * Content is for secure prompting
     * @type {string}
     * @memberof IDaemonRequest
     */
    securePrompt?: string;
    /**
     * Content is progress spinner
     * @type {boolean}
     * @memberof IDaemonRequest
     */
    progress?: boolean;
}
