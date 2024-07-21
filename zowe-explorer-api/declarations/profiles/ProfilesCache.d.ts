/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 *
 */
/// <reference types="node" />
import * as zowe from "@zowe/cli";
import { ZoweExplorerApi } from "./ZoweExplorerApi";
export declare const CONTEXT_PREFIX = "_";
export declare const DEFAULT_PORT = 443;
export interface IUrlValidator {
    valid: boolean;
    protocol: string;
    host: string;
    port: number;
}
export interface IProfileValidation {
    status: string;
    name: string;
}
export interface IValidationSetting {
    name: string;
    setting: boolean;
}
export declare enum ValidProfileEnum {
    UNVERIFIED = 1,
    VALID = 0,
    INVALID = -1
}
export declare enum EventTypes {
    CREATE = 0,
    UPDATE = 1,
    DELETE = 2
}
export declare function getZoweDir(): string;
export declare function getFullPath(anyPath: string): string;
export declare class ProfilesCache {
    protected log: zowe.imperative.Logger;
    protected cwd?: string;
    profilesForValidation: IProfileValidation[];
    profilesValidationSetting: IValidationSetting[];
    allProfiles: zowe.imperative.IProfileLoaded[];
    profileTypeConfigurations: zowe.imperative.ICommandProfileTypeConfiguration[];
    protected allTypes: string[];
    protected allExternalTypes: Set<string>;
    protected profilesByType: Map<string, zowe.imperative.IProfileLoaded[]>;
    protected defaultProfileByType: Map<string, zowe.imperative.IProfileLoaded>;
    protected profileManagerByType: Map<string, zowe.imperative.CliProfileManager>;
    constructor(log: zowe.imperative.Logger, cwd?: string);
    static requireKeyring(this: void): NodeModule;
    addToConfigArray(extendermetadata: zowe.imperative.ICommandProfileTypeConfiguration[]): void;
    getConfigArray(): zowe.imperative.ICommandProfileTypeConfiguration[];
    getProfileInfo(_envTheia?: boolean): Promise<zowe.imperative.ProfileInfo>;
    /**
     * Loads the named profile from allProfiles
     *
     * @param {string} name Name of Profile
     * @param {string} type Type of Profile, optional
     *
     * @returns {IProfileLoaded}
     */
    loadNamedProfile(name: string, type?: string): zowe.imperative.IProfileLoaded;
    /**
     * Updates profile in allProfiles array and if default updates defaultProfileByType
     *
     * @param {string} profileLoaded
     *
     * @returns {void}
     */
    updateProfilesArrays(profileLoaded: zowe.imperative.IProfileLoaded): void;
    /**
     * This returns default profile by type from defaultProfileByType
     *
     * @param {string} type Name of Profile, defaults to "zosmf" if nothing passed.
     *
     * @returns {IProfileLoaded}
     */
    getDefaultProfile(type?: string): zowe.imperative.IProfileLoaded;
    /**
     * Gets default Profile attributes from imperative
     *
     * @param {ProfileInfo} mProfileInfo
     * @param {string} profileType Type of Profile
     *
     * @returns {IProfAttrs}
     */
    getDefaultConfigProfile(mProfileInfo: zowe.imperative.ProfileInfo, profileType: string): zowe.imperative.IProfAttrs;
    /**
     * Gets array of profiles by type
     *
     * @param {string} type Type of Profile, defaults to "zosmf" if nothing passed.
     *
     * @returns {IProfileLoaded[]}
     */
    getProfiles(type?: string): zowe.imperative.IProfileLoaded[] | undefined;
    /**
     * Used for extenders to register with Zowe Explorer that do not need their
     * profile type in the existing MVS, USS, and JES
     *
     * @param {string} profileTypeName Type of Profile
     *
     * @returns {void}
     */
    registerCustomProfilesType(profileTypeName: string): void;
    refresh(apiRegister?: ZoweExplorerApi.IApiRegisterClient): Promise<void>;
    validateAndParseUrl(newUrl: string): IUrlValidator;
    /**
     * V1 Profile specific
     * gets schema from /.zowe/profiles/profileType directory
     * used by Zowe Explorer for creation & update of v1 profiles
     * TO DO: put in request for public readonly api for this on Imperative.
     * @param profileType
     * @returns
     */
    getSchema(profileType: string): Record<string, unknown>;
    /**
     * get array of profile types
     * @returns string[]
     */
    getAllTypes(): string[];
    /**
     * get array of Profile names by type
     * @param type  profile type
     * @returns string[]
     */
    getNamesForType(type: string): Promise<string[]>;
    /**
     * get array of IProfileLoaded by type
     * @param type profile type
     * @returns IProfileLoaded[]
     */
    fetchAllProfilesByType(type: string): Promise<zowe.imperative.IProfileLoaded[]>;
    /**
     * get array of IProfileLoaded for all profiles
     * @returns IProfileLoaded[]
     */
    fetchAllProfiles(): Promise<zowe.imperative.IProfileLoaded[]>;
    /**
     * Direct load and return of particular IProfileLoaded
     * @param type profile type
     * @param name profile name
     * @returns IProfileLoaded
     */
    directLoad(type: string, name: string): Promise<zowe.imperative.IProfileLoaded | undefined>;
    getProfileFromConfig(profileName: string, profileType?: string): Promise<zowe.imperative.IProfAttrs | undefined>;
    getLoadedProfConfig(profileName: string, profileType?: string): Promise<zowe.imperative.IProfileLoaded | undefined>;
    /**
     * V1 Profile specific
     * Used by Zowe Explorer to handle v1 profiles
     * @param type string, profile type
     * @returns zowe.imperative.CliProfileManager
     */
    getCliProfileManager(type: string): zowe.imperative.CliProfileManager | undefined;
    getBaseProfile(): zowe.imperative.IProfileLoaded | undefined;
    fetchBaseProfile(): Promise<zowe.imperative.IProfileLoaded | undefined>;
    /**
     * This returns true or false depending on if credentials are stored securely.
     *
     * @returns {boolean}
     */
    isCredentialsSecured(): Promise<boolean>;
    /**
     * This returns true or false depending on if SCS plugin is installed. Use isCredentialsSecured().
     * @deprecated
     * @returns {boolean}
     */
    isSecureCredentialPluginActive(): boolean;
    getProfileLoaded(profileName: string, profileType: string, profile: zowe.imperative.IProfile): zowe.imperative.IProfileLoaded;
    protected deleteProfileOnDisk(profileInfo: zowe.imperative.IProfileLoaded): Promise<void>;
    protected saveProfile(profileInfo: Record<string, unknown>, profileName: string, profileType: string): Promise<zowe.imperative.IProfile>;
    protected checkMergingConfigAllProfiles(): void;
    protected checkMergingConfigSingleProfile(profile: zowe.imperative.IProfileLoaded): zowe.imperative.IProfileLoaded;
    protected getMergedAttrs(mProfileInfo: zowe.imperative.ProfileInfo, profAttrs: zowe.imperative.IProfAttrs): zowe.imperative.IProfile;
    private getAllProfileTypes;
    private shouldRemoveTokenFromProfile;
    updateBaseProfileFileLogin(profile: zowe.imperative.IProfileLoaded, updProfile: zowe.imperative.IProfile, forceUpdate?: boolean): Promise<void>;
    updateBaseProfileFileLogout(profile: zowe.imperative.IProfileLoaded): Promise<void>;
}
