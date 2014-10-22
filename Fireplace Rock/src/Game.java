public class Game
{
    Board p1Board,p2Board;
    Hero p1Hero, p2Hero;
    boolean currentTurn;
    public Game(Hero p1Hero, Hero p2Hero)
    {
        this.p1Board = p1Hero.alliedBoard;
        this.p2Board = p2Hero.alliedBoard;
        this.p1Hero = p1Hero;
        this.p2Hero = p2Hero;
        this.currentTurn = true;  
        this.p1Hero.heroHand[0] = new CardCoin(p1Hero);
        this.p1Hero.cardsLeftInHand++;
    }
    
    public void attack(int p1Index, int p2Index)
    {
    	boolean attackIsValid = false;
    	int tauntingMinions;
    	Minion attacker;
    	Minion defender;
    	Hero attackingTeam;
		tauntingMinions = 0;
		
		if (this.currentTurn)
		{			
			attacker = this.p1Board.get(p1Index);
			defender = this.p2Board.get(p2Index);
			attackingTeam = this.p1Hero;
		} else {
			attacker = this.p2Board.get(p2Index);
			defender = this.p1Board.get(p1Index);
			attackingTeam = this.p2Hero;
		}
		System.out.println(attacker.hasAwoken+" "+attacker.canAttack +attacker.getAttackDamage());
    	if (attacker.hasAwoken && attacker.canAttack && attacker.getAttackDamage()>0)
    	{
    		if (attackingTeam==this.p1Hero)
    		{
    			for (int i=0; i<this.p2Board.size();i++)
    			{
    				if (this.p2Board.get(i).hasTaunt && p2Index==i)
    				{
    					attackIsValid = true;
    				} else if (this.p2Board.get(i).hasTaunt)
    				{
    					tauntingMinions++;
    				}
    					
    			}
    		} 
    		if (attackingTeam==this.p2Hero)
    		{
    			for (int i=0; i<this.p1Board.size();i++)
    			{
    				if (this.p1Board.get(i).hasTaunt && p1Index==i)
    				{
    					attackIsValid = true;
    				} else if (this.p1Board.get(i).hasTaunt)
    				{
    					tauntingMinions++;
    				}
    					
    			}
    		}
    		if (attackIsValid || tauntingMinions==0)
    		{
    			
	            attacker.giveBasicEffect(new EffectDamage(defender.getAttackDamage()));
	            defender.giveBasicEffect(new EffectDamage(attacker.getAttackDamage()));
	        
	            p1Board.sendEventToAll(new Event(Event.CHECK_FOR_MINION_DEATH));
	            p2Board.sendEventToAll(new Event(Event.CHECK_FOR_MINION_DEATH));
    		} else {
    			System.out.println("Minions with taunt must be attacked first.");
    		}
    		
    	} else {
    		System.out.println("That cannot attack.");
    	}
    }
    public boolean progressTurn()
    {
        //returns true if is p1 turn, false if p2 turn
        if (this.currentTurn)
        {
            p1Hero.endTurn();
            p2Hero.startTurn();
            p2Board.sendEventToAll(new Event(Event.TURN_START));
        } else {
            p2Hero.endTurn();
            p1Hero.startTurn();
            p1Board.sendEventToAll(new Event(Event.TURN_START));
        }
        this.currentTurn = !this.currentTurn;   
        return this.currentTurn;
    }
}
