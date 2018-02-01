package com.example.administrator.a20180130_ratrofit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018-01-30.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private Integer id;
    private String name;
    private Integer price;
    private  String img;

}
