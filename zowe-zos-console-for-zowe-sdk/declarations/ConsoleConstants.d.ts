import { IMessageDefinition } from "@zowe/imperative";
export declare class ConsoleConstants {
    static readonly CLASS: string;
    static readonly RESOURCE: string;
    static readonly RES_DEF_CN: string;
    static readonly SOL_MSGS: string;
    static readonly DEFAULT_FOLLOWUP_ATTEMPTS: number;
    static readonly DEFAULT_TIMEOUT: number;
}
export declare const displayResponse: IMessageDefinition;
export declare const displayError: IMessageDefinition;
export declare const displayCollectResponse: IMessageDefinition;
export declare const displayCollectError: IMessageDefinition;
export declare const decreaseCounter: IMessageDefinition;
export declare const resetCounter: IMessageDefinition;
export declare const noZosmfInput: IMessageDefinition;
export declare const noConsoleInput: IMessageDefinition;
export declare const noConsoleName: IMessageDefinition;
export declare const noCommandKey: IMessageDefinition;
export declare const noCollectParameters: IMessageDefinition;
export declare const collectProcessingDetails: IMessageDefinition;
