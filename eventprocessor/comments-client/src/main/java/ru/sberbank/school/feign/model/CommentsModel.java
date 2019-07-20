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
public class CommentsModel {

	private long id;
	private long newsId;
	private long eventId;
	private long userId;
	private String body;
	private Timestamp timestamp;

}
