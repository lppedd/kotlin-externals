import { ISettingsFile } from "../doc/ISettingsFile";
export interface ISettingsFilePersistence {
    read(): ISettingsFile;
    write(settings: ISettingsFile): void;
}
