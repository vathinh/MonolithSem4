package com.group1.monolithsem4.mapstruct;


import com.group1.monolithsem4.dto.temp.TempRequest;
import com.group1.monolithsem4.dto.temp.TempResponse;
import com.group1.monolithsem4.model.TempEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TempMapper {

    TempEntity toEntity(TempRequest tempRequest);

    TempResponse toResponse(TempEntity tempEntity);

    void toEntity(TempRequest request, @MappingTarget TempEntity tempEntity);



}
