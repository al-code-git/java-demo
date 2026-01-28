# Video outline: Teaching NullPointerException

**Goal**: Show how to reproduce, read, and prevent NullPointerException in Java.

## 1. Hook (30s)
- Show a quick crash, the stack trace, and explain that NPE means you dereferenced `null`.

## 2. Minimal repro (1m)
- Run `mvn exec:java` and highlight the first block in `Main` that calls `triggerNpeWithNullCall()`.
- Pause on the stack trace to point out the exact line and method.

## 3. Safer inputs (1m)
- Introduce `safeLength` and `defensiveDefault` as simple null checks.
- Emphasize returning sensible defaults and trimming inputs.

## 4. Fail fast (45s)
- Show `lengthWithRequireNonNull` to produce a clearer message when null is unacceptable.

## 5. Nested object access (2m)
- Contrast `userCityUnsafe` (throws) with `userCitySafe` and `userCityWithOptional` (guarded access and Optional chains).
- Highlight how each guard prevents null from propagating.

## 6. Tests as documentation (1m)
- Open `NullPointerExamplesTest`; run `mvn test` to prove both the failure mode and the fixes.

## 7. Wrap up (30s)
- Checklist for avoiding NPEs: validate inputs, fail fast on illegal nulls, guard nested access, add unit tests.
