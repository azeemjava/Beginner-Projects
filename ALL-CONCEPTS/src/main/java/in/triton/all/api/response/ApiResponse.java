package in.triton.all.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
@AllArgsConstructor
public class ApiResponse {

	private Object data;
	private String error;
	private Object status;
	private long code;
	
}
