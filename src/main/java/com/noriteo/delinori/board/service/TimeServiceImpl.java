package com.noriteo.delinori.board.service;


import com.noriteo.delinori.board.mapper.TimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService{

    private final TimeMapper timeMapper;


    @Override
    public String getNow() {


        return timeMapper.getTime();

    }

}
