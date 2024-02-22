import { IImperativeConfig } from "@zowe/imperative";
/**
 * Get the Imperative config object which defines properties of the CLI.
 * This allows it to be accessed without calling Imperative.init.
 */
export declare function getImperativeConfig(): IImperativeConfig;
