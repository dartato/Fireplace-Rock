
public class HeroWarlock extends Hero {
	public HeroWarlock(Board alliedBoard, Board enemyBoard)
	{
		super(alliedBoard, enemyBoard);
		this.heroPower = new HeroPowerWarlock(this);
		this.minionName = "  Warlock ";
	}
}
