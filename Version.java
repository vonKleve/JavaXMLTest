package lab2try1pr;


 public class Version{
            
    private Integer mDosage;
    private Certificate mCertificate;
    private Package mPackage;

    Version(Integer iDosage, Certificate iCertificate, Package iPackage){
        mDosage = Math.abs(iDosage);
        mCertificate = iCertificate;
        mPackage = iPackage;
    }
    
    Version(){
        mDosage = 0;
        mCertificate = new Certificate();
        mPackage = new Package();
    }

    public Integer getDosage(){
        return mDosage;
    }

    public Certificate getCertificate(){
        return mCertificate;
    }

    public Package getPackage(){
        return mPackage;
    }
    
    public void setDosage(Integer iDosage){
        mDosage = Math.abs(iDosage);
    }
    
    public void setCertificate(Certificate icert){
        mCertificate = icert;
    }
    
    public void setPackage(Package iPackage){
        mPackage = iPackage;
    }
    
    public void setVersion(Version iVersion){
        mDosage = iVersion.mDosage;
        mCertificate = iVersion.mCertificate;
        mPackage = iVersion.mPackage;
    }
    
    @Override 
    public String toString(){
        String result = "Dosage: "  + mDosage.toString() + "\n" +
                "Certificate: " + mCertificate.toString() + "\n" +
                "Package: " + mPackage.toString() + "\n";
        return result;
    }
}