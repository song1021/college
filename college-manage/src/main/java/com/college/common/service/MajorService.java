package com.college.common.service;

import com.college.common.entity.Major;
import com.college.common.entity.Page;

import java.util.List;


public interface MajorService {

    public Major getById(int id);
    public boolean add(Major major);
    public boolean update(Major major);
    public boolean delete(int mid);

    public List<Major> getAll();
    public List<Major> getList(Integer cid);
    public Page<Major> getAll(Major major, int pageNo, int limit);
}
