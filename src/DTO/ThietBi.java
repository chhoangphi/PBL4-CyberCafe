/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author boixi
 */
public class ThietBi {
    private String id;
    private String name;
    private double price;
    private NCCInternet nccinternet;

    public ThietBi() {
    }

    public ThietBi(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    public ThietBi(String id, String name, double price, NCCInternet nccinternet) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nccinternet = nccinternet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NCCInternet getNccinternet() {
        return nccinternet;
    }

    public void setNccinternet(NCCInternet nccinternet) {
        this.nccinternet = nccinternet;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
