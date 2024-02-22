import { IQueuedMessage } from "./doc/IQueuedMessage";
/**
 * LoggerManager is a singleton class used to contain logger information.
 */
export declare class LoggerManager {
    private static readonly DEFAULT_MAX_QUEUE_SIZE;
    private static mInstance;
    static get instance(): LoggerManager;
    private mIsLoggerInit;
    private mLogInMemory;
    private mMaxQueueSize;
    private console;
    private mQueuedMessages;
    constructor();
    /**
     * The following flag is used to monitor if the Logger.initLogger function
     * have been called to set the configuration of log4js.
     */
    get isLoggerInit(): boolean;
    set isLoggerInit(status: boolean);
    /**
     * The following flag is used to control if the log message should be store
     * in memory while log4js have yet to be configured.
     */
    get logInMemory(): boolean;
    set logInMemory(status: boolean);
    /**
     * The following value is used to control the max number of messages allowed
     * to be stored in memory at all time.
     */
    get maxQueueSize(): number;
    set maxQueueSize(size: number);
    /**
     * This function returned an array that contain all of the messages.
     */
    get QueuedMessages(): IQueuedMessage[];
    /**
     * This function is responsible for gathering all of the input parameters and
     * store them in the message queue array.
     *
     * New messages are to be stored at the top of the array instead of the bottom.
     * This allow easy removing message from array while looping the array.
     * @param category - logger category
     * @param method - log method
     * @param message - log message
     */
    queueMessage(category: string, method: string, message: string): void;
    /**
     * Dump all of the log messages in memory to the specified file
     * @param file log file
     */
    dumpQueuedMessages(file: string): void;
}
