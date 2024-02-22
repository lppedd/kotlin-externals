import { ISettingsFile } from "../doc/ISettingsFile";
import { ISettingsFilePersistence } from "./ISettingsFilePersistence";
export declare class JSONSettingsFilePersistence implements ISettingsFilePersistence {
    private readonly settingsFile;
    private readonly path;
    constructor(settingsFile: string);
    read(): ISettingsFile;
    write(settings: ISettingsFile): void;
}
