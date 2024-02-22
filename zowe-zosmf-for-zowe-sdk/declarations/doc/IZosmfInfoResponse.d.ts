import { IZosmfPluginInfo } from "./IZosmfPluginInfo";
/**
 * The Z/OSMF info API response.
 * @export
 * @interface IZosmfInfoResponse
 */
export interface IZosmfInfoResponse {
    zos_version?: string;
    zosmf_port?: string;
    zosmf_version?: string;
    zosmf_hostname?: string;
    zosmf_saf_realm?: string;
    zosmf_full_version?: string;
    api_version?: string;
    plugins?: [IZosmfPluginInfo];
}
