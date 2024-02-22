import { ISettingsFile } from "./doc/ISettingsFile";
import { ISettingsFilePersistence } from "./persistance/ISettingsFilePersistence";
declare type SettingValue = false | string;
/**
 * This class represents settings for an Imperative CLI application that can be configured
 * by an end user by modifying a settings file. Settings are stored in {@link AppSettings#settings}
 * in a format specified by {@link ISettingsFile}.
 */
export declare class AppSettings {
    /**
     * Initialize
     * @param settingsFile The settings file to load from
     * @param defaults {@link ISettingsFile} Settings with default values
     */
    static initialize(settingsFile: string, defaults: ISettingsFile): AppSettings;
    /**
     * This is an internal reference to the static settings instance.
     */
    private static mInstance;
    /**
     * The settings loaded from the file specified in the constructor.
     */
    private readonly settings;
    private readonly persistence;
    /**
     *  Constructs a new settings object
     *
     * @param persistence
     * @param initial Initial settings object
     */
    constructor(persistence: ISettingsFilePersistence, initial: ISettingsFile);
    /**
     * Get the singleton instance of the app settings object that was initialized
     * within the {@link AppSettings.initialize} function.
     *
     * @returns A singleton AppSettings object
     *
     * @throws {@link SettingsNotInitialized} When the settings singleton has not been initialized.
     */
    static get instance(): AppSettings;
    /**
     * @returns true if the app settings have been initialized
     */
    static get initialized(): boolean;
    /**
     * Set a settings option and save it to the settings file.
     * @param namespace {@link ISettingsFile}
     * @param key Name of a setting option to set
     * @param value
     */
    set(namespace: keyof ISettingsFile, key: string, value: SettingValue): void;
    /**
     * Get a value of settings option
     * @param namespace {@link ISettingsFile}
     * @param key Name of a setting option to set
     */
    get(namespace: keyof ISettingsFile, key: string): SettingValue;
    /**
     * Get a member of ISettingsFile of specified namespace
     * @param namespace
     */
    getNamespace(namespace: keyof ISettingsFile): {
        [x: string]: string | false;
        CredentialManager: string | false;
    };
    /**
     * Get settings
     */
    getSettings(): ISettingsFile;
    /**
     * Writes settings to the file
     */
    private flush;
}
export {};
