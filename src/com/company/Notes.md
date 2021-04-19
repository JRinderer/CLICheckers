#Checkers 2 Electric-Boogaloo

## Summary:
The objective is to rewrite and reorganize some of the code. Overall, for a quick build this wasn't too bad. However, some
ideas should be reworked. The purpose of this build is two fold.

1. Utilize the Game and Player classes more - especially trim down Main class
2. Clean up code and redesign a few classes.

##Overall Abstraction:

###Game.java:
The Game class will be responsible for:
1. Creating the board

2. Creating the players

3. Playing the game (getting user input, printing the board, etc)

### Player.java:

1. Tracking player turns.

2. Switching turns.

3. Determining what player won (some overlap with Game maybe?) Review player.gameOver class

4. Contemplate moving some code related to moving pieces here?

5. Possibly change Piece ownership from Board to Player?

### Piece (including RegularPiece & KingPiece):

Cleaning up the move code might be best. Right now the KingPiece is sort of pseudo created in the RegularPiece.
While it is in it's own class it doesn't do much as it extends RegularPiece and uses it's move function. Best practice
would be to write a move function for the KingPiece and have it simply implement the Interface Piece instead of 
inhereting from the RegularPiece. Since the two pieces are so different (amount of spaces to move) inheritance doesn't
make sense.

### Board.java & Square.java

These two classes are primitive, and written fairly well for what I wanted to do. Some further organization can be done

### Moves.java

This class has some complicated code, but I think the concept and structure is fair. Improvements to code can be made;
but structurally it's sound.


##Plan
I want to start with taking almost all of the code out of Main; and move it into Game. Then rework the Game class to be
what primarily organizes and manages the game.

I then want to modify the KingPiece class to include a move function, and rather than call the RegularPiece move function
call the one in KingPiece. 

I'd like to work on trimming Game up, and organizing it a little better in terms of how it's structured. Specifically in the playGame function. I think a lot of work can be done with Game to make it easier to read and understand.

Between Game and Player there seems to be a little cross over with gameOver. It seems this would make more sense to move in the Game class as opposed to the Player class.