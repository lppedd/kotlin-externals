@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.rest

import zowe.sdk.core.rest.doc.IHeaderContent

/**
 * Class to contain default z/OSMF headers
 */
external class ZosmfHeaders {
  companion object {
    /**
     * file encoding header
     */
    @JsString("X-IBM-Intrdr-File-Encoding")
    val X_IBM_INTRDR_FILE_ENCODING: String

    /**
     * lrecl header
     */
    @JsString("X-IBM-Intrdr-Lrecl")
    val X_IBM_INTRDR_LRECL: String

    /**
     * recfm header
     */
    @JsString("X-IBM-Intrdr-Recfm")
    val X_IBM_INTRDR_RECFM: String

    /**
     * jcl symbol header to be completed by API
     */
    @JsString("X-IBM-JCL-Symbol-")
    val X_IBM_JCL_SYMBOL_PARTIAL: String

    /**
     * job class header
     */
    val X_IBM_INTRDR_CLASS_A: IHeaderContent

    /**
     * fixed recfm header
     */
    val X_IBM_INTRDR_RECFM_F: IHeaderContent

    /**
     * 80 lrecl header
     */
    val X_IBM_INTRDR_LRECL_80: IHeaderContent

    /**
     * 256 lrecl header
     */
    val X_IBM_INTRDR_LRECL_256: IHeaderContent

    /**
     * text type header
     */
    val X_IBM_INTRDR_MODE_TEXT: IHeaderContent

    /**
     * n/a header
     */
    val X_IBM_NOTIFICATION_URL: IHeaderContent

    /**
     * base header
     */
    val X_IBM_ATTRIBUTES_BASE: IHeaderContent

    /**
     * If you use this header, delete job API will be asynchronous.
     * This is the default setting, so using this header is not really necessary unless you want to be explicit.
     */
    val X_IBM_JOB_MODIFY_VERSION_1: IHeaderContent

    /**
     * If you use this header, delete job API will be synchronous.
     * But using it may cause problems for some users depending on their maintenance level and configuration.
     */
    val X_IBM_JOB_MODIFY_VERSION_2: IHeaderContent

    /**
     * security header
     */
    val X_CSRF_ZOSMF_HEADER: Any

    /**
     * binary transfer header
     */
    val X_IBM_BINARY: IHeaderContent

    /**
     * record transfer header
     */
    val X_IBM_RECORD: IHeaderContent

    /**
     * binary by record header
     */
    val X_IBM_BINARY_BY_RECORD: IHeaderContent

    /**
     * text transfer header
     */
    val X_IBM_TEXT: IHeaderContent

    /**
     * encoding value for text headers
     */
    val X_IBM_TEXT_ENCODING: String

    /**
     * octet stream header
     */
    val OCTET_STREAM: IHeaderContent

    /**
     * plain text header
     */
    val TEXT_PLAIN: IHeaderContent

    /**
     * This header value specifies the maximum number of items to return.
     * To request that all items be returned, set this header to 0. If you omit this header, or specify an incorrect value,
     * up to 1000 items are returned by default.
     */
    val X_IBM_MAX_ITEMS: IHeaderContent

    /**
     * data set migrated recall headers
     */
    val X_IBM_MIGRATED_RECALL_WAIT: IHeaderContent
    val X_IBM_MIGRATED_RECALL_NO_WAIT: IHeaderContent
    val X_IBM_MIGRATED_RECALL_ERROR: IHeaderContent

    /**
     * Header to check ETag on read
     * Request returns HTTP 304 if not modified
     */
    @JsString("If-None-Match")
    val IF_NONE_MATCH: String

    /**
     * Header to check ETag on write
     * Request returns HTTP 412 if not matched
     */
    @JsString("If-Match")
    val IF_MATCH: String

    /**
     * Header to set response timeout
     * Timeout defaults to 30 seconds if not modified
     */
    val X_IBM_RESPONSE_TIMEOUT: String

    /**
     * Header to set record range
     */
    val X_IBM_RECORD_RANGE: String

    /**
     * Header to set byte range
     */
    val RANGE: String

    /**
     * Header to force return of ETag in response regardless of file size
     * By default Etag is returned only for files smaller than a system determined value (which is at least 8mb)
     */
    val X_IBM_RETURN_ETAG: IHeaderContent

    /**
     * Header that specifies GZIP compression is supported
     * Recent versions of z/OSMF issue a warning if this header is omitted
     */
    val ACCEPT_ENCODING: IHeaderContent
  }
}
