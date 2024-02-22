import { IDefinedSystem } from "./IDefinedSystem";
/**
 * API response for list systems defined to z/OSMF.
 * @export
 * @interface IZosmfInfoResponse
 */
export interface IZosmfListDefinedSystemsResponse {
    /**
     * Total items returned.
     */
    numRows: number;
    /**
     * Properties of each defined system.
     */
    items: IDefinedSystem[];
}
