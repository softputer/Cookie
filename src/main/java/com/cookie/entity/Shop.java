package com.cookie.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by koko on 19.08.16.
 */
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String adress;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "shop_commodities", joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "commodity_id"))
    private List<Commodity> commodities;

    public Shop() {
    }

    public Shop(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "adress='" + adress + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
