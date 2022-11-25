package javafiles;

public class doctormodel {
    private int app_id;
    private String p_id;
    private String app_date;
    private int hos_id;
    private int doc_id;
    private int count;
    private String doc_name;
    private String d_special;
    private int status;
    private String uname;

    // public doctormodel(int app_id, String p_id, String app_date, int hos_id, int doc_id, String uname) {
    //     this.app_id = app_id;
    //     this.p_id = p_id;
    //     this.app_date = app_date;
    //     this.hos_id = hos_id;
    //     this.doc_id = doc_id;
    //     this.uname = uname;
    // }

    public doctormodel(int app_id, String p_id, String app_date, int hos_id, int doc_id, int status, String uname) {
        this.app_id = app_id;
        this.p_id = p_id;
        this.app_date = app_date;
        this.hos_id = hos_id;
        this.doc_id = doc_id;
        this.status = status;
        this.uname = uname;
    }

    public doctormodel(int doc_id, int count, String doc_name, String d_special) {
        this.doc_id = doc_id;
        this.count = count;
        this.doc_name = doc_name;
        this.d_special = d_special;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getD_special() {
        return d_special;
    }

    public void setD_special(String d_special) {
        this.d_special = d_special;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getApp_date() {
        return app_date;
    }

    public void setApp_date(String app_date) {
        this.app_date = app_date;
    }

    public int getHos_id() {
        return hos_id;
    }

    public void setHos_id(int hos_id) {
        this.hos_id = hos_id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
