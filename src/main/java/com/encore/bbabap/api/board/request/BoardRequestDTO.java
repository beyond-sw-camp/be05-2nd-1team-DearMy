package com.encore.bbabap.api.board.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardRequestDTO {
    private String title;
    private String content;
}