/**
 * Interface for prompt options
 * @export
 * @interface IPromptOptions
 */
export interface IPromptOptions {
    /**
     * Whether or not to obscure answered prompt (e.g. for passwords)
     * @type {boolean}
     * @memberof IPromptOptions
     */
    hideText?: boolean;
    /**
     * How long to wait in seconds for prompting
     * @type {number}
     * @memberof IPromptOptions
     */
    secToWait?: number;
    /**
     * Character to use for masking hidden text
     * @type {string}
     * @memberof IPromptOptions
     */
    maskChar?: string | null;
}
