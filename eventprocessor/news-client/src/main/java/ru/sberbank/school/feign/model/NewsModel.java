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

	private long eventId;

	private String headline;

	private String body;

	private Timestamp timestamp;
}
