package com.servicios.bean;

public class FacturaDetalleBean {

    private int usuaid;
    private int emprid;
    private int factid;
    private int servid;
    private double servvlr;
    private String servnomb;
    private int mantid; 
    private String mantdesc;
    private String mantfech;

    public FacturaDetalleBean() {
    }

    /**
     * @return the usuaid
     */
    public int getUsuaid() {
        return usuaid;
    }

    /**
     * @param usuaid the usuaid to set
     */
    public void setUsuaid(int usuaid) {
        this.usuaid = usuaid;
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
     * @return the factid
     */
    public int getFactid() {
        return factid;
    }

    /**
     * @param factid the factid to set
     */
    public void setFactid(int factid) {
        this.factid = factid;
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
     * @return the servvlr
     */
    public double getServvlr() {
        return servvlr;
    }

    /**
     * @param servvlr the servvlr to set
     */
    public void setServvlr(double servvlr) {
        this.servvlr = servvlr;
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
     * @return the mantid
     */
    public int getMantid() {
        return mantid;
    }

    /**
     * @param mantid the mantid to set
     */
    public void setMantid(int mantid) {
        this.mantid = mantid;
    }

    /**
     * @return the mantdesc
     */
    public String getMantdesc() {
        return mantdesc;
    }

    /**
     * @param mantdesc the mantdesc to set
     */
    public void setMantdesc(String mantdesc) {
        this.mantdesc = mantdesc;
    }

    /**
     * @return the mantfech
     */
    public String getMantfech() {
        return mantfech;
    }

    /**
     * @param mantfech the mantfech to set
     */
    public void setMantfech(String mantfech) {
        this.mantfech = mantfech;
    }

}
