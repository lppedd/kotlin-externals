package zowe.explorer.api.tree

import js.objects.Record
import js.promise.Promise
import zowe.explorer.api.profiles.DataSetAllocTemplate
import zowe.explorer.api.profiles.PersistenceSchemaEnum
import zowe.imperative.profiles.doc.response.IProfileLoaded

external interface IZoweTree<T> : vscode.TreeDataProvider<T> {
  /**
   * Root session nodes
   */
  var mSessionNodes: Array<IZoweTreeNode>

  /**
   * Root favorites node
   */
  var mFavoriteSession: IZoweTreeNode

  /**
   * Array of favorite nodes
   */
  @Deprecated("should not be visible outside of class")
  var mFavorites: Array<IZoweTreeNode>

  /**
   * Defines the last node that was opened in the editor
   */
  var lastOpened: NodeInteraction?

  /**
   * Whether the tree is copying files.
   *
   * `await` this promise to wait for the copy operation to complete.
   */
  var copying: Promise<Any?>?

  /**
   * A record of open files from this tree.
   */
  var openFiles: Record<String, IZoweTreeNode>?

  /**
   * Adds a session to the container
   *
   * @param sessionName
   * @param type e.g. zosmf
   * @param provider tree provider to add to, undefined will add for all
   */
  fun addSession(
    sessionName: String = definedExternally,
    type: String = definedExternally,
    provider: IZoweTree<IZoweTreeNode> = definedExternally,
  ): Promise<Unit>

  /**
   * Adds a single session to the tree
   *
   * @param profile the profile to add to the tree
   */
  fun addSingleSession(profile: IProfileLoaded): Promise<Unit>

  /**
   * Edit a session to the container
   *
   * @param node This parameter identifies the node that needs to be called
   */
  fun editSession(
    node: IZoweTreeNode,
    zoweFileProvider: IZoweTree<IZoweTreeNode>,
  ): Promise<Unit>

  /**
   * Get sessions from persistent object of provider
   */
  fun getSessions(): Array<String>

  /**
   * Add a new session to the container
   *
   * @param zoweFileProvider The tree to which the profile should be added
   */
  fun createZoweSession(zoweFileProvider: IZoweTree<IZoweTreeNode>): Promise<Unit>

  /**
   * Create a brand new Schema
   *
   * @param zoweFileProvider The tree from which the schema will be created
   */
  fun createZoweSchema(zoweFileProvider: IZoweTree<IZoweTreeNode>): Promise<Unit>

  /**
   * Adds a favorite node
   *
   * @param favorite Adds a favorite node
   */
  fun checkCurrentProfile(node: IZoweTreeNode): Any?

  /**
   * Log in to authentication service
   *
   * @param node This parameter identifies the node that needs to be called
   */
  fun ssoLogin(node: IZoweTreeNode): Any?

  /**
   * Log out from authentication service
   *
   * @param node This parameter identifies the node that needs to be called
   */
  fun ssoLogout(node: IZoweTreeNode): Any?

  /**
   * Adds a favorite node
   *
   * @param favorite Adds a favorite node
   */
  fun addFavorite(favorite: IZoweTreeNode): Any?

  /**
   * Removes a favorite node
   *
   * @param favorite Adds a favorite node
   */
  fun removeFavorite(node: IZoweTreeNode): Any?

  /**
   * Removes profile node from Favorites section
   *
   * @param profileName
   */
  fun removeFavProfile(
    profileName: String,
    userSelected: Boolean,
  ): Any?

  /** Refreshes the tree */
  fun refresh()

  /**
   * Refreshes an element of the tree
   *
   * @param favorite Node to refresh
   */
  fun refreshElement(node: IZoweTreeNode)

  /** Event Emitters used to notify subscribers that the refresh event has fired */
  fun onDidChangeConfiguration(e: vscode.ConfigurationChangeEvent): Any?

  /**
   * Change the state of an expandable node
   *
   * @param element the node being flipped
   * @param isOpen the intended state of the the tree view provider, true or false
   */
  fun flipState(
    element: IZoweTreeNode,
    isOpen: Boolean,
  ): Any?

  /**
   * Rename the node. Begins a dialog.
   *
   * @param the node to be renamed
   */
  fun rename(node: IZoweTreeNode): Any?

  /**
   * Opens the node. Begins a dialog.
   *
   * @param node: the node to be opened
   * @param preview: open in preview of edit mode
   */
  fun open(
    node: IZoweTreeNode,
    preview: Boolean,
  ): Any?

  /**
   * Begins a copy operation on the node.
   *
   * @param node: the node to be copied
   */
  fun copy(node: IZoweTreeNode): Any?

  /**
   * Concludes a copy/paste operation on the node.
   *
   * @param node: the node to be pasted
   */
  fun paste(node: IZoweTreeNode): Any?

  /**
   * Deletes a node.
   *
   * @param node: the node to be deleted
   */
  fun delete(node: IZoweTreeNode): Any?

  /**
   * Reveals and selects a node within the tree.
   *
   * @param treeView: the vscode tree container
   * @param node: the node to be selected
   */
  fun setItem(
    treeView: vscode.TreeView<IZoweTreeNode>,
    node: IZoweTreeNode,
  ): Any?

  /**
   * Saves the currently employed filter as a favorite.
   *
   * @param node: A root node representing a session
   */
  fun saveSearch(node: IZoweTreeNode): Any?

  /**
   * Saves an edited file.
   *
   * @param node: the node to be saved
   */
  fun saveFile(document: vscode.TextDocument): Any?

  fun refreshPS(node: IZoweTreeNode): Any?

  fun uploadDialog(node: IZoweTreeNode): Any?

  /**
   * Begins a filter/search operation on a node.
   *
   * @param node: the root node to be searched from
   */
  fun filterPrompt(node: IZoweTreeNode): Any?

  /**
   * Adds a search history element to persisted settings.
   *
   * @param node: the root node representing the operation
   */
  fun addSearchHistory(element: String): Any?

  /** Retrieves search history elements from persisted settings. */
  fun getSearchHistory(): Any?

  /**
   * Returns the type of the tree provider.
   *
   * @return {PersistenceSchemaEnum} the type of tree: Dataset, USS, or Job
   */
  fun getTreeType(): PersistenceSchemaEnum

  /**
   * Deletes a root node from the tree.
   *
   * @param node: A root node representing a session
   * @param hideFromAllTrees: <optional> whether to hide from all trees or just the single tree
   */
  fun deleteSession(
    node: IZoweTreeNode,
    hideFromAllTrees: Boolean = definedExternally,
  ): Any?

  /**
   * Lets the user open a dataset by filtering the currently-loaded list
   */
  fun getAllLoadedItems(): Promise<Array<IZoweTreeNode>>

  /**
   * Retrieves the vscode tree container
   */
  fun getTreeView(): vscode.TreeView<IZoweTreeNode>

  /**
   * Finds an equivalent node but not as a favorite
   *
   * @param node
   */
  @Deprecated("should not be visible outside of class")
  fun findFavoritedNode(node: IZoweTreeNode): IZoweTreeNode

  /**
   * Finds the equivalent node but not as a favorite
   *
   * @param node
   */
  @Deprecated("should not be visible outside of class")
  fun findNonFavoritedNode(node: IZoweTreeNode): IZoweTreeNode

  /**
   * Finds the equivalent node, based on isFavorite
   *
   * @param node
   */
  fun findEquivalentNode(
    node: IZoweTreeNode,
    isFavorite: Boolean,
  ): IZoweTreeNode

  /**
   * Updates favorite
   */
  @Deprecated("should not be visible outside of class")
  fun updateFavorites(): Any?

  /**
   * Renames a node from the favorites list
   *
   * @param node
   */
  @Deprecated("should not be visible outside of class")
  fun renameFavorite(
    node: IZoweTreeNode,
    newLabel: String,
  ): Any?

  /**
   * Renames a node based on the profile and it's label
   *
   * @param criteria the member name to add
   */
  @Deprecated("should not be visible outside of class")
  fun addFileHistory(criteria: String): Any?

  /**
   * Returns the array of recently-opened member names
   *
   * @return {string[]} the array of recently-opened member names
   */
  fun getFileHistory(): Any?

  /**
   * Removes a member name from the recently-opened members array
   *
   * @param name the member to remove
   */
  fun removeFileHistory(name: String): Any?

  /**
   * Removes session from the session array
   *
   * @param name the sessions to remove
   */
  fun removeSession(name: String)

  /**
   * Returns a new dataset filter string, from an old filter and a new string
   *
   * @param newFilter the new filter to add
   * @param node the node with the old filter
   */
  fun createFilterString(
    newFilter: String,
    node: IZoweTreeNode,
  ): Any?

  fun renameNode(
    profile: String,
    beforeDataSetName: String,
    afterDataSetName: String,
  ): Any?

  /**
   * Opens an item & reveals it in the tree
   *
   * @param path the path of the item
   * @param sessionNode the session to use
   */
  fun openItemFromPath(
    path: String,
    sessionNode: IZoweTreeNode,
  ): Any?

  /**
   * Adds template for data set creation attributes
   *
   * @param criteria the member name to add
   */
  fun addDsTemplate(criteria: DataSetAllocTemplate)

  /**
   * Returns the array of saved templates for data set creation attributes
   *
   * @return the array of recently-opened member names
   */
  fun getDsTemplates(): Array<DataSetAllocTemplate>

  fun pollData(node: IZoweTreeNode): Any?
}
