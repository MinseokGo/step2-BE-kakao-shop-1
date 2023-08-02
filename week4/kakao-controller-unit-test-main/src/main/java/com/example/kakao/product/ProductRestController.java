package com.example.kakao.product;

import com.example.kakao._core.errors.GlobalExceptionHandler;
import com.example.kakao._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final GlobalExceptionHandler globalExceptionHandler;
    private final ProductService productService;

    // (기능4) 전체 상품 목록 조회 (페이징 9개씩)
    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, HttpServletRequest request) {
        try{
            List<ProductResponse.FindAllDTO> responseDTOs = productService.findAll(page);
            return ResponseEntity.ok(ApiUtils.success(responseDTOs));
        }catch(RuntimeException e){
            return globalExceptionHandler.handle(e, request);
        }
    }

    // (기능5) 개별 상품 상세 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable int id, HttpServletRequest request) {

        try{
            ProductResponse.FindByIdDTO responseDTO = productService.findById(id);
            return ResponseEntity.ok(ApiUtils.success(responseDTO));
        }catch(RuntimeException e){
            return globalExceptionHandler.handle(e, request);
        }
    }
}