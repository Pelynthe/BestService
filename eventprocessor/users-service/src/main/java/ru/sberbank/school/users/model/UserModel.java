package ru.sberbank.school.users.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

	long id;
	String username;
	String email;
	String firstName;
	String lastName;
}
