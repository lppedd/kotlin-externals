import * as yargs from "yargs";
import { IChainedHandlerEntry } from "./doc/handler/IChainedHandlerEntry";
import { Logger } from "../../logger";
/**
 * Service for processing chained handlers and their
 * argument mappings.
 */
export declare class ChainedHandlerService {
    /**
     * Get the arguments for the current handler in the chain
     * @param binName - name of the binary/primary command for this CLI
     * @param {IChainedHandlerEntry[]} chainedHandlerConfigs - the configured chained handlers.
     * @param handlerIndex -  current index into the chained handlers e.g. 0 is the first chained handler
     * @param previousResponseObjects - command responses completed so far
     * @param  overallArguments - arguments specified by the use for the overall chained command
     * @param logger - a logger to use as we check and perform the argument mappings
     * @returns {yargs.Arguments[]} fully mapped arguments for this command
     */
    static getArguments(binName: string, chainedHandlerConfigs: IChainedHandlerEntry[], handlerIndex: number, previousResponseObjects: any[], overallArguments: yargs.Arguments, logger: Logger): yargs.Arguments;
}
