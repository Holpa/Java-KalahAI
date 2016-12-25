


//tactic 1: search for spot that the last bean will drop in my hole
// tactic 2: search for spot that the last bean will drop in MY empty space
// tactic 3: pick biggest hole and use it.

public class KalahAISmart implements KalahAI{
	public Position chooseMove(GameState state) {
		Position move = null;
		GameState Clone= (GameState) state.clone(); // making clone of the game.
		move=findBestMove(Clone,move,6); // calling best move method to find which position will give you the optimum move
		return move;
	}
	// tactic 1 and 2 recursivly 
	public Position findBestMove(GameState Clone,Position fBPos, int holeNumber)
	{
		if(Clone.isTopPlayerTurn())
		{
			
			fBPos= Clone.createPosition(Clone.isTopPlayerTurn(),holeNumber);
			Position fBPos2;
			// if we endedup non of the tactics runing we will do the simple move tactic 
			if(holeNumber==0)
			{
				fBPos=findMove(Clone,fBPos);
				return fBPos;
			}
			// tactic 1: find the free move 
			if(Clone.getBeanCount(fBPos)== holeNumber)
			{
				return fBPos;	
			}
			// tactic 2: find the other side beans.
			if(Clone.getBeanCount(fBPos)<=holeNumber)
			{
				
				fBPos2= Clone.createPosition(Clone.isTopPlayerTurn(), Clone.getBeanCount(fBPos));
				if(Clone.getBeanCount(fBPos)== (fBPos.getHoleNumber()-fBPos2.getHoleNumber())&& Clone.getBeanCount(fBPos2)==0)
				{
					return fBPos;
				}
			}		
			fBPos=findBestMove(Clone,fBPos,--holeNumber);
			//System.out.println("worst case "+holeNumber);
			return fBPos;
			}else // if the CPU is playing as second player
			{
				
				fBPos= Clone.createPosition(Clone.isTopPlayerTurn(),holeNumber);
				Position fBPos2;// create imaginary position to evaluate the result ( mini back tracking )
				if(holeNumber==0)
				{
					fBPos=findMove(Clone,fBPos);
					return fBPos;
				}
				// tactic 1: find the free move 
				if(Clone.getBeanCount(fBPos)== (7-holeNumber)) // checking if the beans would reach to the POT
				{
					return fBPos;	
				}
				// tactic 2: flick the other side beans.
				if(Clone.getBeanCount(fBPos)>=holeNumber && Clone.getBeanCount(fBPos)<6)
				{
					fBPos2= Clone.createPosition(Clone.isTopPlayerTurn(), Clone.getBeanCount(fBPos)+1);
					if((Clone.getBeanCount(fBPos))== (fBPos2.getHoleNumber()-fBPos.getHoleNumber())&& Clone.getBeanCount(fBPos2)==0) // see if we will end up into empty spot of ours
					{
						return fBPos;
					}
				}		
				fBPos=findBestMove(Clone,fBPos,--holeNumber); // recursive to the next hole
				return fBPos;
			}
			
	}
	
	//find most beans and use them tactic 3 worst case, which is simply just search for the biggest beans in the pots!
	public Position findMove(GameState Clone,Position fPos)
	{
		int Cbeans=0;
		int Mbeans=0;
		Position Move=null;
		for (int i = 1; i <= Clone.getHolesPerPlayer(); i++){
			fPos = Clone.createPosition(Clone.isTopPlayerTurn(), i);
			Cbeans = Clone.getBeanCount(fPos);
			if (Cbeans > Mbeans) {
				Mbeans = Cbeans;
				Move = fPos;
				
			}
			
		}
		return Move;
	}
}
