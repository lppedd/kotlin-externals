import { ICommandHandler } from "./ICommandHandler";
/**
 * This type is here so that we can indicate an object from a
 * require can be instantiated.
 */
export declare type ICommandHandlerConstructor = new () => ICommandHandler;
