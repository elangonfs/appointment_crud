package com.sysvine.app_api.dao;

import com.sysvine.app_api.model.AppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AppointmentDetailsDao used for AppointmentDetails JpaRepository
 */
@Repository
public interface AppointmentDetailsDao extends JpaRepository<AppointmentDetails, Long> {
}
