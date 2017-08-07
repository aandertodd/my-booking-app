package com.toddsapp.mybookingapp.models.data;

import com.toddsapp.mybookingapp.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by margareticloud on 7/25/17.
 */
@Repository // tells spring this interface is a repository and it should manage it for us
@Transactional //specifies that all methods should be sent one at a time?
// dao = data access object
public interface AdminDao extends CrudRepository<Admin, Integer> {

    Admin findByAdminName(String adminName);
}
