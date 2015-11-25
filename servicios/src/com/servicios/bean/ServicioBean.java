package com.servicios.bean;

public class ServicioBean {

    private int emprid;
    private int servid;
    private int userid;
    private String emprnomb;
    private String servnomb;
    private String servdesc;
    private String servest;

    public ServicioBean() {
    }

    /**
     * @return the emprid
     */
    public int getEmprid() {
        return emprid;
    }

    /**
     * @param emprid the emprid to set
     */
    public void setEmprid(int emprid) {
        this.emprid = emprid;
    }

    /**
     * @return the servid
     */
    public int getServid() {
        return servid;
    }

    /**
     * @param servid the servid to set
     */
    public void setServid(int servid) {
        this.servid = servid;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * @return the emprnomb
     */
    public String getEmprnomb() {
        return emprnomb;
    }

    /**
     * @param emprnomb the emprnomb to set
     */
    public void setEmprnomb(String emprnomb) {
        this.emprnomb = emprnomb;
    }

    /**
     * @return the servnomb
     */
    public String getServnomb() {
        return servnomb;
    }

    /**
     * @param servnomb the servnomb to set
     */
    public void setServnomb(String servnomb) {
        this.servnomb = servnomb;
    }

    /**
     * @return the servdesc
     */
    public String getServdesc() {
        return servdesc;
    }

    /**
     * @param servdesc the servdesc to set
     */
    public void setServdesc(String servdesc) {
        this.servdesc = servdesc;
    }

    /**
     * @return the servest
     */
    public String getServest() {
        return servest;
    }

    /**
     * @param servest the servest to set
     */
    public void setServest(String servest) {
        this.servest = servest;
    }

}
