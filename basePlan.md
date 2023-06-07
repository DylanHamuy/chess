##Packages
- Chess.board
  - board.java, tile.java
- Chess.player
  - player.java, AI classes
##Classes
- board.java
- tile.java
- player.java
- Main.java
- game.java
- command.java
- pieces.java
  - pawn.java
  - rook.java
  - knight.java
  - bishop.java
  - king.java
  - queen.java
##Class Descriptions
###board.java
This is the class that is responsible for representing the chess board. Some methods will include, 
`clear()`, `gameOver()`, `get(tile coordinate)`, `move()`, `isValidMove()`
###tile.java
This is the class that is responsible for representing a given square on the chessboard. I think it
will be an enum that stores what type of object, if any, lies in the square.
###player.java
This is the class responsible for representing a player in chess. We need to keep track of the color
of the player, which pieces they have on the board, which pieces they have captured, time remaining.
###Main.java
Handles the initialization of the game, such as creating the Game instance, setting up the board, 
initializing players, and starting the game loop. 
###game.java
This class can handle the overall flow of the game, including turn management, checking for checkmate
or stalemate, handling game termination conditions, and enforcing the rules of chess. This can help
keep the responsibilities of each class focused and improve code organization.
###command.java
This class will be responsible for interpreting user input.
###display.java
A class responsible for displaying the board and interacting with the user.
###piece.java
class that serves as a blueprint for all the chess pieces. Each specific piece (e.g., chess.piece.Pawn, chess.piece.Rook, etc.) 
would then be a subclass of the chess.piece.Piece class, inheriting common functionality and allowing for easy 
expansion or modification of behavior.