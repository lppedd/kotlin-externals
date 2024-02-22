package zowe.imperative.settings.persistance

import zowe.imperative.settings.doc.ISettingsFile

external interface ISettingsFilePersistence {
  fun read(): ISettingsFile

  fun write(settings: ISettingsFile)
}
