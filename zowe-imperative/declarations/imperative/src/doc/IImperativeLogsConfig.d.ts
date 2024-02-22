import { IImperativeLoggingConfig } from "../../../index";
export interface IImperativeLogsConfig {
    /**
     * Use this property to configure imperative logging preferences.  Defaults are provided and this
     * property must only be supplied to override defaults.  See the IImperativeLoggingConfig document for more
     * information.
     */
    imperativeLogging?: IImperativeLoggingConfig;
    /**
     * Use this property to configure your applications logging preferences.  Defaults are provided and this
     * property must only be supplied to override defaults.  See the IImperativeLoggingConfig document for more
     * information.
     */
    appLogging?: IImperativeLoggingConfig;
    /**
     * Use this property to configure additional log files and preferences if needed.
     */
    additionalLogging?: IImperativeLoggingConfig[];
    [key: string]: any;
}
