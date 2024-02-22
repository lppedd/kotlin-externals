/**
 * Session interface for maintaining cookie and protocol information
 * @export
 * @interface ISshSession
 */
export interface ISshSession {
    /**
     * Host to connect ssh to
     * @type {string}
     * @memberof ISession
     */
    hostname?: string;
    /**
     * Port to obtain data from
     * 22 is the default for ssh
     * @type {number}
     * @memberof ISession
     */
    port?: number;
    /**
     * User name for logging in
     * @type {string}
     * @memberof ISession
     */
    user?: string;
    /**
     * Password
     * @type {string}
     * @memberof ISession
     */
    password?: string;
    /**
     * Path to a private key that matches with a public key stored in the server for authentication
     * @type {string}
     * @memberof ISession
     */
    privateKey?: string;
    /**
     * password to unlock the private key.
     * @type {string}
     * @memberof ISession
     */
    keyPassphrase?: string;
    /**
     * How long in milliseconds to wait for the SSH handshake to complete. If unset, defaults to 0 - no timeout.
     * @type {string}
     * @memberof ISession
     */
    handshakeTimeout?: number;
}
