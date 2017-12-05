package lab2try1pr;

public class Date{
    private Integer dd, mm, yy;
    private void checkAndCorrect(){
        if(dd > 31)
            dd = 31;
        if(mm > 12)
            mm = 12;

        if(dd <= 0)
            dd = 1;
        if(mm <= 0)
            mm = 1;
    }

    Date(Integer idd, Integer imm, Integer iyy){
        dd = idd;
        mm = imm;
        yy = iyy;
        checkAndCorrect();
    }

    Date(String date){
        dd = Integer.parseUnsignedInt(date.substring(0, 2));
        mm = Integer.parseUnsignedInt(date.substring(3, 5));
        yy = Integer.parseUnsignedInt(date.substring(6));
        checkAndCorrect();
    }

    Date(Date iDate){
        dd = iDate.dd;
        mm = iDate.mm;
        yy = iDate.yy;
    }
    
    Date(){
        dd = 1;
        mm = 1;
        yy = 2000;
    }

    public Integer getDay(){
        return dd;
    }

    public Integer getMonth(){
        return mm;
    }

    public Integer getYear(){
        return yy;
    }

    public void setDate(Date mdate){
        dd = mdate.dd;
        mm = mdate.mm;
        yy = mdate.yy;
    }

    public String toString(){
        return (dd.toString() + "/" + mm.toString() + "/" + yy.toString());
    }
}