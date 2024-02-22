import { IChainedHandlerArgumentMapping } from "./IChainedHandlerArgumentMapping";
/**
 * A single link in a chain of chained handlers.
 * Specifies which handler to call and how to direct the output of that handler
 * into future handlers of the chain.
 */
export interface IChainedHandlerEntry {
    /**
     * String path to a module containing a command handler.
     * exports.default (export default class in Typescript) should be the command handler
     * @type {string}
     * @memberof IChainedHandlerEntry
     */
    handler: string;
    /**
     * When your handler is invoked, you can call response.data.setObj(<an object>)
     * If you do, you can map properties of that object to arguments for the next handler,
     * or a handler further down the chain. See the below interface for more details.
     * @type {IChainedHandlerArgumentMapping[]}
     * @memberof IChainedHandlerEntry
     */
    mapping?: IChainedHandlerArgumentMapping[];
    /**
     * If you set this to true, this handler will produce no output.
     * Note: if you specify "true" for the last handler in a chain, the command will not produce the final output.
     * @type {boolean}
     * @memberof IChainedHandlerEntry
     */
    silent?: boolean;
}
