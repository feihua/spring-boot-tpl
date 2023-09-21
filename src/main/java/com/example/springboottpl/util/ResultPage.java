package com.example.springboottpl.util;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultPage<T> implements Serializable {

	private List<T> list;
	private Integer pageNum;
	private Integer pageSize;
	private long total;

}
