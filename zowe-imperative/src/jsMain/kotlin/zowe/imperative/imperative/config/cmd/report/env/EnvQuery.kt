@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.report.env

import js.promise.Promise

/**
 * This class encapulates operations for Zowe CLI environment information. We use the term
 * environment loosely. Sometimes it is an environment variable. It can also be something in the
 * runtime environment, like version of NodeJS.
 */
external class EnvQuery {
  companion object {
    /**
     * For the specified itemId, get its value.
     *
     * @param itemId ID of the environmental item for which we want get the value.
     * @param getItemOpts options that affect our behavior.
     * @return An object with the item value, a display message, and a problem message.
     */
    fun getEnvItemVal(
      itemId: ItemId,
      getItemOpts: IGetItemOpts = definedExternally,
    ): Promise<IGetItemVal>
  }
}
