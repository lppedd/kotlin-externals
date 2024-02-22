import { Operation } from "../Operation";
export interface IOperationResult<T> {
    "operationName": string;
    "resultMessage": string;
    "operationFailed": boolean;
    "diverge": boolean;
    "divergeTo": Operation<any>;
    "continuePath": boolean;
    "nextOperationResult": IOperationResult<any>;
    "operationObject": Operation<any>;
    "operationUndoPossible": boolean;
    "operationUndoFailed": boolean;
    "operationUndoAttempted": boolean;
    "critical": boolean;
    "infoMessages": string[];
    "errorMessages": string[];
    "output": T;
}
