package pl.edu.ug.aib.firstApp.data;

/**
 * Created by student7 on 2015-01-08.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    @JsonProperty("record")
    public List<Person> records = new ArrayList<Person>();
}
