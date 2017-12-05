package lab2try1pr;

import java.util.Comparator;

 public class Certificate implements Comparator, Comparable<Certificate>{
    private Integer mNumber;
    private Date mExpDate;
    private String mOrganisation;
    private String mID;

    Certificate(Integer iNumber, Date iDate, String iOrg, String iID){
        mNumber = Math.abs(iNumber);
        mExpDate = iDate;
        mOrganisation = iOrg;
        mID = iID;
    }

    Certificate(Certificate iCertificate){
        mNumber = iCertificate.mNumber;
        mExpDate = iCertificate.mExpDate;
        mOrganisation = iCertificate.mOrganisation;
        mID = iCertificate.mID;
    }
    
    Certificate(){
        mNumber = 0;
        mExpDate = new Date();
        mOrganisation = "";
        mID = "0";
    }

    public Integer getNumber(){
        return mNumber;
    }

    public Date getExpDate(){
        return mExpDate;
    }

    public String getOrganisation(){
        return mOrganisation;
    }
    
    public String getID(){
        return mID;
    }
    
    
    public void setNumber(Integer val){
        mNumber = Math.abs(val);
    }
    
    public void setDate(Date iDate){
        mExpDate = iDate;
    }
    
    public void setOrganisation(String iorg){
        mOrganisation = iorg;
    }
    
    public void setID(String iID){
        mID = iID;
    }
    
    public void set(Certificate iCertificate){
        mNumber = iCertificate.mNumber;
        mExpDate = iCertificate.getExpDate();
        mOrganisation = iCertificate.mOrganisation;
    }
    
    @Override 
    public String toString(){
        String result = "Number: " + mNumber.toString() + "\n" +
                "ID: " + mID + "\n" +
                "ExpDate: " + mExpDate.toString() + "\n" +
                "Organisation: " + mOrganisation + "\n";
        return result;
    }

    @Override
    public int compare(Object t, Object t1) {    
        Certificate ct = (Certificate) t;
        Certificate ctl = (Certificate) t1;
        
        return compare(ct.mNumber, ctl.mNumber);
    }

    @Override
    public int compareTo(Certificate t) {   
        return mNumber.compareTo(t.mNumber);
    }
}