package co.company.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TV {
	@Autowired 
	@Qualifier("appleSpeaker")
	Speaker speaker;
	public void volumeup() {
		speaker.volumeup(); 
	}
	
	public TV() {
		System.out.println("TV 생성됨"); 
	}
	public void init() {
		System.out.println("init 생성됨");
	}
	public void destroy() {
		System.out.println("destroy 소멸됨");
	}
}
