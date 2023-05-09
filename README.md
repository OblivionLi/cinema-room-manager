# cinema-room-manager
An easy project provided by JetBrains Academy to learn arrays/loop/etc.
##### *Disclaimer - this project doesn't include OOP concepts because the lecture focuses only on learning arrays(multidimensional arrays)/loops and other basic Java syntax*

The program prompts the user to provide a number of rows and seats that will create the cinema room and then the user can choose a number of options to manipulate the room/show details about it.
#### The first inputs of the user will create a multidimensional array with their values as sizes for rows and columns:
```
    1   2   3   4   5   6
  +---+---+---+---+---+---+
1 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
2 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
3 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
4 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
5 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
6 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
  ```

#### Then the program prompts the user to choose an option from a menu list:

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit

## Number 1 option shows the seats (including the seats bought if any)

#### No seats bought yet:
```
    1   2   3   4   5   6
  +---+---+---+---+---+---+
1 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
2 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
3 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
4 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
5 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
6 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
  ```

#### With seats bought (at position 2-2 indicated by "B"):
```
    1   2   3   4   5   6
  +---+---+---+---+---+---+
1 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
2 | S | B | S | S | S | S |
  +---+---+---+---+---+---+
3 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
4 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
5 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
6 | S | S | S | S | S | S |
  +---+---+---+---+---+---+
  ```

## Number 2 option allows the user to buy a ticket at X row and Y seat (it will be indicated by the char. "B" in the array)
## Number 3 option displays the statistics of the Cinema Room:
- Number of purchased tickets: 1
- Percentage: 2.78% (of tickets bought)
- Current income: $10 (the price of the current ticket, for front rows $10 and for the back rows $8)
- Total income: $324 (the total income if all the seats were bought)
