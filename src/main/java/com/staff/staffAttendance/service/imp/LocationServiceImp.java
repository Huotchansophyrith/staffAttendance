package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.LocationDto;
import com.staff.staffAttendance.mapper.LocationMapper;
import com.staff.staffAttendance.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {

    @Autowired
    private LocationMapper locationMapper;

    private final String FIND_SUCCESS ="Find Successfully";
    private final String CREATE_SUCCESS ="Create Successfully";
    private final String UPDATE_SUCCESS ="Update Successfully";
    private final String EXSITS ="Existing Data";
    private final String DELETE ="Delete Successfully";

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<LocationDto> loc = this.locationMapper.findAll();
        return new ResponseDTO(FIND_SUCCESS,loc);
    }

    @Override
    public ResponseDTO create(LocationDto locationDto) throws RequestException {
        String locName = this.locationMapper.findByLocName(locationDto.getName());
        if (locName == null){
            this.locationMapper.create(locationDto);
            return new ResponseDTO(CREATE_SUCCESS);
        }
        return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
    }

    @Override
    public ResponseDTO update(LocationDto locationDto) throws RequestException {
        this.locationMapper.findById(locationDto.getLocSeq());
        try{
            this.locationMapper.update(locationDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }

    @Override
    public ResponseDTO delete(int logSeq) throws RequestException {
        this.locationMapper.delete(logSeq);
        return new ResponseDTO(DELETE);
    }
}
