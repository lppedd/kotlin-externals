/// <reference types="node" />
/// <reference types="node" />
import { URL } from 'url';
import { Agent } from 'https';
import { ISession } from '../session/doc/ISession';
/**
 * Utility class to provide an http agent to REST APIs that is configured for
 * a proxy server based on commonly used environment variables.
 *
 * Supports the usage of the environment variables HTTP_PROXY, http_proxy, HTTPS_PROXY, https_proxy.
 * If any of these env variables is set and depending how the Zowe session is configured for http or
 * https it instantiates an appropriate http agent utilizing a popular third party library. If the z/OS
 * system uses self-signed certificates then the proxy server must be configured to accept them. If the
 * proxy server itself is configured with self-signed certificates then the user needs to either import
 * these certificates on their workstation, use rejectUnauthorized in their Zowe profile, or use the (not
 * recommended) nodejs variable NODE_TLS_REJECT_UNAUTHORIZED=0. This class also looks for the environment
 * variables NO_PROXY or no_proxy. These work with a simple comma separated list of hostnames that need
 * to match with the hostname of the Zowe profile.
 */
export declare class Proxy {
    /**
     * Retrieve an appropriate http.agent instance if proxy environment variables can be found.
     * @static
     * @param session Zowe `ISession` containing the hostname for the http request.
     *                Uses the session's `rejectUnauthorized` also for the proxy connection.
     * @returns an instance of an appropriate subclass of node's https.agent if proxy
     *          settings were found. Returns `undefined` if no proxy settings are found.
     * @memberof Proxy
     */
    static getProxyAgent(session: ISession): Agent | undefined;
    /**
     * Returns the URL to the proxy server if proxy environment variables can be found.
     * Can be used for testing the settings and logging connection details.
     * @static
     * @param session Zowe `ISession` containing the hostname for the http request.
     * @returns `URL` to proxy server
     * @memberof Proxy
     */
    static getSystemProxyUrl(session: ISession): URL | undefined;
    /**
     * If the NO_PROXY or no_proxy environment variables are set with a comma separated
     * list of hostnames it will try to match the hostname of the Zowe `ISession` and
     * return `true` if found. Performs a simple string compare ignoring casing and white
     * spaces, but will not resolve hostnames to ip addressees and not perform wildcard matching.
     * @static
     * @param session Zowe `ISession` containing the hostname for the http request.
     * @returns `true` if the Zowe session host matches an entry in the comma separated
     *          list of hostnames in the environment variable. `false` otherwise.
     * @memberof Proxy
     */
    static matchesNoProxySettings(session: ISession): boolean;
    /**
     * Parses environment variables for proxy servers.
     * @private
     * @static
     * @param session Zowe `ISession` containing the hostname for the http request.
     * @returns instance of private `ProxySetting` or `undefined`
     * @memberof Proxy
     */
    private static getProxySettings;
    /**
     * Parses environment variables valid for http requests.
     * @private
     * @static
     * @returns `string` if valid variable is found or undefined.
     * @memberof Proxy
     */
    private static getHttpEnvVariables;
    /**
     * Parses environment variables valid for https requests.
     * @private
     * @static
     * @returns `string` if valid variable is found or undefined.
     * @memberof Proxy
     */
    private static getHttpsEnvVariables;
    /**
     * Parses environment variables valid for no proxy exceptions.
     * @private
     * @static
     * @returns `string[]` of all hostnames found in the comma separated list
     *          in lowercase without white spaces.
     * @memberof Proxy
     */
    private static getNoProxyEnvVariables;
    /**
     * Parses a string to check if it is a valid URL.
     * @private
     * @static
     * @param inputUrl a string with a URL
     * @returns a URL instance or undefined if not a valid url.
     * @memberof Proxy
     */
    private static checkUrl;
}
