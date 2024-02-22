import { ICredentialManagerNameMap } from "./doc/ICredentialManagerNameMap";
/**
 * This class provides access to the known set of credential manager overrides
 * and functions to manipulate which credential manager is in use.
 * Other credential managers can replace the default credential manager.
 * Both CLI plugins and Zowe Explorer extensions can override the default
 * credential manager. However, only one credential manager will be in effect
 * on a given computer. The last component to override the credential
 * manager wins.
 */
export declare class CredentialManagerOverride {
    static readonly CRED_MGR_SETTING_NAME: string;
    static readonly DEFAULT_CRED_MGR_NAME: string;
    private static readonly KNOWN_CRED_MGRS;
    /**
     * Get the credential manager information for the specified credential manager
     * display name.
     *
     * @param credMgrDisplayName - display name of the credential manager
     *
     * @returns An ICredentialManagerNameMap or
     *          null if the specified plugin is not a known credential manager.
     */
    static getCredMgrInfoByDisplayName(credMgrDisplayName: string): ICredentialManagerNameMap | null;
    /**
     * Get the credential manager information for the specified plugin.
     *
     * @param pluginName - Name of the plugin package
     *
     * @returns An ICredentialManagerNameMap or
     *          null if the specified plugin is not a known credential manager.
     */
    static getCredMgrInfoByPlugin(pluginName: string): ICredentialManagerNameMap | null;
    /**
     * Get the credential manager information for the specified plugin.
     *
     * @param ZEExtName - Name of the Zowe Explorer extension
     *
     * @returns An ICredentialManagerNameMap or
     *          null if the specified extension is not a known credential manager.
     */
    static getCredMgrInfoByZEExt(ZEExtName: string): ICredentialManagerNameMap | null;
    /**
     * Get the known credential managers.
     *
     * @returns An array of credential managers.
     */
    static getKnownCredMgrs(): ICredentialManagerNameMap[];
    /**
     * Record the specified credential manager in the configuration of overrides.
     * A plugin or ZE extension that provides a credential manager would record
     * its credential manager name upon installation.
     *
     * @param newCredMgrName
     *        The display name of your credential manager.
     *
     * @throws An ImperativeError upon error.
     */
    static recordCredMgrInConfig(newCredMgrName: string): void;
    /**
     * Record the default Zowe CLI credential manager in the configuration of
     * overrides. The specified credential manager will be replaced with the
     * default Zowe CLI credential manager. A plugin or ZE extension that provides
     * a credential manager would replace itself with the default credential
     * manager when it is being uninstalled.
     *
     * @param credMgrToReplace
     *        The display name of your credential manager. This name must also
     *        be the credential manager currently recorded in the configuration
     *        of overrides. Otherwise, no replacement will be performed.
     *        Specifying your own name is intended to prevent a plugin from
     *        inadvertently replacing another plugin's credential manager.
     *
     * @throws An ImperativeError upon error.
     */
    static recordDefaultCredMgrInConfig(credMgrToReplace: string): void;
    /**
     * Get the contents of the $ZOWE_CLI_HOME/settings/imperative.json file.
     * The resulting JSON is guaranteed to contain the key
     * 'overrides.CredentialManager'.
     *
     * @returns A 'settings' object with the properties: fileName and json.
     *          The json object contains the contents of the settings file.
     *
     * @throws An ImperativeError if the file does not exist or have the key.
     */
    private static getSettingsFileJson;
}
