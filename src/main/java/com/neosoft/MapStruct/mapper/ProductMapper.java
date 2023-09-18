package com.neosoft.MapStruct.mapper;

import com.neosoft.MapStruct.dto.ProductDto;
import com.neosoft.MapStruct.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "name", target = "desc")
    ProductDto toDto(final Product product);


    List<ProductDto> toDtos(final List<Product> products);

    @InheritInverseConfiguration
    Product productDtoToProduct( final ProductDto productDto);
}
