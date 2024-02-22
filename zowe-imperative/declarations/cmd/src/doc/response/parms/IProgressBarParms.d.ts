/// <reference types="node" />
import { ITaskWithStatus } from "../../../../../operations";
import WriteStream = NodeJS.WriteStream;
export interface IProgressBarParms {
    task: ITaskWithStatus;
    updateInterval?: number;
    stream?: WriteStream;
}
