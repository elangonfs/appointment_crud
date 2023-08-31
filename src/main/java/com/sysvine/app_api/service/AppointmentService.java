package com.sysvine.app_api.service;

import com.sysvine.app_api.model.AppointmentDetails;

import java.util.List;

/**
 * AppointmentService contains  interface with method for AppointmentServiceImpl class
 */

public interface AppointmentService {
     AppointmentDetails addAppointmentDetails(AppointmentDetails appointmentDetails);
     List<AppointmentDetails> getAllAppointmentDetails();

     AppointmentDetails getAppointmentDetailsId(long id);

     AppointmentDetails updateAppointmentDetails(long id, AppointmentDetails appointmentDetails);

     String deleteAppointmentDetailsById(long id);
}
