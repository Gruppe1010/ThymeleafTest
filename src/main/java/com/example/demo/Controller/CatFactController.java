package com.example.demo.Controller;
import com.example.demo.models.CatFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // for at kunne bruge Model-klassen som parameter i index-metoden
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/* Resources-mappen:
    // I static-mappen ligger vi vores statiske filer - dvs. bl.a. vores css-filer
    // I templates-mappen ligger vores html-filer
    */

@Controller // Skrives foran klassen, fordi vi vil lave en Controller-klasse
public class CatFactController
{
    List<CatFact> catFactList = new ArrayList<CatFact>();
    int ID = 0; // Counter som bruges i postCatFact()-metoden
    
    @GetMapping("/")
    public String index(Model catFactModel) // Model-objektet used to transport data til viewet - altså til html-filen
    {
        /*
        // Via model-objektets metode addAttribute() giver man et navn (som man så skriver ovre i html-filen inde i:
        // ${}) og det objekt som den skal hente/vise/inteagere med over i viewet
        // addAttribute(String navnAtReferereTilIHTML, Obj objSomSkalVisesIView) */
        catFactModel.addAttribute("catFactList", catFactList);
        
        /* INDSÆT FOR ENKELT CATFACT
        // catFactModel.addAttribute("firstCatFact", catFactToDisplay); */
        return "index";   // "index" == navnet på html-filen som sendes retur (ligger i resources --> templates)
    }
    
    /*
    // vi laver denne @PostMapping fordi vi skal lave endpointet /postCatFact - som vi refererer til i html-filen
    // det er sådan vi kaster data som vi laver i html-dokumentet hen til serveren
    */
    @PostMapping("/postCatFact")
    public String postCatFact(WebRequest dataFromForm) // Metoden kaldes når data submittes i inputfelt i browser
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

        /* INDSÆT FOR ENKELT CATFACT
        catFactToDisplay = new CatFact(dataFromForm.getParameter("catfact"));
        */
        return "redirect:/";  // Vi redirecter til GetMapping'en "/" (fordi den skal blive på samme side?)
    }
}
