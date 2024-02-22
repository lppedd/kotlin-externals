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
export declare type PollRequest = {
    msInterval: number;
    dispose?: boolean;
    reject?<T = never>(reason?: any): Promise<T>;
    resolve?: (uniqueId: string, data: any) => any;
    request: () => Promise<unknown>;
    [key: string]: any;
};
export declare class Poller {
    static pollRequests: {
        [key: string]: PollRequest;
    };
    private static poll;
    static addRequest(uniqueId: string, request: PollRequest): void;
    static removeRequest(uniqueId: string): void;
}
