# Bit Manipulation

## Bitwise Operators

- `&` : **Bitwise AND** - if both bits are 1, then the result is 1, otherwise 0
- `|` : **Bitwise OR** - if any of the two bits is 1, then the result is 1, otherwise 0
- `^` : **Bitwise XOR** - if even 1s, then 0, otherwise 1
- `~` : **Bitwise NOT** - reverse the bits
- `<<` : **Left Shift** - shift the bits to the left - `a << b` => `a * 2^b`
- `>>` : **Right Shift** - shift the bits to the right - `a >> b` => `a / 2^b`
- `>>>` : **Right Shift with Zero fill** - shift the bits to the right and fill the left bits with 0 - `a >>> b` => `a / 2^b`

## Tricks and Techniques

- **Swap two numbers**
    - `a = a^b; b = a^b; a = a^b;`
- **Check if ith bit is set or not**
    - `n & (1 << i)` : res=0 => not set, res=1 => set
    - `(n>>i) & 1` : res=0 => not set, res=1 => set
- **Set ith bit**
    - `n | (1 << i)`
- **Clear ith bit**
    - `n & ~(1 << i)`
- **Toggle ith bit**
    - `n ^ (1 << i)`
- **Remove the last set bit**
    - `n & (n-1)` : result will have the last set bit removed from n
- **Check if a number is odd or even**
    - `n & 1` : res=0 => even, res=1 => odd
- **Check if a number is power of 2**
    - `n & (n-1) == 0` : res=0 => power of 2, res=1 => not power of 2
- **Count the number of set bits**
    - `Integer.bitCount(n)`
    - `while(n>0) { n = n & (n-1); count++; }`
- **Generate all the subsets of a set**