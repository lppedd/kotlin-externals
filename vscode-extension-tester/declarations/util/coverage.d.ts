/**
 * Manages collecting coverage data from test runs. All runs, regardless of
 * platform, expect coverage data given in the V8 coverage format. We then
 * use c8 to convert it to the common Istanbul format and represent it with
 * a variety of reporters.
 */
export declare class Coverage {
    readonly targetDir: string;
    private userOptions;
    constructor();
    loadConfig(): Promise<void>;
    write(): Promise<void>;
}
