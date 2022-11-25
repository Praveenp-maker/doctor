package javafiles;

public class dmodel {
    private String d_user1;
    private int password1;
    private int d_id1;
    private String d_name1;
    private int app_id1;
    private String spi;
    public dmodel(String d_user1, int password1, int d_id1, String d_name1, int app_id1,String spi) {
        this.d_user1 = d_user1;
        this.password1 = password1;
        this.d_id1 = d_id1;
        this.d_name1 = d_name1;
        this.app_id1 = app_id1;
        this.spi = spi;

    }
    public String getD_user1() {
        return d_user1;
    }
    public String getSpi() {
        return spi;
    }
    public void setSpi(String spi) {
        this.spi = spi;
    }
    public void setD_user1(String d_user1) {
        this.d_user1 = d_user1;
    }
    public int getPassword1() {
        return password1;
    }
    public void setPassword1(int password1) {
        this.password1 = password1;
    }
    public int getD_id1() {
        return d_id1;
    }
    public void setD_id1(int d_id1) {
        this.d_id1 = d_id1;
    }
    public String getD_name1() {
        return d_name1;
    }
    public void setD_name1(String d_name1) {
        this.d_name1 = d_name1;
    }
    public int getApp_id1() {
        return app_id1;
    }
    public void setApp_id1(int app_id1) {
        this.app_id1 = app_id1;
    }

    
}
	