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
import { CodeUtil, ReleaseQuality } from '../util/codeUtil';
import { logging } from 'selenium-webdriver';
/**
 * Mocha runner wrapper
 */
export declare class VSRunner {
    private mocha;
    private chromeBin;
    private customSettings;
    private codeVersion;
    private cleanup;
    private tmpLink;
    private releaseType;
    constructor(bin: string, codeVersion: string, customSettings: object | undefined, cleanup: boolean | undefined, releaseType: ReleaseQuality, config?: string);
    /**
     * Set up mocha suite, add vscode instance handling, run tests
     * @param testFilesPattern glob pattern of test files to run
     * @param logLevel The logging level for the Webdriver
     * @return The exit code of the mocha process
     */
    runTests(testFilesPattern: string[], code: CodeUtil, logLevel: logging.Level | undefined, resources: string[]): Promise<number>;
    private createShortcut;
    private loadConfig;
}
