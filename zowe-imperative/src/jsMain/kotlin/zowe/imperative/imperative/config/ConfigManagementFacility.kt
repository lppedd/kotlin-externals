@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config

external class ConfigManagementFacility {
  /**
   * Initialize the CMF. Must be called to enable the various commands provided by the facility.
   */
  fun init()

  companion object {
    /**
     * Gets a single instance of the CMF. On the first call of [ConfigManagementFacility.instance], a
     * new CMF is initialized and returned. Every subsequent call will use the one that was first
     * created.
     *
     * @return The newly initialized CMF object.
     */
    val instance: ConfigManagementFacility
  }
}
