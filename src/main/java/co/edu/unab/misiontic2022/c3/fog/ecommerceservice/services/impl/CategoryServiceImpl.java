package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.CategoryEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.ICategoryRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.ICategoryService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> listAllCategories() {
        List<CategoryEntity> categoriesEntity = categoryRepository.findAll();
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoriesEntity) {
            categoriesDto.add(modelMapper.map(categoryEntity, CategoryDto.class));
        }
        return categoriesDto;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id).map(categoryEntity -> modelMapper.map(categoryEntity, CategoryDto.class)).orElse(null);
    }

    @Override
    public CategoryDto createCategory(CategoryDto category) {
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(categoryEntity, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category) {
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);
        return modelMapper.map(categoryEntity, CategoryDto.class);
    }

    @Override
    public CategoryDto deleteCategory(Long id) {
        return categoryRepository.findById(id).map(categoryEntity -> {
            categoryRepository.delete(categoryEntity);
            return modelMapper.map(categoryEntity, CategoryDto.class);
        }).orElse(null);
    }

}
