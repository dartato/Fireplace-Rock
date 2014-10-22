public class UserInterface
{
    Hero p1;
    Hero p2;
    Board p1Board;
    Board p2Board;
    public UserInterface(Game game)
    {
        // this module will provide input/output for the user (will be replaced with graphics eventually)
        this.p1 = game.p1Hero;
        this.p2 = game.p2Hero;
        this.p1Board = game.p1Board;
        this.p2Board = game.p2Board;
    }
    public void displayBoard()
    {
        /* Basic board layout:
         * CARDS: ([1] Goldshire Footman (1/2): Taunt),([1] Goldshire Footman (1/2): Taunt),([5] Gurubashi Beserker (2/7): Every time this minion takes damage, gain +3 attack)
         * Mana: 0/6
         *+-----------------------------------------+
         *|              HeroName 0/30              |
         *|     |     |     |     |     |     |     |
         *|                                         |
         *|  1     2     3     4     5     6     7  |
         *|     |     |     |     |     |     |     |
         *|                                         |
         *|              HeroName 0/30              |
         *+-----------------------------------------+
         *Mana: 3/7
         *CARDS: ([1] Goldshire Footman (1/2): Taunt),([1] Goldshire Footman (1/2): Taunt),([5] Gurubashi Beserker (2/7): Every time this minion takes damage, gain +3 attack)
         *With minions:
         *
         *CARDS: ([1] Goldshire Footman (1/2): Taunt),([1] Goldshire Footman (1/2): Taunt),([5] Gurubashi Beserker (2/7): Every time this minion takes damage, gain +3 attack)
         *Mana: 0/6
         *+-----------------------------------------+
         *|             Basic Hero 0/30             |
         *|     |     |Golds|Gurub|     |     |     |
         *|            *1/2*  5/6                   |
         *|  1     2     3     4     5     6     7  |
         *|     |     |Sen'j|Chill|     |     |     |
         *|            *3/5*  4/5                   |
         *|              HeroName 0/30              |
         *+-----------------------------------------+        
         *Mana: 3/7
         *CARDS: ([1] Goldshire Footman (1/2): Taunt),([1] Goldshire Footman (1/2): Taunt),([5] Gurubashi Beserker (2/7): Every time this minion takes damage, gain +3 attack)
         */
        String output = "CARDS: ";
        this.p1.getHand();
        for (int i=0; i<this.p1.cardsLeftInHand; i++)
        {
            output += "(["+i+":"+this.p1.heroHand[i].manaCost+"] "+this.p1.heroHand[i].cardName+": "+this.p1.heroHand[i].cardText+")";
        }
        output +="\nMana: "+this.p1.currentMana+"/"+this.p1.totalMana+"\n+-----------------------------------------+\n|             "+this.p1.minionName+" "+this.p1.currentAttack+"/"+this.p1.currentHealth+"             |\n";
        // output += "|
        String minions = "";
        String stats = "";
        int unusedSpaces, spacesToLeft, spacesToRight;
        for (int i=0; i<p1Board.size();i++)
        {
            minions += "|"+(p1Board.get(i).minionName+"     ").substring(0,5);
            if (p1Board.get(i).hasTaunt)
            {
                stats += "|*"+p1Board.get(i).currentAttack+"/"+p1Board.get(i).currentHealth+"*";
            } else {
                stats += "| "+p1Board.get(i).currentAttack+"/"+p1Board.get(i).currentHealth+" ";
            }
            
        }        
        unusedSpaces = 7-p1Board.size();
        spacesToLeft = unusedSpaces/2;
        spacesToRight = unusedSpaces/2 + unusedSpaces%2;
        for (int i=spacesToLeft; i>0;i--)
        {
            minions = "|     "+minions;
            stats = "|     "+stats;
        }
        for (int i=spacesToRight; i>0;i--)
        {
            minions += "|     ";
            stats += "|     ";
        }
        output += minions+"|\n"+stats+"|\n|  1     2     3     4     5     6     7  |\n";
        minions = "";
        stats = "";
        for (int i=0; i<p2Board.size();i++)
        {
            minions += "|"+(p2Board.get(i).minionName+"     ").substring(0,5);
            if (p2Board.get(i).hasTaunt)
            {
                stats += "|*"+p2Board.get(i).currentAttack+"/"+p2Board.get(i).currentHealth+"*";
            } else {
                stats += "| "+p2Board.get(i).currentAttack+"/"+p2Board.get(i).currentHealth+" ";
            }
            
        }        
        unusedSpaces = 7-p2Board.size();
        spacesToLeft = unusedSpaces/2;
        spacesToRight = unusedSpaces/2 + unusedSpaces%2;
        for (int i=spacesToLeft; i>0;i--)
        {
            minions = "|     "+minions;
            stats = "|     "+stats;
        }
        for (int i=spacesToRight; i>0;i--)
        {
            minions += "|     ";
            stats += "|     ";
        }
        output += minions+"|\n"+stats+"|\n|             "+this.p2.minionName+" "+this.p2.currentAttack+"/"+this.p2.currentHealth+"             |\n+-----------------------------------------+\nMana: "+this.p2.currentMana+"/"+this.p2.totalMana+"\nCARDS:";
        
        this.p2.getHand();
        for (int i=0; i<this.p2.cardsLeftInHand; i++)
        {
            output += "(["+i+":"+this.p2.heroHand[i].manaCost+"] "+this.p2.heroHand[i].cardName+": "+this.p2.heroHand[i].cardText+")";
        }
        System.out.println(output+"\n_____________________________________________________________________________________");
    }
}
