package com.noriteo.delinori.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/board")
public class SampleController {

    @GetMapping("/doAdmin")
    public void doAll() {
        log.warn("doAdmin..........................");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/doDeli")
    public void doMamber() {
        log.warn("doDeli..........................");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doNori")
    public void doAdmin() {
        log.warn("doNori..........................");
    }

}
