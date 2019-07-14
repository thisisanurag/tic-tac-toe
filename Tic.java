import java.io.*;
import java.util.Scanner;
public class Tic
{
	static char board[][];
	static String msg="Enter x and y coordinates as the moves";
	public static void main (String args[])
	{
		board=new char[3][3];
		for (int i=0;i<3;i++)
			for (int j=0;j<3;j++)
				board[i][j]='-';
		printBoard();
		playGame();
	}
	public static void playGame()
	{
		Scanner sc=new Scanner(System.in);
		boolean game=true;
		boolean win=false;
		boolean enter=true;
		int chance=1;
		int x,y;
		while (win==false)
		{
			if (checkBoard())
			{
				if (chance==1)
				{
					System.out.println("Player 1 Enter your move");
				}
				else
				{
					System.out.println("Player 2 Enter your move");
				}
				x=sc.nextInt();
				y=sc.nextInt();
				if (board[x][y]!='-' && x<3 && y<3)
				{
					msg="Please Enter valid option";
					printBoard();
					continue;
				}
				if (chance==1)
				{
					chance=2;
					board[x][y]='x';
					win=checkPlayer(1);
					if (win)
					{
						msg="Player 1 wins";
					}
				}
				else
				{
					chance=1;
					board[x][y]='o';
					win=checkPlayer(2);
					if (win)
					{
						msg="Player 2 wins";
					}
				}
			}
			else
			{
				msg="Match Drawn";
				win=true;
			}
			printBoard();
		}
	}
	public static boolean checkBoard()
	{
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				if (board[i][j]=='-')
				{
					return true;
				}
			}
		}
		return false;
	}
	public static boolean checkPlayer(int player)
	{
		char check;
		if (player==1)
		{
			check='x';
		}
		else
		{
			check='o';
		}
		for (int i=0;i<3;i++)
		{
			if (board[i][0]==check && board[i][1]==check && board[i][2]==check)
			{
				return true;
			}
			if (board[0][i]==check && board[1][i]==check && board[2][i]==check)
			{
				return true;
			}
		}
		if (board[0][0]==check && board[1][1]==check && board[2][2]==check)
		{
			return true;
		}
		if (board[2][0]==check && board[1][1]==check && board[0][2]==check)
		{
			return true;
		}
		return false;
	}
	public static void printBoard()
	{
		for (int i=0;i<50;i++)
		{
			System.out.println();
		}
		System.out.println(msg);
		System.out.println(board[0][0]+" | "+board[0][1]+" | "+board[0][2]);
		System.out.println("--|---|--");
		System.out.println(board[1][0]+" | "+board[1][1]+" | "+board[1][2]);
		System.out.println("--|---|--");
		System.out.println(board[2][0]+" | "+board[2][1]+" | "+board[2][2]);
	}
}
