import { IWebHelpManager } from "./doc/IWebHelpManager";
import { IHandlerResponseApi } from "../doc/response/api/handler/IHandlerResponseApi";
import { ICommandDefinition } from "../doc/ICommandDefinition";
/**
 * Imperative web help manager. Single instance class used to launch web help
 * in browser which handles (re)building web help files first if necessary.
 * @export
 * @class WebHelpManager
 */
export declare class WebHelpManager implements IWebHelpManager {
    /**
     * Singleton instance of this class
     * @private
     * @static
     * @type {WebHelpManager}
     * @memberof WebHelpManager
     */
    private static mInstance;
    /**
     * Imperative command tree to build help for
     * @private
     * @memberof WebHelpManager
     */
    private mFullCommandTree;
    /**
     * Return a singleton instance of this class
     * @static
     * @readonly
     */
    static get instance(): WebHelpManager;
    /**
     * Launch root help page in browser.
     * @param {IHandlerResponseApi} cmdResponse - Command response object to use for output
     * @memberof WebHelpManager
     */
    openRootHelp(cmdResponse: IHandlerResponseApi): void;
    /**
     * Launch help page for specific group/command in browser.
     * @param {string} inContext - Name of page for group/command to jump to
     * @param {IHandlerResponseApi} cmdResponse - Command response object to use for output
     * @memberof WebHelpManager
     */
    openHelp(inContext: string, cmdResponse: IHandlerResponseApi): void;
    /**
     * Record a reference to our CLI's full command tree.
     * @param fullCommandTree - The command tree.
     */
    set fullCommandTree(fullCommandTree: ICommandDefinition);
    /**
     * Get a reference to our CLI's full command tree.
     * @returns The command tree.
     */
    get fullCommandTree(): ICommandDefinition;
    /**
     * Gets the directory where built copy of web help is stored
     * @readonly
     * @private
     * @returns {string} Absolute path of directory
     */
    private get webHelpDir();
    /**
     * Computes current package metadata based on version of core and installed plug-ins
     * @private
     * @param packageJson - CLI package JSON
     * @param pluginsJson - Imperative plug-ins JSON
     * @returns {IWebHelpPackageMetadata[]} Names and versions of all components
     */
    private calcPackageMetadata;
    /**
     * Compares two package metadata objects to see if they are equal
     * @private
     * @param {IWebHelpPackageMetadata[]} cached - Old cached package metadata
     * @param {IWebHelpPackageMetadata[]} current - Freshly computed package metadata
     * @returns {boolean} True if the package metadata objects are equal
     */
    private eqPackageMetadata;
    /**
     * Checks if cached package metadata is non-existent or out of date
     * @private
     * @returns {MaybePackageMetadata} Updated metadata, or `null` if cached metadata is already up to date
     */
    private checkIfMetadataChanged;
    /**
     * Updates cached package metadata
     * @private
     * @param {IWebHelpPackageMetadata[]} metadata - New metadata to save to disk
     */
    private writePackageMetadata;
}
