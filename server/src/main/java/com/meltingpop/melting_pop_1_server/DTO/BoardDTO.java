package com.meltingpop.melting_pop_1_server.DTO;

import com.meltingpop.melting_pop_1_server.vo.BoardVO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private Long idx;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public BoardVO toEntity(){
        BoardVO build = BoardVO.builder()
                .idx(idx)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDTO(Long idx, String author, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.idx = idx;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
