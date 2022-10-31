package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;

import java.util.List;

public interface ICategoryService {

    public List<CategoryDto> listAllCategories();

    public CategoryDto getCategoryById(Long id);

    public CategoryDto createCategory(CategoryDto category);

    public CategoryDto updateCategory(CategoryDto category);

    public CategoryDto deleteCategory(Long id);

}
