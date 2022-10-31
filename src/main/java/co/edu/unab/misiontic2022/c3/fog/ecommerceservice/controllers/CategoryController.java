package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.controllers;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response.CategoryDataResponseModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.ICategoryService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.CategoryDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/categories")
@Tag(name = "Category", description = "Category API")
public class CategoryController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping(value = "")
    public ResponseEntity<List<CategoryDataResponseModel>> listCategory() {
        List<CategoryDto> categories = categoryService.listAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CategoryDataResponseModel> categoriesResponse = new ArrayList<>();
        categories.forEach(category -> {
            categoriesResponse.add(modelMapper.map(category, CategoryDataResponseModel.class));
        });
        return ResponseEntity.ok(categoriesResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDataResponseModel> getCategory(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        CategoryDataResponseModel categoryDataResponseModel = modelMapper.map(categoryDto, CategoryDataResponseModel.class);
        return ResponseEntity.ok(categoryDataResponseModel);
    }

    @PostMapping(value = "")
    public ResponseEntity<CategoryDataResponseModel> createCategory(@RequestBody CategoryDataResponseModel categoryDataResponseModel) {
        CategoryDto categoryDto = modelMapper.map(categoryDataResponseModel, CategoryDto.class);
        CategoryDto categoryDtoCreated = categoryService.createCategory(categoryDto);
        CategoryDataResponseModel categoryDataResponseModelCreated = modelMapper.map(categoryDtoCreated, CategoryDataResponseModel.class);
        return ResponseEntity.ok(categoryDataResponseModelCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDataResponseModel> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDataResponseModel categoryDataResponseModel) {
        CategoryDto categoryDto = modelMapper.map(categoryDataResponseModel, CategoryDto.class);
        CategoryDto categoryDtoUpdated = categoryService.updateCategory(categoryDto);
        CategoryDataResponseModel categoryDataResponseModelUpdated = modelMapper.map(categoryDtoUpdated, CategoryDataResponseModel.class);
        return ResponseEntity.ok(categoryDataResponseModelUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
