/**
 * Recursive object containing data for a node of web help command tree
 * @export
 * @interface IWebHelpTreeNode
 */
export interface IWebHelpTreeNode {
    /**
     * Name of HTML file corresponding to the node
     * @type {string}
     * @memberof IWebHelpTreeNode
     */
    id: string;
    /**
     * Display name for the node which includes full name and aliases
     * @type {string}
     * @memberof IWebHelpTreeNode
     */
    text: string;
    /**
     * List of child nodes
     * @type {IWebHelpTreeNode[]}
     * @memberof IWebHelpTreeNode
     */
    children?: IWebHelpTreeNode[];
}
