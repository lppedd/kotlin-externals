import { IImperativeConfig } from "../doc/IImperativeConfig";
import { IImperativeApi } from "./doc/IImperativeApi";
import { Logger } from "../../../logger";
import { CliProfileManager } from "../../../cmd";
export declare class ImperativeApi {
    private mApis;
    private mConfig;
    private mHome;
    /**
     * index signature for accessing Imperative api via dictionary [] notation.
     */
    [key: string]: any;
    /**
     * Input parameters to construct the API object
     */
    private mLog;
    private mCustomLoggerMap;
    constructor(mApis: IImperativeApi, mConfig: IImperativeConfig, mHome: string);
    /**
     * Returns the imperative logger API object
     * @returns {Logger}: The imperative logger api object.
     */
    get imperativeLogger(): Logger;
    /**
     * Returns an imperative app's logger API object
     * @returns {Logger}: The imperative app's logger api object.
     */
    get appLogger(): Logger;
    /**
     * Retrieve a named custom logger that has been configured
     * @param {string} name - the name of the custom logger
     * @returns {Logger} the configured logger, if it exists
     */
    additionalLogger(name: string): Logger;
    /**
     * Register a logger with the Imperative API
     * Mostly used internally in Imperative
     * @param {string} name - the name of the logger to register
     * @param {Logger} logger - the logger to store
     */
    addAdditionalLogger(name: string, logger: Logger): void;
    /**
     * Return an instance of a profile manager for a given profile type
     * See ProfileManager.ts for more details
     */
    profileManager(type: string): CliProfileManager;
}
