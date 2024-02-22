import { IConfigLogging } from "../../logger/src/doc/IConfigLogging";
import { IImperativeConfig } from "./doc/IImperativeConfig";
/**
 * Helper class to construct default config, log4js config, and define
 * log4js configuration document.
 * @export
 * @class LoggingConfigurer
 */
export declare class LoggingConfigurer {
    /**
     * Configure all log4js loggers based on imperative config
     * @static
     * @param {string} home - home directory
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @returns {IConfigLogging} - compiled logging config for Logger.init();
     * @memberof LoggingConfigurer
     */
    static configureLogger(home: string, imperativeConfig: IImperativeConfig): IConfigLogging;
    /**
     * Configures log4js imperative appender from imperative config
     * @private
     * @static
     * @param {string} home - home directory
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {IConfigLogging} loggingConfig - log4js config
     * @param {string} key - keys within log4js appenders (like the appenders "imperative" key or categories "imperative" key)
     * @memberof LoggingConfigurer
     */
    private static configureImperativeLogger;
    /**
     * Configures log4js app appender from imperative config
     * @private
     * @static
     * @param {string} home - home directory
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {IConfigLogging} loggingConfig - log4js config
     * @param {string} key - keys within log4js appenders (like the appenders "imperative" key or categories "imperative" key)
     * @memberof LoggingConfigurer
     */
    private static configureAppLogger;
    /**
     * Configures log4js console appender from imperative config
     * @private
     * @static
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {IConfigLogging} loggingConfig - log4js config
     * @param {string} key - keys within log4js appenders (like the appenders "imperative" key or categories "imperative" key)
     * @memberof LoggingConfigurer
     */
    /**
     * Configures log4js appenders from imperative config
     * @private
     * @static
     * @param {string} home - home directory
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {IConfigLogging} loggingConfig - log4js config
     * @param {string} entryKey - keys within log4js appenders (like the appenders "imperative" key or categories "imperative" key)
     * @param {string} configKey - keys within IImperativeLogsConfig (like imperativeLogging)
     * @memberof LoggingConfigurer
     */
    private static configureLoggerByKey;
    /**
     * Common method to configure log4js appenders via imperative config
     * @private
     * @static
     * @param {string} home - home directory
     * @param {IImperativeLoggingConfig} impLogConfig
     * @param {IConfigLogging} loggingConfig - imperative main config
     * @param {string} entryKey - imperative key
     * @param {string} configKey -log4js key
     * @returns {IImperativeConfig} - populated config
     * @memberof LoggingConfigurer
     */
    private static configureLoggerByKeyHelper;
    /**
     * Build minimum imperative config for default supplied loggers
     * @private
     * @static
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @returns {IImperativeConfig} - populated config
     * @memberof LoggingConfigurer
     */
    private static buildLoggingDefaults;
    /**
     * Build minimum imperative config for default imperative logger
     * @private
     * @static
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {string} name - log4js name
     * @returns {IImperativeConfig} - populated config
     * @memberof LoggingConfigurer
     */
    private static buildImperativeLoggingDefaults;
    /**
     * Build minimum app config for default app logger
     * @private
     * @static
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {string} name - log4js name
     * @returns {IImperativeConfig} - populated config
     * @memberof LoggingConfigurer
     */
    private static buildAppLoggingDefaults;
    /**
     * Build minimum console config for default console logger
     * @private
     * @static
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {string} name - imperative main config
     * @memberof LoggingConfigurer
     */
    /**
     * This method overrides any configuration of reserved loggers.
     * Build minimum console config for default console logger
     * @private
     * @static
     * @param {IImperativeConfig} imperativeConfig - imperative main config
     * @param {string} key - imperative main config
     * @param {string} apiName - imperative main config
     * @param {string} [category=apiName] - imperative main config
     * @returns {IImperativeConfig} - populated config
     * @memberof LoggingConfigurer
     */
    private static buildLoggingDefaultsByKey;
    /**
     * Normalize input file path for logs in the case that a user provides
     * redundant or missing file delimiters.
     * @private
     * @static
     * @param {string} file - normalized file
     * @returns {string} - normalized dir
     * @memberof LoggingConfigurer
     */
    private static normalizeDir;
}
