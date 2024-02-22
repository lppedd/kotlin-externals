import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines a few optional options that can be sent on a VSAM
 * delete operation.
 */
export interface IDeleteVsamOptions extends IZosFilesOptions {
    /**
     * Specifies the data component of a cluster is to be
     * overwritten with binary zeros when the cluster is deleted.
     */
    erase?: boolean;
    /**
     * Specifies the entry is to be deleted even if the retention period,
     * specified in the TO or FOR operand, has not expired.
     */
    purge?: boolean;
}
