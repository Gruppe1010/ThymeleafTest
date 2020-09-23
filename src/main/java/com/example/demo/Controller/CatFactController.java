package com.example.demo.Controller;
import com.example.demo.models.CatFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // for at kunne bruge model som parameter i index-metoden
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatFactController
{
    List<CatFact> catFactList = new ArrayList<CatFact>();
    int ID = 0;
    
    // HER - 2 linjer
    //CatFact catFactToDisplay = new CatFact("Vores test-CatFact");
    //CatFactList catFactList = new CatFactList();
    
    // Resources-mappen:
    /*
    // I static-mappen ligger vi vores statiske filer - dvs. bl.a. vores css-filer
    // I templates-mappen ligger vores html-filer
    */
    
    @GetMapping("/")
    public String index(Model catFactModel)
    {
        // den får et navn og et objekt som den skal inteagere med
        // Man bruger Model-objektet til at transportere data til viewet - altså til html-filen
        catFactModel.addAttribute("catFactList", catFactList);
        
        // INDSÆT FOR ENKELT CATFACT
        // catFactModel.addAttribute("firstCatFact", catFactToDisplay);
    
        // "index" == navnet på den html-fil den skal sende retur - ligger i resources --> templates
        return "index";
    }
    
    /*
    // vi laver denne @PostMapping fordi vi skal lave endpointet /postCatFact - fordi vi i vores html-dokumenet
    // det er sådan vi kaster data som vi laver i html-dokumentet hen til serveren
    */
    @PostMapping("/postCatFact")
    public String postCatFact(WebRequest dataFromForm)
    {
        ID++;
        /*
        // Vi laver nyt CatFact-object og sætter attributten til bruger-input + adder det til listen
        vi skal oprette et CatFact-objekt - vi skal sette attributten med det som brugeren inputter:
        // 'catfact' er fra name-attributten i html-filen l. 16
        // getParameter = getter det som brugeren har skrevet(måske?)
        // WebRequest - siger at det ikke er en request fra browseren (måske?????)
         */
        catFactList.add(new CatFact(ID ,dataFromForm.getParameter("catfact")));
        
        // INDSÆT FOR ENKELT CATFACT
        /*
        catFactToDisplay = new CatFact(dataFromForm.getParameter("catfact"));
        */
        
        // Vi redirecter til GetMapping'en "/"
        return "redirect:/";
    }
}
