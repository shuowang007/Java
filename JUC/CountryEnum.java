package JUC;

public enum CountryEnum {
    ONE(0,"1号技师"),TWO(1,"2号技师"),THREE(2,"3号技师"),FOUR(3,"4号技师"),FIVE(4,"5号技师");
    private Integer iet;
    private String strr;

    public Integer getIet() {
        return iet;
    }

    public String getStrr() {
        return strr;
    }

    CountryEnum(Integer iet, String sst) {
        this.iet = iet;
        this.strr = sst;
    }
    public static CountryEnum forEach_CountEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element :
                myArray) {
            if (index == element.getIet()) return element;
        }
        return null;
    }
}
