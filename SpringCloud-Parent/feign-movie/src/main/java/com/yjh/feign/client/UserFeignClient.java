package com.yjh.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjh.feign.entity.User;

@FeignClient("feign-user")
public interface UserFeignClient {

	/**注意使用feign的两个坑：
	 * 	
	 * 	1. 虽然@GetMapping等效于@RequestMapping(value="",method=RequestMethod.GET)注解，
	 * 	       但是只能使用下面这种方式.（即：feign不支持@GetMapping）
	 * 
	 * 	2. 在springmvc中@PathVariable()不写值，默认与 id名一致，但是此处必须要写成
	 * 	   @PathVariable("id")这样。（即：@PathVariable必须要写value值）
	 */
	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	/**该请求不会成功，因为：
	 * 		只要接收的参数是复杂对象，即使指定了是GET方法，feign依然会以post方式发送请求。
	 * 		
	 * 		若要接收多个参数就这样写：
	 * 
	 * public User getUser(@Params("id") String id,@Params("username") String username);
	 *
	 */
	@RequestMapping(value = "/get-user", method = RequestMethod.GET)
	public User getUser(User user);
}
