package ru.sberbank.school.feign.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsModel {

	private long id;

	private int idEvent;

	private String text;

	private Timestamp timestamp;
}
