package Football_Manager;

public class Player 
{
	 String F_N;
	 String L_N;
	String Nation;
	int rating;
	int pot;
	int fitness;
	int wage;
	int injury;
	int[] position = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	String team;
	int age;
	int value;
	
	public Player(String f_N, String l_N, String nation, int rating,int pot, int fitness, int wage, int injury, int[] position,
			String team, int age,int value) { 
		F_N = f_N;
		L_N = l_N;
		Nation = nation;
		this.rating = rating;
		this.pot = pot;
		this.fitness = fitness;
		this.wage = wage;
		this.injury = injury;
		this.position = position;
		this.team = team;
		this.age= age;
		this.value = value;
	}
	
	public String Take_Position()
	{
		for(int i = 0;i<14;i++)
		{
			if(this.position[i] == 10)
			{
				switch (i) {
				case 0:
				{
					return "GK";
				}
					
				case 1:
				{
					return "RB";
				}
					
				case 2:
				{
					return "CB";
				}
					
				case 3:
				{
					return "LB";
				}
					
				case 4:
				{
					return "RWB";
				}
					
				case 5:
				{
					return "LWB";
				}
					
				case 6:
				{
					return "CDM";
				}
					
				case 7:
				{
					return "CM";
				}
					
				case 8:
				{
					return "CAM";
				}
					
				case 9:
				{
					return "RM";
				}
					
				case 10:
				{
					return "LM";
				}
					
				case 11:
				{
					return "RW";
				}
					
				case 12:
				{
					return "LW";
				}
					
				case 13:
				{
					return "ST";
				}
					
				
				default:
					break;
				}
			}
		}
		
		return "NULL";
	}
	
	

	
	

}
