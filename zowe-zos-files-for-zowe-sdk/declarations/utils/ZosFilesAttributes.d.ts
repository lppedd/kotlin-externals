export declare enum TransferMode {
    BINARY = 0,
    TEXT = 1
}
/**
 * Attributes for a set of files relating to how they will be uploaded to USS
 */
export declare class ZosFilesAttributes {
    private static MAX_EXPECTED_FIELDS;
    private static MIN_EXPECTED_FIELDS;
    private attributes;
    private basePath;
    constructor(attributesFileContents: string, basePath?: string);
    static loadFromFile(filePath?: string, defaultDir?: string): ZosFilesAttributes | undefined;
    fileShouldBeUploaded(path: string): boolean;
    fileShouldBeIgnored(path: string): boolean;
    getFileTransferMode(path: string, preferBinary?: boolean): TransferMode;
    getRemoteEncoding(path: string): string;
    getLocalEncoding(path: string): string;
    private parse;
    private findLastMatchingAttributes;
}
