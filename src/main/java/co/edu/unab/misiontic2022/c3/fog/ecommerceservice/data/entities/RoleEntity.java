package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @Column(nullable = false, length = 10)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<CustomerEntity> customersList;

}
