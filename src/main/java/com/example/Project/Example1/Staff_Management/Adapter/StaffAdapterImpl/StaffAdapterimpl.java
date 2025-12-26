package com.example.Project.Example1.Staff_Management.Adapter.StaffAdapterImpl;

import com.example.Project.Example1.Staff_Management.Adapter.StaffAdapter;
import com.example.Project.Example1.Staff_Management.entity.StaffEntity;
import com.example.Project.Example1.Staff_Management.repository.StaffRepository;
import org.springframework.stereotype.Component;


@Component
public class StaffAdapterimpl implements StaffAdapter {
    private final StaffRepository staffRepository;
    public StaffAdapterimpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public StaffEntity saveStaff(StaffEntity entity) {
        return staffRepository.save(entity);
    }
}
