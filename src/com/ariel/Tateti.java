package com.ariel;

import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Tateti {

    private String playerOneName;

    private String playerTwoName;

    private int turn;

    private String[] moves;

    private String playerOneScore;

    private String playerTwoScore;




    public Tateti(String playerOneName, String playerTwoName){

        this.playerOneName = playerOneName;

        this.playerTwoName = playerTwoName;

        this.turn = 1;

        this.moves = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        this.playerOneScore = "";

        this.playerTwoScore = "";

    }

    public void startGame(){

        Scanner scanner = new Scanner(System.in);

        String playerMove;

        this.viewTable();

        if(!(this.turn %2 == 0)){

            System.out.println(this.playerOneName+ "'s turn") ;

            System.out.println("position: ");

            playerMove = scanner.next();

            this.move(playerMove, "x");

            this.playerOneScore += playerMove;

        }
        else{

                System.out.println(this.playerTwoName+ "'s turn");

                System.out.println("position: ");

                playerMove = scanner.next();

                this.move(playerMove, "o");

                this.playerTwoScore += playerMove;

        }

            if((this.whoWin(this.turn) == 0) || (this.whoWin(this.turn) == 1) ){

                switch(this.whoWin(this.turn)){

                    case 0:

                        System.out.println(this.playerOneName+" won");

                        break;

                    case 1:

                        System.out.println(this.playerTwoName+" won");

                        break;

                }

            }

           else if(this.whoWin(this.turn) == 10) {

                System.out.println("Nobody won");

            }

          else{

                this.turn += 1;

                this.startGame();

            }

    }

    private void move(String move, String xo){

        if(this.moves[parseInt(move)-1].equals(move)){

            this.moves[parseInt(move)-1] = xo;

        }

        else{

            System.out.println("that space isn't empty, try take another space");

            this.startGame();

        }

    }

    private int whoWin(int turn){
        //123 456 789 159 357 147 258 369 and reversed

        if(this.getWinner(this.playerOneScore)){

            return 0;

        }

        else if (this.getWinner(this.playerTwoScore)) {

            return 1;

        }

        else if(turn == 9){

            return 10;

        }

        else {

            return 11;

        }

    }


    private boolean getWinner(String playerScore) {

        return
                        (Pattern.compile("123").matcher(playerScore).find()) |
                        (Pattern.compile("321").matcher(playerScore).find()) |
                        (Pattern.compile("456").matcher(playerScore).find()) |
                        (Pattern.compile("654").matcher(playerScore).find()) |
                        (Pattern.compile("789").matcher(playerScore).find()) |
                        (Pattern.compile("987").matcher(playerScore).find()) |
                        (Pattern.compile("147").matcher(playerScore).find()) |
                        (Pattern.compile("741").matcher(playerScore).find()) |
                        (Pattern.compile("258").matcher(playerScore).find()) |
                        (Pattern.compile("852").matcher(playerScore).find()) |
                        (Pattern.compile("369").matcher(playerScore).find()) |
                        (Pattern.compile("963").matcher(playerScore).find()) |
                        (Pattern.compile("159").matcher(playerScore).find()) |
                        (Pattern.compile("951").matcher(playerScore).find()) |
                        (Pattern.compile("357").matcher(playerScore).find()) |
                        (Pattern.compile("753").matcher(playerScore).find());

    }

    private void viewTable(){

        System.out.println(this.moves[0] +"|"+ this.moves[1] +"|"+ this.moves[2]);

        System.out.println(this.moves[3] +"|"+ this.moves[4] +"|"+ this.moves[5]);

        System.out.println(this.moves[6] +"|"+ this.moves[7] +"|"+ this.moves[8]);

    }

}
