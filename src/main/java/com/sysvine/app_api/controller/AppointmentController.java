package com.sysvine.app_api.controller;

import com.sysvine.app_api.model.AppointmentDetails;
import com.sysvine.app_api.service.AppointmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AppointmentController class is responsible for processing incoming REST API requests,
 * preparing a model, and returning the view to be rendered as a response.
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private static Logger logger =  Logger.getLogger(AppointmentController.class);
    @Autowired
    AppointmentService appointmentService;

    /**
     * The method createAppointment used to create new appointment for http request
     * and returns a corresponding response as json format.
     * The @PostMapping annotation is a Spring annotation that is used to map HTTP POST requests onto specific handler methods.
     * @param appointmentDetails request object.
     * @return response.
     */
    @PostMapping("/")
    public AppointmentDetails createAppointment(@RequestBody AppointmentDetails appointmentDetails) {
        logger.info("AppointmentController(createAppointment) >> Entry :" + appointmentDetails);
        return appointmentService.addAppointmentDetails(appointmentDetails);
    }

    /**
     * The method getAllAppointments used to get all appointments for http request
     * and returns a corresponding response as json format.
     *  @GetMapping annotation for mapping HTTP GET requests onto specific handler methods.
     * @return response.
     */
    @GetMapping("/")
    public List<AppointmentDetails> getAllAppointments() {
        logger.info("AppointmentController(getAllAppointments) >> Entry :");
        return appointmentService.getAllAppointmentDetails();
    }


    /**
     * The method getAppointmentById used to get a appointments for http request id
     * and returns a corresponding response as json format.
     *  @GetMapping annotation for mapping HTTP GET requests onto specific handler methods.
     * @param id request id
     * @return response.
     */
    @GetMapping("/{id}")
    public AppointmentDetails getAppointmentById(@PathVariable(value = "id") Long id) {
        logger.info("AppointmentController(getAppointmentById) >> Entry :" + id);
        return appointmentService.getAppointmentDetailsId(id);
    }

    /**
     * The method updateAppointment used to update a appointments for http request id
     * and returns a corresponding response as json format.
     *  PATCH is used when you want to apply a partial update to the resource and
     *  @PatchMapping annotation for mapping HTTP PATCH requests onto specific handler methods..
     * @param id request id
     * @param appointmentDetails request objects
     * @return response.
     */
    @PatchMapping("/{id}")
    public AppointmentDetails updateAppointment(@PathVariable("id") Long id, @RequestBody AppointmentDetails appointmentDetails) {
        logger.info("AppointmentController(updateAppointment) >> Entry :" + id);
        return appointmentService.updateAppointmentDetails(id, appointmentDetails);
    }

    /**
     * The method getAppointmentById used to delete a appointments for http request id
     * and returns a corresponding response as json format.
     *  @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods..
     * @param id request id
     * @return response.
     */
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        logger.info("AppointmentController(deleteAppointment) >> Entry :" + id);
        return appointmentService.deleteAppointmentDetailsById(id);
    }
}
