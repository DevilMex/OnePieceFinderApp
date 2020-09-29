package com.example.onepiecefinder.classes;

public class Episode {

    protected int number;
    protected String stringNumber;
    protected String firstLink;
    protected String secondLink;

    public Episode(){}

    public Episode(int number){
        this.number = number;
        stringNumber = getStringNumber(number);
        firstLink = getFirstLink();
        secondLink = getSecondLink();
    }

    public String getStringNumber() {
        return stringNumber;
    }

    public String getFirstLink(){
        return "https://www.animehdita.org/host/srv0.php?v=OnePieceITA/OnePiece_Ep_" + stringNumber + "_ITA";
    }

    public String getSecondLink(){
        return "https://www.animehdita.org/host/srv0.php?v=OnePiece/OnePiece_Ep_" + stringNumber + "_ITA";
    }

    private String getStringNumber(int num){
        if(num < 10){
            return "00" + num;
        } else if(num < 100){
            return "0" + num;
        } else {
            return "" + num;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void load(){
        new Episode(number);
    }

}
