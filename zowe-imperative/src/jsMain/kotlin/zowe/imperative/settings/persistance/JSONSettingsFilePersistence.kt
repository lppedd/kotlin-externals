@file:JsModule("@zowe/imperative")

package zowe.imperative.settings.persistance

import zowe.imperative.settings.doc.ISettingsFile

external class JSONSettingsFilePersistence : ISettingsFilePersistence {
  constructor(settingsFile: String)

  override fun read(): ISettingsFile

  override fun write(settings: ISettingsFile)
}
