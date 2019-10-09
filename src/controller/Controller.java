package controller;


import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import entity.Member;
import entity.Profile;
import entity.users;
import service.Service;

/**
 * 
 * @author Nishant Tiwari
 * @Created-at : 01-08-2019 12:15
 *
 */

@Path("/demo")
public class Controller 
{
//	Client client = ClientBuilder.newClient();
//	WebTarget webTarget 
//	  = client.target("https://jsonplaceholder.typicode.com/");
//	WebTarget users = client.target("users");
//	Invocation.Builder userinvoke 
//	  = users.request(MediaType.APPLICATION_JSON);
//	
	
	Service service = new Service();
	
	/**
	 * To Implement a Method for Response Header
	 * @Created-at : 01-08-2019 12:15
	 * @param Object entity which needs to be included as Response
	 * @return Response Object
	 */
	public Response setResponse(Object entity) {
		ResponseBuilder respBuilder = Response.ok(entity);
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Credentials", "true")
//			      .header("Access-Control-Allow-Headers",
//			        "origin, content-type, accept, authorization")
//			      .header("Access-Control-Allow-Methods", 
//			        "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		return respBuilder.build();
	}
	
	/**
	 *@Deprecated
	 *@Created-at : 01-08-2019 12:15
	 */
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<users> getAllusers()
	{
		
		return service.getAllusers();
	}
	
	/**
	 *@Deprecated
	 *@Created-at : 01-08-2019 12:15
	 */
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public users getInternById(@PathParam("id") int id)
	{
		return service.getuserById(id);
	}
	
	
	/*
	 * -------------------------Methods for Members---------------------------------
	 */
	
	/**
	 * To Implement Response for /getMembers which will return all the members from Databases
	 * @Created-at : 01-08-2019 12:15
	 * @param Object entity which needs to be included as Response
	 * @return Response Object
	 */
	@GET
	@Path("/getMembers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllmembers()
	{
		return setResponse(service.getAllMembers());//setResponse(serv.getAllMembers());
	}
	
	/**
	 * To Implement Response for /getMembers with mobile will return a specific member from Databases
	 * @Created-at : 01-08-2019 12:15
	 * @param Object entity which needs to be included as Response
	 * @return Response Object
	 */
	
	@GET
	@Path("/getMembers/{mobile}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getMemberById(@PathParam("mobile") String mobile)
	{
		return setResponse(service.getMemberById(mobile));
	}
	
	
	/**
	 * To Implement Response for /getMembers with Profile will return a specific member from Databases
	 * @Created-at : 01-08-2019 12:15
	 * @param mobile which will be in URL Path
	 * @return Response Object
	 */
	
	@GET
	@Path("/getMembersProfile/{mobile}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMemberProfile(@PathParam("mobile") String mobile)
	{
		return setResponse(service.getMemberProfile(mobile).equals(null)? false : service.getMemberProfile(mobile));
	}
	

	
	/**
	 * To Implement Response for /login
	 * Authenticates the param from database 
	 * @Created : 01-08-2019 12:15
	 * @param Object entity which needs to be included as Response
	 * @return Response Object which will be boolean in case of invalid user and an Object of data in case of valid
	 */
	@POST
	@Path("/Login")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes({"application/x-www-form-urlencoded"})
	public Response Login(
			@FormParam("Password") String password,
			@FormParam("Username") String mobile,
			@Context Request request
			)
	{
		Response res = null;
		Profile prof = service.Login(mobile, password);
		
		if(prof != null) {
			res = setResponse(prof);
			
		}else {
			res =setResponse(false);
		}
			
		
		return res;
	}

	/**
	 * To Implement a Member Data Update Method with POST URL
	 * @Created-at : 01-08-2019 12:15
	 * @param Object entity which needs to be updated
	 * @return Response Object status
	 */
	@POST
	@Path("/setMember")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes({"application/x-www-form-urlencoded"})
	public Response setMember(
			@FormParam("FirstName") String fname,
			@FormParam("LastName") String lname,
			@FormParam("Age") int age,
			@FormParam("Address") String address,
			@FormParam("Email") String email,
			@FormParam("Mobile") String mobile,
			@Context Request request
			)
	{
		boolean status = service.setMember(new Member(fname,lname, age, address, mobile,email));
		
		return setResponse(status);
	}
}
