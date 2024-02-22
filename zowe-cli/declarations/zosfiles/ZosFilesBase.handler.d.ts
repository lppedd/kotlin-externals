import { AbstractSession, ICommandHandler, IHandlerParameters, IProfile } from "@zowe/imperative";
import { IZosFilesResponse } from "@zowe/zos-files-for-zowe-sdk";
/**
 * This class is used by the various zosfiles handlers as the base class for their implementation.
 * All handlers within zosfiles should extend this class.
 *
 * This class should not be used outside of the zosfiles package.
 *
 * @private
 */
export declare abstract class ZosFilesBaseHandler implements ICommandHandler {
    /**
     * This will grab the zosmf profile and create a session before calling the subclass
     * {@link ZosFilesBaseHandler#processWithSession} method.
     *
     * @param {IHandlerParameters} commandParameters Command parameters sent by imperative.
     *
     * @returns {Promise<void>}
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
    /**
     * This is called by the {@link ZosFilesBaseHandler#process} after it creates a session. Should
     * be used so that every class under files does not have to instantiate the session object.
     *
     * @param {IHandlerParameters} commandParameters Command parameters sent to the handler.
     * @param {AbstractSession} session The session object generated from the zosmf profile.
     * @param {IProfile} zosmfProfile The zosmf profile that was loaded for the command.
     *        Never use this deprecated zosmfProfile parameter.
     *        It should have been removed for the V2 version of Zowe, but we missed it.
     *        There is no good reason to use it. Better techniques exist, and are
     *        implemented in all of the implementations of this abstract class.
     *
     * @returns {Promise<IZosFilesResponse>} The response from the underlying zos-files api call.
     */
    abstract processWithSession(commandParameters: IHandlerParameters, session: AbstractSession, zosmfProfile?: IProfile): Promise<IZosFilesResponse>;
}
