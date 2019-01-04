package Football_Manager;

public class Date 
{
	int day;
	int month;
	int year;
	Date prev;
	
	public Date() 
	{
		// TODO Auto-generated constructor stub
		this.day = 1;
		this.month = 7;
		this.year = 2018;
		this.prev = new Date(30,6,2018);
	}
	
	public Date(int i, int j, int k) 
	{
		// TODO Auto-generated constructor stub
		this.day = i;
		this.month = j;
		this.year = k;
	}

	String make_text()
	{
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	void increase()
	{
		prev = this;
		if(this.month == 12 && this.day == 31)
		{
			this.day = 1;
			this.month = 1;
			this.year = this.year + 1;
		}
		else if(this.month == 1 && this.day == 31)
		{
			this.day = 1;
			this.month = 2;
		}
		else if(this.month == 2 && this.day == 28)
		{
			this.day = 1;
			this.month = 3;
		}
		else if(this.month == 3 && this.day == 31)
		{
			this.day = 1;
			this.month = 4;
		}
		else if(this.month == 4 && this.day == 30)
		{
			this.day = 1;
			this.month = 5;
		}
		else if(this.month == 5 && this.day == 31)
		{
			this.day = 1;
			this.month = 6;
		}
		else if(this.month == 6 && this.day == 30)
		{
			this.day = 1;
			this.month = 7;
		}
		else if(this.month == 7 && this.day == 31)
		{
			this.day = 1;
			this.month = 8;
		}
		else if(this.month == 8 && this.day == 31)
		{
			this.day = 1;
			this.month = 9;
		}
		else if(this.month == 9 && this.day == 30)
		{
			this.day = 1;
			this.month = 10;
		}
		else if(this.month == 10 && this.day == 31)
		{
			this.day = 1;
			this.month = 11;
		}
		else if(this.month == 11 && this.day == 30)
		{
			this.day = 1;
			this.month = 12;
		}
		else
		{
			this.day = this.day + 1;
		}
	}
	
	
}
