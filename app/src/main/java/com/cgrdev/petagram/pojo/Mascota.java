package com.cgrdev.petagram.pojo;

import java.util.ArrayList;

public class Mascota {

    private int id;
    private int pictureId;
    private String name;
    private int rating;
    private ArrayList<RatedPicture> ratedPictures;

    public Mascota (int id, int pictureId, String name) {
        this.id         = id;
        this.pictureId  = pictureId;
        this.name       = name;
        this.rating     = 0;
        this.ratedPictures = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<RatedPicture> getRatedPictures() {
        return ratedPictures;
    }

    public void setRatedPictures(ArrayList<RatedPicture> ratedPictures) {
        this.ratedPictures = ratedPictures;
    }

    public void addRatedPicture (RatedPicture ratedPicture) {
        this.ratedPictures.add(ratedPicture);
    }

}
