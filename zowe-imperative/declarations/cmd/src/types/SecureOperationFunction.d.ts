/**
 * This type defines the signature for a function taht calls the credential manager. This is used by the TypeScript
 * compiler to verify that any function that wants to call the credential manager have the necessary
 * arguments sent to it.
 */
export declare type SecureOperationFunction = 
/**
 * @param {string} propNamePath - The path to a child property
 * @param {*} propValue - The value of said property
 * @param {boolean} optional - Set to true if failure to find credentials should be ignored
 * @return {Promise<any>} - The processed value after the secure operation function runs
 */
(propNamePath: string, propValue?: any, optional?: boolean) => Promise<any>;
