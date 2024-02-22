import { ImperativeError } from "../../error/src/ImperativeError";
import { IConfigLogging } from "./doc/IConfigLogging";
import * as log4js from "log4js";
import { Console } from "../../console/src/Console";
/**
 * Note(Kelosky): it seems from the log4js doc that you only get a single
 * instance of log4js per category.  To reconfigure, you should "shutdown" logger.
 */
export declare class Logger {
    private mJsLogger;
    private category?;
    static readonly DEFAULT_IMPERATIVE_NAME = "imperative";
    static readonly DEFAULT_APP_NAME = "app";
    static readonly DEFAULT_CONSOLE_NAME = "console";
    static readonly DEFAULT_VALID_LOG_LEVELS: string[];
    /**
     * Get accessibility to logging service to invoke log calls, e.g
     * Logger.getLogger.info("important log info goes here");
     * @param {string} category - category of logger to obtain
     * @return {Logger} - instance of logger set to our app's category
     */
    static getLoggerCategory(category: string): Logger;
    /**
     * Get accessibility to logging service to invoke log calls, e.g
     * Logger.getLogger.info("important log info goes here");
     * @return {Logger} - instance of logger set to our app's category
     */
    static getImperativeLogger(): Logger;
    /**
     * Get log4js instance directed at our app's category.
     * @return {Logger} - instance of logger set to our app's category
     */
    static getAppLogger(): Logger;
    static setLogInMemory(status: boolean, maxQueueSize?: number): void;
    /**
     * Write all messages that was stored in memory to the input file.
     * @param {string} file - destination file name
     */
    static writeInMemoryMessages(file: string): void;
    /**
     * Test if the input level is a valid value for Log4js.
     * @param {string} testLevel - input level to be tested
     * @returns {boolean} - status if the input level is valid
     */
    static isValidLevel(testLevel: string): boolean;
    /**
     * Return an instance to the console logger which applies TextUtils invoked
     * through this Logger class.
     *
     * Note(Kelosky): this is not the same as obtaining a new Console() directly,
     * since we can make use of the internationalization and other routines
     * within this Logger class via this implementation.
     *
     * @return {Logger} - instance of logger set to our app's category
     */
    static getConsoleLogger(): Logger;
    /**
     * Get an instance of logging and adjust for config if config is present;
     * otherwise, use defaults.
     * @param  {IConfigLogging} loggingConfig [description]
     * @return {[type]}                       [description]
     */
    static initLogger(loggingConfig: IConfigLogging): Logger;
    /**
     * This flag is being used to monitor the log4js configure status.
     */
    private initStatus;
    constructor(mJsLogger: log4js.Logger | Console, category?: string);
    /**
     * Log a message at the "trace" level
     *  Example: 'Entering cheese testing'
     * @param message - printf style template string, or a plain string message
     * @param args - printf style args
     * @returns {any}
     */
    trace(message: string, ...args: any[]): string;
    /**
     * Log a message at the "debug" level
     *  Example: 'Got cheese'
     * @param message - printf  or mustache style template string, or a plain string message
     * @param args - printf or mustache style args
     * @returns {any}
     */
    debug(message: string, ...args: any[]): string;
    /**
     * Log a message at the "info" level
     *  Example: 'Cheese is Gouda'
     * @param message - printf or mustache style template string, or a plain string message
     * @param args - printf or mustache style args
     * @returns {any}
     */
    info(message: string, ...args: any[]): string;
    /**
     * Log a message at the "warn" level
     *  Example: 'Cheese is quite smelly.'
     * @param message - printf or mustache style template string, or a plain string message
     * @param args - printf  or mustache style args
     * @returns {any}
     */
    warn(message: string, ...args: any[]): string;
    /**
     * Log a message at the "error" level
     *  Example: 'Cheese is too ripe!'
     * @param message - printf or mustache style template string, or a plain string message
     * @param args - printf or mustache style args
     * @returns {any}
     */
    error(message: string, ...args: any[]): string;
    /**
     * Log a message at the "fatal" level
     *  Example: 'Cheese was breeding ground for listeria.'
     * @param message - printf or mustache style template string, or a plain string message
     * @param args - printf  or mustache style args
     * @returns {any}
     */
    fatal(message: string, ...args: any[]): string;
    /**
     * Log a message without CallerFileAndLineTag
     *  Example: 'Cheese that is plain'
     * @param message - printf or mustache style template string, or a plain string message
     * @param args - printf or mustache style args
     * @returns {any}
     */
    simple(message: string, ...args: any[]): string;
    /**
     * Log an Imperative error, including any optional fields if present
     * @param {ImperativeError} err - the error to log
     */
    logError(err: ImperativeError): void;
    /**
     * translate a message if possible
     * @param message - original message to translate, possibly with printf or {{obj}} style template
     * @param args  - varargs to use to translate / format
     * @returns {string} translated or replaced result
     */
    /**
     * Obtain .js file name and line number which issued the log message.
     * NOTE(Kelosky): Consensus seems to be that this may produce a lot of overhead
     * by creating an Error and obtaining stack information for EVERY log message
     * that is issued.
     *
     * There are also packages available to obtain the appropriate line number.
     *
     * Perhaps when a package pops up that gives the appropriate .ts line number
     * and file name, we'll remove usage of this method.
     * @returns {string} - file and line number
     */
    private getCallerFileAndLineTag;
    /**
     * Allow for programmatic adjustments to the logger
     * @param {string} level - new level to set
     */
    set level(level: string);
    /**
     * Get current level setting
     * @return {string} - level of current log setting
     */
    get level(): string;
    /**
     * Get underlying logger service
     *
     * This function also check to see if log4js is configured since the last time it
     * was called.  If yes, then update the logger with to leverage the new configuration.
     */
    private get logService();
    /**
     * Set underlying logger service
     */
    private set logService(value);
}
