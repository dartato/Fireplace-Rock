
public class HeroMage extends Hero{
	public HeroMage(Board alliedBoard, Board enemyBoard)
	{
		super(alliedBoard, enemyBoard);
		this.heroPower = new HeroPowerMage(this);
		this.minionName = "   Mage   ";
	}

}
