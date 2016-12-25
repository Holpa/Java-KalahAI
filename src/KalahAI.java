/**
 *
 * ICS 23 Summer 2004
 * Project #2: End of the Game
 *
 * Your AI should be implemented in a class that implements this KalahAI
 * interface.  Remember that your AI class needs to follow a specific
 * naming convention.  It should be called "KalahAI[yourID#]".  So, if
 * your student ID# is 12345678, your AI class should be called
 * "KalahAI12345678".  Naturally, you should write that class in a file
 * called "KalahAI12345678.java".
 */

public interface KalahAI
{
	/**
   * Takes a GameState and chooses the best move, returning
   * a Position indicating what the move is.  For example, if the
   * appropriate move is to take the beans from the top hole #3, you'd
   * return that as a Position.  Note that you can create a Position
   * by calling the createPosition() method on the GameState.
   *
   * @param state a current game state
   * @return the position for the next move
   * @see GameState
   */
	
	public Position chooseMove(GameState state);
}
