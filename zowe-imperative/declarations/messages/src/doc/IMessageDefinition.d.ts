export interface IMessageDefinition {
    message: string;
    locales?: {
        [key: string]: string;
    };
}
