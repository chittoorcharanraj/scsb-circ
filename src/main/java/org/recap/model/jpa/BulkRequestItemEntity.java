package org.recap.model.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Created by rajeshbabuk on 10/10/17.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "bulk_request_item_t", catalog = "")
@AttributeOverride(name = "id", column = @Column(name = "BULK_REQUEST_ID"))
public class BulkRequestItemEntity extends BulkRequestItemAbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REQUESTING_INST_ID", insertable = false, updatable = false)
    private InstitutionEntity institutionEntity;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "bulk_request_t",
            joinColumns = @JoinColumn(name = "BULK_REQUEST_ID"),
            inverseJoinColumns = @JoinColumn(name = "REQUEST_ID"))
    private List<RequestItemEntity> requestItemEntities;

}
