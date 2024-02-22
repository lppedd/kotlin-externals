/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 *
 */
import { imperative } from "@zowe/cli";
export declare enum MessageSeverity {
    TRACE = 0,
    DEBUG = 1,
    INFO = 2,
    WARN = 3,
    ERROR = 4,
    FATAL = 5
}
/**
 * @deprecated Please use `MessageSeverity` instead
 */
export declare type MessageSeverityEnum = MessageSeverity;
/**
 * Creates an instance of the Imperative logger for extenders to use
 *
 * @export
 * @class IZoweLogger
 */
export declare class IZoweLogger {
    private extensionName;
    private log;
    /**
     * Creates an instance of the Imperative logger
     */
    constructor(extensionName: string, loggingPath: string);
    getExtensionName(): string;
    getImperativeLogger(): imperative.Logger;
    /**
     * Log an error message to the Imperative logger.
     * Default severity is DEBUG if not specified.
     */
    logImperativeMessage(message: string, severity?: MessageSeverity): void;
}
