/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas.Java.Reminder.Tugas.Java.Reminder.B;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mwllf
 */
@Controller
public class projectController {
    
    @RequestMapping("/inputdata")
    public String
           
        getData(HttpServletRequest data, Model disscountprocess){
                
                String inputnamabuah = data.getParameter("var_name");
                
                String inputhrg = data.getParameter("var_price");
                Double inputharga = Double.valueOf(inputhrg);
                
                String inputjml = data.getParameter("var_quantity");
                Double inputtotal = Double.valueOf(inputjml);
                
                String inputtunai = data.getParameter("var_money");
                Double inputtunaiawal = Double.valueOf(inputtunai);
                
                String disscount = "";
                
                Double hargatotal = inputharga * inputtotal;
                Double harga = inputtunaiawal - hargatotal;
                Double totalpembayaran = null;
                
                if (hargatotal < 16000)
                {
                    totalpembayaran = hargatotal - (0 * hargatotal/100);
                    disscount = "0%";
                }
                else if (hargatotal >= 16000 && hargatotal <25000)
                {
                    totalpembayaran = hargatotal - (10 * hargatotal/100);
                    disscount = "10%";
                }
                else if (hargatotal >= 25000)
                {
                    totalpembayaran = hargatotal - (15 * hargatotal/100);
                    disscount = "15%";
                }
                
                disscountprocess.addAttribute("buah",inputnamabuah);
                disscountprocess.addAttribute("harga",inputhrg);
                disscountprocess.addAttribute("jumlah beli", inputjml);
                disscountprocess.addAttribute("tunai awal",inputtunaiawal);
                disscountprocess.addAttribute("total", totalpembayaran);
                disscountprocess.addAttribute("disscount", disscount);        
        return "view";
    }    
}
                
            

    
