package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.LocationDto;
import com.staff.staffAttendance.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locations")
public class GenerateQRRestController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseDTO findAll(){
        return this.locationService.findAll();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody LocationDto locationDto) {
        return this.locationService.create(locationDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody LocationDto locationDto){
        return this.locationService.update(locationDto);
    }

    @DeleteMapping("/delete/{loc_seq}")
    public ResponseDTO delete(@PathVariable int loc_seq){
        return this.locationService.delete(loc_seq);
    }


}
