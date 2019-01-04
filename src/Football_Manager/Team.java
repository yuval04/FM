package Football_Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.security.auth.x500.X500Principal;

public class Team
{
	String name;
	Player[] players = new Player[30];
	int T_b;
	int W_b;
	String coach;
	String stadium;
	double rep;
	
	public Team(String name) throws SQLException
	{
		Connection connection = null;
		connection = sqliteConnection.this_game(); 
		int[] x = {10,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] x1 = {0,10,0,0,6,0,0,0,0,0,0,0,0,0};
		int[] x2 = {0,0,10,0,0,0,0,0,0,0,0,0,0,0};
		int[] x3 = {0,0,6,10,0,6,0,0,0,0,0,0,0,0};
		int[] x4 = {0,0,5,10,0,0,0,0,0,0,0,0,0,0};
		int[] x5 = {0,0,0,0,0,0,10,8,0,0,0,0,0,0};
		int[] x6 = {0,0,0,0,0,0,7,10,0,0,0,0,0,0};
		int[] x7 = {0,0,0,0,0,0,0,10,8,6,0,0,0,0};
		int[] x8 = {0,0,0,0,0,0,0,5,10,0,0,7,7,0};
		int[] x9 = {0,0,0,0,0,0,0,0,10,0,0,9,7,0};
		int[] x10 = {0,0,0,0,0,0,0,0,0,0,0,8,10,0};
		int[] x11 = {0,0,0,0,0,0,0,0,0,0,0,6,8,10};
		int[] x12 = {0,0,0,0,0,0,0,0,0,0,0,0,0,10};
		int[] x13 = {0,0,0,0,0,0,0,0,0,10,8,0,0,0};
		switch (name) {
		case "Arsenal":
		{
			PreparedStatement pst1 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Arsenal(First_Name TEXT,Last_Name TEXT,Nationality TEXT,Team TEXT, Rating INTEGER,Potential INTEGER,Fitness INTEGER,Wage INTEGER,Injury INTEGER,Position TEXT,Age INTEGER,Value INTEGER)");
			pst1.executeUpdate();
			PreparedStatement pst2 = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Arsenal2(First_Name TEXT,Last_Name TEXT,Nationality TEXT,Team TEXT, Rating INTEGER,Potential INTEGER,Fitness INTEGER,Wage INTEGER,Injury INTEGER,Position TEXT,Age INTEGER,Value INTEGER)");
			pst2.executeUpdate();
			this.name=name;
			this.rep = 4.5;
			this.coach = "Unai Emery";
			this.stadium = "Emirates Stadium";
			this.T_b = 90000000;
			this.W_b = 5000000;
			players[0]=new Player("Petr", "Cech", "Czech Republic", 79,79, 100, 100000, 0, x, this.name, 36,3000000);
			players[1]=new Player("Brend", "Leno", "Germany", 82,86, 100, 90000, 0, x, this.name, 26,22000000);
			players[2]=new Player("Emiliano", "Martinez", "Argentina", 68,71, 100, 40000, 0, x, this.name, 26,1000000);
			
			players[3]=new Player("Hector", "Bellerin", "Spain", 81,86, 100, 100000, 0, x1, this.name, 23,40000000);
			players[4]=new Player("Stephan", "Lichtsteiner", "Switzerland", 79,79, 100, 90000, 0, x1, this.name, 34,1500000);
			players[5]=new Player("Carl", "Jenkinson", "England", 71,73, 100, 25000, 0, x1, this.name, 26,3500000);
			
			players[6]=new Player("Sokratis", "Papastathopoulos", "Greece", 84,84, 100, 90000, 0, x2, this.name, 30,20000000);
			players[7]=new Player("Laurent", "Koscielny", "France", 81,81, 100, 90000, 0, x2, this.name, 32,10000000);
			players[8]=new Player("Shkodran", "Mustafi", "Germany", 82,84, 100, 90000, 0, x2, this.name, 26,25000000);
			players[9]=new Player("Rob", "Holding", "England", 74,81, 100, 40000, 0, x2, this.name, 23,7000000);
			players[10]=new Player("Konstantinos", "Mavropanos", "Greece", 70,82, 100, 25000, 0, x2, this.name, 20,3000000);
			
			players[11]=new Player("Sead", "Kolasinac", "Bosnia-Herzegovina", 82,85, 100, 120000, 0, x3, this.name, 25,18000000);
			
			players[12]=new Player("Nacho", "Monreal", "Spain", 78,78, 100, 65000, 0, x4, this.name, 32,13000000);
			
			players[13]=new Player("Lucas", "Torreira", "Uruguay", 81,87, 100, 75000, 0, x5, this.name, 22,40000000);
			players[14]=new Player("Granit", "Xhaka", "Switzerland", 79,81, 100, 90000, 0, x5, this.name, 26,40000000);
			players[15]=new Player("Mohamed", "Elneny", "Egypt", 76,78, 100, 55000, 0, x5, this.name, 26,10000000);
			
			players[16]=new Player("Matteo", "Guendouzi", "France", 77,88, 100, 90000, 0, x6, this.name, 19,35000000);
			
			
			players[17]=new Player("Aaron", "Ramsey", "Wales", 84,85 ,100, 110000, 0, x7, this.name, 27,45000000);
			
			players[18]=new Player("Mesut", "Ozil", "Germany", 85,85 ,100, 300000, 0, x8, this.name, 30,45000000);
			
			players[19]=new Player("Ainsley", "Maitland-niles", "England", 72,80 ,100, 30000, 0, x13, this.name, 21,7000000);
			
			players[20]=new Player("Henrikh", "Mkhitaryan", "Armenia", 84,85 ,100, 120000, 0, x9, this.name, 29,35000000);
			
			players[21]=new Player("Alex", "Iwobi", "Nigeria", 78,84 ,100, 30000, 0, x10, this.name, 22,18000000);
		
			players[22]=new Player("Danny", "Welbeck", "England", 80,82 ,100, 70000, 0, x11, this.name, 28,15000000);
			players[23]=new Player("Pierre-Emerick", "Aubameyang", "Gabon", 87,87 ,100, 180000, 0, x12, this.name, 29,75000000);
			players[24]=new Player("Alexandre", "Lacazette", "France", 86,87 ,100, 140000, 0, x12, this.name, 27,65000000);
			
			for(int i = 0;i<this.players.length;i++)
			{
				String query = "insert into Arsenal(First_Name ,Last_Name,Nationality,Team, Rating,Potential,Fitness,Wage,Injury,Position,Age,Value) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				if(i>20)
				{
					query = "insert into Arsenal2(First_Name ,Last_Name,Nationality,Team, Rating,Potential,Fitness,Wage,Injury,Position,Age,Value) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				}
				PreparedStatement pst = connection.prepareStatement(query);
				if(this.players[i] != null)
				{
				pst.setString(1, this.players[i].F_N);
				pst.setString(2, this.players[i].L_N);
				pst.setString(3, this.players[i].Nation);
				pst.setString(4, this.players[i].team);
				pst.setInt(5, this.players[i].rating);
				pst.setInt(6, this.players[i].pot);
				pst.setInt(7, this.players[i].fitness);
				pst.setInt(8, this.players[i].wage);
				pst.setInt(9, this.players[i].injury);
				pst.setString(10, this.players[i].Take_Position());
				pst.setInt(11, this.players[i].age);
				pst.setInt(12, this.players[i].value);
				pst.execute();
				pst.close();
				}
			}
		}
			break;

		default:
			break;
		}
	}
	
}
