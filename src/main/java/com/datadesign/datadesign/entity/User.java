package com.datadesign.datadesign.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    private String usetId;
    private String name;
    private String email;

}
