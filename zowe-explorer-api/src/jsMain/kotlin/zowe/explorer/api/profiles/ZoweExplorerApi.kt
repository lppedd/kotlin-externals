@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.promise.Promise
import node.buffer.Buffer
import zowe.explorer.api.utils.FileAttributes
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.imperative.rest.session.Session
import zowe.sdk.console.doc.IConsoleResponse
import zowe.sdk.zos.files.doc.IDataSet
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.create.CreateDataSetTypeEnum
import zowe.sdk.zos.files.methods.create.doc.ICreateDataSetOptions
import zowe.sdk.zos.files.methods.delete.doc.IDeleteDatasetOptions
import zowe.sdk.zos.files.methods.download.doc.IDownloadOptions
import zowe.sdk.zos.files.methods.list.doc.IDsmListOptions
import zowe.sdk.zos.files.methods.list.doc.IListOptions
import zowe.sdk.zos.files.methods.upload.doc.IUploadOptions
import zowe.sdk.zos.jobs.doc.input.IDownloadAllSpoolContentParms
import zowe.sdk.zos.jobs.doc.input.IDownloadSpoolContentParms
import zowe.sdk.zos.jobs.doc.input.IGetJobsParms
import zowe.sdk.zos.jobs.doc.response.IJob
import zowe.sdk.zos.jobs.doc.response.IJobFeedback
import zowe.sdk.zos.jobs.doc.response.IJobFile
import zowe.sdk.zos.tso.doc.IIssueResponse
import zowe.sdk.zos.tso.doc.input.IStartTsoParms
import kotlin.ts.Partial

/**
 * This namespace provides interfaces for all the external APIs provided by this VS Code Extension.
 * Other VS Code Extension can implement these and use the IApiRegister interface to register themselves.
 */
