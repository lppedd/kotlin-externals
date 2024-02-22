/// <reference types="node" />
import { IImperativeError } from "../../../error";
import { IHandlerResponseConsoleApi } from "../doc/response/api/handler/IHandlerResponseConsoleApi";
import { IHandlerResponseDataApi } from "../doc/response/api/handler/IHandlerResponseDataApi";
import { ICommandResponseParms } from "../doc/response/parms/ICommandResponseParms";
import { ICommandResponse } from "../doc/response/response/ICommandResponse";
import { COMMAND_RESPONSE_FORMAT, ICommandResponseApi } from "../doc/response/api/processor/ICommandResponseApi";
import { IHandlerProgressApi } from "../doc/response/api/handler/IHandlerProgressApi";
import { IHandlerFormatOutputApi } from "../doc/response/api/handler/IHandlerFormatOutputApi";
/**
 * Command response object allocated by the command processor and used to construct the handler response object
 * passed to the command handlers. The response object contains all the methods necessary for a command handler (and
 * the processor) to formulate a command response. Controls buffering of messages and JSON response formats.
 *
 * Instances of this class are only manipulated by the command processor. See "HandlerResponse" for the handler response
 * object.
 *
 * @export
 * @class CommandResponse
 * @implements {ICommandResponseApi}
 */
