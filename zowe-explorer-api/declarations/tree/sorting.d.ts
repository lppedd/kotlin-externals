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
export declare enum DatasetSortOpts {
    Name = 0,
    DateCreated = 1,
    LastModified = 2,
    UserId = 3
}
export declare enum SortDirection {
    Ascending = 0,
    Descending = 1
}
export declare enum DatasetFilterOpts {
    LastModified = 0,
    UserId = 1
}
export declare type DatasetFilter = {
    method: DatasetFilterOpts;
    value: string;
};
export declare type NodeSort = {
    method: DatasetSortOpts | JobSortOpts;
    direction: SortDirection;
};
export declare enum JobSortOpts {
    Id = 0,
    DateSubmitted = 1,
    DateCompleted = 2,
    Name = 3,
    ReturnCode = 4
}
