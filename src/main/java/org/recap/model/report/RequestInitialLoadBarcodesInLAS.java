package org.recap.model.report;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import java.io.Serializable;

@Data
@CsvRecord(generateHeaderColumns = true, separator = ",", quoting = true, crlf = "UNIX", skipFirstLine = false)
public class RequestInitialLoadBarcodesInLAS implements Serializable {
    @DataField(pos = 1, columnName = "Barcode")
    private String barcode;

    public RequestInitialLoadBarcodesInLAS(String barcode) {
        this.barcode=barcode;
    }
}
