package com.group1.monolithsem4.service;

import com.group1.monolithsem4.dto.temp.TempCriteria;
import com.group1.monolithsem4.dto.temp.TempRequest;
import com.group1.monolithsem4.dto.temp.TempResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface TempService {
    void create(TempRequest tempRequest);

    Page<TempResponse> getAll(TempCriteria tempCriteria);

    void update(Integer id, TempRequest tempRequest);

    void delete(Map<Integer, Long> ids);

    TempResponse getById(Integer id);
}
