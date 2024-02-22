import { IDataSet } from "../../../doc/IDataSet";
import { IZosFilesOptions } from "../../../doc/IZosFilesOptions";
/**
 * This interface defines the options that can be sent into the copy data set function.
 */
export interface ICopyDatasetOptions extends IZosFilesOptions {
    /**
     * The dataset to copy from.
     * @type {IDataSet}
     */
    "from-dataset": IDataSet;
    /**
     * Enq option
     * Allow values are: SHR, SHRW, EXCLU.
     * @type {string}
     */
    enq?: string;
    /**
     * Replace option
     * @type {boolean}
     */
    replace?: boolean;
}
