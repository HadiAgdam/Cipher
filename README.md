# Acrypt

Acrypt is a command-line tool for encrypting and decrypting text using passwords and sets of keys. It also provides an option to hide the length of the text.


### Encrypt Function

The `encrypt` function transforms the input text into an encrypted form using the provided password and key set. Here’s a breakdown of how it works:

1. **Padding**: If the `hideLength` argument is set to `1`, the function pads the text with `*` characters until its length is a power of 2. This is done to obscure the original length of the text.
2. **Encryption**: Each character in the text is replaced based on its position, the password, and the key set. The character's index in the `chars` list is incremented by the sum of:
    - The password value for the current position.
    - The key value for the current position.
    - The length of the text.

   This transformation is applied to each character in the text.

### Hide Length Function

The `hideLength` option is used during encryption to obscure the length of the text. When `hideLength` is set to `1`:
- The text is padded with `*` characters until its length becomes a power of 2.
- This padding helps to prevent revealing the length of the original text, adding an extra layer of obfuscation.

When `hideLength` is set to `0` or not provided, the text is encrypted without any padding, and the length remains visible.



## Features

- **Encryption**: Encrypt text using a password and a set of keys.
- **Decryption**: Decrypt text using the same password and set of keys.
- **Hide Length**: Optionally hide the length of the text during encryption.

## Prerequisites

- Java Runtime Environment (JRE) 8 or later.

## Download

Download the latest release of `acrypt.jar` from the [releases](link-to-your-release) section.

## Usage

To use Acrypt, run the JAR file with the required arguments. Open a terminal or command prompt and use the following syntax:

```bash
java -jar acrypt.jar <command> <password> <keySet> <text> [hideLength]
```

### Arguments

- `<command>`: Specify `e` for encryption or `d` for decryption.
- `<password>`: The password used for encryption or decryption.
- `<keySet>`: The set of keys used for encryption or decryption.
- `<text>`: The text to encrypt or decrypt.
- `[hideLength]` (optional): Specify `1` to hide the length of the text during encryption. By default, it is `0` (false).

### Examples

- **Encrypt Text**
```bash
java -jar acrypt.jar e "password" "1-2-3 22-4" "Hello, World!" 1
- ```


This command encrypts `"Hello, World!"` with the password `"password"`, using the key set `"1-2-3 22-4"`, and hides the length of the text.

- **Decrypt Text**
```bash
java -jar acrypt.jar d "password" "1-2-3 22-4" "EncryptedTextHere" 0
```
This command decrypts `"EncryptedTextHere"` with the password `"password"`, using the key set `"1-2-3 22-4"`, and does not hide the length of the text.

