package lab2try1pr;

import java.util.ArrayList;

public class Medicine{
     
    private final ArrayList<Drug> mdrugs;
    
    Medicine(){
        mdrugs = new ArrayList<>();
    }
    
    public ArrayList<Drug> getDrugs(){
        return mdrugs;
    }
    
    public void addDrug(Drug mdrug){
        mdrugs.add(mdrug);
    }
    
    public Drug get(int i){
        return mdrugs.get(i);
    }
    
    @Override 
    public String toString(){
        String result = new String();
        for(int i = 0; i < mdrugs.size(); i++){
            result += mdrugs.get(i);
        }
        return result;
    }
}
