import { IProfileSchema } from "../../../profiles";
/**
 * This type corresponds to the `extenders.json` file stored in the CLI home directory.
 *
 * Here is an example structure of what `extenders.json` could look like on disk:
 * ```json
 * {
 *     "profileTypes": {
 *         "banana": {
 *             "from": ["@zowe/banana-for-zowe-cli", "Zowe Explorer Banana Extension"],
 *             "version": "v1.1.0",
 *             "latestFrom": "Zowe Explorer Banana Extension"
 *         }
 *     }
 * }
 * ```
 */
export declare type IExtendersJsonOpts = {
    profileTypes: Record<string, {
        from: string[];
        version?: string;
        latestFrom?: string;
    }>;
};
export declare type IAddProfTypeResult = {
    success: boolean;
    info: string;
};
export declare type IExtenderTypeInfo = {
    sourceApp: string;
    schema: IProfileSchema;
};
