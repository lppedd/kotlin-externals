import { IOperationResult } from "./doc/IOperationResult";
import { TaskStage } from "./TaskStage";
import { ITaskWithStatus } from "./doc/ITaskWithStatus";
import { Logger } from "../../logger";
export declare type IOperationCompleted<T> = (output: T) => void;
export declare type IOperationUndoCompleted = () => void;
export declare type IOperationResultReady<T> = (output: T, operationResults: IOperationResult<any>) => void;
export declare abstract class Operation<T> implements ITaskWithStatus {
    static readonly NO_PARMS: any;
    static readonly NO_OUTPUT: any;
    static summarizeResults(operationResults: IOperationResult<any>): boolean;
    /**
     * Traverses the results chain and prints results and gives overall failure status
     */
    private static readonly outputSeparator;
    infoMessages: string[];
    errorMessages: string[];
    get statusMessage(): string;
    get percentComplete(): number;
    set percentComplete(newPercent: number);
    get totalOperations(): number;
    protected log: Logger;
    /**
     * The full list of operation results
     */
    protected mOperationResults: IOperationResult<any>;
    /**
     * the result from the operation
     */
    protected mOperationResult: IOperationResult<T>;
    /**
     * The status of the operation
     */
    private mStageName;
    /**
     * A string describing what is currently happening in the operation e.g. "Submitted job..."
     */
    private mStatusMessage;
    private mPercentComplete;
    /**
     * The operation has completed and results are ready, this callback is invoked to inform the
     * caller of executeOperation, that the operation is done.
     */
    private mOperationCompleteCallback;
    /**
     * The list of all files that have been created by the service function
     * @type {Array}
     */
    private mAllFilesCreated;
    /**
     * The list of files that will be cleaned during an undo operation.
     * @type {Array}
     */
    private mFilesForUndo;
    /**
     * Action constructor to build action object
     * @param {string} opName: the name of the operation
     * @param {boolean} criticalOperation the operation is critical - meaning if it fails the entire operation fails and
     * the undo methods should be called.
     */
    constructor(opName: string, criticalOperation?: boolean);
    /**
     * Execute the operation. Set the status of the operation to IN_PROGRESS and invoke the implemented operations
     * execute method.
     *
     * @param {any} inputParameters: The input parameters to this operation. This can be anything as defined by
     * the operation.
     * @param {IOperationResultReady} operationComplete: Operation has completed callback
     */
    executeOperation(inputParameters: T, operationComplete: IOperationResultReady<any>): void;
    /**
     *  Set the status message for the operation
     * @param message - the message,  including any templates you want replaced like %s or "{{myObject}}"
     * @param args - variable args as allowed by printf-like syntax or {myObject: this.myObject}
     * @returns {string} the final translated and formatted string (in case you want to log it etc.)
     */
    setStatusMessage(message: string, ...args: any[]): void;
    /**
     * The perform undo method sets that an attempt was made to perform the undo and invokes the
     * undo method of the implemented operation.
     *
     * Before invoking, any files that have been created and saved on the undo-able list will be cleaned.
     *
     * @param {IOperationUndoCompleted} undoCompletedCallback: the undo completed callback
     */
    performUndo(undoCompletedCallback: IOperationUndoCompleted): void;
    /**
     * Override this method when implementing and place any operation end messages that should be
     * logged here.
     */
    abstract logOperationResults(): void;
    /**
     * Accessor method for operation result
     * @returns {IOperationResult}: The operation result
     */
    get operationResult(): IOperationResult<T>;
    /**
     * Accessor method for operation status
     * @returns {TaskStage}: The operation status/ stage name e.g. FAILED
     */
    get stageName(): TaskStage;
    /**
     * Accessor method to obtain all the files created using the file creator service
     * @return {string[]}
     */
    get allFilesCreated(): string[];
    /**
     * Accessor method to obtain all the files created that are marked as delete on undo
     * @return {string[]}
     */
    get fileToUndo(): string[];
    /**
     * Get the operation name for display and other purposes
     * @return {string}
     */
    get operationName(): string;
    /**
     * Set method to indicate that the operation failed.
     */
    protected setOperationFailed(): void;
    /**
     * Set method to indicate that the operation is "undoable".
     *
     * This means that if an operation fails, we will 'rollback' through the completed operations
     * and undo any that have occurred.
     */
    protected setOperationUndoable(): void;
    /**
     * Append an additional message to the result message buffer
     * @param {string} message: The result message you wish to append.
     */
    set operationResultMessage(message: string);
    /**
     * Determine if the operation failed
     *
     * @return {boolean}: If the operation failed
     */
    get operationSucceeded(): boolean;
    /**
     * Set that the operation undo failed. This is for diagnostic purposes.
     */
    protected setOperationUndoFailed(): void;
    /**
     * If the operation decides that a different path is required. You can set the next operation to complete
     * and whether or not you should continue down the original path
     *
     * @param {Operation} operation: the operation you use to diverge to
     * @param {boolean} continuePathAfterDiverge: Indicates that you want to continue down the normal path after
     * the divergent path is complete.
     */
    protected setOperationDiverge(operation: Operation<any>, continuePathAfterDiverge: boolean): void;
    /**
     * Set the operation undo attempted (whether it succeed or failed is up to the undo method to set)
     */
    protected setOperationUndoAttempted(): void;
    /**
     * The execute method must be implemented by the class. This is where the operation performs its
     * work and sets the result and the course of action (failed, undo possible, etc).
     *
     * @param {any} inputParameters: The input parameters to the operation
     * @param {IOperationCompleted} operationCompletedCallback: Operation
     */
    protected abstract execute(inputParameters: T, operationCompletedCallback: IOperationCompleted<any>): void;
    /**
     * The undo method is called when an operation fails and the operation is set to "undoable"
     */
    protected abstract undo(undoCompleteCallback: IOperationUndoCompleted): void;
    /**
     * Override this method when implementing and place any operation start messages that should be
     * logged here.
     */
    protected abstract logOperationBeginMessages(): void;
    /**
     * Add the result to the end of the results list
     * @param {IOperationResult} result: the result from the last operation
     */
    protected addResult(result: IOperationResult<any>): void;
    /**
     * Use this method to create files and optionally push them onto the files created stack that will
     * be referenced when an undo is required.
     *
     * @param {string} filePath
     * @param {string} message: the error message to print.
     * @param {boolean} saveFileNameForUndo: Whether you want to keep track of the files created for undo
     * @param {boolean} isDir: if this is a file or directory
     */
    protected createFile(filePath: string, message: string, saveFileNameForUndo: boolean, isDir: boolean): void;
    /**
     * Method to print all the files created by the file creator service.
     */
    protected printFilesCreatedList(): void;
    /**
     * Add a file created by the operation to the list of all files created and optionally mark this file
     * as undoable, which will cause the undo operation to attempt to remove the file or directory.
     *
     * @param {boolean} fileUndoable: The file or directory should be automatically removed by the undo operation.
     * @param {string} file: The file or directory created.
     */
    protected addFileCreated(fileUndoable: boolean, file: string): void;
    /**
     * Method that is called after the implementing classes undo to delete all the files that have been
     * saved during the operation (on the mFilesForUndo list).
     */
    private deleteAllFilesMarkedForUndo;
    /**
     * This method logs a standard header for the operation
     */
    private logBeginMessage;
    /**
     * This method logs a standard header for the operation
     */
    private logEndMessage;
    /**
     * Operation complete callback method. The operation must invoke the callback to indicate that it
     * has finished. If it does not, the operation sequence will not continue.
     */
    private operationComplete;
    /**
     * The operation undo complete callback method, this must be called by the operations undo method
     * in order for the operation 'undos' to continue.
     */
    private undoComplete;
}
