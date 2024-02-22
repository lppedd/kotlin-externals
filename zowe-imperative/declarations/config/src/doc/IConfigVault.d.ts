export interface IConfigVault {
    load: (key: string) => Promise<any>;
    save: (key: string, value: any) => Promise<void>;
}
