/// <reference types="node" />
import * as net from "net";
/**
 * Class for handling client connections to our persistent service (e.g. daemon mode)
 * @export
 * @class DaemonClient
 */
export declare class DaemonClient {
    private mClient;
    private mServer;
    private mOwner;
    /**
     * The number of stdin bytes remaining to read from the daemon client.
     */
    private stdinBytesRemaining;
    /**
     * Creates an instance of DaemonClient.
     * @param {net.Socket} mClient
     * @param {net.Server} mServer
     * @param {string} mOwner
     * @memberof DaemonClient
     */
    constructor(mClient: net.Socket, mServer: net.Server, mOwner: string);
    /**
     * Run an instance of this client and wait for proper events
     * @memberof DaemonClient
     */
    run(): void;
    /**
     * End event handler triggered when client disconnects
     * @private
     * @memberof DaemonClient
     */
    private end;
    /**
     * Close event handler triggered when client closes connection
     * @private
     * @memberof DaemonClient
     */
    private close;
    /**
     * Shutdown the daemon server cleanly. This is triggered when our EXE
     * sends Control-C in the stdin property of its request object.
     * @private
     * @memberof DaemonClient
     */
    private shutdown;
    /**
     * Create readable stream for stdin data received from the daemon client.
     * @param data First chunk of stdin data
     * @param expectedLength Expected byte length of stdin data
     * @private
     * @memberof DaemonClient
     */
    private createStdinStream;
    /**
     * Data event handler triggered for whenever data comes in on a connection
     * @private
     * @param {Buffer} data
     * @memberof DaemonClient
     */
    private data;
}
