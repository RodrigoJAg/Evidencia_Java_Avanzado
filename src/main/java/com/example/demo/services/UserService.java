package com.example.demo.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.IMCDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.models.IMCModel;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.IIMCRepository;
import com.example.demo.repositories.IUserRepository;



@Service
public class UserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IIMCRepository imcRepository;
	
	

	
	public UserModel save(UserDTO userDTO) {
		UserModel user = new UserModel();
		
		user.setAge(userDTO.getAge());

		user.setConfirm_password(userDTO.getConfirm_password());
		
		user.setFullname(userDTO.getFullname());
		
		user.setGender(userDTO.getGender());
		
		user.setId(userDTO.getId());
		
		user.setPassword(userDTO.getPassword());
		
		user.setUsername(userDTO.getUsername());
		
		return userRepository.save(user);
		
	}
	
	public List<UserModel> getUsers(){
		return (List<UserModel>) userRepository.findAll();
	}
	
	public List<IMCModel> getIMC(){
		return (List<IMCModel>) imcRepository.findAll();
	}
	
	public IMCModel saveIMC(IMCDTO IMCdto) {
		List<UserModel> users = getUsers();
		IMCModel imc = new IMCModel();
		
		imc.setAltura(IMCdto.getAltura());
		imc.setId(IMCdto.getId());
		imc.setPeso(IMCdto.getPeso());
		imc.setTime(ZonedDateTime.now());
		imc.setImc(IMCdto.getImc());
		imc.setImc(IMCdto.getImc());
		
		imc.setUsername(IMCdto.getUsername());
		
		for(int i = 0; i < users.size(); i++) {
			if(IMCdto.getUsername().equals(users.get(i).getUsername())) {
				imc.setUser_id(users.get(i).getId());
			}
			
		}
		
		
		
    	
		
		return imcRepository.save(imc) ;
	}
	
	
	
    
}
