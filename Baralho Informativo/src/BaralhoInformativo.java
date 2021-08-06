import model.CardModel;
import model.DeckModel;
import service.CardService;
import service.DeckService;
import utils.ImagePrinter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class BaralhoInformativo extends JFrame {
    private JPanel mainPanel;
    private JLabel deck_id_text;
    private JButton drawButton;
    private JButton getADeckButton;
    private JLabel deck_id_value;
    private JLabel code_value;

    public BaralhoInformativo(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        getADeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeckModel deck = null;
                try {
                    deck = DeckService.pickADeck();
                } catch (Exception exception) {
                    System.out.println("Erro: " + exception);
                }
                System.out.println("Pegando um Deck");
                System.out.println("Sucesso: " + deck.isSuccess());
                System.out.println("Deck id: " + deck.getDeckId());
                System.out.println("Embaralhado: " + deck.isShuffled());
                System.out.println("Cartas restantes: " + deck.getRemaining());
                System.out.println("------------------------------");

                deck_id_value.setText(deck.getDeckId());
            }
        });
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardModel card = null;
                try {
                    card = CardService.drawACard(deck_id_value.getText());
                } catch (Exception exception) {
                    System.out.println("Erro: " + exception);
                }
                System.out.println("Comprando uma Carta");

                System.out.println("Código carta: " + card.getCode());
                System.out.println("Valor carta: " + card.getValue());
                System.out.println("Manilha carta: " + card.getSuit());
                System.out.println("ImageUrl carta: " + card.getImage());

                code_value.setText(card.getCode());

                try {
                    URL url = new URL(card.getImage());
                    BufferedImage c = ImageIO.read(url);
                    ImageIcon image = new ImageIcon(c);

                    JFrame frame = new JFrame();

                    JLabel label = new JLabel(image);

                    frame.add(label);
                    frame.setDefaultCloseOperation
                            (JFrame.HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new BaralhoInformativo("Titulo");
        frame.setVisible(true);
    }


}
