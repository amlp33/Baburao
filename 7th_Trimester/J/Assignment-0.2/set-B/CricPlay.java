import java.util.Scanner;

class Player{
  private static int totalRuns=0 ;
  private static int totalPlayers=0;
  private static int totalInnings = 0;
  private int jerNo; 
  private String name; 
  private int runs;
  private int inn; 
  private int notOut; 

  Scanner input = new Scanner(System.in);

  public void GetData(){
    System.out.println("Enter Jersey number: ");
    jerNo = input.nextInt();
    input.nextLine();
    System.out.println("Enter Player's name: ");
    name = input.nextLine();
    System.out.println("Enter runs: ");
    runs = input.nextInt();
    System.out.println("Enter innings played: ");
    inn = input.nextInt();
    System.out.println("Enter number of times not out: ");
    notOut = input.nextInt();
    totalRuns += runs;
    totalInnings += inn;
    totalPlayers++;
  }

  public void PutData(){
    System.out.println(" Jersy Number : "+jerNo+"\n Player Name : "+name+"\n Player Runs : "+runs+"\n Player Innings : "+inn+"\n Player Not Out For : "+notOut+" matches");
    System.out.println("------------------------------------------------------------------");
  }

  public String getName(){
    return name;
  }

  public int getRuns(){
    return runs;
  }

  public int getInnings_played(){
    return inn;
  }

  public static int getTotalPlayers(){
      return totalPlayers;
  }

  public static int getTotalRuns(){
    return totalRuns;
  }

  public static int getTotalInnings(){
    return totalInnings;
  }

  public int getJerNo(){
    return jerNo;
  }
}

public class CricPlay{

  public static void main(String[] ar){
    Scanner input = new Scanner(System.in);
    Player[] players= new Player[11];
    Player player;
    int choice , playerNo;

    do{
      System.out.println("Enter: \n 0.To Exit \n 1.To Add Player \n 2.To View Single Player Details \n 3.To View All Team Details");
      System.out.println(" 4.To Find Average Runs Of Single Player \n 5.To Find Average Runs Of All The Players");
      choice = input.nextInt();
      switch(choice){
        // display all
        //specific player
        //sagle player
        case 0 : System.exit(0);
        case 1 : players[Player.getTotalPlayers()] = new Player();
                System.out.println("Enter details of player : ");
                players[Player.getTotalPlayers()].GetData();
                break;
        case 2 : System.out.println("Enter The Player Jersy Number Whose Details You Want : ");
                playerNo = input.nextInt();
                player = findPlayer(playerNo, players);
                player.PutData();
                break;
        case 3 :  for(int i = 0 ; i < Player.getTotalPlayers() ; i++){
                    System.out.println("Details Player "+(i+1)+" : ");
                  }
                break;
        case 4 : System.out.println("Enter The Player Jersy Number Whose Average You Want : ");
                playerNo = input.nextInt();
                getAverageRuns(playerNo,players);
                break;
        case 5 : getAverageRuns();
                break;
        default : System.out.println("Wrong Choice !!!!!!!");
      }
    }while(choice != 0);
    input.close();
  }

  public static Player findPlayer(int jersyNumber , Player[] players){
      for(int i = 0 ; i < Player.getTotalPlayers() ; i++){
        if(players[i].getJerNo() == jersyNumber){
           return players[i];        }
      }
      System.out.println("The Player With The Jersy Number "+jersyNumber+" Not Found");
      return null;
  }

  public static void getAverageRuns(int playerNo , Player[] players){
    Player player = findPlayer(playerNo, players);
    if(player != null){
      player.PutData();
      System.out.println("Average Runs By "+player.getName()+" are : "+(player.getRuns()/player.getInnings_played()));
    }
  }

  public static void getAverageRuns(){
    System.out.println("Average Runs By The Team Are : " + (Player.getTotalRuns() / Player.getTotalInnings()));
  }
}
