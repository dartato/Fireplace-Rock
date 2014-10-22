
public class EffectWake extends BasicEffect {
	public EffectWake()
	{
		// enables a minion to attack
	}
    public void runEffect(Minion minion)
    {
    	minion.hasAwoken = true;
    }
}
