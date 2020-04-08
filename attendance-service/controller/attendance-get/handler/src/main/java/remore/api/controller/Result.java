package remore.api.controller;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
