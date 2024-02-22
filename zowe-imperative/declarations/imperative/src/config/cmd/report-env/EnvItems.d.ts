/**
 * This enum represents the runtime environment items of interest.
 * These are more than just environment variables.
 * We will report on these items (and report on any detected problems)
 * in the order that the items are listed below.
 */
export declare enum ItemId {
    ZOWE_VER = 0,
    NODEJS_VER = 1,
    NVM_VER = 2,
    PLATFORM = 3,
    ARCHITECTURE = 4,
    OS_PATH = 5,
    ZOWE_CLI_HOME = 6,
    ZOWE_APP_LOG_LEVEL = 7,
    ZOWE_IMPERATIVE_LOG_LEVEL = 8,
    OTHER_ZOWE_VARS = 9,
    NPM_VER = 10,
    ZOWE_CONFIG_TYPE = 11,
    ZOWE_PLUGINS = 12
}
/**
 * This is the structure for defining a test to identify if a problem exists
 * for a given runtime environment item, and the message to give when the
 * problem is detected.
 */
export interface IProbTest {
    itemId: ItemId;
    probExpr: string;
    probMsg: string;
}
/**
 * The tests to check for problems that we run for environmental items.
 * One ItemId can have multiple entries in the array, to check for
 * different problems. When the probExpr is true, we have a problem,
 * and we print the probMsg.
 */
export declare const probTests: IProbTest[];
