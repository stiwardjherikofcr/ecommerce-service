package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared;

import java.io.Serializable;


public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idCategory;
    private String name;

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
