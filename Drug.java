package lab2try1pr;

import java.util.Comparator;

 public class Drug implements Comparator, Comparable<Drug>{
     
    public enum Category{Antibiotic, Painkiller, Undefined};
     
    private String mName;
    private Category mCategory;
    private String mPharm;
    private String mAnalogs;
    private Version mVersion;

    Drug(String iName, Category iCategory, String iPharm,
           String iAnalogs, Version iVersion){
        mName = iName;
        mCategory = iCategory;
        mPharm = iPharm;
        mAnalogs = iAnalogs;
        mVersion = iVersion;
    }
    
    Drug(){
        mName = "";
        mCategory = Category.Undefined;
        mPharm = "";
        mAnalogs = "";
        mVersion = new Version();
    }

    public String getName(){
        return mName;
    }

    public Category getCategory(){
        return mCategory;
    }

    public String getPharm(){
        return mPharm;
    }

    public String getAnalogs(){
        return mAnalogs;
    }

    public Version getVersion(){
        return mVersion;
    }

    public void set(Drug iDrug){
        mName = iDrug.mName;
        mCategory = iDrug.mCategory;
        mPharm = iDrug.mPharm;
        mAnalogs = iDrug.mAnalogs;
        mVersion = iDrug.mVersion;
    }
    
    public void setName(String iName){
        mName = iName;
    }
    
    public void setCategory(Category iCategory){
        mCategory = iCategory;
    }
    
    public void setPharm(String iPharm){
        mPharm = iPharm;
    }
    
    public void setAnalogs(String analog){
        mAnalogs = analog;
    }
    
    public void setVersion(Version iVersion){
        mVersion = iVersion;
    }
    
    static public Category getEnum(String s){
        if(s.equals("Antibiotic"))
            return Category.Antibiotic;
        else 
            return Category.Painkiller;
    }
     
     @Override
     public String toString(){
         String result = "Name: " + mName + "\n" +
                 "Category: " + mCategory.toString() + "\n" +
                 "Pharm: " + mPharm + "\n" + 
                 "Analogs: " + mAnalogs + "\n" +
                 mVersion.toString();
         return result;
     }
     
     
    @Override
    public int compare(Object t, Object t1) {
        Drug dt = (Drug) t;
        Drug dtl = (Drug)t1;
        
        Integer num = dt.getVersion().getCertificate().getNumber();
        Integer num1 = dtl.getVersion().getCertificate().getNumber();
        
        return compare(num, num1);
    }
    
    @Override
    public int compareTo(Drug t){
        Integer num = mVersion.getCertificate().getNumber();
        Integer num1 = t.getVersion().getCertificate().getNumber();
        
        return num.compareTo(num1);
    }
}