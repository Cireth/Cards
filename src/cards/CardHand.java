/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

import javax.swing.JPanel;

/**
 *Testing GIT
 * Testing again
 * @author rdpalmer
 */
public class CardHand {
   
    final static int XGAP = 10;
    final static int YGAP = 20;
    final static int cardLim = 7;
    
    JPanel panel;
    CardsUI cardsUI;
    int playerNum;

    Card[] card = new Card[cardLim];
    int cardNum = 0;
    int sum = 0;
    
    CardHand(int playerNum, JPanel panel, CardsUI cardsUI){
        this.playerNum = playerNum;
        this.panel = panel;
        this.cardsUI = cardsUI;
    }
    
    public void draw(){
        panel.removeAll();
        for (int n=0; n<cardNum; n++) {
            int xPos = XGAP + n*(card[n].getWidth()+ XGAP);
            int yPos = YGAP;
            card[n].setBounds(xPos, yPos, card[n].getWidth(), card[n].getHeight());
            panel.add(card[n]);
        }
    }
    
    public void addCard(){
        if (cardNum < cardLim){
            card[cardNum] = new Card("Card "+sum, playerNum, this, cardNum, cardsUI);
            cardNum++;
            sum++;
        }
    }
    
    public void removeCard(int num){
        if (num < cardNum){
            for (int n=num; n<cardNum-1; n++){
                card[n] = card[n+1];
                card[n].setNum(n);
            }
            cardNum--;
            card[cardNum] = null;

        }
    }
}
