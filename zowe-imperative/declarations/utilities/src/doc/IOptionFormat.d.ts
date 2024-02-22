export interface IOptionFormat {
    /**
     * The camel cased format of an option.
     *
     * Example:
     * ---
     *
     * this-is-a-test -> thisIsATest
     */
    camelCase: string;
    /**
     * The kebab cased format of an option key
     *
     * Example:
     * ---
     * thisIsATest -> this-is-a-test
     */
    kebabCase: string;
    /**
     * The untouched original key.
     *
     * Example:
     * ---
     * thisIsATest-test-here -> thisIsATest-test-here
     *
     * camelCase: thisIsATestTestHere
     * kebabCase: this-is-a-test-test-here
     */
    key: string;
}
