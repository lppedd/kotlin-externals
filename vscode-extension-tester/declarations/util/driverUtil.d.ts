/**
 * Handles version checks and download of ChromeDriver
 */
export declare class DriverUtil {
    private downloadFolder;
    /**
     * Create an instance of chrome driver handler
     * @param folder path to a folder to store all artifacts
     */
    constructor(folder?: string);
    /**
     * Find a matching ChromeDriver version for a given Chromium version and download it.
     * @param chromiumVersion version of Chromium to match the ChromeDriver against
     */
    downloadChromeDriverForChromiumVersion(chromiumVersion: string): Promise<string>;
    /**
     * Download a given version ChromeDriver
     * @param version version to download
     */
    downloadChromeDriver(version: string): Promise<string>;
    private getChromeDriverBinaryPath;
    static getChromeDriverPlatform(): string | undefined;
    private static getChromeDriverPlatformOLD;
    private getChromeDriverURL;
    checkDriverVersionOffline(version: string): Promise<string>;
    /**
     * Check local chrome driver version
     */
    private getLocalDriverVersion;
    /**
     * Find a matching version of ChromeDriver for a given Chromium version
     * @param chromiumVersion Chromium version to check against
     */
    private getChromeDriverVersion;
    private getMajorVersion;
    private readonly chromiumVersionMap;
}
