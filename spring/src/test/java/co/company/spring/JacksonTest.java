package co.company.spring;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.util.URI;

import co.company.spring.controller.SlipVO;

public class JacksonTest {
	@Test
	public void test1() {
		ObjectMapper mapper = new ObjectMapper();
		String str = "[{\"slipAmount\":19326,\"salDt\":\"202101\",\"customer\":\"114\",\"bankAcct\":\"111\"}]";
		try {
			JsonNode node = mapper.readTree(str);
			System.out.println(node.get(0).path("slipAmount"));

			SlipVO[] list = mapper.readValue(str, SlipVO[].class);
			System.out.println(list[0].getSlipAmount());

			URL url = new URL(
					"http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=f5eef3421c602c6cb7ea224104795888 ");
			JsonNode movie = mapper.readTree(url);
			System.out.println(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
