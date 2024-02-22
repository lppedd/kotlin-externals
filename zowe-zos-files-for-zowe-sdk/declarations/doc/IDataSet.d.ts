/**
 * Interface for data sets
 *
 * @export
 */
export interface IDataSet {
    /**
     * The name of the data set
     * @type {string}
     */
    dsn: string;
    /**
     * The name of the member
     * @type {string}
     */
    member?: string;
}
