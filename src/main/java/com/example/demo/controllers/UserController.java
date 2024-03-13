package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.IMCDTO;
import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController{

    @Autowired
    private UserService userService;
    
    
    @ModelAttribute("user")
    public UserDTO newUser() {
    	return new UserDTO();
    }
    
    @ModelAttribute("IMC")
    public IMCDTO newIMC() {
    	return new IMCDTO();
    }
    
    
    
    @GetMapping("/registro")
    public String registro() {
    	return "registro";
    }
    
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("user") UserDTO userDTO,@ModelAttribute("IMC") IMCDTO imcDTO) {    	
    	List<UserModel> users = userService.getUsers();
    	
    	
    	for(int i = 0; i < users.size(); i++) {
    		if(userDTO.getUsername().equals(users.get(i).getUsername())) {
    			userDTO.setUsername(null);
    			return "registro";
    		}
    	}
    	
    	
    	try {
    		if(Integer.parseInt(userDTO.getAge()) < 15) {
    			userDTO.setAge("15");
    			return "registro";

        		
        	};
    	}catch(NumberFormatException e) {
    		userDTO.setAge("15");
			return "registro";

    	}

    	if (userDTO.getPassword().equals(userDTO.getConfirm_password())) {
			imcDTO.setUsername(userDTO.getUsername());
    		userService.save(userDTO);
        	return "menu";
    	}else {
    		return"registro";
    	}
    	
    }
    
    
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @PostMapping("/logged")
    public String logged(@ModelAttribute("user") UserDTO userDTO,@ModelAttribute("IMC") IMCDTO imcDTO) {
    	
    	List<UserModel> users = userService.getUsers();
    	
    	for(int i = 0; i < users.size(); i++) {
    		if(users.get(i).getPassword().equals(userDTO.getPassword()) &&
    				users.get(i).getUsername().equals(userDTO.getUsername())){
    			imcDTO.setUsername(userDTO.getUsername());
    			return menu();
    		}
    	}
    	return "login";
    	
    	
    }
    
    @PostMapping("/logout")
    public String logout() {
    	return "index";
    	
    	
    }
    
    @GetMapping("/menu")
    public String menu() {
    	return "menu";
    } 
    
    @PostMapping("/res")
    public String registrar(@ModelAttribute("IMC") IMCDTO imcDTO){
    	
    	if(imcDTO.getAltura() >2.5 || imcDTO.getAltura() < 1.0) {
    		imcDTO.setAltura(0.5);
    		return "menu";
    	}
    	
    	if(imcDTO.getPeso() < 10) {
    		return "menu";

    	}
    	
    	userService.saveIMC(imcDTO);
    	return "menu";
    } 
     
    
    
    
    
    

    
    
   
    

}
