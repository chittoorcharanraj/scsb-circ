package org.recap.model.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 * Created by rajeshbabuk on 8/5/17.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "DELETED_RECORDS_T", catalog = "")
@AttributeOverride(name = "id", column = @Column(name = "DELETED_RECORDS_ID"))
public class DeletedRecordsEntity extends AbstractEntity<Integer>  {
    @Column(name = "RECORDS_TABLE")
    private String Records_Table;

    @Column(name = "RECORDS_PRIMARY_KEY")
    private String recordsPrimaryKey;

    @Column(name = "DELETED_REPORTED_STATUS")
    private String deletedReportedStatus;

    @Column(name = "DELETED_BY")
    private String deletedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELETED_DATE")
    private Date deletedDate;

    @Column(name = "RECORDS_LOG")
    private String recordsLog;
}
