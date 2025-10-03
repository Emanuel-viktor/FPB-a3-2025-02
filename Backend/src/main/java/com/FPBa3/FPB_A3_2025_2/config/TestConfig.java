package com.FPBa3.FPB_A3_2025_2.config;


import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.FPBa3.FPB_A3_2025_2.Enum.TypeOfcomplaint;
import com.FPBa3.FPB_A3_2025_2.entities.Complaint;
import com.FPBa3.FPB_A3_2025_2.entities.Event;
import com.FPBa3.FPB_A3_2025_2.entities.User;
import com.FPBa3.FPB_A3_2025_2.repositories.ComplaintRepository;
import com.FPBa3.FPB_A3_2025_2.repositories.EventRepository;
import com.FPBa3.FPB_A3_2025_2.repositories.UserRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {
	

@Autowired
private UserRepository userRepository;
@Autowired
private EventRepository eventRepository;
@Autowired
private ComplaintRepository complaintRepository;
@Override
public void run(String... args) throws Exception {
	
	LocalDateTime dateTimeY1 = LocalDateTime.of(2025, 8, 1, 15, 20);
	
	User u1 =new User(null, "Adm1", "adm1fpbproject@gmail.com", "123456");
	userRepository.saveAll(Arrays.asList(u1));
	
	User u2 =new User(null, "Adm2", "adm2fpbproject@gmail.com", "1234567");
	userRepository.saveAll(Arrays.asList(u2));
	
	Event ev1 = new Event(null, "Sao joao", "Evento publico", LocalDateTime.now(), "Praça do povo", null, u1);
    eventRepository.saveAll(Arrays.asList(ev1));
    
    Event ev2 =new Event(null, "Ação social", "Evento comunitario", dateTimeY1, "Praça getulio vargas", null, u2);
    eventRepository.saveAll(Arrays.asList(ev2));
	Complaint Cp1 = new Complaint(null,  TypeOfcomplaint.ASSALTO, "Assalto mao armada", LocalDateTime.now(), "Rua projetada 178", null, u1);
	complaintRepository.saveAll(Arrays.asList(Cp1));
	
	Complaint Cp2 = new Complaint(null,  TypeOfcomplaint.ACIDENTE, "Acidente de carro ", LocalDateTime.now(), "Rua paraiba 20", null, u2);
	complaintRepository.saveAll(Arrays.asList(Cp2));
}


}


