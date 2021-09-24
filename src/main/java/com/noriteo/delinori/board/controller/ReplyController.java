package com.noriteo.delinori.board.controller;

import com.noriteo.delinori.board.dto.ReplyDTO;
import com.noriteo.delinori.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("")
    public int add(@RequestBody ReplyDTO replyDTO) {//JSON으로 보내주는 데이터를 DTO로 바꿔준다.

        log.info("====================");
        log.info(replyDTO);

        return replyService.add(replyDTO);

    }

    @GetMapping("/list/{bno}")//replies/list/130
    public List<ReplyDTO> getBoardReplies(@PathVariable(name = "bno")Long bno){
        //서비스 계층 호출
        return replyService.getRepliesWithBno(bno);//생성자 생성 해야함 service
    }

    @DeleteMapping("/{rno}")
    public String remove(@PathVariable(name = "rno")Long rno) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-------------------------------reply remove-----------------");

        replyService.remove(rno);

        log.info("rno: " + rno);

        return "success";
    }

    @PutMapping("/{rno}")
    public String modify(@PathVariable(name = "rno")Long rno,
                         @RequestBody ReplyDTO replyDTO) {
        log.info("-------------------reply--------------" + rno);
        log.info(replyDTO);
        replyService.modify(replyDTO);
        return "success";
    }

}
