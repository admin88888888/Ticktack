package com.qianfeng.service;

import com.qianfeng.entity.depart;
import com.qianfeng.vo.VDepart;

import java.util.List;

public interface DepartService {

    public List<VDepart> findByAll();

    public void deleteId(int id);

    public void add(depart depart);

    public void updateDepart(depart depart);

}
