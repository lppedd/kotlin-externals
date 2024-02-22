@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.session

/**
 * http protocol
 */
@JsString("http")
external val HTTP_PROTOCOL: String

/**
 * https protocol
 */
@JsString("https")
external val HTTPS_PROTOCOL: String

/**
 * Session type property value for no authentication
 */
@JsString("none")
external val AUTH_TYPE_NONE: String

/**
 * Session type property value for basic authentication
 */
@JsString("basic")
external val AUTH_TYPE_BASIC: String

/**
 * Session type property value for bearer token authentication
 */
@JsString("bearer")
external val AUTH_TYPE_BEARER: String

/**
 * Session type property value for cookie token authentication, which uses a named token type.
 */
@JsString("token")
external val AUTH_TYPE_TOKEN: String

/**
 * Session type property value for certificate authentication, which uses a certificate file and key file.
 */
@JsString("cert-pem")
external val AUTH_TYPE_CERT_PEM: String

/**
 * tokenType property value for IBM's LTPA2 token
 */
@JsString("LtpaToken2")
external val TOKEN_TYPE_LTPA: String

/**
 * tokenType property value for a JWT token
 */
@JsString("jwtToken")
external val TOKEN_TYPE_JWT: String

/**
 * tokenType property value for an API Mediation Layer token
 */
@JsString("apimlAuthenticationToken")
external val TOKEN_TYPE_APIML: String

/**
 * List that specifies the choice of token types
 */
external val ALL_TOKEN_TYPES: Array<String>
