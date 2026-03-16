package com.example.employee_api.controller;

import com.example.employee_api.model.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();
    private Long idCounter = 1L;

    @PostMapping
    public Object createProduct(
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam MultipartFile image
    ) throws IOException {

        // kiểm tra tên
        if (name == null || name.trim().isEmpty()) {
            return "Tên sản phẩm là bắt buộc";
        }

        // kiểm tra giá
        if (price == null || price <= 0) {
            return "Giá sản phẩm không hợp lệ";
        }

        // kiểm tra ảnh
        if (image == null || image.isEmpty()) {
            return "Ảnh sản phẩm là bắt buộc";
        }

        String originalFileName = image.getOriginalFilename();

        if (originalFileName == null) {
            return "Tên file không hợp lệ";
        }

        // kiểm tra định dạng ảnh
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();

        if (!extension.equals(".png") && !extension.equals(".jpg")) {
            return "Chỉ cho phép file png hoặc jpg";
        }

        // tạo thư mục uploads nếu chưa có

        String uploadDir = System.getProperty("user.dir")+"uploads/";

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // đổi tên file bằng UUID
        String newFileName = "image_" + UUID.randomUUID() + extension;

        File dest = new File(uploadDir + newFileName);

        // lưu file
        image.transferTo(dest);

        // tạo product
        Product product = new Product(
                idCounter++,
                name,
                price,
                newFileName
        );

        products.add(product);

        return product;
    }
}