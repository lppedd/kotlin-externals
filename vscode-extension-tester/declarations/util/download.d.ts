export declare class Download {
    static getText(uri: string): Promise<string>;
    static getFile(uri: string, destination: string, progress?: boolean): Promise<void>;
}
