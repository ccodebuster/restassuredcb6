package com.student.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "limit",
        "skip",
        "data"
})
@Generated("jsonschema2pojo")
public class Products {
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("skip")
    private Integer skip;
    @JsonProperty("data")
    private List<Datum> data;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    public Products withTotal(Integer total) {
        this.total = total;
        return this;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Products withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    @JsonProperty("skip")
    public Integer getSkip() {
        return skip;
    }

    @JsonProperty("skip")
    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Products withSkip(Integer skip) {
        this.skip = skip;
        return this;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Products withData(List<Datum> data) {
        this.data = data;
        return this;
    }
}
