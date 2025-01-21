import java.util.*;

public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.BLUE + Text.BACKGROUND;
  private static final String SPACES = "                                                                                ";

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    Text.clear();
    
    Text.go(0,0);
    for(int i = 0; i < WIDTH; i++){ // Column 1
      System.out.print(Text.colorize(" ", BORDER_BACKGROUND));
    }

    for(int column = 1; column < HEIGHT; column++){ //Columns 2 - 29
      System.out.print("\n" + Text.colorize(" ", BORDER_BACKGROUND));
      Text.go(column, WIDTH);
      System.out.print(Text.colorize(" ", BORDER_BACKGROUND));
    }

    Text.go(HEIGHT, 0); //Column 30
    for(int i = 0; i < WIDTH; i++){
      System.out.print(Text.colorize(" ", BORDER_BACKGROUND));
    }

    Text.go(28,0);
    for(int i = 0; i < WIDTH; i++){ // Column 29
      System.out.print(Text.colorize(" ", BORDER_BACKGROUND));
    }
    
    Text.reset();    
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(s);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    String spaces = "";
    for(int j = 0; j < width; j++){ //ie. width of 2 -> spaces = "  "
      spaces += " ";
    }

    for(int i = 0; i < height; i++){ //goes through all rows
      if (text.length() > width){ //ie. "abcd" with a width of 3 | "abc"
        drawText(text.substring(0, width), row + i, col);
        text = text.substring(width);
      }

      else if (text.length() > 0){ //ie. "abcd" with a width of 6 | "abcd  "
        drawText(text, row + i, col);
        drawText(spaces.substring(0, width - text.length()), row + i, col + text.length());
        text = "";
      }
      else{ //ie. "" with a width of 2 | "  "
        drawText(spaces, row + i, col);
      }
    }
  }


    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(String team){
      if (team.equals("party")){
        int randint = (int)(Math.random() * 3); //0 = CodeWarrior, 1 = JavaJester, 2 = PythonPrince
        if(randint == 0){
          return new CodeWarrior("Coder"+(int)(Math.random()*100));
        }
        else if (randint == 1){
          return new JavaJester("Javas"+(int)(Math.random()*100));
        }
        else{
          return new PythonPrince("Pythe"+(int)(Math.random()*100));
        }
      }
      else{
        int randint = (int)(Math.random() * 3); //0 = Sharpshooter, 1 = Tank, 2 = SwordsMachine
        if(randint == 0){
          return new EnemyMalware("Mally"+(int)(Math.random()*100));
        }
        else if (randint == 1){
          return new EnemySpyware("Spy"+(int)(Math.random()*100));
        }
        else{
          return new EnemyAdware("Ad"+(int)(Math.random()*100));
        }
      }
      
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      for(int i = 0; i < party.size(); i++){
        Adventurer player = party.get(i);
        int spacing = 78 / party.size();
        TextBox(startRow + 0, 2 + spacing * i, spacing - 1, 1, player.getName());
        TextBox(startRow + 1, 2 + spacing * i, spacing - 1, 1, "HP: " + colorByPercent(player.getHP(), player.getmaxHP()) + "   ");
        Text.reset();
        TextBox(startRow + 2, 2 + spacing * i, spacing - 1, 1, player.getSpecialName() + ": " + player.getSpecial() + "/" + player.getSpecialMax());
      }
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  //COLORIZE THE OUTPUT IF HIGH/LOW:
  // under 25% : red
  // under 75% : yellow
  // otherwise : white
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    double percent = (double) hp / maxHP;
    if (percent < 0.25){
      return Text.colorize(output, Text.RED);
    }
    else if (percent < 0.75){
      return Text.colorize(output, Text.YELLOW);
    }
    else{
      return output;
    }
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){
    //draw player party
    drawParty(party, 2);

    //draw enemy party
    drawParty(enemies, 25);
    TextBox(27, 2, 78, 1, "");

    //places cursor at input place
    TextBox(29, 2, 6, 1, "Input: ");
    Text.go(29, 9);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(29, 9);
      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      //clear the text that was written
      TextBox(29, 9, 71, 1, "");

      Text.hideCursor();

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static boolean checkValidInput(String input, ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){
    boolean validAtkInput = input.startsWith("attack ") || input.startsWith("a ") ||
                            input.startsWith("special ") || input.startsWith("sp ");
    boolean validSuInput = input.startsWith("support ") || input.startsWith("su ");
    boolean validQuitInput = input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit");      

    if(validAtkInput){
      try{
        int target = Integer.parseInt(input.substring(input.length() - 1));
        int someonesHP = enemies.get(target).getHP();
      }
      catch(Exception e){
        validAtkInput = false;
      }
    }
    else if (validSuInput){
      try{
        int target = Integer.parseInt(input.substring(input.length() - 1));
        int someonesHP = party.get(target).getHP();
      }
      catch(Exception e){
        validSuInput = false;
      }
    }
    
    return validAtkInput || validSuInput || validQuitInput;
  }

  public static void run(){
      //Clear and initialize
      Text.hideCursor();
      Text.clear();
      


      //Things to attack:
      //Make an ArrayList of Adventurers and add 1-3 enemies to it.
      //If only 1 enemy is added it should be the boss class.
      //start with 1 boss and modify the code to allow 2-3 adventurers later.
      ArrayList<Adventurer> enemies = new ArrayList<Adventurer>();
      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      int enemyNum = (int) (Math.random() * 3) + 1;
      if (enemyNum == 1){
        Boss BossyBoss = new Boss("The Bossy Virus");
        enemies.add(BossyBoss);
      }
      else{
        for(int i = 0; i < enemyNum; i++){
          enemies.add(createRandomAdventurer("enemy"));
        }
      }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

      //Adventurers you control:
      //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
      ArrayList<Adventurer> party = new ArrayList<>();
      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      int partyNum = (int) (Math.random() * 3) + 2;
      for(int i = 0; i < partyNum; i++){
        party.add(createRandomAdventurer("party"));
      }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

      boolean partyTurn = true;
      int whichPlayer = 0;
      int whichOpponent = 0;
      int turn = 0;
      boolean hasDeath = false;
      String input = "";//blank to get into the main loop.
      Scanner in = new Scanner(System.in);
      //Draw the window border
      drawBackground();

      //You can add parameters to draw screen!
      drawScreen(party, enemies);//initial state.

      //Main loop

      //display this prompt at the start of the game.
      String preprompt = Text.colorize("Enter command for "+party.get(whichPlayer)+": (a)ttack #/(sp)ecial #/(su)pport #/(q)uit", Text.GREEN);
      TextBox(6, 2, 78, 1, preprompt + SPACES);

      while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
        //Read user input
        input = userInput(in);

        //You should decide when you want to re-ask for user input

        boolean validInput = checkValidInput(input, party, enemies);

        while(partyTurn && !validInput){
          TextBox(7, 2, 78, 1, Text.colorize("Please use the format above.", Text.GREEN) + SPACES);
          input = userInput(in);
          validInput = checkValidInput(input, party, enemies);
        }
        TextBox(7, 2, 78, 1, "");

        //display event based on last turn's input
        if(partyTurn){

          //Process user input for the last Adventurer:
          if(input.startsWith("attack ") || input.startsWith("a ")){
            /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
            int target = Integer.parseInt(input.substring(input.length() - 1));
            String userOutput = party.get(whichPlayer).attack(enemies.get(target));
            TextBox(10, 2, 78, 5, userOutput);
            /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
          }
          else if(input.startsWith("special ") || input.startsWith("sp ")){
            /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
            int target = Integer.parseInt(input.substring(input.length() - 1));
            String userOutput = party.get(whichPlayer).specialAttack(enemies.get(target));
            TextBox(10, 2, 78, 5, userOutput);
            /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
          }
          else if(input.startsWith("su ") || input.startsWith("support ")){
            //"support 0" or "su 0" or "su 2" etc.
            //assume the value that follows su  is an integer.
            /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
            int target = Integer.parseInt(input.substring(input.length() - 1));
            if (target == whichPlayer){
              String userOutput = party.get(whichPlayer).support();
              TextBox(10, 2, 78, 5, userOutput);
            }
            else{
              String userOutput = party.get(whichPlayer).support(party.get(target));
              TextBox(10, 2, 78, 5, userOutput);
            }
            /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
          }

          //If no errors:
          whichPlayer++;


          if(whichPlayer < party.size()){
            //This is a player turn.
            //Decide where to draw the following prompt:
            String prompt = Text.colorize("Enter command for "+party.get(whichPlayer)+": (a)ttack #/(sp)ecial #/(su)pport #/(q)uit", Text.GREEN);
            TextBox(6, 2, 78, 1, prompt + SPACES);


          }else{
            //This is after the player's turn, and allows the user to see the enemy turn
            //Decide where to draw the following prompt:
            partyTurn = false;
            whichOpponent = 0;
            String prompt = Text.colorize("press enter to see "+enemies.get(whichOpponent)+"'s turn", Text.RED);
            TextBox(6, 2, 78, 1, prompt + SPACES);
          }
          //done with one party member
        }else{
          //not the party turn!


          //enemy attacks a randomly chosen person with a randomly chosen attack.z`
          //Enemy action choices go here!
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          /*
          Enemy chooses an action:
          If attack, it targets a party member
          If support, it targets itself
          */
          int action = (int)(Math.random() * 2); //0 = atk, 1 = su
          String enemyOutput = "";
          if(action == 0){
            int target =(int)(Math.random() * party.size());
            enemyOutput = enemies.get(whichOpponent).attack(party.get(target));
          }
          else{
            int target = (int)(Math.random() * enemies.size());
            enemyOutput = enemies.get(whichOpponent).support();
          }
          TextBox(10, 2, 78, 5, enemyOutput);
          
          
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


          //Decide where to draw the following prompt:
          whichOpponent++;
          if(whichOpponent < enemies.size()){
            String prompt = Text.colorize("press enter to see "+enemies.get(whichOpponent)+"'s turn", Text.RED);
            TextBox(6, 2, 78, 1, prompt + SPACES);
          }
        }//end of one enemy.

        //modify this if statement.
        if(!partyTurn && whichOpponent >= enemies.size()){
          //THIS BLOCK IS TO END THE ENEMY TURN
          //It only triggers after the last enemy goes.
          whichPlayer = 0;
          turn++;
          partyTurn=true;
          //display this prompt before player's turn
          String prompt = Text.colorize("Enter command for "+party.get(whichPlayer)+": (a)ttack #/(sp)ecial #/(su)pport #/(q)uit", Text.GREEN);
          TextBox(6, 2, 78, 1, prompt + SPACES);
        }

        //when HP goes to or below 0, the adventurer dies.
        if (hasDeath == true){ //triggers 1 turn after someone died
          TextBox(15, 2, 78, 1, ""); //removes death prompt
          hasDeath = false;
        }
        
        for(int i = 0; i < party.size(); i++){ //checks party
          if(party.get(i).getHP() <= 0){
            TextBox(15, 2, 78, 1, party.get(i) + " died!");
            TextBox(2, 2, 78, 3, "");
            party.remove(i);
            hasDeath = true;
            if(party.size() > 0 && partyTurn){ 
              String prompt = Text.colorize("Enter command for "+party.get(whichPlayer)+": (a)ttack #/(sp)ecial #/(su)pport #/(q)uit", Text.GREEN);
              TextBox(6, 2, 78, 1, prompt + SPACES);
            }
          }
        }

        for(int i = 0; i < enemies.size(); i++){ //checks enemies
          if(enemies.get(i).getHP() <= 0){
            TextBox(15, 2, 78, 1, enemies.get(i) + " died!");
            TextBox(25, 2, 78, 3, "");
            enemies.remove(i);
            hasDeath = true;
            if(enemies.size() > 0 && !partyTurn){ 
              String prompt = Text.colorize("press enter to see "+enemies.get(whichOpponent)+"'s turn", Text.RED);
              TextBox(6, 2, 78, 1, prompt + SPACES);
            }
          }
        }

        //display the updated screen after input has been processed.
        drawScreen(party, enemies);

        //ends game when one side has no more adventurers
        if (party.size() == 0){
          TextBox(16, 2, 78, 1, Text.colorize("YOU LOSE", Text.RED, Text.WHITE + Text.BACKGROUND));
          quit();
          return;
        }
        else if (enemies.size() == 0){
          TextBox(16, 2, 78, 1, Text.colorize("YOU WIN", Text.GREEN, Text.WHITE + Text.BACKGROUND));
          quit();
          return;
        }

      }//end of main game loop


      //After quit reset things:
      quit();
    }
  }
