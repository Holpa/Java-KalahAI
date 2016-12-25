/** 
 *
 * ICS 23 Summer 2004
 * Project #2: End of the Game
 *
 * The Position interface describes the behavior of an object that stores
 * a position.  A position is defined as one of the holes on the board,
 * and is essentially made up of a boolean value that indicates whether
 * it is a "top" or "bottom" position (depending on which player owns the
 * hole) and a hole number.  The pots are legal positions; their hole number
 * is indicated by the constant Position.POT.  You should use this constant
 * in your code, never relying on its hard-coded value (which theoretically
 * could be changed for the tournament).
 *
 * You likely will not find all of these methods useful in your AI.
 * Some of them are primarily used by the parts of the game that I've
 * provided.
 */

public interface Position
extends Cloneable
{
	// This constant indicates the hole number of a pot.  Do not change the
	// value of this constant.
	static final int POT = 0;

	/** 
   * Makes a copy of this Position object.
   *
   * @param
   * @return copy of this object
   */
	Object clone();

	/**
   * Returns true if this position is a "top" position, or false if it's a
   * "bottom" position. 
   *
   * @param 
   * @return true if this position is a "top" position, or false if it's a
   * "bottom" position. 
   */
	boolean isTopPosition();

	/**
   * Returns the hole number of this position, typically between 1 and the
   * number of holes per player (inclusive).  If this position indicates a
   * pot, Position.POT is returned.
   *
   * @param 
   * @return number corresponding to this postion.
   */
	int getHoleNumber();

	/**
   * Returns the number of holes per player on the board with which this
   * position is associated. 
   *
   * @param
   * @return number of holeas each player has in front of them.
   */
	int getHolesPerPlayer();

	/**
   * Moves this position one hole clockwise.
   *
   * @param
   * @return
   */
	void moveClockwise();

	/**
   * Moves this position one hole counterclockwise.
   *
   * @param
   * @return
   */
	void moveCounterclockwise();

	/**
   *  Moves this position to the opposite side of the board.
   *
   * @param
   * @return
   */
	void moveToOppositePosition();
}
