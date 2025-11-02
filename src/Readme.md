# Task_Tooling - Siemens India
Author: Mallikarjunaiah B M

This program solves the given Task_Tooling problem.

Steps:
1. Place all input lines (each bag string) into `input.txt`.
2. Compile and run the program:
   javac ToolingTask.java
   java ToolingTask

Output:
- Prints the common item and its priority per line.
- Displays the total priority sum at the end.

---------------------------------------------------
Approach Summary
---------------------------------------------------
- Each bag string is divided into two compartments.
- When the total number of items is even, both halves are equal.
- When the number of items is odd, as observed from the example cases,
  the first compartment is taken one character smaller than the second.
  This ensures the correct result.
- The items from the first compartment are added to a HashSet for O(1)
  lookup time.
- The program then iterates through the second compartment to find the
  first matching character that exists in the HashSet.
- Once the common character is found, it is converted to a numeric
  priority:
    - a–z → 1–26
    - A–Z → 27–52
- All such priorities are summed to compute the total priority value.

This HashSet-based approach provides optimal time efficiency by avoiding
nested loops and performing constant-time lookups.

---------------------------------------------------
Boundary Conditions and Problems Solved
---------------------------------------------------
- For even-length item strings, both compartments are exactly equal.
- For odd-length strings, the first half is one item smaller than the
  second half, following the logic derived from example observations.
- HashSet ensures efficient existence checking of characters.
- The entire process runs in linear time relative to the string length.

---------------------------------------------------
Comparison with ChatGPT (LLM Analysis)
---------------------------------------------------
I have used ChatGPT to analyze and validate my approach.
The model suggested a similar method that uses two HashSets (one for
each compartment) to find the intersection. However, my version uses
only one HashSet for the first compartment and directly scans the
second compartment, achieving the same result more efficiently.

Additionally, ChatGPT initially failed to recognize the even–odd
pattern in compartment division. It always assumed an exact half split
for all cases, which leads to incorrect results when the total length
of items is odd. My implementation correctly handles this scenario
based on observed examples. Therefore, I retained my original approach
as it is both optimal and logically consistent with the problem
examples.
