/**
 * Initial paramter parse to handle conditionally starting as a persistent process (e.g. daemon mode)
 * @export
 * @class DaemonDecider
 */
export declare class DaemonDecider {
    private mParms;
    /**
     * Undocumented paramter for launching in server mode
     * @private
     * @static
     * @memberof DaemonDecider
     */
    private static readonly DAEMON_KEY;
    /**
     * Hold instance of a running server
     * @private
     * @type {net.Server}
     * @memberof DaemonDecider
     */
    private mServer;
    /**
     * Hold current socket path for the server
     * @private
     * @type {number}
     * @memberof DaemonDecider
     */
    private mSocket;
    /**
     * Hold current owner for the server
     * @private
     * @type {number}
     * @memberof Processor
     */
    private mUser;
    /**
     * Indicator for whether or not to start the server
     * @private
     * @type {boolean}
     * @memberof DaemonDecider
     */
    private mStartServer;
    /**
     * Creates an instance of DaemonDecider.
     * @param {string[]} mParms
     * @memberof DaemonDecider
     */
    constructor(mParms: string[]);
    /**
     * Initialize our DaemonDecider parse and optionally start the server
     * @memberof DaemonDecider
     */
    init(): void;
    /**
     * Method to immediately parse or otherwise start the server for later processing from
     * incoming socket connections.
     * @memberof DaemonDecider
     */
    runOrUseDaemon(): void;
    /**
     * Record the process ID of the daemon that is being started for the current user.
     * On a multi-user system, each user gets his/her own daemon.
     *
     * @private
     * @memberof DaemonDecider
     */
    private recordDaemonPid;
    /**
     * Server close handler
     * @private
     * @memberof DaemonDecider
     */
    private close;
    /**
     * Server error handler
     * @private
     * @param {Error} err
     * @memberof DaemonDecider
     */
    private error;
    /**
     * Perform initial parsing of undocumented parameters
     * @private
     * @memberof DaemonDecider
     */
    private initialParse;
    /**
     * Get whether or not to start the server
     * @private
     * @memberof DaemonDecider
     */
    private get startServer();
    /**
     * Set whether or not to start the server
     * @private
     * @memberof DaemonDecider
     */
    private set startServer(value);
}
