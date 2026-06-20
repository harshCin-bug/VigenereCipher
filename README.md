# 🗝️ Vigenère Cipher: Polyalphabetic Substitution Algorithm

## Project Author & Affiliation
* **Author:** Harsh Chakravarti

---

## Executive Summary
This repository contains a Java-based implementation of the Vigenère Cipher, a classical polyalphabetic substitution algorithm. Unlike simple monoalphabetic ciphers (such as the Caesar Cipher) which use a single fixed shift, this algorithm utilizes a rotating keyword to dynamically alter the shift value for each character. This project demonstrates foundational knowledge of cryptographic diffusion and the algorithmic masking of data patterns.

## Detailed Explanation: How it Works
The Vigenère cipher operates by applying a series of interwoven Caesar ciphers based on the letters of a keyword. 

Mathematically, the encryption of a plaintext letter $P_i$ using a key letter $K_j$ is defined as:
$C_i = (P_i + K_j) \pmod{26}$

Where:
* $C_i$ is the resulting ciphertext character.
* $P_i$ is the numerical value of the plaintext character (A=0, B=1 ... Z=25).
* $K_j$ is the numerical value of the key character.

If the plaintext is longer than the keyword, the keyword is repeated cyclically until the entire message is encrypted.

### Step-by-Step Example
* **Plaintext:** `ATTACK`
* **Keyword:** `LEMON` (Repeated to match length: `LEMONL`)

**Encryption Process:**
1. **A (0)** shifted by **L (11)** $\rightarrow$ $0 + 11 = 11$ $\rightarrow$ **L**
2. **T (19)** shifted by **E (4)** $\rightarrow$ $19 + 4 = 23$ $\rightarrow$ **X**
3. **T (19)** shifted by **M (12)** $\rightarrow$ $(19 + 12) \pmod{26} = 5$ $\rightarrow$ **F**
4. **A (0)** shifted by **O (14)** $\rightarrow$ $0 + 14 = 14$ $\rightarrow$ **O**
5. **C (2)** shifted by **N (13)** $\rightarrow$ $2 + 13 = 15$ $\rightarrow$ **P**
6. **K (10)** shifted by **L (11)** $\rightarrow$ $10 + 11 = 21$ $\rightarrow$ **V**

**Final Ciphertext:** `LXFOPV`

*Notice that the two 'T's in the plaintext were encrypted into two different letters ('X' and 'F'). This is the core advantage of polyalphabetic substitution.*

## Algorithmic Logic (Java Implementation)
This program is optimized for string manipulation and memory efficiency:
* **Dynamic Indexing:** Instead of creating a massive array to hold a stretched keyword, the program uses the modulo operator (`keyIndex % key.length()`) to dynamically wrap the keyword on the fly, saving system memory.
* **ASCII Normalization:** Characters are converted to their 0-25 alphabetic index by subtracting the ASCII base value (e.g., `ch - 'A'`). After the shift is applied, the base is added back to output the correct ASCII character.
* **Data Sanitization:** The `Character.isLetter(ch)` function ensures that numbers, spaces, and punctuation bypass the mathematical shift, preserving the document's structural integrity.

## Security Context & Vulnerability Assessment
*Note: This algorithm is historically significant but is not suitable for modern data security.*

While the Vigenère Cipher successfully defends against basic Statistical Frequency Analysis (by mapping one plaintext letter to multiple ciphertext letters), it is still vulnerable to advanced cryptanalysis:
1. **The Kasiski Examination:** An attacker can look for repeated strings of characters in the ciphertext. The distance between these repeated strings usually reveals a multiple of the keyword length.
2. **Reduction to Caesar:** Once an attacker deduces the length of the keyword (e.g., 5 letters), they can split the ciphertext into 5 separate blocks. Each block is essentially encrypted with a standard monoalphabetic Caesar cipher, which can then be trivially broken using standard frequency analysis.
