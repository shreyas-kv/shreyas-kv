package com.niit.shreyasmobilesBack;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shreyasmobilesBackend.Dao.PayDao;
import com.niit.shreyasmobilesBackend.model.Pay;

public class PayTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		PayDao payDao = (PayDao) context.getBean("payDao");
		Pay pay = (Pay) context.getBean("pay");
		
		
        pay.setPay_id("001");
        pay.setPay_method("COD");
        pay.setPay_status("success");
//        save and update
        if(payDao.saveupdate(pay)==true)
        {
        	System.out.println("saved");
        }
        else
        	System.out.println("Sorry");
          
       // delete
//     if(payDao.delete("001")==true){
//        	System.out.println("Delete successfull");
//        }
//        else{
//        	System.out.println("Sorry");
//        }
        Pay c=payDao.get("001");
        System.out.println(c.getPay_id());
        System.out.println(c.getPay_method());
        System.out.println(c.getPay_status());
        
        List<Pay> li=payDao.list();
        for(Pay c1:li){
        	System.out.println(c1.getPay_id());
        	System.out.println(c1.getPay_method());
        	System.out.println(c1.getPay_status());
        }
       
	}


}
