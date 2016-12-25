/**
 *
 * ICS 23 Summer 2004
 * Project #2: End of the Game
 *
 * The KalahAIFactory's job is to create new objects of your KalahAI class.
 * The reason for this class is that my GUI won't know the name of your
 * class, since each of you will name your class differently.  So, the GUI
 * will call KalahAIFactory.createKalahAI() to create the object, and you'll
 * supply the code (which will likely only be one line) to create it.
 */

public class KalahAIFactory
{
	public static KalahAI createKalahAI()
	{
		// Replace the line of code below with a line of code that creates
		// and returns an object of your KalahAI class.  It's likely that
		// your line of code might be this simple, though you naturally
		// should use the name of your KalahAI class (including your
		// student ID#).
		//
		//     return new KalahAI12345678();

		KalahAI	KA= new KalahAISmart();
		return KA;
	}
}
