package com.group1.monolithsem4.controller;

import com.group1.monolithsem4.dto.temp.TempCriteria;
import com.group1.monolithsem4.dto.temp.TempRequest;
import com.group1.monolithsem4.dto.temp.TempResponse;
import com.group1.monolithsem4.service.TempService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Map;

import static com.group1.monolithsem4.controller.EndPoints.TEMP_PATH;

@RequestMapping(TEMP_PATH)
@RestController
@Slf4j
@RequiredArgsConstructor
public class TempController {

    private final TempService tempService;

    @GetMapping
    public Page<TempResponse> getAll (@Valid TempCriteria tempCriteria) {
        return tempService.getAll(tempCriteria);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TempRequest tempRequest) {
        tempService.create(tempRequest);
    }

    @PutMapping("{id}")
    public void update (@PathVariable("id")Integer id, @RequestBody @Valid TempRequest tempRequest) {
        tempService.update(id, tempRequest);
    }

    @DeleteMapping
    public void delete (Map<Integer, Long> ids) {
        tempService.delete(ids);
    }

    @GetMapping("{id}")
    public TempResponse getById(@PathVariable("id") Integer id) {
        return tempService.getById(id);
    }


}
