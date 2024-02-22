@file:JsModule("@zowe/imperative")

package zowe.imperative.operations

import zowe.imperative.logger.Logger
import zowe.imperative.operations.doc.IOperationResult
import zowe.imperative.operations.doc.ITaskWithStatus

open external class Operation<T> : ITaskWithStatus {
  /**
   * Action constructor to build action object
   *
   * @param opName the name of the operation
   * @param criticalOperation the operation is critical - meaning if it fails the entire
   *   operation fails and the undo methods should be called.
   */
  constructor(opName: String, criticalOperation: Boolean = definedExternally)

  var infoMessages: Array<String>
  var errorMessages: Array<String>

  override var statusMessage: String

  override var percentComplete: Int

  open val totalOperations: Int

  var log: Logger

  /**
   * The full list of operation results
   */
  var mOperationResults: IOperationResult<Any?>

  /**
   * The result from the operation
   */
  var mOperationResult: IOperationResult<T>

  /**
   * Execute the operation. Set the status of the operation to IN_PROGRESS and invoke the
   * implemented operations execute method.
   *
   * @param inputParameters The input parameters to this operation.
   *   This can be anything as defined by the operation.
   * @param operationComplete Operation has completed callback
   */
  fun executeOperation(
    inputParameters: T,
    operationComplete: IOperationResultReady<Any?>,
  )

  /**
   * Set the status message for the operation
   *
   * @param message the message, including any templates you want replaced like %s or "{{myObject}}"
   * @param args variable args as allowed by printf-like syntax or {myObject: this.myObject}
   * @return the final translated and formatted string (in case you want to log it etc.)
   */
  open fun setStatusMessage(
    message: String,
    vararg args: Any?,
  ): String

  /**
   * The perform undo method sets that an attempt was made to perform the undo and invokes the undo
   * method of the implemented operation.
   *
   * Before invoking, any files that have been created and saved on the undo-able list will be
   * cleaned.
   *
   * @param undoCompletedCallback the undo completed callback
   */
  fun performUndo(undoCompletedCallback: IOperationUndoCompleted)

  /**
   * Override this method when implementing and place any operation end messages that should be
   * logged here.
   */
  open fun logOperationResults()

  /**
   * Accessor method for operation result
   *
   * @return: The operation result
   */
  val operationResult: IOperationResult<T>

  /**
   * Accessor method for operation status
   *
   * @return The operation status/ stage name e.g. FAILED
   */
  override var stageName: TaskStage

  /**
   * Accessor method to obtain all the files created using the file creator service
   *
   * @return
   */
  val allFilesCreated: Array<String>

  /**
   * Accessor method to obtain all the files created that are marked as delete on undo
   *
   * @return
   */
  val fileToUndo: Array<String>

  /**
   * Get the operation name for display and other purposes
   *
   * @return
   */
  val operationName: String

  /** Set method to indicate that the operation failed. */
  fun setOperationFailed()

  /**
   * Set method to indicate that the operation is "undoable".
   *
   * This means that if an operation fails, we will 'rollback' through the completed operations and
   * undo any that have occurred.
   */
  fun setOperationUndoable()

  /**
   * Append an additional message to the result message buffer
   */
  var operationResultMessage: String

  /**
   * Determine if the operation failed
   *
   * @return If the operation failed
   */
  val operationSucceeded: Boolean

  /**
   * Set that the operation undo failed. This is for diagnostic purposes.
   */
  fun setOperationUndoFailed()

  /**
   * If the operation decides that a different path is required. You can set the next operation to
   * complete and whether you should continue down the original path
   *
   * @param operation the operation you use to diverge to
   * @param continuePathAfterDiverge Indicates that you want to continue down the normal
   *   path after the divergent path is complete.
   */
  fun setOperationDiverge(
    operation: Operation<Any?>,
    continuePathAfterDiverge: Boolean,
  )

  /**
   * Set the operation undo attempted (whether it succeed or failed is up to the undo method to set)
   */
  fun setOperationUndoAttempted()

  /**
   * The execute method must be implemented by the class. This is where the operation performs its
   * work and sets the result and the course of action (failed, undo possible, etc).
   *
   * @param inputParameters The input parameters to the operation
   * @param operationCompletedCallback Operation
   */
  fun execute(
    inputParameters: T,
    operationCompletedCallback: IOperationCompleted<Any?>,
  )

  /**
   * The undo method is called when an operation fails and the operation is set to "undoable"
   */
  fun undo(undoCompleteCallback: IOperationUndoCompleted)

  /**
   * Override this method when implementing and place any operation start messages that should be logged here.
   */
  open fun logOperationBeginMessages()

  /**
   * Add the result to the end of the results list
   *
   * @param result the result from the last operation
   */
  fun addResult(result: IOperationResult<Any?>)

  /**
   * Use this method to create files and optionally push them onto the files created stack that will
   * be referenced when an undo is required.
   *
   * @param filePath
   * @param message the error message to print.
   * @param saveFileNameForUndo Whether you want to keep track of the files created for undo
   * @param isDir if this is a file or directory
   */
  fun createFile(
    filePath: String,
    message: String,
    saveFileNameForUndo: Boolean,
    isDir: Boolean,
  )

  /**
   * Method to print all the files created by the file creator service.
   */
  fun printFilesCreatedList()

  /**
   * Add a file created by the operation to the list of all files created and optionally mark this
   * file as undoable, which will cause the undo operation to attempt to remove the file or
   * directory.
   *
   * @param fileUndoable The file or directory should be automatically removed by the undo operation.
   * @param file The file or directory created.
   */
  fun addFileCreated(
    fileUndoable: Boolean,
    file: String,
  )

  companion object {
    val NO_PARMS: Any?
    val NO_OUTPUT: Any?

    fun summarizeResults(operationResults: IOperationResult<Any?>): Boolean
  }
}
