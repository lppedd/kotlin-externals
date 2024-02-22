import { IOptions } from "../../../doc/IOptions";
/**
 * This interface defines the options that can be sent to get a data set or USS file function
 * @export
 * @interface IGetOptions
 */
export interface IGetOptions extends IOptions {
    /**
     * Range of records to return
     * @type {string}
     * @memberof IGetOptions
     */
    range?: string;
}
