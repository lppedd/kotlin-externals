/// <reference types="node" />
/// <reference types="node" />
import { SpawnSyncOptions } from "child_process";
import { ISystemInfo } from "./doc/ISystemInfo";
/**
 * This enum represents the possible results from isGuiAvailable.
 */
export declare enum GuiResult {
    /** A GUI is available */
    GUI_AVAILABLE = 0,
    /** No GUI because this is an SSH connection. */
    NO_GUI_SSH = 1,
    /** No GUI because The $DISPLAY environment variable is not set. */
    NO_GUI_NO_DISPLAY = 2
}
/**
 * A collection of utilities related to the running process.
 * @export
 * @class ProcessUtils
 */
export declare class ProcessUtils {
    /**
     * Process utility to wrap callback process routines into promises
     * Turn nextTick into a promise to prevent nesting
     * @static
     * @param {() => void} callback - called before promise is resolved
     * @param {...any[]} args - arguments passed to the callback
     * @returns {Promise<void>} - fulfilled whenever callback is invoked
     * @memberof ProcessUtils
     */
    static nextTick(callback: (...args: any[]) => void, ...args: any[]): Promise<void>;
    /**
     * Is a Graphical User Interface available in the environment in which
     * the current command is running?
     *
     * @returns {boolean} - True if GUI. False when no GUI.
     */
    static isGuiAvailable(): GuiResult;
    /**
     * Get some basic information about the system
     */
    static getBasicSystemInfo(): ISystemInfo;
    /**
     * Open a file or URL in the default application associated with its file
     * extension or URL protocol. This method is only supported in graphical
     * environments.
     * @param pathOrUrl File path or Internet URL to open
     */
    static openInDefaultApp(pathOrUrl: string): void;
    /**
     * Open a file in the best editor that can be found in the current
     * environment. In a graphical environment, the default application
     * associated with its file extension will be launched. In a command-line
     * environment, the file will be opened in vi, or the editor in the
     * the `{envVariablePrefix}_EDITOR` environment variable if specified.
     * @param filePath - File path to edit
     * @param editorOpt - Chosen editor, can be a path or a valid environment variable name
     * @param sync - Boolean where true == synchronous and false == asynchronous
     */
    static openInEditor(filePath: string, editorOpt?: string, sync?: boolean): void;
    /**
     * Spawn a process with arguments and throw an error if the process fails.
     * Parameters are same as `child_process.spawnSync` (see Node.js docs).
     * Use this method if you want the safe argument parsing of `spawnSync`
     * combined with the smart output handling of `execSync`.
     * @deprecated Use ExecUtils.spawnAndGetOutput instead.
     * @returns Contents of stdout as buffer or string
     */
    static execAndCheckOutput(command: string, args?: string[], options?: SpawnSyncOptions): Buffer | string;
}
