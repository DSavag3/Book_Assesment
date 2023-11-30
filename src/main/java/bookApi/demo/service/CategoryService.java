package bookApi.demo.service;

import bookApi.demo.model.Category;
import bookApi.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
public List <Category> getAllCategories(){
        return categoryRepository.findAll();
}

public Optional <Category> getCategoryBySku(Long sku){
        return categoryRepository.findById(sku);
}
public Category editCategory (Long sku, Category updatedCategory){
   getCategoryBySku(sku);
   updatedCategory.setSku(sku);
   return categoryRepository.save(updatedCategory);
}
}
