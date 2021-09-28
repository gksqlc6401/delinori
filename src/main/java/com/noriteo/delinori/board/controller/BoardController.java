package com.noriteo.delinori.board.controller;

import com.noriteo.delinori.board.dto.BoardDTO;
import com.noriteo.delinori.board.service.BoardService;
import com.noriteo.delinori.board.service.TimeService;
import com.noriteo.delinori.common.dto.PageMaker;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final TimeService timeService;

    private final BoardService boardService;

    @GetMapping("/time")
    public void getTime(int num, Model model) {
        log.info("================controller getTime===================");
        model.addAttribute("time", timeService.getNow());

        log.info(num % 0);
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {

        log.info("boardDTO :" +boardDTO);

        Long bno = boardService.register(boardDTO);

        log.info("===================c : ");
        log.info(bno);
        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/register")
    public void registerGet() {

    }



    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        log.info("c   getList......................" + pageRequestDTO);

        log.info("================================");
        log.info(boardService);
        log.info("================================");

        PageResponseDTO<BoardDTO> responseDTO = boardService.getDTOList(pageRequestDTO);//제네릭타입이 정해진다
        //responseDTO에 카운트, boardDTO,보드리퀘스트DTO가 담겨있다

        model.addAttribute("dtoList",responseDTO.getDtoList());

        int total = responseDTO.getCount();
        int page = pageRequestDTO.getPage();
        int size = pageRequestDTO.getSize();

        model.addAttribute("pageMaker", new PageMaker(page, size, total));
        model.addAttribute("pageRequestDTO", pageRequestDTO);


    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/read")
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("c      read        "+bno);
        model.addAttribute("boardDTO", boardService.read(bno));
    }

    @PostMapping
    public String remove(Long bno, RedirectAttributes redirectAttributes) {

        log.info("c             remove:" +bno);

        boardService.remove(bno);
//        if(boardService.remove(bno)) {
              log.info("remove success");
//            redirectAttributes.addFlashAttribute("result","success");
//        }

        return "redirect:/board/list";

    }

//    @PostMapping("/modify")
//    public void modify(BoardDTO boardDTO, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
//        log.info("=========================================");
//        log.info("=========================================");
//        log.info("=========================================");
//        log.info("=========================================");
//        log.info(boardDTO);
//        log.info("=========================================");
//        log.info("=========================================");
//        log.info("=========================================");
//
//        redirectAttributes.addAttribute("bno",boardDTO.getBno());
//        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
//        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());

//        return "redirect:/board/read";
//    }

}
