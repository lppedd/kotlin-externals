import { ICopyDatasetOptions } from "./ICopyDatasetOptions";
/**
 * This interface defines the options that can be sent into the copy cross lpar data set function.
 */
export interface ICrossLparCopyDatasetOptions extends ICopyDatasetOptions {
    /**
     * Target volser
     * @type {string}
     */
    targetVolser?: string;
    /**
     * Target management class
     * @type {string}
     */
    targetManagementClass?: string;
    /**
     * Target storage class
     * @type {string}
     */
    targetStorageClass?: string;
    /**
     * Target data class
     * @type {string}
     */
    targetDataClass?: string;
    /**
     * Overwrite option
     * @type {boolean}
     */
    overwrite?: boolean;
    /**
     * Prompt callback that will be invoked before overwiting a data set.
     * @param targetDSN Name of data set that already exists
     * @returns True if target data set should be overwritten
     */
    promptFn?: (targetDSN: string) => Promise<boolean>;
}
