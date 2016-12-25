/**
 *
 * ICS 23 Summer 2004
 * Project #2: End of the Game
 *
 *
 * The GameState interface describes the behavior of an object that stores
 * the current state of a Kalah game.  You may not find all of these methods
 * useful in your solution.
 *
 * (You can ignore the fact that GameState extends the GameStateView
 * interface.)
 */

public interface GameState
extends
	GameStateView,
	Cloneable
{
	/** 
   * Makes a copy of this GameState object.  You'll find cloning to
   * be necessary as you work your way through your AI algorithm, since the
   * AI explores hypothetical game states, but shouldn't actually apply any
   * moves to the actual game state.
   *
   * @param
   * @return a copy of the GameState object
   */
	Object clone();

	/** 
   * Returns true if it's the top player's turn, and false if it's the
   * bottom player's turn.
   *
   * @param
   * @return boolean representing the current player.  True for the top
   * player, false for the bottom.
   */
  boolean isTopPlayerTurn();

	/**
   * Returns the number of holes on each player's side of the board, not
   * including the pot.
   *
   * @param
   * @return number of holes
   */
	int getHolesPerPlayer();

	/** 
   * Returns the number of beans in the hole indicated by the given
   * Position object. 
   *
   * @param
   * @return number of beans in a hole position
   * @see Position
   */
	int getBeanCount(Position position);

	/**
   * Creates a new Position object.  If you'd like to indicate
   * one of the top player's positions, pass true for topPosition, otherwise
   * pass false.  The hole number may be either a number from 1..n (where n is
   * the number of holes per player), or it may be the constant Position.POT,
   * if you'd like the position to represent one of the player's pots.
   *
   * @param topPosition  indicate the top or bottom player
   *        holeNumber   the hole location
   * @return new position object representing the hole location
   */
	Position createPosition(boolean topPosition, int holeNumber);

	/** Returns true if the game is over and false otherwise.
   *
   * @param
   * @return true if the game is over, false otherwise.
   */
	boolean gameOver();

	/**
   * Evaluates whether it is possible to make a move with the
   * given Position (i.e. whether it's legal to take all of the beans from the
   * given position and redistribute them).  If it is legal, this method has
   * no effect.  If the move is illegal, this method throws an
   * InvalidMoveException.
   *
   * @param position a particular hole.
   * @return
   * @see Position
   */ 
	void checkValidMove(Position position)
    throws InvalidMoveException;

	/** Applies a move with the given Position, taking all of the
   * beans from that position and redistributing them according to the rules.
   * If the move is not legal, an InvalidMoveException is thrown.
   *
   * @param position a particular hole.
   * @return
   * @see Position
   */
   void applyMove(Position position)
     throws InvalidMoveException;
}
