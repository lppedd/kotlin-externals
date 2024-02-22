/**
 * Generic logging-use class for writing info to the console if we have log4js
 * failures or are unable to initialize otherwise.
 *
 * This class supports most of the methods / accessors log4js uses.
 */
import { IConsole } from "./doc/IConsole";
export declare class Console implements IConsole {
    private mLevel;
    static readonly LEVELS: string[];
    static readonly LEVEL_DEFAULT = "warn";
    static getConsole(category: string): Console;
    static isValidLevel(level: string): boolean;
    static validateLevel(level: string): void;
    private mPrefix;
    private mColor;
    private mIsOn;
    constructor(mLevel?: string);
    addContext(key: string, value: any): void;
    removeContext(key: string): void;
    clearContext(): void;
    isLevelEnabled(): boolean;
    isTraceEnabled(): boolean;
    isDebugEnabled(): boolean;
    isInfoEnabled(): boolean;
    isWarnEnabled(): boolean;
    isErrorEnabled(): boolean;
    isFatalEnabled(): boolean;
    isFormatEnabled(): boolean;
    info(message: any, ...args: any[]): string;
    trace(message: any, ...args: any[]): string;
    debug(message: any, ...args: any[]): string;
    warn(message: any, ...args: any[]): string;
    error(message: any, ...args: any[]): string;
    fatal(message: any, ...args: any[]): string;
    private writeStderr;
    private writeStdout;
    private format;
    private buildPrefix;
    set level(level: string);
    get level(): string;
    set prefix(isEnabled: boolean);
    get prefix(): boolean;
    set color(isEnabled: boolean);
    get color(): boolean;
    set on(isOn: boolean);
    get on(): boolean;
}
