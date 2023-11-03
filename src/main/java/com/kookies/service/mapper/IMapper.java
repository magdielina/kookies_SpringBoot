package com.kookies.service.mapper;

import com.kookies.service.dto.IDTO;

import java.util.List;

public interface IMapper<T, DTO extends IDTO> {

    T toEntity(DTO dto);

    DTO toDTO(T T);

    List<DTO> toDTOList(List<T> entiyList);
}
