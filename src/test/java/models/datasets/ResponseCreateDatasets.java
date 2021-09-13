package models.datasets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCreateDatasets {

    public String id;
    public String name;
    public String experimentId;
    public String creationDate;
    public String lastUpdateDate;
    public String conclusionDate;
    public int size;
    public ResponseStatusDatasets status;
    public int numRows;
    public int numColumns;

}
