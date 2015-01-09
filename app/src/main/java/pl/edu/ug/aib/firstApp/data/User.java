package pl.edu.ug.aib.firstApp.data;

/**
 * Created by student7 on 2015-01-09.
 */

        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import com.fasterxml.jackson.annotation.JsonProperty;

        import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    public Integer id;

    @JsonProperty("session_id")
    public String sessionId;

}
