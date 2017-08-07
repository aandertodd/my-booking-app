package com.toddsapp.mybookingapp.models.data;

import com.toddsapp.mybookingapp.models.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by margareticloud on 8/7/17.
 */
@Repository
@Transactional
public interface VenueDao extends CrudRepository<Venue, Integer> {
}
