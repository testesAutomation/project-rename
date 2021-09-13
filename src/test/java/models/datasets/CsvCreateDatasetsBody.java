package models.datasets;

import com.github.javafaker.File;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CsvCreateDatasetsBody {

    private String ndoc;
    private String dt_t0;
    private String Target;
    private String value;
    private String your_column;
    private String other_column;
    private String renda;
    private String tdoc;
    private String country;
}
