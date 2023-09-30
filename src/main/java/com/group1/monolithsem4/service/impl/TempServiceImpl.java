package com.group1.monolithsem4.service.impl;

import com.group1.monolithsem4.dto.temp.TempCriteria;
import com.group1.monolithsem4.dto.temp.TempRequest;
import com.group1.monolithsem4.dto.temp.TempResponse;
import com.group1.monolithsem4.exception.ResourceNotFoundException;
import com.group1.monolithsem4.mapstruct.TempMapper;
import com.group1.monolithsem4.model.TempEntity;
import com.group1.monolithsem4.repository.TempRepository;
import com.group1.monolithsem4.service.TempService;
import com.group1.monolithsem4.specification.TempSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TempServiceImpl implements TempService {

    private final TempRepository tempRepository;

    private final TempMapper mapper;


    @Autowired
    private final TempSpecification tempSpecification;

    private ResourceNotFoundException buildNotFoundException(int id) {
        return new ResourceNotFoundException("Not found entity with id: " + id);
    }

    @Override
    @Transactional
    public void create(TempRequest tempRequest) {
        tempRepository.save(mapper.toEntity(tempRequest));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TempResponse> getAll(TempCriteria tempCriteria) {
        return tempRepository.findAll(tempSpecification.getTempCriteria(tempCriteria), tempCriteria.getPageable())
                .map(mapper::toResponse);
    }

    @Override
    @Transactional
    public void update(Integer id, TempRequest tempRequest) {
        tempRepository.findById(id).ifPresent(tempEntity -> {
            mapper.toEntity(tempRequest, tempEntity);
            tempRepository.save(tempEntity);
        });
    }

    @Override
    @Transactional
    public void delete(Map<Integer, Long> ids) {
        List<TempEntity> tempEntityList = tempRepository.findAllById(ids.keySet());
        tempEntityList.forEach(tempEntity -> tempEntity.setDeleteFlag(true));
        tempRepository.saveAll(tempEntityList);
    }

    @Override
    @Transactional(readOnly = true)
    public TempResponse getById(Integer id) {
        return tempRepository.findById(id).map(mapper::toResponse)
                .orElseThrow(() -> buildNotFoundException(id));
    }
}
