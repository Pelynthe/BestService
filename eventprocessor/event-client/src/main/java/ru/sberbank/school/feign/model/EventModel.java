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
public class EventModel {

	private long id;
	private long userId;
	private String header;
	private String body;
	private Timestamp timestamp;

}
