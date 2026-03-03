package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;
import java.util.UUID;
import com.example.demo.models.Product;

@Service
public class ProductService {
    List<Product> listProduct = new ArrayList<>();
    
    public List<Product> getAll() {
        return listProduct;
    }

    public Product get(int id) {
        return listProduct.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void add(Product newProduct) {
        int maxId = listProduct.stream().mapToInt(Product::getId).max().orElse(0);
        newProduct.setId(maxId + 1);
        listProduct.add(newProduct);
    }

    public void update(Product editProduct) {
        Product find = get(editProduct.getId());
        if (find != null) {
            find.setPrice(editProduct.getPrice());
            find.setName(editProduct.getName());
            if (editProduct.getImage() != null)
                find.setImage(editProduct.getImage());
        }
    }

    public void updateImage(Product newProduct, MultipartFile imageProduct) {
        if (imageProduct == null || imageProduct.isEmpty()) {
            return;
        }

        String contentType = imageProduct.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Tệp tải lên không phải là hình ảnh!");
        }

        try {
            Path dirImages = Paths.get("uploads/images");
            if (!Files.exists(dirImages)) {
                Files.createDirectories(dirImages);
            }

            String original = imageProduct.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + (original != null ? "_" + original : "");
            Path pathFileUpload = dirImages.resolve(newFileName);
            Files.copy(imageProduct.getInputStream(), pathFileUpload, StandardCopyOption.REPLACE_EXISTING);

            newProduct.setImage(newFileName);
        } catch (IOException e) {
            throw new RuntimeException("Không thể lưu tệp hình ảnh", e);
        }
    }
}