import { CapturingGroup, Group, LookaroundAssertion, Pattern } from 'regexpp/ast';
/**
 * An alternation is a regexpp node that has an `alternatives` field.
 */
export type Alternation = Pattern | CapturingGroup | Group | LookaroundAssertion;
