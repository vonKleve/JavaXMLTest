package lab2try1pr;

 public class Package{
    private Integer mAmount;
    private Integer mPrice;

    Package(Integer iAmount, Integer iPrice){
        mAmount = Math.abs(iAmount);
        mPrice = Math.abs(iPrice);
    }

    Package(Package iPackage){
        mAmount = iPackage.mAmount;
        mPrice = iPackage.mPrice;
    }
    
    Package(){
        mAmount = 0;
        mPrice = 0;
    }

    public Integer getAmount(){
        return mAmount;
    }

    public Integer getPrice(){
        return mPrice;
    }

    public void setAmount(Integer iAmount){
        mAmount = Math.abs(iAmount);
    }

    public void setPrice(Integer iPrice){
        mPrice = Math.abs(iPrice);
    }

    public void setPackage(Package iPackage){
        mAmount = iPackage.mAmount;
        mPrice = iPackage.mPrice;
    }
    
    @Override
    public String toString(){
        String result = "Amount: " + mAmount.toString() + "\n" +
                "Price: " + mPrice + "\n";
        return result;
    }
}
