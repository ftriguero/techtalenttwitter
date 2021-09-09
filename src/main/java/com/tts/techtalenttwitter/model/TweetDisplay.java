package com.tts.techtalenttwitter.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetDisplay 
{
	private User user;
	private String message;
	private String date; //This is the reason TweetDisplay exists. We want to store the date 
						//in a different format.
	private List<Tag> tags;
}
