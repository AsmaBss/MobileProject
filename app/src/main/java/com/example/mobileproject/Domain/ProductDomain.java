package com.example.mobileproject.Domain;

public class ProductDomain {
    private String title;
    private String pic;
    private String description;
    private Double fee;

    public ProductDomain(String title, String pic, String description, Double fee) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", description='" + description + '\'' +
                ", fee=" + fee +
                '}';
    }

}
