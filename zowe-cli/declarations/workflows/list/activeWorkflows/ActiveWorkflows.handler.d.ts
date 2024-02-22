import { IHandlerParameters } from "@zowe/imperative";
import { ZosmfBaseHandler } from "@zowe/zosmf-for-zowe-sdk";
/**
 * Common Handler for listing active workflow(s) instance(s) in z/OSMF.
 */
export default class ListActiveWorkflowsHandler extends ZosmfBaseHandler {
    /**
     * Command line arguments passed
     * @private
     * @type {*}
     * @memberof ListHandler
     */
    private arguments;
    /**
     * Handler process - invoked by the command processor to handle the "zos-workflows list"
     * @param params Command handler parameters
     * @returns {Promise<void>} - Fulfilled when the command completes successfully OR rejected with imperative error
     * @memberof ListHandler
     */
    processCmd(commandParameters: IHandlerParameters): Promise<void>;
}
