package zowe.explorer.api.tree

import js.promise.Promise
import zowe.sdk.zos.jobs.doc.response.IJob

/**
 * Extended interface for Zowe Job tree nodes.
 */
external interface IZoweJobTreeNode : IZoweTreeNode {
  /**
   * Use Job-specific tree node for children.
   */
  @Suppress("VAR_TYPE_MISMATCH_ON_OVERRIDE")
  override var children: Array<IZoweJobTreeNode>?

  /**
   * Standard job response document
   * Represents the attributes and status of a z/OS batch job
   */
  var job: IJob?

  /**
   * Search criteria for a Job search
   */
  var searchId: String?

  /**
   * Job Prefix i.e "MYJOB"
   * Attribute of Job query
   */
  var prefix: String?

  /**
   * Job Owner i.e "MYID"
   * Attribute of Job query
   */
  var owner: String?

  /**
   * Job Status i.e "ACTIVE"
   * Attribute of Job query
   */
  var status: String?

  /**
   * Returns whether the job node is a filtered search
   */
  var filtered: Boolean?

  /**
   * Filter method for this job search
   */
  var filter: String?

  /**
   * Array of original filter search results job's children
   */
  var actualJobs: Array<IZoweTreeNode>?

  /**
   * Retrieves child nodes of this IZoweJobTreeNode
   */
  @Suppress("RETURN_TYPE_MISMATCH_ON_OVERRIDE")
  override fun getChildren(): Promise<Array<IZoweJobTreeNode>>
}
