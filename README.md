# Acrypt Encryption/Decryption Program

This Kotlin program provides a simple encryption and decryption algorithm that uses a password and a set of keys. The program can also optionally hide the length of the encrypted text to add an additional layer of security.

## Overview

The program encrypts and decrypts text using a combination of a password and a key set. The encryption process involves shifting characters based on the values derived from the password, key set, and text length. The program supports both command-line execution and interactive mode.

## Features

- **Encryption/Decryption**: Encrypts and decrypts text using a password and a key set.
- **Hide Length**: Optionally hides the length of the text in the encrypted output.
- **Interactive Mode**: If no valid command-line arguments are provided, the program will enter an interactive mode, prompting the user for inputs.

## Usage

### Command-Line Execution

You can run the program directly from the command line with the following syntax:

---
java -jar acrypt.jar <command> <password> <key_set> <text> <hide_length>
---

- `<command>`: The operation to perform. Use `e` for encryption and `d` for decryption.
- `<password>`: The password to use for encryption/decryption. The password must adhere to the expected format.
- `<key_set>`: The key set to use for encryption/decryption, in the format of `1-23 4-78-91`.
- `<text>`: The text you want to encrypt or decrypt.
- `<hide_length>`: Boolean value (`true` or `false`) to determine whether to hide the length of the text in the encryption.

Example:

---
java -jar acrypt.jar e myPassword 1-23 4-78-91 "Hello, World!" true
---

### Interactive Mode

If the command-line arguments are not provided, the program will enter interactive mode. The user will be prompted to enter the necessary inputs one by one.

### Commands

- **e**: Encrypt the provided text.
- **d**: Decrypt the provided text.
- **q**: Quit the program (only available in interactive mode).

## Implementation Details

### Cipher Object

The `Cipher` object contains the core encryption and decryption logic. It uses the following character sets for processing:

- Uppercase letters (`A-Z`)
- Lowercase letters (`a-z`)
- Numbers (`0-9`)
- Symbols (`! @ # $ % ^ & *`)

The encryption and decryption processes involve shifting characters based on the password, key set, and text length. 

### Hide Length Option

If the `hideLength` option is enabled, the length of the text will be hidden by altering the shifts applied during encryption and decryption.

## Example

### Encrypting Text

---
java -jar acrypt.jar e "myPassword" "1-23 4-78-91" "Hello, World!" true
---

### Decrypting Text

---
java -jar acrypt.jar d "myPassword" "1-23 4-78-91" "EncryptedTextHere" true
---
ensed under the MIT License. See the [LICENSE](LICENSE) file for details.
