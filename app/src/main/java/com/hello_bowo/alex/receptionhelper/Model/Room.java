package com.hello_bowo.alex.receptionhelper.Model;

import java.io.Serializable;

/**
 * Created by Alex on 13/06/2017.
 */

public class Room implements ICardObject, Serializable {
    private String _title;
    private String _description;
    private int _price;
    private int _picture;

    public Room(String _title, String _description, int _price, int _picture) {
        this._title = _title;
        this._description = _description;
        this._price = _price;
        this._picture = _picture;
    }

    public Room() {
        this._title = "Default";
        this._description = "Default";
        this._price = -1;
        this._picture = -1;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_price() {
        return _price;
    }

    public void set_price(int _price) {
        this._price = _price;
    }

    public int get_picture() {
        return _picture;
    }

    public void set_picture(int _picture) {
        this._picture = _picture;
    }
}
