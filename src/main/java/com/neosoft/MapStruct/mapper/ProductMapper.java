package com.neosoft.MapStruct.mapper;

import com.neosoft.MapStruct.dto.ProductDto;
import com.neosoft.MapStruct.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // @Mapping(source = "desc", target = "description", defaultValue = "description")
    //  @Mapping(target = "itemId",expression = "java(UUID.randomUUID.toString())")
    // @Mapping(target = "itemsList", source = "items")
    ProductDto modelToDto(final Product product);

    List<ProductDto> modelsToDtos(List<Product> product);

    //in above method we already written mapping so we no need to write mapping again instead of this we need to write @InheritInverseConfiguration
    //@Mapping(source = "description", target = "desc",defaultValue = "description")
    @InheritInverseConfiguration
    Product dtoToModel(final ProductDto productDto);
    /*//(if we are not set defaultvalue then below output is showing if set then  else {
            product.setDesc( "description" );
        }  is printed )
    if ( productDto == null ) {
        return null;
    }

    Product product = new Product();

        product.setDesc( productDto.getDescription() );
        product.setId( productDto.getId() );
        product.setPrice( productDto.getPrice() );
        product.setQuantity( productDto.getQuantity() );

        return product;*/

}
