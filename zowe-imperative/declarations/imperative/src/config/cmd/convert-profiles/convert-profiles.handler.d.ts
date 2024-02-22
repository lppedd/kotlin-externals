import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * Handler for the convert profiles command.
 */
export default class ConvertProfilesHandler implements ICommandHandler {
    private readonly ZOWE_CLI_PACKAGE_NAME;
    private readonly ZOWE_CLI_SECURE_PLUGIN_NAME;
    private keytar;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    /**
     * Retrieve info about old plug-ins and their overrides.
     *  - `plugins` - List of CLI plug-ins to uninstall
     *  - `overrides` - List of overrides to remove from app settings
     */
    private getOldPluginInfo;
    /**
     * Get the number of old profiles present in the CLI home dir.
     * @param profilesRootDir Root profiles directory
     * @returns Number of old profiles found
     */
    private getOldProfileCount;
    /**
     * Remove obsolete Imperative overrides from app settings. This method is
     * called before uninstalling old plug-ins.
     *
     * This method is private because only the convert-profiles command is able
     * to disable the credential manager and reload it. For all other commands,
     * the credential manager is loaded in `Imperative.init` and frozen with
     * `Object.freeze` so cannot be modified later on.
     */
    private removeOverride;
    /**
     * Lazy load keytar, and verify that the credential vault is able to be accessed,
     * or whether there is a problem.
     * @returns true if credential vault is available, false if it is not
     */
    private checkKeytarAvailable;
    /**
     * Locate the names of secured properties stored under an account in the operating
     * system's credential vault.
     * @param acct The account to search for in the credential store
     * @param params The parameters and response console APIs
     * @returns a list of secured properties stored under the specified account
     */
    private findOldSecureProps;
    /**
     * Delete the secure property specified from the operating system credential vault.
     * @param acct The account the property is stored under
     * @param propName The name of the property to delete
     * @param params The parameters and response console APIs
     * @returns true if the property was deleted successfully
     */
    private deleteOldSecureProps;
}