external object ZoweExplorerApi {
  /**
   * Common interface shared between all API interfaces offered by this extension.
   */
  interface ICommon {
    /**
     * The profile associated with a specific instance of an API.
     */
    var profile: IProfileLoaded?

    /**
     * Return the type name of the CLI profile supported by this api.
     *
     * @return the type name as defined by a CLI plugin that implements the profile.
     */
    fun getProfileTypeName(): String

    /**
     * Create a session for the specific profile type.
     *
     * @param profile optional profile reference, will use the profile the API was retrieved with by default
     * @return a Zowe CLI Session
     */
    fun getSession(profile: IProfileLoaded = definedExternally): Session

    /**
     * Create a session for the specific profile type.
     *
     * @param profile will use the profile the API was retrieved with by default
     * @return z/OSMF Check Status response
     */
    fun getStatus(
      profile: IProfileLoaded,
      profileType: Any? = definedExternally,
    ): Promise<String>

    /**
     * Create a session for a set command arguments. The session will be created independent
     * of a specific profile using a specific API implementation that was created with a
     * referece profile.
     *
     * @param cmdArgs a Zowe CLI ICommandArguments instance
     * @return a Zowe CLI Session
     */
    fun getSessionFromCommandArgument(cmdArgs: ICommandArguments): Session

    /**
     * Perform login to obtain a token from the authentication service
     *
     * @param session a Zowe CLI Session
     * @return the token value
     */
    fun login(session: Session): Promise<String>

    /**
     * Perform logout from the authentication service
     *
     * @param session a Zowe CLI Session
     */
    fun logout(session: Session): Any?

    /**
     * Return the type name of the token supported by this api.
     *
     * @return the token type name as defined by a CLI plugin that implements the profile.
     */
    fun getTokenTypeName(): String
  }

  /**
   * API for providing a USS API handler to the extension.
   */
  interface IUss : ICommon {
    /**
     * Return the directory elements for a given USS path.
     *
     * @param ussFilePath A response structure that contains a boolean success property
     *     as well as the list of results in apiResponse.items with
     *     minimal properties name, mode.
     */
    fun fileList(ussFilePath: String): Promise<IZosFilesResponse<Any?>>

    /**
     * Check th USS chtag to see if a file requires conversion.
     *
     * @param ussFilePath
     */
    fun isFileTagBinOrAscii(ussFilePath: String): Promise<Boolean>

    /**
     * Copy operation for USS files or directories.
     *
     * @param outputPath the output/destination path for the file/directory
     * @param options Other options for the API endpoint
     */
    fun copy(outputPath: String, options: Any /* Omit<object, "request"> */ = definedExternally): Promise<Buffer>

    /**
     * Retrieve the contents of a USS file.
     *
     * @param ussFilePath
     * @param options
     */
    fun getContents(
      ussFilePath: String,
      options: IDownloadOptions,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Uploads the file at the given path. Use for Save.
     *
     * @param inputFilePath
     * @param ussFilePath
     * @param binary Indicates if a conversion should be attempted or treated as binary.
     * @param localEncoding Optional encoding that can be used by an implementation to overwrite defaults
     * @param etag
     * @param returnEtag
     */
    @Deprecated("")
    fun putContents(
      inputFilePath: String,
      ussFilePath: String,
      binary: Boolean = definedExternally,
      localEncoding: String = definedExternally,
      etag: String = definedExternally,
      returnEtag: Boolean = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Uploads the file at the given path. Use for Save.
     *
     * @param inputFilePath
     * @param ussFilePath
     * @param options
     */
    fun putContent(
      inputFilePath: String,
      ussFilePath: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Updates attributes for a USS directory or file.
     *
     * @param ussPath The USS path of the directory or file to update
     * @param attributes The attributes that should be updated
     */
    fun updateAttributes(
      ussPath: String,
      attributes: @Partial FileAttributes,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Uploads directory at the given path.
     *
     * @param inputDirectoryPath
     * @param ussDirectoryPath
     * @param options
     */
    fun uploadDirectory(
      inputDirectoryPath: String,
      ussDirectoryPath: String,
      options: IUploadOptions,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Create a new directory or file in the specified path.
     *
     * @param ussPath
     * @param type Either "file" or "directory".
     * @param mode An optional Unix string representation of the permissions.
     */
    fun create(
      ussPath: String,
      type: String,
      mode: String = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Deletes the USS directory or file at the given path.
     *
     * @param ussPath
     * @param recursive
     */
    fun delete(
      ussPath: String,
      recursive: Boolean = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Rename a file or directory.
     *
     * @param currentUssPath
     * @param newUssPath
     */
    fun rename(
      currentUssPath: String,
      newUssPath: String,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Get the tag of a USS file
     *
     * @param currentUssPath
     */
    fun getTag(ussPath: String): Promise<String>
  }

  /**
   * API for providing am MVS API handler to the extension.
   */
  interface IMvs : ICommon {
    /**
     * Get a list of data sets that match the filter pattern.
     *
     * @param filter
     * @param options
     */
    fun dataSet(
      filter: String,
      options: IListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Get a list of members for a partitioned data set.
     *
     * @param dataSetName
     * @param options
     */
    fun allMembers(
      dataSetName: String,
      options: IListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Get the contents of a data set or member specified by name.
     *
     * @param dataSetName
     * @param options
     */
    fun getContents(
      dataSetName: String,
      options: IDownloadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Upload the content of a file to a data set or member.
     *
     * @param inputFilePath
     * @param dataSetName
     * @param options
     */
    fun putContents(
      inputFilePath: String,
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Create a new data set with the specified options.
     *
     * @param dataSetType
     * @param dataSetName
     * @param options
     */
    fun createDataSet(
      dataSetType: CreateDataSetTypeEnum,
      dataSetName: String,
      options: @Partial ICreateDataSetOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Creates an empty data set member with given name.
     *
     * @param dataSetName
     * @param options
     */
    fun createDataSetMember(
      dataSetName: String,
      options: IUploadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Allocates a copy of a data set with the specified options.
     *
     * @param dataSetType
     * @param dataSetName
     * @param options
     */
    fun allocateLikeDataSet(
      dataSetName: String,
      likeDataSetName: String,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Copies a data set member.
     *
     * @param { dataSetName: fromDataSetName, memberName: fromMemberName }
     * @param { dataSetName: toDataSetName, memberName: toMemberName }
     * @param {{replace?: boolean}} [options]
     */
    fun copyDataSetMember(
      param0: IDataSet, // TODO(Edoardo): check if it's right
      param1: IDataSet, // TODO(Edoardo): check if it's right
      options: IMvsCopyDataSetMemberOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Renames a data set.
     *
     * @param currentDataSetName
     * @param newDataSetName
     */
    fun renameDataSet(
      currentDataSetName: String,
      newDataSetName: String,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Renames a data set member.
     *
     * @param dataSetName
     * @param currentMemberName
     * @param newMemberName
     */
    fun renameDataSetMember(
      dataSetName: String,
      currentMemberName: String,
      newMemberName: String,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Migrates a data set.
     *
     * @param dataSetName
     */
    fun hMigrateDataSet(dataSetName: String): Promise<IZosFilesResponse<Any?>>

    /**
     * Recalls a data set.
     *
     * @param dataSetName
     */
    fun hRecallDataSet(dataSetName: String): Promise<IZosFilesResponse<Any?>>

    /**
     * Deletes a data set or data set member.
     *
     * @param dataSetName
     * @param options
     */
    fun deleteDataSet(
      dataSetName: String,
      options: IDeleteDatasetOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Get a list of data sets that match the filter pattern.
     *
     * @param filter
     * @param options
     */
    fun dataSetsMatchingPattern(
      filter: Array<String>,
      options: IDsmListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Copies a dataSet.
     *
     * @param fromDataSetName
     * @param toDataSetName
     * @param enq possible values : {SHR, SHRW, EXCLU}
     * @param replace
     */
    fun copyDataSet(
      fromDataSetName: String,
      toDataSetName: String,
      enq: String = definedExternally,
      replace: Boolean = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }

  /**
   * API for providing am JES API handler to the extension.
   */
  interface IJes : ICommon {
    /**
     * Returns a list of jobs for any parameters.
     *
     * @param owner
     * @return an array if IJob
     */
    fun getJobsByParameters(params: IGetJobsParms): Promise<Array<IJob>>

    /**
     * Returns a list of jobs for a specific user and prefix.
     *
     * @param owner
     * @param prefix
     * @return an array if IJob
     */
    @Deprecated("Use getJobsByParameters")
    fun getJobsByOwnerAndPrefix(
      owner: String,
      prefix: String,
    ): Promise<Array<IJob>>

    /**
     * Returns meta-data for one specific job identified by id.
     *
     * @param jobid
     */
    fun getJob(jobid: String): Promise<IJob>

    /**
     * Returns spool file meta-data for a job.
     *
     * @param jobname
     * @param jobid
     */
    fun getSpoolFiles(
      jobname: String,
      jobid: String,
    ): Promise<Array<IJobFile>>

    /**
     * Retrieves content for all spool files as specified in the parms
     * to be store in a file.
     *
     * @param parms
     */
    fun downloadSpoolContent(parms: IDownloadAllSpoolContentParms): Promise<Unit>

    /**
     * Retrieves a single spool file content as specified in the parms
     * to be store in a file.
     *
     * @param parms
     */
    fun downloadSingleSpool(parms: IDownloadSpoolContentParms): Promise<Unit>

    /**
     * Returns spool file content as a string.
     *
     * @param jobname
     * @param jobid
     * @param spoolId
     */
    fun getSpoolContentById(
      jobname: String,
      jobid: String,
      spoolId: Int,
    ): Promise<String>

    /**
     * Returns the JCL of a job as a string.
     *
     * @param job
     */
    fun getJclForJob(job: IJob): Promise<String>

    /**
     * Submits a job with the JCL provided returning job meta-data.
     *
     * @param jcl string of JCL that you want to be submit
     * @param internalReaderRecfm record format of the jcl you want to submit. "F" (fixed) or "V" (variable)
     * @param internalReaderLrecl logical record length of the jcl you want to submit
     * @return IJob document with details about the submitted job
     */
    fun submitJcl(
      jcl: String,
      internalReaderRecfm: String = definedExternally,
      internalReaderLrecl: String = definedExternally,
    ): Promise<IJob>

    /**
     * Submits a job that is stored in the data set name provided returning job meta-data.
     *
     * @param jobDataSet
     */
    fun submitJob(jobDataSet: String): Promise<IJob>

    /**
     * Cancels the job provided.
     *
     * @param job The job object to cancel
     * @return Whether the job was successfully cancelled
     */
    fun cancelJob(job: IJob): Promise<Boolean>

    /**
     * Cancels and purges a job identified by name and id.
     *
     * @param jobname
     * @param jobid
     */
    fun deleteJob(
      jobname: String,
      jobid: String,
    ): Promise<Unit>

    /**
     * Cancels and purges a job identified by name and id.
     * This version returns information about the status of the job
     *
     * @param jobname
     * @param jobid
     */
    fun deleteJobWithInfo(
      jobname: String,
      jobid: String,
    ): Promise<IJobFeedback?>
  }

  /**
   * API for providing a Command API handler to the extension.
   */
  interface ICommand : ICommon {
    /**
     * Issues a TSO Command and returns a TsoSend API response.
     *
     * @param command
     * @param acctNum
     */
    @Deprecated("Use issueTsoCommandWithParms")
    fun issueTsoCommand(
      command: String,
      acctNum: String = definedExternally,
    ): Promise<IIssueResponse>

    /**
     * Issues a TSO Command and returns a TsoSend API response.
     *
     * @param command
     * @param parms
     */
    fun issueTsoCommandWithParms(
      command: String,
      parms: IStartTsoParms = definedExternally,
    ): Promise<IIssueResponse>

    /**
     * Issues a MVS Command and returns a Console Command API response.
     *
     * @param command
     */
    fun issueMvsCommand(command: String): Promise<IConsoleResponse>
  }

  /**
   * This interface can be used by other VS Code Extensions to access an alternative
   * profile types that can be employed in conjunction with the primary profile to provide
   * alternative support.
   *
   */
  interface IApiExplorerExtender {
    /**
     * Allows extenders access to the profiles loaded into Zowe Explorer.
     * This includes profiles of other extenders. Called reloadProfiles()
     * in case other extensions might have registered themselves before accessing.
     * See the ProfilesCache class for the available accessors. When making changes
     * to the profile in this cache remember that it shared with Zowe Explorer and
     * all other Zowe Explorer extensions
     * @version 1.18 or newer of Zowe Explorer
     */
    fun getProfilesCache(): ProfilesCache

    /**
     * After an extenders registered all its API extensions it
     * might want to request that profiles should get reloaded
     * to make them automatically appears in the Explorer drop-
     * down dialogs.
     */
    fun reloadProfiles(profileType: String = definedExternally): Promise<Unit>

    /**
     * After an extenders registered all its API extensions it
     * might want to check for an existing profile folder with meta-file
     * or to create them automatically if it is non-existant.
     */
    fun initForZowe(
      type: String,
      profileTypeConfigurations: Array<ICommandProfileTypeConfiguration> = definedExternally,
    ): Promise<Unit>
  }

  /**
   * This interface can be used by other VS Code Extensions to register themselves
   * with additional API implementations. The other extension would implement one or
   * more interfaces above, for example MyZoweExplorerAppUssApi, and register it with
   * the object returned by this extensions activate() method as shown below.
   *
   * Example:
   * ```
   * // see if Zowe Explorer is installed and retrieve the API Registry
   * const explorerApi = extensions.getExtension('zowe.vscode-extension-for-zowe');
   * if (explorerApi && explorerApi.exports) {
   *   // Cast the returned object to the IApiRegisterClient interface
   *   const importedApi: ZoweExplorerApi.IApiRegisterClient = explorerApi.exports;
   *   // create an instance of my API and register it with Zowe Explorer
   *   importedApi.registerUssApi(new MyZoweExplorerAppUssApi());
   *   window.showInformationMessage(
   *     'Zowe Explorer was augmented for MyApp support. Please, refresh your explorer views.');
   *   } else {
   *   window.showInformationMessage(
   *     'Zowe VS Extension was not found: either not installe or older version.');
   * }
   * ```
   */
  interface IApiRegisterClient {
    /**
     * Register a new implementation of the USS Api.
     * See example in Interface docs.
     *
     * @param ussApi
     */
    fun registerUssApi(ussApi: IUss)

    /**
     * Lookup of an API for USS for a given profile.
     * @param profile
     * @return the registered API instance for the given profile
     */
    fun getUssApi(profile: IProfileLoaded): IUss

    /**
     * Register a new implementation of the MVS Api.
     * See example in Interface docs.
     *
     * @param mvsApi
     */
    fun registerMvsApi(mvsApi: IMvs)

    /**
     * Lookup of an API for MVS for a given profile.
     * @param profile
     * @return the registered API instance
     */
    fun getMvsApi(profile: IProfileLoaded): IMvs

    /**
     * Register a new implementation of the JES Api.
     * See example in Interface docs.
     *
     * @param jesApi
     */
    fun registerJesApi(jesApi: IJes)

    /**
     * Lookup of an API for JES for a given profile.
     * @param profile
     * @return the registered API instance
     */
    fun getJesApi(profile: IProfileLoaded): IJes

    /**
     * Register a new implementation of the Command Api.
     * See example in Interface docs.
     *
     * @param commandApi
     */
    fun registerCommandApi(CommandApi: ICommand)

    /**
     * Lookup of an API for Issuing a Command for a given profile.
     * @param profile
     * @return the registered API instance
     */
    fun getCommandApi(profile: IProfileLoaded): ICommand

    /**
     * Lookup of an API for the generic extender API.
     * @return the registered API instance
     */
    fun getExplorerExtenderApi(): IApiExplorerExtender

    /**
     * Get an array of all the registered APIs identified by the CLI profile type names,
     * such as ["zosmf", "zftp"].
     */
    fun registeredApiTypes(): Array<String>

    /**
     * Define events that fire whenever an existing team config profile is updated.
     */
    var onProfilesUpdate: vscode.Event<EventTypes>?

    /**
     * Lookup of any registered API (Uss, Mvs, Jes, or Command).
     * @param profile
     * @return the registered API instance
     */
    fun getCommonApi(profile: IProfileLoaded): ICommon
  }
}
