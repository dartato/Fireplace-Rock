
public class HeroHunter extends Hero {
	public HeroHunter(Board alliedBoard, Board enemyBoard)
	{
		super(alliedBoard, enemyBoard);
		this.heroPower = new HeroPowerHunter(this);
		this.minionName = "  Hunter  ";
	}
}
