package org.recap.model.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "PENDING_REQUEST_T", catalog = "")
@AttributeOverride(name = "id", column = @Column(name = "PENDING_ID"))
public class PendingRequestEntity extends AbstractEntity<Integer>  {
    @Column(name = "REQUEST_ID")
    private Integer requestId;

    @Column(name = "ITEM_ID")
    private Integer itemId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REQUEST_CREATED_DATE")
    private Date requestCreatedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REQUEST_ID", referencedColumnName = "REQUEST_ID", insertable = false, updatable = false)
    private RequestItemEntity requestItemEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", insertable = false, updatable = false)
    private ItemEntity itemEntity;
}
