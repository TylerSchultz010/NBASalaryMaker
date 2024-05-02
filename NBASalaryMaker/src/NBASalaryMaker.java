import java.util.Scanner;

/**
 * 
 */

/**
 * 
 */
public class NBASalaryMaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int millions;
		int years;
		int contract;
		double rate;
		
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the anticipated contract in millions (i.e 10 = 10 million): ");
		millions = input.nextInt();
		contract = millions * 1000000;
		
		System.out.print("\nNow enter the amount of years for this salary: ");
		years = input.nextInt();
		
		System.out.println("\nLastly enter the contract rate from the available options below:\n0.92	0.95	1.00	1.05	1.08");
		rate = input.nextDouble();
		
		int salary[] = new int[5];
		
		if(years == 1) {oneYear(contract, rate, salary);}
		else if(years == 2) {twoYears(contract, rate, salary);}
		else if(years == 3) {threeYears(contract, rate, salary);}
		else if(years == 4) {fourYears(contract, rate, salary);}
		
		System.out.println("\nPlayers expected salary by year:\n");
		
		
		for (int i = 0; salary[i] != 0; i++)
		{
			System.out.println("Year " + (i+1) + ": " + salary[i]);
		}

	}
	
	public static void oneYear(int contract, double rate, int salary[])
	{
		salary[0] = contract;
		return;
	}
	
	public static void twoYears(int contract, double rate, int salary[])
	{
		salary[0] = (int) ((contract/2) * (1-(rate-1)));
		salary[1] = contract - salary[0];
		return;
	}
	
	public static void threeYears(int contract, double rate, int salary[])
	{
		salary[1] = (int) Math.round((double) contract/3);
		salary[0] = (int) (salary[1] * (1-(rate-1)));
		salary[2] = contract - (salary[0] + salary[1]);
	}
	
	public static void fourYears(int contract, double rate, int salary[])
	{
		salary[1] = (int) Math.round((contract/4) * (1-(((rate+1)/2)-1)));
		salary[2] = (int) Math.round((contract/4) * (1+(((rate+1)/2)-1)));
		
		salary[0] = salary[1] - (salary[2] - salary[1]);
		salary[3] = contract - (salary[0] + salary[1] + salary[2]);
	}

}
