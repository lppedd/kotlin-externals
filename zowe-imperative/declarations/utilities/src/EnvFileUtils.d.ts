/**
 * Utility to load environment JSON files and set variables
 * @export
 * @class EnvFileUtils
 */
export declare class EnvFileUtils {
    /**
     * This variable holds a cached version of the EnvFileJson.
     */
    private static environmentJSON;
    /**
     * Check and read in an environment file from the user home directory using the app name
     * If the file is valid, set the environment variables
     * If the file is not valid, display an error and continue
     * @param {string} appName - The application name
     * @param {boolean} checkCliHomeVariableFirst - Check inside of *_CLI_HOME first if it is defined
     * @param {string} envPrefix - The environment variable prefix
     * @returns {void}
     * @throws {ImperativeError}
     */
    static setEnvironmentForApp(appName: string, checkCliHomeVariableFirst?: boolean, envPrefix?: string): void;
    /**
     * Reapply environment variables that were applied before
     * @returns {void}
     * @throws {ImperativeError}
     */
    static resetEnvironmentForApp(): void;
    /**
     * Get the expected path for the user's environment variable file
     * @param {string} appName - The application name
     * @param {boolean} checkCliHomeVariableFirst - Check inside of *_CLI_HOME first if it is defined
     * @param {string} envPrefix - environment variable prefix
     * @returns {string} - Returns the path string if it exists, or null if it does not
     */
    static getEnvironmentFilePath(appName: string, checkCliHomeVariableFirst?: boolean, envPrefix?: string): string;
    /**
     * Get the expected path for the user's environment variable file
     * @param {string} appName - The application name
     * @returns {string} - Returns the path string if it exists, or null if it does not
     */
    static getUserHomeEnvironmentFilePath(appName: string): string;
    /**
     * Get the expected path for the user's environment variable file
     * @param {string} appName - The application name
     * @param {string} envPrefix - The environment variable prefix
     * @returns {string} - Returns the path string if it exists, or null if it does not
     */
    static getCliHomeEnvironmentFilePath(appName: string, envPrefix?: string): string;
}
