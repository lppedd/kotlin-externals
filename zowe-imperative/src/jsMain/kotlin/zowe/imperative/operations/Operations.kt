@file:JsModule("@zowe/imperative")

package zowe.imperative.operations

import zowe.imperative.operations.doc.IOperationResult

/**
 * The Operations class extends Operation and is used to create a 'string' of operations that must
 * be completed in serial order.
 *
 * The implementing class is responsible (in defineOperations) for creating each operation (and
 * invoking addNextOperation) to add the operations to the list. You must also call
 * "defineOperations" from your constructor. This allows you to setup anything you need (in your
 * constructor) before defining the list of operations.
 *
 * You can initiate the operation by invoking performOperation, which will iterate through each
 * operation defined and perform them in sequence. If a operation chooses to diverge, then
 */
external class Operations<T> : Operation<Any?> {
  /**
   * Building an Operations object
   *
   * @param opName Operations Name
   * @param critical if the operation is critical
   */
  constructor(opName: String, critical: Boolean = definedExternally)

  /**
   * The public interface to Operations. This method allows consumers to initiate the operation
   * sequence.
   *
   * @return: The operation results
   */
  fun executeOperation(
    inputParameters: T,
    operationComplete: IOperationResultReady<Any?>,
  )

  /**
   * Set the status message for the overall Operations object, which takes precedence over the
   * sub-operations' messages
   *
   * @param message the message, including any templates you want replaced like %s or "{{myObject}}"
   * @param args variable args as allowed by printf-like syntax or {myObject: this.myObject}
   * @return the final translated and formatted string (in case you want to log it etc.)
   */
  override fun setStatusMessage(
    message: String,
    vararg args: Any?,
  ): String

  override var statusMessage: String

  /**
   * What percent complete is the Operations as a whole?s
   *
   * @return percentComplete weighted against how many operations are complete
   */
  override var percentComplete: Int

  /**
   * Log that the set of operations have completed.
   */
  override fun logOperationResults()

  /**
   * Count the total number of base operation objects
   */
  override val totalOperations: Int

  /**
   * Add a new operation to the list of operations to be executed.
   *
   * @param newOperation Operation to be added to the list of sequential operations
   */
  fun addNextOperation(newOperation: Operation<Any?>)

  /**
   * This is a placeholder and is never directly called.
   */
  fun execute()

  /**
   * Perform all undos if the undo function is called for an Operations
   */
  fun undo()

  /**
   * Log that this is a set of operations that are about to begin.
   */
  override fun logOperationBeginMessages()

  /**
   * Callback invoked when the operation completes. Passed the result object of the operation.
   *
   * @param operationResult The result of the operation
   * @param output The output from the operation
   */
  fun operationCompleted(
    output: Any?,
    operationResult: IOperationResult<Any?>,
  )

  /**
   * Abstract method that must be implemented by the subclass. In this method, you invoke
   * "addNextOperation" to add all the operations that must be performed when "executeOperation" is
   * invoked.
   */
  fun defineOperations()
}
