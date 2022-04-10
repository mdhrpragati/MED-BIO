package com.example.rishika.myapplication;

import java.util.Comparator;

/**
 * Created by pragati on 12/12/2016.
 */
public class Item implements Comparator<Item> {
    private int id;
    private byte[] image;
    private String botanicalname;
    private String englishname;
    private String nepaliname;
    private String location;
    private String description;

    // private String info;


    //Constructor
    public  Item( byte[] image, String botanicalname, String englishname,String nepaliname,String location,String description){
        this.id=id;
        this.image = image;
        this.botanicalname=botanicalname;
        this.englishname=englishname;
        this.nepaliname=nepaliname;
        this.location=location;
        this.description=description;

        // this.info=info;
        // this.description=description;
    }

    //Setter and getter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBotanicalname() {
        return botanicalname;
    }

    public void setBotanicalname(String botanicalname) {
        this.botanicalname = botanicalname;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    public String getNepaliname() {
        return nepaliname;
    }

    public void setNepaliname(String nepaliname) {
        this.nepaliname = nepaliname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    @Override
    public int compare(Item t1, Item t2) {
        return t1.getBotanicalname().compareTo(t2.getBotanicalname());

    }



    // public String getDescription() {
    //     return description;
    // }

    //   public void setDescription(String description) {
    //    this.description = description;
    // }
}
