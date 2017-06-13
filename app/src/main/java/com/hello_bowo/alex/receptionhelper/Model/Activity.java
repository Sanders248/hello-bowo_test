package com.hello_bowo.alex.receptionhelper.Model;

/**
 * Created by Alex on 13/06/2017.
 */

public class Activity implements ICardObject {
    private String _title;
    private String _description;
    private int _price;
    private int _picture;
    private String _location;
    private String _telnumber;

    public Activity(String _title, String _description, int _price, int _picture, String _location, String _telnumber) {
        this._title = _title;
        this._description = _description;
        this._price = _price;
        this._picture = _picture;
        this._location = _location;
        this._telnumber = _telnumber;
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

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public String get_telnumber() {
        return _telnumber;
    }

    public void set_telnumber(String _telnumber) {
        this._telnumber = _telnumber;
    }
}
