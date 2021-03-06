package com.noriteo.delinori.board.service;

import com.noriteo.delinori.board.dto.ReplyDTO;
import com.noriteo.delinori.board.mapper.BoardMapper;
import com.noriteo.delinori.board.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService{

    private final BoardMapper boardMapper;
    private final ReplyMapper replyMapper;


    @Override
    public int add(ReplyDTO replyDTO) {
        int count = replyMapper.insert(dtoToEntity(replyDTO));
        boardMapper.updateReplyCnt(replyDTO.getBno(),1);

        return count;
    }

    @Override
    public List<ReplyDTO> getRepliesWithBno(Long bno) {
        return replyMapper.getListWithBoard(bno).stream()
                .map(reply -> entityToDTO(reply)).collect(Collectors.toList());//한줄로 끝내는 방법 이것도 이해는 못함..
    }

    @Override
    public int remove(Long rno) {
        return replyMapper.delete(rno);
    }

    @Override
    public int modify(ReplyDTO replyDTO) {
        return replyMapper.update(dtoToEntity(replyDTO));
    }


}
