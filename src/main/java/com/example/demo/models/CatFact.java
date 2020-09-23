package com.example.demo.models;


import java.util.List;

// dette er en model - den modelererer et CatFact
// factText vil vi gerne have ind fra brugeren
public class CatFact
{
    private int ID;
    private String factText;
    
    // constructor
    public CatFact(int ID, String factText)
    {
        this.ID = ID;
        this.factText = factText;
    }
    
    // autogenerate get og set: alt + insert
    
    public int getID()
    {
        return ID;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    
    public String getFactText()
    {
        return factText;
    }
    
    public void setFactText(String factText)
    {
        this.factText = factText;
    }
    
    public String printList(List<CatFact> catFactList)
    {
        String catFactListString = "";
        for(int i = 0; i < catFactList.size(); i++)
        {
            // int j = 1 + i;
            catFactListString =
                    catFactListString + "CatFact number: " + (i + 1) + " " + catFactList.get(i).getFactText();
        }
        return catFactListString;
    }
    
}
