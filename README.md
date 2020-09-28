# kata04
Answers to questions:

1. To what extent did the design decisions you made when writing the original programs make it easier or harder to factor out common code?

   Much harder. Since I decided not to bother with Files.lines() and stream to a lambda function (the task was so easy) my original logic was much easier to just replicate in the final product because of time constraints.
   
2. Was the way you wrote the second program influenced by writing the first?

   Yes, of course. My original solution was easy to replicate with minor changes owing to differences in the data format.
   
3. Is factoring out as much common code as possible always a good thing? Did the readability of the programs suffer because of this requirement? How about the maintainability?

   It is not always a good thing. Specific use-cases create differing edge-cases. By combining two use-cases into one flow of logic, some things were improved, like the use of parameterization for field indexes, and the use of Math.abs() to eliminate the sign on subtractions. But this is little more than a temporary adjustment to catch an additional use-case. New data formats will require brand-new thinking about edge cases, and this code merely squeaks past the finish line. Moreover, the proliferation of parameters in the final result makes the code less functional, more fragile, less reliable, and more difficult to maintain.
   
   With more time and thought the code could be made more idiomatic. Using Streams would reduce the number of conditionals and getSpread() could take values instead of indexes into an array. findMinSpreadLabel() would require less code and have lower cyclomatic complexity. It's just too late at night to refactor, my only excuse.
   
   Because this kata involves just two examples, it didn't trip the Rule of Three (Fowler), so extensive refactoring of the basic logic flow was not triggered.
   
   There are more complicated and general-purpose solutions, but using one of them really requires knowing more about the broader problem, and the kata doesn't provide that. More-complicated solutions typically require the use of more-complicated regexes, general-purpose data loaders, or complicated (or even behavioral) model classes. Given the problem space, these are premature complexity, which I find abhorrent.

   I declined to use any Spring Boot functionality, since there is no need whatsoever for it.
