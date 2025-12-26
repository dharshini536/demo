package com.example.Project.Example1.Staff_Management.facad;

import com.example.Project.Example1.Staff_Management.Service.StaffSevice;
import com.example.Project.Example1.Staff_Management.dto.StaffRegisterDto;
import com.example.Project.Example1.Staff_Management.mapper.StaffDtoMapper;
import com.example.Project.Example1.Staff_Management.model.StaffRegisterModel;
import org.springframework.stereotype.Component;

@Component
public class StaffFacad {
    private final StaffSevice staffSevice;
    private final StaffDtoMapper staffDtoMapper;

    public StaffFacad(StaffSevice staffSevice, StaffDtoMapper staffDtoMapper) {
        this.staffSevice = staffSevice;
        this.staffDtoMapper = staffDtoMapper;
    }

    public StaffRegisterDto createStaff(StaffRegisterDto staffRegisterDto) {
        StaffRegisterModel staffRegisterModel = staffDtoMapper.toModel(staffRegisterDto);
        StaffRegisterModel model= staffSevice.saveStaff(staffRegisterModel);
        return staffDtoMapper.toDto(model);
    }
}
