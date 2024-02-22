declare function vscodeBefore(fn: Function): void;
declare function vscodeBefore(name: string, fn: Function): void;
declare function vscodeBeforeEach(fn: Function): void;
declare function vscodeBeforeEach(name: string, fn: Function): void;
declare function vscodeAfter(fn: Function): void;
declare function vscodeAfter(name: string, fn: Function): void;
declare function vscodeAfterEach(fn: Function): void;
declare function vscodeAfterEach(name: string, fn: Function): void;
export { vscodeBefore as before, vscodeBeforeEach as beforeEach, vscodeAfter as after, vscodeAfterEach as afterEach };
