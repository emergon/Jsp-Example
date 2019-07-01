/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author anastasios
 */
public class Salesman {
    private int scode;
    private String sname;
    private String scity;
    private double scomm;
    
    public Salesman(){
        
    }
    
    public Salesman(int scode, String sname, String scity, double scomm) {
        this.scode = scode;
        this.sname = sname;
        this.scity = scity;
        this.scomm = scomm;
    }

    public int getScode() {
        return scode;
    }

    public void setScode(int scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public double getScomm() {
        return scomm;
    }

    public void setScomm(double scomm) {
        this.scomm = scomm;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.scode;
        hash = 97 * hash + Objects.hashCode(this.sname);
        hash = 97 * hash + Objects.hashCode(this.scity);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.scomm) ^ (Double.doubleToLongBits(this.scomm) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salesman other = (Salesman) obj;
        if (this.scode != other.scode) {
            return false;
        }
        if (Double.doubleToLongBits(this.scomm) != Double.doubleToLongBits(other.scomm)) {
            return false;
        }
        if (!Objects.equals(this.sname, other.sname)) {
            return false;
        }
        if (!Objects.equals(this.scity, other.scity)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Salesman{" + "scode=" + scode + ", sname=" + sname + ", scity=" + scity + ", scomm=" + scomm + '}';
    }
    
    
    
}
