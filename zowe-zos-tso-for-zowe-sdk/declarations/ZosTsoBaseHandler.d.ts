import { ZosmfBaseHandler } from "@zowe/zosmf-for-zowe-sdk";
import { IHandlerParameters } from "@zowe/imperative";
import { IStartTsoParms } from "./doc/input/IStartTsoParms";
export declare abstract class ZosTsoBaseHandler extends ZosmfBaseHandler {
    /**
     * The parameter object required to issue start commands
     * @type {IStartTsoParms}
     */
    protected mTsoStart: IStartTsoParms;
    /**
     * This will grab the arguments and create the tso parameter object for APIs before
     * invoking the actual TSO handler.
     * {@link ZosmfBaseHandler#processWithSession} method.
     *
     * @param {IHandlerParameters} params Command parameters sent by imperative.
     *
     * @returns {Promise<void>}
     */
    process(params: IHandlerParameters): Promise<void>;
}
