import { IImperativeErrorParms } from "../../../error/src/doc/IImperativeErrorParms";
/**
 * Options that will affect the behavior of the ProfileInfo class.
 * They are supplied on the ProfileInfo constructor.
 */
export interface IProfInfoErrParms extends IImperativeErrorParms {
    /**
     * This property is used when an error is returned that is related
     * to a number of configuration items. For example, if a problem is
     * identified that affects a subset of profiles, those affected
     * profiles can be identified in the itemsInError array. An app can
     * easily identify each affected profile by traversing itemsInError.
     */
    itemsInError?: string[];
}
