package com.niit.shreyasmobilesBack;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.CardDao;
import com.niit.shreyasmobilesBackend.model.Card;

public class CardTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		CardDao cardDao = (CardDao) context.getBean("cardDao");
		Card card= (Card) context.getBean("card");
		
		
        card.setCard_id("001");
        card.setCard_no("002");
        card.setCard_name("me");
        card.setCard_expiry("lifetime");
        
//        save and update
        if(cardDao.saveupdate(card)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
          
       // delete
//     if(cardDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        Card c=cardDao.get("001");
        System.out.println(c.getCard_id());
        System.out.println(c.getCard_no());
        System.out.println(c.getCard_name());
        System.out.println(c.getCard_expiry());
        
        
        List<Card> li=cardDao.list();
        for(Card c1:li){
        	System.out.println(c.getCard_id());
            System.out.println(c.getCard_no());
            System.out.println(c.getCard_name());
            System.out.println(c.getCard_expiry());
        	
        }
       
	}
}
