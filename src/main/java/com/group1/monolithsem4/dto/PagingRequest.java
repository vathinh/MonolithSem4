package com.group1.monolithsem4.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public interface PagingRequest {
    default int getPage() {
        return 0;
    }

    default int getSize() {
        return 10;
    }

    default String getLastedValue() {
        return "";
    }

    default String getFirstValue() {
        return "";
    }

    default int getLastedPage() {
        return 0;
    }

    default List<String> getSort() {
        return Collections.emptyList();
    }

    default Pageable getPageable() {
        return PageRequest.of(getPage(), getSize() > 0 ? getSize() : 10);
    }
}
