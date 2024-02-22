import { IHandlerResponseApi } from "../../doc/response/api/handler/IHandlerResponseApi";
/**
 * Web help manager API that handles launching of web help and generating it if necessary.
 * @export
 * @interface IWebHelpManager
 */
export interface IWebHelpManager {
    /**
     * Launch root help page in browser.
     * @param {IHandlerResponseApi} cmdResponse - Command response object to use for output
     * @memberof IWebHelpManager
     */
    openRootHelp(cmdResponse: IHandlerResponseApi): void;
    /**
     * Launch help page for specific group/command in browser.
     * @param {string} inContext - Name of page for group/command to jump to
     * @param {IHandlerResponseApi} cmdResponse - Command response object to use for output
     * @memberof IWebHelpManager
     */
    openHelp(inContext: string, cmdResponse: IHandlerResponseApi): void;
}
