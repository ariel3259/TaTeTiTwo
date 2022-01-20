package com.ariel;

import java.util.Scanner;

public class index {


        public static void main(String [] args){

                Scanner scan = new Scanner(System.in);

                System.out.println("Ingrese el nombre del primer jugador: ");

                String firstName = scan.next();

                System.out.println("Ingrese el nombre del segundo jugador");

                String secondName = scan.next();

                Tateti newParty = new Tateti(firstName, secondName);

                newParty.startGame();

        }

}
