/**
  * http protocol
  */
export declare const HTTP_PROTOCOL = "http";
/**
 * https protocol
 */
export declare const HTTPS_PROTOCOL = "https";
/**
 * type that specifies the choice of protocols
 */
export declare type HTTP_PROTOCOL_CHOICES = typeof HTTP_PROTOCOL | typeof HTTPS_PROTOCOL;
/**
 * Session type property value for no authentication
 */
export declare const AUTH_TYPE_NONE = "none";
/**
 * Session type property value for basic authentication
 */
export declare const AUTH_TYPE_BASIC = "basic";
/**
 * Session type property value for bearer token authentication
 */
export declare const AUTH_TYPE_BEARER = "bearer";
/**
 * Session type property value for cookie token authentication,
 * which uses a named token type.
 */
export declare const AUTH_TYPE_TOKEN = "token";
/**
 * Session type property value for certificate authentication,
 * which uses a certificate file and key file.
 */
export declare const AUTH_TYPE_CERT_PEM = "cert-pem";
/**
 * Session type property value for certificate authentication,
 * which uses a certificate file and passphrase.
 */
/**
 * type that specifies the choice of authentication types
 */
export declare type AUTH_TYPE_CHOICES = typeof AUTH_TYPE_NONE | typeof AUTH_TYPE_BASIC | typeof AUTH_TYPE_BEARER | typeof AUTH_TYPE_TOKEN | typeof AUTH_TYPE_CERT_PEM;
/**
 * tokenType property value for IBM's LTPA2 token
 */
export declare const TOKEN_TYPE_LTPA = "LtpaToken2";
/**
 * tokenType property value for a JWT token
 */
export declare const TOKEN_TYPE_JWT = "jwtToken";
/**
 * tokenType property value for an API Mediation Layer token
 */
export declare const TOKEN_TYPE_APIML = "apimlAuthenticationToken";
/**
 * list that specifies the choice of token types
 */
export declare const ALL_TOKEN_TYPES: string[];
/**
 * type that specifies the choice of token types
 */
export declare type TOKEN_TYPE_CHOICES = typeof TOKEN_TYPE_LTPA | typeof TOKEN_TYPE_JWT | typeof TOKEN_TYPE_APIML;
