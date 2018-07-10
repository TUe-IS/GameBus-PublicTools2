package com.pietervangorp.gamebus.util.config;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by pvgorp on 28/12/2017.
 */
@Data
public class ColumnMapping {

    private String srcTable;
    private String srcColumn;

    private String mockarooURL; // e.g., https://my.api.mockaroo.com/achievement.json?key=ebf97070
    private String localJSON;
    private String jsonAttribute;

    private boolean preserveDuplicateValues = true;

    public enum JSONType {
        @SerializedName("string")
        STRING,
        @SerializedName("int")
        INT
    }

    private JSONType jsonType = JSONType.STRING;
}
