# ICSI 409 - Option 2, Student 1

## Language & Membership Module

Selected proof: the regular-language Pumping Lemma for

L = {0^n 1^n | n >= 0}

This language contains all strings with the same number of 0s and 1s, where every 0 comes before every 1. The empty string is included because n may be 0.

Examples in the language: `""`, `01`, `0011`, `000111`.

Examples not in the language: `0`, `001`, `0101`, `111000`.

## Files

- `Language.java`: defines the language and checks whether a string is a member.
- `LanguageTest.java`: runs 16 membership tests.

## Run

Open a terminal in this folder with Java installed:

```sh
javac Language.java LanguageTest.java
java Language
java LanguageTest
```

## How the group uses this module

The other modules can call:

```java
boolean belongs = Language.isMember("0011");
String description = Language.getDescription();
```

`isMember` returns `true` for a valid string and `false` otherwise. No objects need to be created because these methods are `static`.

## How the membership check works

1. Return false if the input is null.
2. Count all zeros at the start of the string.
3. Count all ones immediately after the zeros.
4. Return true only if the entire string was processed and the counts match.

The empty string is valid since it has zero zeros followed by zero ones. Strings such as `0101` are invalid because a zero appears after a one.

