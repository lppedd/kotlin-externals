/// <reference types="node" />
/// <reference types="node" />
import { SpawnSyncOptions } from "child_process";
/**
 * A collection of utilities related to executing a sub-process.
 * @export
 * @class ExecUtils
 */
export declare class ExecUtils {
    /**
     * Spawn a process with arguments and throw an error if the process fails.
     * Parameters are same as `child_process.spawnSync` (see Node.js docs).
     * Use this method if you want the safe argument parsing of `spawnSync`
     * combined with the smart output handling of `execSync`.
     * @returns Contents of stdout as buffer or string
     */
    static spawnAndGetOutput(command: string, args?: string[], options?: SpawnSyncOptions): Buffer | string;
}
