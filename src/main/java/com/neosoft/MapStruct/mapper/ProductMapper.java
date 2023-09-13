package com.neosoft.MapStruct.mapper;

import com.neosoft.MapStruct.dto.ProductDto;
import com.neosoft.MapStruct.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDto modelToDto(Product product);
    Product DtoToModel(ProductDto productDto);


}
