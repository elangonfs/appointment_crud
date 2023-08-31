package com.sysvine.app_api.service;

import com.sysvine.app_api.dao.AppointmentDetailsDao;
import com.sysvine.app_api.model.AppointmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * AppointmentServiceImpl contains implementation for CRUD operations of Appointment details.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentDetailsDao appointmentDetailsDao;

    /**
     * The method addAppointmentDetails used to create new appointment for request object
     * and returns a corresponding response to controller class.
     * @param appointmentDetails request object.
     * @return response.
     */
    @Override
    public AppointmentDetails addAppointmentDetails(AppointmentDetails appointmentDetails) {
        Date date = new Date();
        appointmentDetails.setCreatedTime(date);
        appointmentDetails.setModifiedTime(date);
        return appointmentDetailsDao.save(appointmentDetails);
    }

    /**
     * The method addAppointmentDetails used to get all appointments from database
     * and returns a corresponding response to controller class.
     * @return response.
     */
    @Override
    public List<AppointmentDetails> getAllAppointmentDetails() {
        return appointmentDetailsDao.findAll();
    }

    /**
     * The method getAllAppointmentDetails used to get appointment for requested id
     * and returns a corresponding response to controller class.
     * @param id request id.
     * @return response.
     */
    @Override
    public AppointmentDetails getAppointmentDetailsId(long id) {
        Optional<AppointmentDetails> appointmentDetails = appointmentDetailsDao.findById(id);
        if (appointmentDetails.isPresent()) {
            return appointmentDetails.get();
        }
        return null;
    }

    /**
     * The method updateAppointmentDetails used to update appointment for requested id, if appointment
     * present in the database and returns a corresponding response to controller class.
     * @param id request id
     * @param appointmentDetails request object.
     * @return response.
     */
    @Override
    public AppointmentDetails updateAppointmentDetails(long id,AppointmentDetails appointmentDetails) {
        Optional<AppointmentDetails> appointment1 = appointmentDetailsDao.findById(id);
        Date date = new Date();
        if (appointment1.isPresent()) {
            AppointmentDetails updateAppointment = appointment1.get();
            updateAppointment.setModifiedTime(date);
            if (Objects.nonNull(appointmentDetails.getPatientName()) && !"".equalsIgnoreCase(appointmentDetails.getPatientName())) {
                updateAppointment.setPatientName(appointmentDetails.getPatientName());
            }
            if (Objects.nonNull(appointmentDetails.getDoctorName()) && !"".equalsIgnoreCase(appointmentDetails.getDoctorName())) {
                updateAppointment.setDoctorName(appointmentDetails.getDoctorName());
            }
            if (Objects.nonNull(appointmentDetails.getAppointmentDate())) {
                updateAppointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            }
            if (Objects.nonNull(appointmentDetails.getAppointmentTime())) {
                updateAppointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
            }
            return appointmentDetailsDao.save(updateAppointment);
        }
        return null;
    }

    /**
     * The method deleteAppointmentDetailsById used to delete a appointment for request id, if appointment
     * present in database and returns a corresponding response to controller class.
     * @param id request id.
     * @return response.
     */
    @Override
    public String deleteAppointmentDetailsById(long id) {
        if (appointmentDetailsDao.findById(id).isPresent()) {
            appointmentDetailsDao.deleteById(id);
            return "Appointment deleted successfully";
        }
        return "No such Appointment in the database";
    }
}
