import { IConfigLogging } from "./doc/IConfigLogging";
export declare class LoggerConfigBuilder {
    static readonly DEFAULT_LANG = "en";
    static readonly DEFAULT_LOG_TYPE_CONSOLE = "console";
    static readonly DEFAULT_LOG_TYPE_PAT = "pattern";
    static readonly DEFAULT_LOG_LAYOUT = "[%d{yyyy/MM/dd} %d{hh:mm:ss.SSS}] [%p] %m";
    static readonly DEFAULT_COLOR_LAYOUT: string;
    static readonly DEFAULT_LOG_TYPE_FILE_SYNC = "fileSync";
    static readonly DEFAULT_BACKEND = "NONE";
    static readonly DEFAULT = "default";
    static readonly DEFAULT_LOG_DIR: string;
    static readonly DEFAULT_LOG_FILE_DIR: string;
    static readonly DEFAULT_LOG_FILE_EXT = ".log";
    static readonly DEFAULT_LOG_FILE_MAX_SIZE = 10000000;
    static readonly DEFAULT_LOG_FILE_BACKUPS = 5;
    /**
     * Build a fully qualified directory to a log file - defaults to the users home directory - Imperative
     * does NOT use this as the home is set by the CLI configuration document.
     * @param {string} name - name of the file to append to fully qualified directory
     */
    static buildFullLogFile(name: string): string;
    /**
     * Returns the constant values defined within the LoggerConfigBuilder for this config object
     * @return {IConfigLogging} - default object built
     */
    static getDefaultIConfigLogging(): IConfigLogging;
    /**
     * Returns the constant values defined within the LoggerConfigBuilder for this config object
     * @return {IConfigLogging} - default object built
     */
    static addConsoleAppender(config: IConfigLogging, key: string, categoryName?: string, logLevel?: string): IConfigLogging;
    /**
     * Returns the constant values defined within the LoggerConfigBuilder for this config object
     * @return {IConfigLogging} - default object built
     */
    static addFileAppender(config: IConfigLogging, key: string, categoryName?: string, filename?: string, logLevel?: string): IConfigLogging;
    /**
     * Returns the log file name that will be used
     * @return {string} - the default file name for the log file
     */
    static getDefaultFileName(name: string): string;
    /**
     * Returns the log level that will be used if not overridden
     * @returns {string} - the default log level
     */
    static getDefaultLogLevel(): string;
}
