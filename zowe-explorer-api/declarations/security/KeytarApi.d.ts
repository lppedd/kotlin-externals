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
export declare class KeytarApi {
    protected log: imperative.Logger;
    constructor(log: imperative.Logger);
    activateKeytar(initialized: boolean, _isTheia: boolean): Promise<void>;
}
