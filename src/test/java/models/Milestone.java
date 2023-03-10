package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Builder
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String name;
    private String references;
    private String description;
    @SerializedName(value = "is_completed")
    private boolean completed;

}
