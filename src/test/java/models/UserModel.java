package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    Integer id;
    String email, avatar, name, job;
    @JsonProperty(value = "first_name")
    String firstName;
    @JsonProperty(value = "last_name")
    String lastName;
}

