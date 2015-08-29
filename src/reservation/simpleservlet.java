package reservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.sqlconnection;
import models.reservation;

public class simpleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private sqlconnection sqlcon= new sqlconnection();
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		ArrayList<reservation> arrreserv=null;
		
		if(action.equals("arrivaldeparture")){
			
			String depaircode = request.getParameter("depaircode");
			String arraircode = request.getParameter("arraircode");
			int noofcon = Integer.parseInt(request.getParameter("noofcon"));
			
		arrreserv=sqlcon.conflights(arraircode,depaircode,noofcon);
		request.setAttribute("arrayList", arrreserv);
		request.setAttribute("arrayListType", noofcon);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/conflights.jsp");

		if( null != rd ){
			rd.forward(request, response);
		}
		}
		
		else if(action.equals("fairinfo")){
			
			int flightno =  Integer.parseInt( request.getParameter("flightno")); 
			arrreserv=sqlcon.fairinfo(flightno);
			
			request.setAttribute("arrayList", arrreserv);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/fairinforesult.jsp");

			if( null != rd ){
				rd.forward(request, response);
			}
			
	
		}
		
		else if(action.equals("passengerflightlist")){
				String passname = request.getParameter("passname");
				
					arrreserv=sqlcon.passengerflightlist(passname);
					request.setAttribute("arrayList", arrreserv);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/passengerflightlistresult.jsp");

					if( null != rd ){
						rd.forward(request, response);
					}
		}
		
      else if(action.equals("passengerslist")){
    	  
			int flightno = Integer.parseInt( request.getParameter("flightno"));
			String date= request.getParameter("date");
			
			arrreserv = sqlcon.passengerslist( flightno , date);
			request.setAttribute("arrayList", arrreserv);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/passengerslistresult.jsp");

			if( null != rd ){
				rd.forward(request, response);
			}
		}
		
      else {
			
   			int flightno = Integer.parseInt( request.getParameter("flightno"));
   			String date = request.getParameter("date");
   
   			arrreserv = sqlcon.seatsavailable(flightno , date);
   			request.setAttribute("arrayList", arrreserv);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/seatsavailableresult.jsp");

			if( null != rd ){
				rd.forward(request, response);
			}
   		}				
	}
}
