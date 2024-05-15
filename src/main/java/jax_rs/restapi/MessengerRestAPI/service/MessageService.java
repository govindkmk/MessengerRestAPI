package jax_rs.restapi.MessengerRestAPI.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import jax_rs.restapi.MessengerRestAPI.database.DatabaseClass;
import jax_rs.restapi.MessengerRestAPI.exception.DataNotFoundException;
import jax_rs.restapi.MessengerRestAPI.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello", "Govind Kumar"));
		messages.put(2L, new Message(2, "Hi", "Rakesh Kumar"));
	}
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()) {
			calendar.setTime(message.getCreatedDate());
			if(calendar.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("Message with id " + id + " not found.");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put((long) message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put((long) message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long id) {
		return messages.remove(id); 
	}
}
