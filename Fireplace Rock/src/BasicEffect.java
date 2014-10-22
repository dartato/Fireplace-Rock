public class BasicEffect
{
    // Simple base class for defining an effect for pretty much anything
    String effectDescription;
    public BasicEffect()
    {
        effectDescription = "How the hell did this effect get on a minion?";
    }
    //And, finally, the effect of the effect... erm, stats that the effect produces.
    boolean doesDamage = false;
    boolean doesHeal = false;
    public int healAmount()
    {
        return 0;
    }
    public int damageAmount()
    {
        return 0;
    }
    public void runEffect(Minion toMinion)
    {
        //Do stuff toMinion
    }
    public void runEffect(Hero hero)
    {
    	this.runEffect((Minion)hero);
    }
}
