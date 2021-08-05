package main;

import model.CardModel;
import model.DeckModel;
import service.CardService;
import service.DeckService;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Digite 1 para pegar uma carta");

        String request = new Scanner(System.in).nextLine();
        while (!request.equals("1")) {
            System.out.println("Digite APENAS 1 para puxar uma carta ou 0 para sair do programa!");
            request = new Scanner(System.in).nextLine();
            if(request.equals("0")){
                System.exit(0);
            }
        }

        DeckModel deck = DeckService.pickADeck();
        System.out.println("Pegando um Deck");
        System.out.println("Sucesso: " + deck.isSuccess());
        System.out.println("Deck id: " + deck.getDeckId());
        System.out.println("Embaralhado: " + deck.isShuffled());
        System.out.println("Cartas restantes: " + deck.getRemaining());
        System.out.println("------------------------------");



        System.out.println("Começando o painel");


    }
}
