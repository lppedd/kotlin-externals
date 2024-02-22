import { IZosmfTsoResponse } from "../doc/zosmf/IZosmfTsoResponse";
export interface ICollectedResponses {
    /**
     * z/OSMF synchronous most tso command response messages.
     * @type {IZosmfTsoResponse[]}
     * @memberof ICollectedResponses
     */
    tsos: IZosmfTsoResponse[];
    /**
     * Appended collected messages including READY prompt at the end.
     * @type {string}
     * @memberof ICollectedResponses
     */
    messages: string;
}
