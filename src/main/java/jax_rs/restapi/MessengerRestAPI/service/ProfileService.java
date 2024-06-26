package jax_rs.restapi.MessengerRestAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jax_rs.restapi.MessengerRestAPI.database.DatabaseClass;
import jax_rs.restapi.MessengerRestAPI.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Govind Kumar", new Profile(1L, "Govind Kumar", "Govind", "Kumar"));
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
