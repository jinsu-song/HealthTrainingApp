package com.sample.healthtrainingapp;

public class TrainerData {
    private String trainerName;
    private String trainerPosition;
    private String trainerCareer;
    private String picture;

    public TrainerData(){}

    public TrainerData(String trainerName, String trainerPosition, String trainerCareer, String picture) {
        this.trainerName = trainerName;
        this.trainerPosition = trainerPosition;
        this.trainerCareer = trainerCareer;
        this.picture = picture;
    }

    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerPosition() {
        return trainerPosition;
    }
    public void setTrainerPosition(String trainerPosition) {
        this.trainerPosition = trainerPosition;
    }

    public String getTrainerCareer() {
        return trainerCareer;
    }
    public void setTrainerCareer(String trainerCareer) {
        this.trainerCareer = trainerCareer;
    }

    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
