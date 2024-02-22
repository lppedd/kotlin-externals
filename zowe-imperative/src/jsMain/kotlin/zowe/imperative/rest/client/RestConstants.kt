@file:JsModule("@zowe/imperative")

package zowe.imperative.rest.client

/**
 * Constants used for REST client, etc.
 */
external class RestConstants {
  companion object {
    /**
     * 200
     */
    @JsInt(200)
    val HTTP_STATUS_200: Int

    /**
     * 201
     */
    @JsInt(201)
    val HTTP_STATUS_201: Int

    /**
     * 202
     */
    @JsInt(202)
    val HTTP_STATUS_202: Int

    /**
     * 204
     */
    @JsInt(204)
    val HTTP_STATUS_204: Int

    /**
     * 300
     */
    @JsInt(300)
    val HTTP_STATUS_300: Int

    /**
     * 400
     */
    @JsInt(400)
    val HTTP_STATUS_400: Int

    /**
     * 401
     */
    @JsInt(401)
    val HTTP_STATUS_401: Int

    /**
     * 404
     */
    @JsInt(404)
    val HTTP_STATUS_404: Int

    /**
     * 500
     */
    @JsInt(500)
    val HTTP_STATUS_500: Int

    /**
     * Set cookie property
     */
    val PROP_COOKIE: String

    /**
     * Query identifier
     */
    @JsString("?")
    val QUERY_ID: String

    /**
     * Basic auth
     */
    val BASIC_PREFIX: String

    /**
     * Bearer auth
     */
    val BEARER_PREFIX: String
  }
}
