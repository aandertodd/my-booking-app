package com.toddsapp.mybookingapp.models.data;

import com.toddsapp.mybookingapp.models.Shows;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by margareticloud on 7/25/17.
 */

@Repository
@Transactional
public interface ShowsDao extends CrudRepository<Shows, Integer> {
}
