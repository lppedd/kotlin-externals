/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License", destination); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
