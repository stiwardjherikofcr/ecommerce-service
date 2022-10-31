package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CATEGORIES", indexes = {
        @Index(name = "idx_category_name", columnList = "name")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private long idCategory;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<ProductEntity> productsLists;

}
