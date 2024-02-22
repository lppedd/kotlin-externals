import { IZosFilesResponse } from "../../../doc/IZosFilesResponse";
/**
 * This interface defines the response type of {@link Delete.vsam}
 */
export interface IDeleteVsamResponse extends IZosFilesResponse {
    /**
     * Delete VSAM calls the invoke api, which returns an {@link IZosFilesResponse}
     * object. So the api response will be set to that return object.
     */
    apiResponse: IZosFilesResponse;
}
