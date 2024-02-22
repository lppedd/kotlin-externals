import { IOperationResultReady, Operation } from "./Operation";
import { IOperationResult } from "./doc/IOperationResult";
/**
 * The Operations class extends Operation and is used to create a 'string' of operations that must
 * be completed in serial order.
 *
 * The implementing class is responsible (in defineOperations) for creating each operation (and
 * invoking addNextOperation) to add the operations to the list. You must also call "defineOperations"
 * from your constructor. This allows you to setup anything you need (in your constructor) before defining
 * the list of operations.
 *
 * You can initiate the operation by invoking performOperation, which will iterate through each operation
 * defined and perform them in sequence. If a operation chooses to diverge, then
 */
export declare abstract class Operations<T> extends Operation<any> {
    /**
     * The list of operations that should be executed in sequence
     */
    private mOperationList;
    /**
     * Optionally give a status message in your Operations object instead of
     * letting the message from your sub-operations come through.
     */
    private mOverallStatusMessage;
    /**
     * The current operation that is being executed.
     * @type {number}
     */
    private mCurrentOperation;
    /**
     * the callers operations complete callback
     */
    private mOperationsCompleteCallback;
    /**
     * In the event of an undo request, we will prepare a list that will be traversed to complete
     * each undo function.
     * @type {Array}
     */
    private mOperationUndoList;
    /**
     * The current operation undo index.
     * @type {number}
     */
    private mOperationUndoIndex;
    /**
     * The input parameters to this string of operations
     */
    private mInputParameters;
    /**
     * Building an Operations object
     * @param {string} opName: Operations Name
     * @param {boolean} critical: if the operation is critical
     */
    constructor(opName: string, critical?: boolean);
    /**
     * The public interface to Operations. This method allows consumers to initiate the operation sequence.
     * @returns {IOperationResult}: The operation results
     */
    executeOperation(inputParameters: T, operationComplete: IOperationResultReady<any>): void;
    /**
     *  Set the status message for the overall Operations object,
     *  which takes precedence over the sub-operations' messages
     * @param message - the message,  including any templates you want replaced like %s or "{{myObject}}"
     * @param args - variable args as allowed by printf-like syntax or {myObject: this.myObject}
     * @returns {string} the final translated and formatted string (in case you want to log it etc.)
     */
    setStatusMessage(message: string, ...args: any[]): string;
    get statusMessage(): string;
    /**
     * What percent complete is the Operations as a whole?s
     * @returns {number}  percentComplete weighted against how many operations are complete
     */
    get percentComplete(): number;
    /**
     * Log that the set of operations have completed.
     */
    logOperationResults(): void;
    /**
     * Count the total number of base operation objects
     * @returns {number}
     */
    get totalOperations(): number;
    /**
     * Add a new operation to the list of operations to be executed.
     *
     * @param {Operation} newOperation: Operation to be added to the list of sequential operations
     */
    protected addNextOperation(newOperation: Operation<any>): void;
    /**
     * This is a placeholder and is never directly called.
     */
    protected execute(): void;
    /**
     * Perform all undos if the undo function is called for an Operations
     */
    protected undo(): void;
    /**
     * Log that this is a set of operations that are about to begin.
     */
    protected logOperationBeginMessages(): void;
    /**
     * Callback invoked when the operation completes. Passed the result object of the operation.
     *
     * @param {IOperationResult} operationResult: The result of the operation
     * @param {any} output: The output from the operation
     */
    protected operationCompleted(output: any, operationResult: IOperationResult<any>): void;
    /**
     * Abstract method that must be implemented by the subclass. In this method, you invoke "addNextOperation"
     * to add all the operations that must be performed when "executeOperation" is invoked.
     */
    protected abstract defineOperations(): void;
    /**
     * If more operations are available, execute the next operation in the list
     * @param {any} input: The output from the previous operation
     */
    private executeNextOperation;
    /**
     * Prepare a list of operations to 'undo', we will traverse the list calling the undo function of
     * each operation. Only operations that are marked as 'undoa-able' will be called.
     *
     * TODO - we could probably fire off all undo functions here async, but for now they are serial
     */
    private prepareForUndo;
    /**
     * Execute the next undo in the list. If the undo index is 0 when this function is called, then we can
     * invoke the callers callback as all undos are complete.
     */
    private executeNextUndo;
    /**
     * Undo operation completed callback. Probably unnecessary.
     */
    private undoOpComplete;
}
