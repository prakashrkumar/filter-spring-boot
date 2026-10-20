package in.prakash.filter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FilterApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void createsStudentFromJsonRequest() throws Exception {
		mockMvc.perform(post("/api/students")
						.header("token", "12345")
						.header("x-api-key", "secret123")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{"id":123,"name":"prakash kumar","email":"prakash@example.com"}
								"""))
				.andExpect(status().isOk())
				.andExpect(content().json("""
						{
						  "name": "prakash kumar",
						  "message": "Student is saved successFully"
						}
						"""));
	}
}
