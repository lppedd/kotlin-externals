import { ISession } from "./doc/ISession";
/**
 * The API session object, serves as the base for sessions and contains the fields that are required by
 * most API calls (hostname, port, credentials, etc).
 * @export
 * @abstract
 * @class AbstractSession
 */
export declare abstract class AbstractSession {
    private mISession;
    /**
     * Basic auth prefix
     * @static
     * @type {string}
     * @memberof AbstractSession
     */
    static readonly BASIC_PREFIX: string;
    /**
     * Bearer auth prefix
     * @static
     * @type {string}
     * @memberof AbstractSession
     */
    static readonly BEARER_PREFIX: string;
    /**
     * Default protocol
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_PROTOCOL = "https";
    /**
     * Default session type
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_TYPE = "none";
    /**
     * Default http port 80
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_HTTP_PORT = 80;
    /**
     * Default https port 443
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_HTTPS_PORT = 443;
    /**
     * Default https port
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_PORT = 443;
    /**
     * Default base path.
     * Our empty string means that we do **not** use an API mediation layer
     * base path at the beginning of every resource URL.
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_BASE_PATH = "";
    /**
     * Default reject unauthorized
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_REJECT_UNAUTHORIZED_SETTING = true;
    /**
     * Default strict ssl setting
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_STRICT_SSL = true;
    /**
     * Default SSL method
     * @static
     * @memberof AbstractSession
     */
    static readonly DEFAULT_SECURE_PROTOCOL = "SSLv23_method";
    /**
     * Regex to extract basic from base64 encoded auth
     * @static
     * @type {RegExp}
     * @memberof AbstractSession
     */
    static readonly BASIC: RegExp;
    /**
     * Obtain user name from a base 64 credential
     * @static
     * @param {string} auth - base 64 encoded credentials
     * @returns {string} - user name
     * @memberof AbstractSession
     */
    static getUsernameFromAuth(auth: string): string;
    /**
     * Obtain password from a base 64 credential
     * @static
     * @param {string} auth - base 64 encoded credentials
     * @returns {string} - password
     * @memberof AbstractSession
     */
    static getPasswordFromAuth(auth: string): string;
    /**
     * Create base 64 encoded representation of user and password
     * @static
     * @param user - plain text user
     * @param password - plain text password
     * @returns {string} - base 64 encoded auth
     * @memberof AbstractSession
     */
    static getBase64Auth(user: string, password: string): string;
    /**
     * Logging object
     */
    private mLog;
    /**
     * Creates an instance of AbstractSession.
     * @param {ISession} session: Session parameter object
     * @memberof AbstractSession
     */
    constructor(mISession: ISession);
    /**
     * Method to parse the requested token type
     * @param {*} cookie - cookie object from http(s) response
     * @memberof AbstractSession
     */
    storeCookie(cookie: any): void;
    /**
     * Builds an ISession so all required pieces are filled in
     * @private
     * @param {ISession} session - the fully populated session
     * @memberof AbstractSession
     */
    private buildSession;
    /**
     * Obtain session info and defaults
     * @readonly
     * @type {ISession}
     * @memberof AbstractSession
     */
    get ISession(): ISession;
}
