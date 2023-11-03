package com.kookies.service;

import com.kookies.service.dto.IDTO;

import java.util.List;
import java.util.Optional;

public interface ICRUDService<DTO extends IDTO,ID> {

    DTO save(DTO dto);
    DTO update(DTO dto);
    List<DTO> findAll();
    Optional<DTO> findById(ID id);
    void delete(ID id);
}
