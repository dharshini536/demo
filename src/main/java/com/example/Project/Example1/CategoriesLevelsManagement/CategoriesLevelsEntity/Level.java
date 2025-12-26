package com.example.Project.Example1.CategoriesLevelsManagement.CategoriesLevelsEntity;

import com.example.Project.Example1.BatchManagement.BatchEntity.BatchEntity;
import com.example.Project.Example1.Staff_Management.entity.StaffEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String levelName;
    @OneToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;
    @OneToMany(mappedBy = "level", cascade = CascadeType.REMOVE)
    private List<LevelHelper> maps;
    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private BatchEntity batch;

    public List<LevelHelper> getMaps() {
        return maps;
    }

    public void setMaps(List<LevelHelper> maps) {
        this.maps = maps;
    }

    public BatchEntity getBatch() {
        return batch;
    }

    public void setBatch(BatchEntity batch) {
        this.batch = batch;
    }

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}

