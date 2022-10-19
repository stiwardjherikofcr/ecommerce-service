package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private long idCustomer;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 10)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    private RoleEntity role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<OrderEntity> ordersList;

}
