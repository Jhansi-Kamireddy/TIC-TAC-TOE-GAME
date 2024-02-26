package Task3;
import java.util.Scanner;

	class BoardCreation
	
	{
		static char[][] board;
		//i rows
		//j columns
		public BoardCreation()
		{
			board=new char[3][3];
			makeBoard();
		}
		void makeBoard()
		// to make board with empty spaces
		{
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board[i].length;j++)
				{
					board[i][j]=' ';
				}
			}
		}
		static void dispBoard() 
		// to display board with rows and column separation
		{
			System.out.println("-------------");
			for(int i=0;i<board.length;i++)
			{
				System.out.print("| ");
				for(int j=0;j<board[i].length;j++)
				{
					System.out.print(board[i][j]+" | ");
				}
				System.out.println();
				System.out.println("-------------");
			}
		}
		static void placemark(int row, int col, char mark)
		{
			if (row>=0&&row<=2 && col>=0&&col<=2)
			{
				board[row][col]=mark;
			}
			else
			{
				System.out.println("Invalid position");
			}
		}
		static boolean checkcolwin()
		//method to check column wise WIN
		{
			for(int j=0; j<=2; j++)
			{
				if(board[0][j] !=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
				{
					return true;
				}
			}
			return false;
		}
		static boolean checkrowwin()
		//method to check row wise WIN
		{
			for(int i=0; i<=2; i++)
			{
				if(board[i][0] !=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
				{
					return true;
				}
			}
			return false;
		}
		static boolean checkdiagwin()
		//Method to check Diagonally WIN
		{
			for(int j=0; j<=2; j++)
			{
				if(board[0][0] !=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
				{
					return true;
				}
			}
			return false;
		}
	}
	class Player
	//method to make the code to run in console with 2 players
	{
		String name;
		char mark;
		Player(String name, char mark)
		{
			this.name=name;
			this.mark=mark;
		}
		void makemove()
		{
			Scanner scan=new Scanner(System.in);
			int row;
			int col;
			
			do
			{
				System.out.println("Enter row and col");
				row=scan.nextInt();
				col=scan.nextInt();
			}
			
			
			while(! isvalidmove(row,col));
			BoardCreation.placemark(row, col, mark);
		}
		
		boolean isvalidmove(int row, int col)
		
		{
			if(row>=0 && row<=2 && col>=0 && col<=2)
			{
				if(BoardCreation.board[row][col]==' ')
				{
					return true;
				}
			}
			return false;
		}
	}

	public class Tictactoe
	{

		    public static void main(String[] args) 
		    {
		    	BoardCreation b=new BoardCreation();
		    	Player p1=new Player("player 1",'x');
		    	Player p2=new Player("player 2",'o');
		    	Player cp;
		    	cp=p1;
		    	while(true)
		    	{
		    		System.out.println(cp.name+" Turn");
		    		cp.makemove();
		    		//cp ---> current player
		 
		    		BoardCreation.dispBoard();
		    		
		    		
		    		if(BoardCreation.checkcolwin()||BoardCreation.checkrowwin()||BoardCreation.checkdiagwin())
		    		{
		    			System.out.println(cp.name+" HAS WON THE GAME");
		    			break;
		    		}
		    		else
		    		{
		    			if(cp==p1)
		    			{
		    				cp=p2;
		    			}
		    			else
		    			{
		    				cp=p1;
		    			}
		    		}
		    	}
		    }
	}
