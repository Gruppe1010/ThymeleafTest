package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class CatFactList
{
    ArrayList<CatFact> catFactList = new ArrayList<CatFact>();
    
    public void addCatFactToList(CatFact catFact)
    {
        catFactList.add(catFact);
    }
    // shift + f6 to refactor
    public String printList()
    {
        String catFactListString = "";
        for(int i = 0; i < catFactList.size(); i++)
        {
            // int j = 1 + i;
            catFactListString =
                    catFactListString + "CatFact number: " + (i + 1) + " " + catFactList.get(i).getFactText() + "<br>";
        }
        return catFactListString;
    }
}
