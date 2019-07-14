package ru.sberbank.school.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	long id;
	String username;
	String email;
	String firstName;
	String lastName;
}
