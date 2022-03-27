package uz.pdp.warehouse.entity.product;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "product")
public class Product extends Auditable {

    private String name;

    private String description;

    private Double initialPrice;

    private Double sellingPrice;

    private Integer softCount;

    private Integer realCount;

    private String madeBy;

    private LocalDate expiryDate;

    private LocalDate producedDate;

    private UUID partyNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private List<Category> category;

    @Builder(builderMethodName = "childBuilder")
    public Product(Long id, Long createdBy, Long updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, boolean deleted, String name, String description, Double initialPrice, Double sellingPrice, Integer softCount, Integer realCount, String madeBy, LocalDate expiryDate, LocalDate producedDate, UUID partyNumber, List<Category> category) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted);
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.sellingPrice = sellingPrice;
        this.softCount = softCount;
        this.realCount = realCount;
        this.madeBy = madeBy;
        this.expiryDate = expiryDate;
        this.producedDate = producedDate;
        this.partyNumber = partyNumber;
        this.category = category;
    }
}
