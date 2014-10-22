
public class HeroPriest extends Hero {
	public HeroPriest(Board alliedBoard, Board enemyBoard)
	{
		super(alliedBoard, enemyBoard);
		this.heroPower = new HeroPowerPriest(this);
		this.minionName = "  Priest  ";
	}

}
