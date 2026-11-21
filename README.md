# MEDI Score Calculator

## Project Overview

This is my Java solution to the Aire Logic Junior Technical Test.

The program calculates a patient's MEDI score using their respiration rate, SpO2, consciousness, temperature and whether they require supplemental oxygen.

## My Approach

When approaching this task, I used computational thinking by breaking the problem down into smaller, more manageable steps.

Rather than trying to build the whole calculator at once, I focused on calculating each score individually, such as respiration rate, SpO2, consciousness, temperature and whether the patient required supplemental oxygen.

I used `if`, `else if` and `else` statements to calculate each score, working through one section at a time before combining them to calculate the patient's total MEDI score.

## Testing

Once I had finished building my MEDI Score Calculator, I wanted to test it to make sure it could calculate scores for different patients rather than just one.

I started by using the three example patients provided in the task, checking whether the calculator returned the expected scores of 0, 4 and 8.

I then added more tests using different patient observations, including values at the boundaries of the scoring ranges, to check that the calculator was giving the correct results.

In total, I ran 43 automated tests, and they all passed.

## How to Run the Program

1. Open the project in IntelliJ IDEA or another Java development environment.
2. Open `MediScoreCalculator.java`.
3. Run the `main()` method.
4. The console will display the automated test results.

The `calculateMediScore()` method can also be used with different patient observations to calculate their MEDI scores.

## Future Improvements

If I had more time to work on this project, I would focus on making my code cleaner and easier to read.

With my current Java knowledge, I found that using `if` and `else if` statements was the most straightforward way to complete the task.

However, as I develop my programming skills, I would like to explore other approaches that could make the code more organised while still producing the same correct results.