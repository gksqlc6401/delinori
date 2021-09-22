package com.noriteo.delinori.board.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeService {

    String getNow();

}
