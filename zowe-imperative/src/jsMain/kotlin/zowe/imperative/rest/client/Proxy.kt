@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

import node.https.Agent
import web.url.URL
import zowe.imperative.rest.session.doc.ISession

/**
 * Utility class to provide an HTTP agent to REST APIs that is configured for
 * a proxy server based on commonly used environment variables.
 *
 * Supports the usage of the environment variables HTTP_PROXY, http_proxy, HTTPS_PROXY, https_proxy.
 * If any of these env variables is set and depending on how the Zowe session is configured for http or
 * https it instantiates an appropriate http agent utilizing a popular third party library. If the z/OS
 * system uses self-signed certificates then the proxy server must be configured to accept them. If the
 * proxy server itself is configured with self-signed certificates then the user needs to either import
 * these certificates on their workstation, use rejectUnauthorized in their Zowe profile, or use the (not
 * recommended) Node.js variable NODE_TLS_REJECT_UNAUTHORIZED=0. This class also looks for the environment
 * variables NO_PROXY or no_proxy. These work with a simple comma separated list of hostnames that need
 * to match with the hostname of the Zowe profile.
 */
external class Proxy {
  companion object {
    /**
     * Retrieve an appropriate http.agent instance if proxy environment variables can be found.
     *
     * @param session Zowe `ISession` containing the hostname for the http request.
     *   Uses the session's `rejectUnauthorized` also for the proxy connection.
     * @return an instance of an appropriate subclass of node's https.agent if proxy
     *   settings were found. Returns `undefined` if no proxy settings are found.
     */
    fun getProxyAgent(session: ISession): Agent?

    /**
     * Returns the URL to the proxy server if proxy environment variables can be found.
     * Can be used for testing the settings and logging connection details.
     *
     * @param session Zowe `ISession` containing the hostname for the http request.
     * @return `URL` to proxy server
     */
    fun getSystemProxyUrl(session: ISession): URL?

    /**
     * If the NO_PROXY or no_proxy environment variables are set with a comma separated
     * list of hostnames it will try to match the hostname of the Zowe `ISession` and
     * return `true` if found. Performs a simple string compare ignoring casing and white
     * spaces, but will not resolve hostnames to ip addressees and not perform wildcard matching.
     *
     * @param session Zowe `ISession` containing the hostname for the http request.
     * @return `true` if the Zowe session host matches an entry in the comma separated
     *   list of hostnames in the environment variable. `false` otherwise.
     */
    fun matchesNoProxySettings(session: ISession): Boolean
  }
}
