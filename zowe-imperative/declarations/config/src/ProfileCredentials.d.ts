/// <reference types="node" />
import { ICredentialManagerInit } from "../../security";
import { IProfOpts } from "./doc/IProfOpts";
import { ProfileInfo } from "./ProfileInfo";
export declare class ProfileCredentials {
    private mProfileInfo;
    private mSecured;
    private mCredMgrOverride?;
    constructor(mProfileInfo: ProfileInfo, opts?: IProfOpts | (() => NodeModule));
    /**
     * Given a custom method to require Keytar, return an object that defines
     * credential manager settings to replace the default credential manager.
     * If the credential manager is not overridden, the default implementation
     * is to `require("keytar")` from the caller app's node_modules folder.
     * @param requireKeytar Callback to require Keytar module for managing secure credentials
     * @returns Credential manager settings with Keytar module overridden
     */
    static defaultCredMgrWithKeytar(requireKeytar: () => NodeModule): ICredentialManagerInit;
    /**
     * Check if secure credentials will be encrypted or stored in plain text.
     * If using team config, this will always return true. If using classic
     * profiles, this will check whether a custom CredentialManager is defined
     * in the Imperative settings.json file.
     */
    get isSecured(): boolean;
    /**
     * Initialize credential manager to be used for secure credential storage.
     * This method throws if ProfileCredentials.isSecured is false. If the
     * CredentialManagerFactory is already initialized, it is reused since it
     * is not possible to reinitialize.
     */
    loadManager(): Promise<void>;
    /**
     * Check whether a teamConfig is secure or not
     * @returns False if not using teamConfig or there are no secure fields
     */
    private isTeamConfigSecure;
    /**
     * Check whether a custom CredentialManager is defined in the Imperative
     * settings.json file.
     */
    private isCredentialManagerInAppSettings;
}
