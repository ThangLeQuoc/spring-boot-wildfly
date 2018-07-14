package com.thanglequoc.departments;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    DepartmentHelper departmentHelper;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DepartmentEntity> getAllDepartmentEntity() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity getDepartmentEntityById(String id) {
        return departmentRepository.findOne(id);
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = getAllDepartmentEntity();
        return departmentHelper.convertToDtos(departmentEntities);
    }

    public DepartmentDto getDepartmentById(String id) {
        /*
        DepartmentEntity departmentEntity = getDepartmentEntityById(id);
        return departmentHelper.convertToDto(departmentEntity);
        */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DepartmentEntity> cq = cb.createQuery(DepartmentEntity.class);
        Root<DepartmentEntity> departmentRoot = cq.from(DepartmentEntity.class);
        cq.select(departmentRoot).where(cb.equal(departmentRoot.get(DepartmentEntity_.NUMBER), id ));
        List<DepartmentEntity> result = em.createQuery(cq).getResultList();
        return CollectionUtils.isNotEmpty(result) ? departmentHelper.convertToDto(result.get(0)) : null;
    }

}
