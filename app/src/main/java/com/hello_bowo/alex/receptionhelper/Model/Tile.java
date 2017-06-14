package com.hello_bowo.alex.receptionhelper.Model;

import java.io.Serializable;

/**
 * Created by Alex on 14/06/2017.
 */

public class Tile implements Serializable {
    private int _picLogo;
    private int _picBackground;
    private String textButton;
    private String textTitle;
    private int _spann;
    private String _classPage; // use this to launch the new activity when click on the button

    public Tile(int _picLogo, int _picBackground, String textButton, String textTitle) {
        this._picLogo = _picLogo;
        this._picBackground = _picBackground;
        this.textButton = textButton;
        this.textTitle = textTitle;
        this._spann = 1;
    }

    public Tile(int _picLogo, int _picBackground, String textButton, String textTitle, int _spann) {
        this._picLogo = _picLogo;
        this._picBackground = _picBackground;
        this.textButton = textButton;
        this.textTitle = textTitle;
        this._spann = _spann;
    }

    public int get_spann() {
        return _spann;
    }

    public void set_spann(int _spann) {
        this._spann = _spann;
    }

    public int get_picLogo() {
        return _picLogo;
    }

    public void set_picLogo(int _picLogo) {
        this._picLogo = _picLogo;
    }

    public int get_picBackground() {
        return _picBackground;
    }

    public void set_picBackground(int _picBackground) {
        this._picBackground = _picBackground;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }
}
