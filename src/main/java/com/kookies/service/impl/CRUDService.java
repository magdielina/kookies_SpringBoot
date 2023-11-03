package com.kookies.service.impl;

import com.kookies.persistence.repository.IGenericRepo;
import com.kookies.service.ICRUDService;
import com.kookies.service.dto.IDTO;
import com.kookies.service.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class CRUDService<T, DTO extends IDTO, M extends IMapper<T, DTO>, ID> implements ICRUDService<DTO, ID>{

    private M mapper;

    @Autowired
    public CRUDService(M mapper) {
        this.mapper = mapper;
    }

    protected abstract IGenericRepo<T, ID> getRepo();
    @Override
    public DTO save(DTO dto) {
        T entity = mapper.toEntity(dto);
        T saved = getRepo().save(entity);
        DTO savedDTO = mapper.toDTO(saved);
        return savedDTO;
    }

    @Override
    public DTO update(DTO dto) {
        T entity = mapper.toEntity(dto);
        T saved = getRepo().save(entity);
        DTO updatedDTO = mapper.toDTO(saved);
        return updatedDTO;
    }

    @Override
    public List<DTO> findAll() {
        List<T> entityList = getRepo().findAll();
        return mapper.toDTOList(entityList);
    }

    @Override
    public Optional<DTO> findById(ID id) {
        Optional<T> opt = getRepo().findById(id);
        T entity = opt.orElse(null);
        return Optional.ofNullable(mapper.toDTO(entity));
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }
}
