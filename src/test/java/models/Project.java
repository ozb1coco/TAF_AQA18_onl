package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Project {

    private String name;
    private String announcement;

    @SerializedName(value = "suite_mode")
    private int type;

    @SerializedName(value = "show_announcement")
    private boolean showAnnouncement;
    private boolean deleted;
}