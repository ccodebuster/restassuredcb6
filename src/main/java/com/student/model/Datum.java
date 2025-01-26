package com.student.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "type",
        "price",
        "upc",
        "shipping",
        "description",
        "manufacturer",
        "model",
        "url",
        "image",
        "createdAt",
        "updatedAt",
        "categories"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("price")
    private int price;
    @JsonProperty("upc")
    private String upc;
    @JsonProperty("shipping")
    private Integer shipping;
    @JsonProperty("description")
    private String description;
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("model")
    private String model;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image")
    private String image;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("categories")
    private List<Category> categories;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Datum withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Datum withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("price")
    public int getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(int price) {
        this.price = price;
    }

    public Datum withPrice(int price) {
        this.price = price;
        return this;
    }

    @JsonProperty("upc")
    public String getUpc() {
        return upc;
    }

    @JsonProperty("upc")
    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Datum withUpc(String upc) {
        this.upc = upc;
        return this;
    }

    @JsonProperty("shipping")
    public Integer getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public Datum withShipping(Integer shipping) {
        this.shipping = shipping;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Datum withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("manufacturer")
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Datum withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    public Datum withModel(String model) {
        this.model = model;
        return this;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public Datum withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    public Datum withImage(String image) {
        this.image = image;
        return this;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Datum withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Datum withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Datum withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

}