export declare class CommandResponse implements ICommandResponseApi {
    /**
     * Imperative Error tag for error messaging
     * @private
     * @static
     * @type {string}
     * @memberof CommandResponse
     */
    private static readonly RESPONSE_ERR_TAG;
    /**
     * Max column width for formulating tabular output
     * @private
     * @static
     * @memberof CommandProcessor
     */
    private static readonly MAX_COLUMN_WIDTH;
    /**
     * The full set of control parameters for the response - see the interface for details.
     * @private
     * @type {ICommandResponseParms}
     * @memberof CommandResponse
     */
    private mControl;
    /**
     * Enable silent mode - means absolutely NO output will be written to the console/terminal.
     * @private
     * @type {boolean}
     * @memberof CommandResponse
     */
    private mSilent;
    /**
     * Command handler succeeded flag - true if the command succeeded.
     * @private
     * @type {boolean}
     * @memberof CommandResponse
     */
    private mSucceeded;
    /**
     * Command handler exit code. Will be used when exiting the process at the end of command execution
     * @private
     * @type {number}
     * @memberof CommandResponse
     */
    private mExitCode;
    /**
     * The default highlight color for chalk
     * @private
     * @memberof CommandResponse
     */
    private mPrimaryTextColor;
    /**
     * The stderr buffer - collects all messages sent to stderr.
     * @private
     * @type {Buffer}
     * @memberof CommandResponse
     */
    private mStderr;
    /**
     * The stdout buffer - collects all messages sent to stdout.
     * @private
     * @type {Buffer}
     * @memberof CommandResponse
     */
    private mStdout;
    /**
     * The message placed on the response object when the JSON response is built
     * @private
     * @type {string}
     * @memberof CommandResponse
     */
    private mMessage;
    /**
     * The "data" object that is placed on the JSON response object of the command
     * @private
     * @type {*}
     * @memberof CommandResponse
     */
    private mData;
    /**
     * The error object appended to the JSON response to the command - automatically added if the handler rejects
     * the promise.
     * @private
     * @type {IImperativeError}
     * @memberof CommandResponse
     */
    private mError;
    /**
     * Progress bar instance - only one can be present at any given time.
     * @private
     * @type {*}
     * @memberof CommandResponse
     */
    private mProgressBar;
    /**
     * API instance for the progress bar - used to create/end command progress bars.
     * @private
     * @type {IHandlerProgressApi}
     * @memberof CommandResponse
     */
    private mProgressApi;
    /**
     * API instance for the data APIs - used to populate the JSON response object fields.
     * @private
     * @type {IHandlerResponseDataApi}
     * @memberof CommandResponse
     */
    private mDataApi;
    /**
     * API instance for the console APIs - used to write messages to stdout/stderr.
     * @private
     * @type {IHandlerResponseConsoleApi}
     * @memberof CommandResponse
     */
    private mConsoleApi;
    /**
     * Format APIs for automatically formatting output data
     * @private
     * @type {IHandlerFormatOutputApi}
     * @memberof CommandResponse
     */
    private mFormatApi;
    /**
     * The command response format - JSON, default, etc.
     * @private
     * @type {COMMAND_RESPONSE_FORMAT}
     * @memberof CommandResponse
     */
    private mResponseFormat;
    /**
     * The progress bar spinner chars.
     * @private
     * @type {string}
     * @memberof CommandResponse
     */
    private mProgressBarSpinnerChars;
    /**
     * The command definition document - may be undefined/null
     * @private
     * @type {ICommandDefinition}
     * @memberof CommandResponse
     */
    private mDefinition;
    /**
     * The arguments passed to the command - may be undefined/null
     * @private
     * @type {Arguments}
     * @memberof CommandResponse
     */
    private mArguments;
    /**
     * The stream to write to in daemon mode
     * @private
     * @type {net.Socket}
     * @memberof CommandResponse
     */
    private mStream;
    /**
     * Creates an instance of CommandResponse.
     * @param {ICommandResponseParms} params - See the interface for details.
     * @memberof CommandResponse
     */
    constructor(params?: ICommandResponseParms);
    get format(): IHandlerFormatOutputApi;
    /**
     * Accessor for the console API - Handlers will use this API to write console messages.
     * @readonly
     * @type {IHandlerResponseConsoleApi}
     * @memberof CommandResponse
     */
    get console(): IHandlerResponseConsoleApi;
    /**
     * Accessor for the data api class - Handlers will use this to construct/influence the response JSON object (data
     * is only displayed to the user if JSON mode is requested).
     * @readonly
     * @type {IHandlerResponseDataApi}
     * @memberof CommandResponse
     */
    get data(): IHandlerResponseDataApi;
    /**
     * Accessor for the progress bar API - Handlers will use this API to create/destroy command progress bars.
     * @readonly
     * @type {IHandlerProgressApi}
     * @memberof CommandResponse
     */
    get progress(): IHandlerProgressApi;
    /**
     * Accessor for the silent flag - silent indicates that the command produces absolutely no output to the console.
     * @readonly
     * @type {boolean}
     * @memberof CommandResponse
     */
    get silent(): boolean;
    /**
     * Setter for the succeeded flag (sets to false to indicate command failure).
     * @memberof CommandResponse
     */
    failed(): void;
    /**
     * Setter for the succeeded flag (sets to true to indicate command success).
     * @memberof CommandResponse
     */
    succeeded(): void;
    /**
     * Buffer the message (string or buffer) to the stdout buffer. Used to accumulate messages for different reasons
     * (JSON mode is enabled, etc.).
     * @param {(Buffer | string)} data - The data/messages to buffer.
     * @memberof CommandResponse
     */
    bufferStdout(data: Buffer | string): void;
    /**
     * Buffer the message (string or buffer) to the stderr buffer. Used to accumulate messages for different reasons
     * (JSON mode is enabled, etc.).
     * @param {(Buffer | string)} data - The data/messages to buffer.
     * @memberof CommandResponse
     */
    bufferStderr(data: Buffer | string): void;
    /**
     * Setter for the error object in the response - automatically populated by the Command Processor if the handler
     * rejects the handler promise.
     * @param {IImperativeError} error - The error object to place in the response.
     * @memberof CommandResponse
     */
    setError(error: IImperativeError): void;
    /**
     * Returns the JSON response for the command.
     * @returns {ICommandResponse} - The command JSON response - See the interface for details.
     * @memberof CommandResponse
     */
    buildJsonResponse(): ICommandResponse;
    /**
     * Writes the JSON response to the console - Done normally by the command processor dependending on the response
     * format specified in the object.
     * @returns {ICommandResponse} - Returns the constructed response that is written to the console.
     * @memberof CommandResponse
     */
    writeJsonResponse(): ICommandResponse;
    /**
     * Accessor for the response format - see the type for available options - controls how the response will be
     * presented to the user (JSON format, default, etc.)
     * @readonly
     * @type {COMMAND_RESPONSE_FORMAT}
     * @memberof CommandResponse
     */
    get responseFormat(): COMMAND_RESPONSE_FORMAT;
    /**
     * Complete any outstanding progress bars.
     * @memberof CommandResponse
     */
    endProgressBar(): void;
    /**
     * Explicitly end a stream
     * @private
     * @memberof CommandResponse
     */
    endStream(): void;
    /**
     * Send headers to daemon client
     * @private
     * @param {string} headers
     * @memberof CommandResponse
     */
    private setDaemonExitCode;
    /**
     * Internal accessor for the full control parameters passed to the command response object.
     * @readonly
     * @private
     * @type {ICommandResponseParms}
     * @memberof CommandResponse
     */
    private get control();
    /**
     * Uses text utils to format the message (format strings).
     * @private
     * @param {string} msg - The format message
     * @param {...any[]} values - The substitution values for the format string
     * @returns {string} - Returns the formatted message
     * @memberof CommandResponse
     */
    private formatMessage;
    /**
     * Buffers to stdout and optionally prints the msg to the console.
     * @private
     * @param {(Buffer | string)} data - The data to write/buffer
     * @memberof CommandResponse
     */
    private writeAndBufferStdout;
    /**
     * Writes the data to stdout
     * @private
     * @param {(Buffer | string)} data - the data to write
     * @memberof CommandResponse
     */
    private writeStdout;
    /**
     * Writes data to stream if provided (for daemon mode)
     * @private
     * @param {(Buffer | string)} data
     * @memberof CommandResponse
     */
    private writeStream;
    /**
     * Buffers to stderr and optionally prints the msg to the console.
     * @private
     * @param {(Buffer | string)} data - The data to write/buffer
     * @memberof CommandResponse
     */
    private writeAndBufferStderr;
    /**
     * Writes the data to stderr
     * @private
     * @param {(Buffer | string)} data - the data to write to stderr
     * @memberof CommandResponse
     */
    private writeStderr;
    /**
     * Indicates if output should be written immediately to the console/terminal. If silent mode is true or response
     * format indicates JSON, then write() will return false.
     * @private
     * @returns {boolean} - True if the output should be written to the console/terminal.
     * @memberof CommandResponse
     */
    private write;
}
