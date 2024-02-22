import { IHandlerProgressApi } from "../../../../../cmd";
import { ItemId } from "./EnvItems";
/**
 * This interface represents the result from getEnvItemVal().
 */
export interface IGetItemVal {
    itemVal: string;
    itemValMsg: string;
    itemProbMsg: string;
}
/**
 * This interface represents the the options for getEnvItemVal().
 */
export interface IGetItemOpts {
    /**
     * API to start/end progress bar for long running actions. Since this is a CLI thing,
     * it is optional in case non-CLI programs want to call the getEnvItemVal function.
     */
    progressApi?: IHandlerProgressApi;
}
/**
 * This class encapulates operations for Zowe CLI environment information.
 * We use the term environment loosely. Sometimes it is an environment variable.
 * It can also be something in the runtime environment, like version of NodeJS.
 */
export declare class EnvQuery {
    private static readonly divider;
    private static readonly indent;
    private static readonly eolMatch;
    private static readonly allEolRegex;
    private static readonly lastEolRegex;
    /**
     * For the specified itemId, get its value.
     *
     * @param itemId ID of the environmental item for which we want get the value.
     * @param getItemOpts options that affect our behavior.
     *
     * @returns An object with the item value, a display message, and a problem message.
     */
    static getEnvItemVal(itemId: ItemId, getItemOpts?: IGetItemOpts): Promise<IGetItemVal>;
    /**
     * Detect if a specified problem test finds a problem for the specified value.
     *
     * @param itemVal The value of the environmental item.
     * @param probTest A problem test to be evaluated.
     *
     * @returns True if we find a problem. False otherwise.
     */
    private static detectProbVal;
    /**
     * Run a command that displays output.
     *
     * @param cmdToRun The command name to be run.
     * @param args The arguments to the command.
     *
     * @return The output of the command.
     */
    private static getCmdOutput;
    /**
     * Get information about the Zowe configuration.
     *
     * @param getResult The itemVal and itemValMsg properties are filled
     *                  by this function.
     * @param getItemOpts options that affect our behavior.
     */
    private static getConfigInfo;
    /**
     * For the specified itemId, get any known problems.
     *
     * @param itemId ID of the environmental item for which we want to detect problems.
     * @param itemVal The value of the environmental item.
     * @returns A string with a message about the problems. An empty string if no problems are detected.
     */
    private static getEnvItemProblems;
    /**
     * Get information about the NPM configuration.
     *
     * @param getResult The itemVal and itemValMsg properties are filled
     *                  by this function.
     * @param getItemOpts options that affect our behavior.
     */
    private static getNpmInfo;
    /**
     * Get other Zowe variables, beyond the ones we check for problem values.
     *
     * @param getResult The itemValMsg property is filled by this function.
     *                  The itemVal property is given no value by this function.
     */
    private static getOtherZoweEnvVars;
    /**
     * Get information about Zowe plugins.
     * Logic stolen from plugins list command handler.
     *
     * @param getResult The itemVal and itemValMsg properties are filled
     *                  by this function.
     */
    private static getPluginInfo;
    /**
     * Get the Zowe version number.
     *
     * @param getResult The itemVal and itemValMsg properties are filled
     *                  by this function.
     */
    private static getZoweVer;
    /**
     * If a progress bar is in use, pause long enough to let it update its status.
     *
     * @param doesProgBarExist
     *        Is the progress bar availbale for use?
     * @param firstUpdate
     *        Is this our first progress bar update?
     *        Initialization of the progress bar takes extra time.
     */
    private static updateProgressBar;
}
