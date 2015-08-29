package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import models.reservation;


public class sqlconnection {
	
	public static ArrayList<reservation> fairinfo(int f_number) {
		Connection conn = null;
		Statement stmt =null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		ArrayList <reservation> arrreserv=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Airline_Reservation", "root", "");
		stmt = conn.createStatement();
		 stmt.execute("use airline_reservation");
		
		 ps=conn.prepareStatement("select * from fare where flight_number = ?");
		 ps.setInt(1, f_number);
		 
		 rs = ps.executeQuery();
		 arrreserv= new ArrayList<reservation>();
		  
		while(rs.next())
		{ 
			reservation rs1= new reservation();
			rs1.setFlight_number( rs.getInt("Flight_number"));
			rs1.setFare_code( rs.getString("Fare_code"));
			rs1.setAmount(rs.getInt("Amount"));
			rs1.setRestrictions(rs.getString("Restrictions"));
			arrreserv.add(rs1);
			//System.out.println(rs1.getFlight_number() +" "+rs1.getFare_code()+ " "+rs1.getAmount() +" " +rs1.getRestrictions());
			}
		}
	catch(SQLException error){
		System.out.println("Error"+error.getMessage());
	}
	catch (ClassNotFoundException error) {
		System.out.println("Error"+error.getMessage());
		}	
	
		finally{
			if(conn!=null)try {conn.close();} catch (SQLException ignore) {}
			if(stmt!=null)try {stmt.close();} catch (SQLException ignore) {}
			if(rs !=null) try {rs.close();  } catch (SQLException ignore) {}
			if(ps !=null) try {ps.close();  } catch (SQLException ignore) {}
			}
		
		return arrreserv;

		}
	
	
	public static ArrayList<reservation> conflights(String arraircode,String depaircode,int noofcon) {
		Connection conn = null;
		Statement stmt =null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		ArrayList <reservation> arrreserv=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Airline_Reservation", "root", "");
		stmt = conn.createStatement();
		stmt.execute("use airline_reservation");
		 
		if(noofcon == 0){
			arrreserv=new ArrayList<reservation>();
		 ps=conn.prepareStatement("SELECT "
		 		+ "departure_airport_code, "
		 		+ "scheduled_departure_time, "
		 		+ "arrival_airport_code, "
		 		+ "scheduled_arrival_time, "
		 		+ "weekdays " 
		 		+ "FROM "
				+ "flight " 
				+ "WHERE "
				+ "departure_airport_code = ? "
				+ "AND arrival_airport_code = ?; ");
		 ps.setString(1, depaircode);
		 ps.setString(2, arraircode);
		 rs = ps.executeQuery();
		
		 while(rs.next())
		{ 
			reservation rs1= new reservation();
			rs1.setDepaircode(rs.getString("departure_airport_code"));
			rs1.setScheduled_departure_time(rs.getString("scheduled_departure_time"));
			rs1.setArraircode(rs.getString("arrival_airport_code"));
			rs1.setScheduled_arrival_time(rs.getString("scheduled_arrival_time"));
			rs1.setWeekdays(rs.getString("weekdays"));
			arrreserv.add(rs1);
			//System.out.println(rs1.getDepaircode() + " " + rs1.getScheduled_arrival_time() + " " + rs1.getArraircode());
		}
		}
		
		else if(noofcon == 1){
			
			ps= conn.prepareStatement("SELECT"
	+  " f1.departure_airport_code,"
    + " f1.scheduled_departure_time,"
    + " f1.arrival_airport_code,"
    + " f1.Scheduled_arrival_time,"
    + "   f1.weekdays," 
    
    
   + " f2.departure_airport_code as dep,"
   + " f2.scheduled_departure_time as schdep,"
   + " f2.arrival_airport_code as arr,"
   + " f2.Scheduled_arrival_time as scharr,"
   +"   f2.weekdays as wekday,"
    
   + " TIME_TO_SEC(TIMEDIFF(f2.scheduled_departure_time,"
   +                 "f1.Scheduled_arrival_time)) / 3600 AS timediff_in_hrs"
+ " FROM"
+    " flight f1,"
+   " flight f2"
+ " WHERE"
+ "    f1.arrival_airport_code = f2.departure_airport_code"
+ "       AND f1.departure_airport_code = ?"
+"        AND f2.arrival_airport_code = ?"
+"        AND TIME_TO_SEC(TIMEDIFF(f2.scheduled_departure_time,"
+"                   f1.Scheduled_arrival_time)) / 3600 > 1 "
+	"	AND TIME_TO_SEC(TIMEDIFF(f2.scheduled_departure_time,"
+"                    f1.Scheduled_arrival_time)) / 3600 < 3"
+"	ORDER BY "
+"    f1.departure_airport_code,"
+"    f1.scheduled_departure_time,"
+"    f1.arrival_airport_code,"
+"    f1.Scheduled_arrival_time,"

    
+"    f2.departure_airport_code,"
+"    f2.scheduled_departure_time,"
+"    f2.arrival_airport_code,"
+"   f2.Scheduled_arrival_time;");
			
			ps.setString(1, depaircode);
			ps.setString(2, arraircode);
			 rs = ps.executeQuery();
			  arrreserv= new ArrayList<reservation>();
			  
				while(rs.next())
				{ 
					reservation rs1= new reservation();
					reservation rs2=new reservation();
					String w1 = rs.getString("weekdays");
					String w2 = rs.getString("wekday");
					
					String weekdays=comaprestrings(w1,w2);
					if(weekdays!=""){
					rs1.setDepaircode(rs.getString("departure_airport_code"));
					rs1.setScheduled_departure_time(rs.getString("scheduled_departure_time"));
					rs1.setArraircode(rs.getString("arrival_airport_code"));
					rs1.setScheduled_arrival_time(rs.getString("scheduled_arrival_time"));
					//rs1.setWeekdays(rs.getString("weekdays"));
					rs1.setWeekdays(weekdays);
					//System.out.println(rs1.getDepaircode() + " " + rs1.getScheduled_departure_time() + " " + rs1.getArraircode() + ""+ rs1.getScheduled_arrival_time());
					
					rs2.setDepaircode(rs.getString("dep"));
					rs2.setScheduled_departure_time(rs.getString("schdep"));
					rs2.setArraircode(rs.getString("arr"));
					rs2.setScheduled_arrival_time(rs.getString("scharr"));
					//rs2.setWeekdays(rs.getString("wekday"));
					rs2.setWeekdays(weekdays);
					//System.out.println(rs2.getDepaircode() + " " + rs2.getScheduled_departure_time() + " " + rs2.getArraircode() + ""+ rs2.getScheduled_arrival_time());
					arrreserv.add(rs1);
					arrreserv.add(rs2);
					}
					else{
						continue;
					}
				}
			
		}
		
		else if(noofcon == 2){
			
			ps= conn.prepareStatement(" SELECT"
					+ " f1.departure_airport_code,"
				    + " f1.scheduled_departure_time,"
				    + " f1.arrival_airport_code,"
				    + " f1.Scheduled_arrival_time,"
				    + "   f1.weekdays,"
				    
				    
				   + " f2.departure_airport_code as dep,"
				   + " f2.scheduled_departure_time as schdep,"
				   + " f2.arrival_airport_code as arr,"
				   + " f2.Scheduled_arrival_time as scharr,"
				   +"   f2.weekdays as wekday,"
				    
				   + " TIME_TO_SEC(TIMEDIFF(f2.scheduled_departure_time,"
				   +                 "f1.Scheduled_arrival_time)) / 3600 AS timediff_in_hrs,"
				   
				   + " f3.departure_airport_code as dep1,"
				   + " f3.scheduled_departure_time as schdep1,"
				   + " f3.arrival_airport_code as arr1,"
				   + " f3.Scheduled_arrival_time as scharr1,"
				   +"   f3.weekdays as wekday1,"
				   
				   + " TIME_TO_SEC(TIMEDIFF(f3.scheduled_departure_time,"
				   + "                 f2.Scheduled_arrival_time)) / 3600 AS timediff_in_hrs1"
				   
				+ " FROM"
				+    " flight f1,"
				+    " flight f2,"
				+	 " flight f3"
				
				+ " WHERE"
				+ "    f1.arrival_airport_code = f2.departure_airport_code"
				+"		AND f2.arrival_airport_code = f3.departure_airport_code"
				+ "       AND f1.departure_airport_code = ?"
				+"        AND f3.arrival_airport_code = ?"
				+" AND STRCMP(f2.arrival_airport_code,f1.departure_airport_code) != 0"
				
				 +" AND TIME_TO_SEC(TIMEDIFF(f2.scheduled_departure_time,"
		         +"           f1.Scheduled_arrival_time)) / 3600 > 1"
		       +" AND TIME_TO_SEC(TIMEDIFF(f2.scheduled_departure_time,"
		       +"             f1.Scheduled_arrival_time)) / 3600 < 3"
		       +" AND TIME_TO_SEC(TIMEDIFF(f3.scheduled_departure_time,"
		        +"            f2.Scheduled_arrival_time)) / 3600 > 1"
		       +" AND TIME_TO_SEC(TIMEDIFF(f3.scheduled_departure_time,"
		        +"            f2.Scheduled_arrival_time)) / 3600 < 3"
				+"	ORDER BY "
				+"    f1.departure_airport_code,"
				+"    f1.scheduled_departure_time,"
				+"    f1.arrival_airport_code,"
				+"    f1.Scheduled_arrival_time,"
				    
				+"    f2.departure_airport_code,"
				+"    f2.scheduled_departure_time,"
				+"    f2.arrival_airport_code,"
				 +"   f2.Scheduled_arrival_time,"
				
				+"    f3.departure_airport_code,"
				+"    f3.scheduled_departure_time,"
				+"    f3.arrival_airport_code,"
				+"    f3.Scheduled_arrival_time;");
							
							ps.setString(1, depaircode);
							ps.setString(2, arraircode);
							
							  arrreserv= new ArrayList<reservation>();
							  rs = ps.executeQuery();
								while(rs.next())
								{ 
									reservation rs1= new reservation();
									reservation rs2=new reservation();
									reservation rs3=new reservation();
									String w1=rs.getString("weekdays");
									String w2=rs.getString("wekday");
									String w3=rs.getString("wekday1");
									String w4=comaprestrings(w1, w2);
									String weekdays=comaprestrings(w3, w4);
									
									if(weekdays!=""){
									rs1.setDepaircode(rs.getString("departure_airport_code"));
									rs1.setScheduled_departure_time(rs.getString("scheduled_departure_time"));
									rs1.setArraircode(rs.getString("arrival_airport_code"));
									rs1.setScheduled_arrival_time(rs.getString("scheduled_arrival_time"));
									rs1.setWeekdays(weekdays);
									//rs1.setWeekdays(rs.getString("weekdays"));
									//System.out.println(rs1.getDepaircode() + " " + rs1.getScheduled_departure_time() + " " + rs1.getArraircode() + ""+ rs1.getScheduled_arrival_time());

									rs2.setDepaircode(rs.getString("dep"));
									rs2.setScheduled_departure_time(rs.getString("schdep"));
									rs2.setArraircode(rs.getString("arr"));
									rs2.setScheduled_arrival_time(rs.getString("scharr"));
									rs2.setWeekdays(weekdays);
									//rs2.setWeekdays(rs.getString("wekday"));
									//System.out.println(rs2.getDepaircode() + " " + rs2.getScheduled_departure_time() + " " + rs2.getArraircode() + ""+ rs2.getScheduled_arrival_time());

									rs3.setDepaircode(rs.getString("dep1"));
									rs3.setScheduled_departure_time(rs.getString("schdep1"));
									rs3.setArraircode(rs.getString("arr1"));
									rs3.setScheduled_arrival_time(rs.getString("scharr1"));
									rs3.setWeekdays(weekdays);
									//rs3.setWeekdays(rs.getString("wekday1"));
									//System.out.println(rs3.getDepaircode() + " " + rs3.getScheduled_departure_time() + " " + rs3.getArraircode() + ""+ rs3.getScheduled_arrival_time());

									arrreserv.add(rs1);
									arrreserv.add(rs2);
									arrreserv.add(rs3);
									}
									else{
										continue;
									}
								}
		}
		}
	catch(SQLException error){
		System.out.println("Error"+error.getMessage());
		}
	catch (ClassNotFoundException error) {
		System.out.println("Error"+error.getMessage());
		}	
	finally{
			if(conn!=null)try {conn.close();} catch (SQLException ignore) {}
			if(stmt!=null)try {stmt.close();} catch (SQLException ignore) {}
			if(rs !=null) try {rs.close();  } catch (SQLException ignore) {}
			if(ps !=null) try {ps.close();  } catch (SQLException ignore) {}
			}
		
	return arrreserv;

		}
	
	public static String comaprestrings(String w1,String w2) {
		int l1=w1.length();
		int l2=w2.length();
		
		String w3="" ;
		if(l1<l2)
		{
			StringTokenizer st1 = new StringTokenizer(w1, "_");
			while (st1.hasMoreTokens())
			{
				String token = st1.nextToken();
				if(w2.contains(token))
				{
							w3= w3.concat(token);
							w3=w3.concat("_");
				}
				else{
					continue;
				}	
			}
		}
				else
				{
					StringTokenizer st1 = new StringTokenizer(w2, "_");
					while (st1.hasMoreTokens())
					{
						String token = st1.nextToken();
						if(w1.contains(token))
						{
									w3= w3.concat(token);
									w3=w3.concat("_");
						}
						else{
							continue;
						}	
					}
				}
		return w3;
		
	}


	public static ArrayList<reservation> seatsavailable(int flightno,String date){
		Connection conn = null;
		Statement stmt =null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rss1=null;
		ResultSet rs= null;
		ArrayList <reservation> arrreserv=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Airline_Reservation", "root", "");
			stmt = conn.createStatement();
			 stmt.execute("use airline_reservation");
			 ps1=conn.prepareStatement("SELECT total_number_of_seats FROM AIRPlANE WHERE airplane_id IN "
					 +" (SELECT airplane_id FROM FLIGHT_INSTANCE WHERE FLIGHT_number = ? AND date = ?); ");
			 ps1.setInt(1, flightno);
			 ps1.setString(2, date);
			 rss1 = ps1.executeQuery();
			 int totalnoofseats=0;
			 while(rss1.next()){
			 totalnoofseats=rss1.getInt("total_number_of_seats");
			 //System.out.println("no of seats are  "+totalnoofseats);
			 }
			
			
			 PreparedStatement ps2=conn.prepareStatement("SELECT COUNT(*) AS seatsbooked FROM seat_reservation WHERE flight_number = ? AND date = ?;");
			 ps2.setInt(1, flightno);
			 ps2.setString(2, date);
			 ResultSet rss2 = ps2.executeQuery();
			 int seatsbooked=0;
			 while(rss2.next()){ 
			  seatsbooked= rss2.getInt("seatsbooked");
			 // System.out.println("no of seats booked are "+seatsbooked);
			 }
			 
			 int noofavailbleseats=totalnoofseats-seatsbooked;
			 PreparedStatement ps3=conn.prepareStatement("update Flight_instance set Number_of_available_seats=? where flight_number = ? AND date = ?;");
			 ps3.setInt(1, noofavailbleseats);
			 ps3.setLong(2, flightno);
			 ps3.setString(3, date);
			 ps3.execute();
			 
			 ps= conn.prepareStatement("select number_of_available_seats from flight_instance where flight_number=? and date=?");
			 ps.setLong(1, flightno);
			 ps.setString(2, date);
			 rs=ps.executeQuery();
			 arrreserv= new ArrayList<reservation>();
			 while(rs.next()){
				 reservation rs1= new reservation();
					rs1.setNumberofavailablesets( rs.getInt("number_of_available_seats"));
					arrreserv.add(rs1);
					//System.out.println("num of available seats on given flight instance are "+rs1.getNumberofavailablesets());
				 
			 }
		}
		catch(SQLException error){
			error.printStackTrace();
			System.out.println("Error"+error.getMessage());
			}
		catch (ClassNotFoundException error) {
			System.out.println("Error"+error.getMessage());
			}	
		finally{
				if(conn!=null)try {conn.close();} catch (SQLException ignore) {}
				if(stmt!=null)try {stmt.close();} catch (SQLException ignore) {}
				if(rs !=null) try {rs.close();  } catch (SQLException ignore) {}
				if(ps !=null) try {ps.close();  } catch (SQLException ignore) {}
				
				}
		return arrreserv;
	}
	
	public static ArrayList<reservation> passengerflightlist(String passname){
		Connection conn = null;
		Statement stmt =null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		ArrayList <reservation> arrreserv=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Airline_Reservation", "root", "");
			stmt = conn.createStatement();
			 stmt.execute("use airline_reservation");
			 
			 ps= conn.prepareStatement("select flight_number,date from seat_reservation where customer_name=?;");
		ps.setString(1, passname);
		rs=ps.executeQuery();
		 arrreserv= new ArrayList<reservation>();
		while(rs.next()){
			reservation rs1= new reservation();
			rs1.setFlight_number( rs.getInt("Flight_number"));
			rs1.setDate(rs.getString("date"));
			arrreserv.add(rs1);
			//System.out.println(rs1.getFlight_number() + " "+rs1.getDate());
		}
		}
		
		catch(SQLException error){
			System.out.println("Error"+error.getMessage());
			}
		catch (ClassNotFoundException error) {
			System.out.println("Error"+error.getMessage());
			}	
		finally{
				if(conn!=null)try {conn.close();} catch (SQLException ignore) {}
				if(stmt!=null)try {stmt.close();} catch (SQLException ignore) {}
				if(rs !=null) try {rs.close();  } catch (SQLException ignore) {}
				if(ps !=null) try {ps.close();  } catch (SQLException ignore) {}
				}
		return arrreserv;
	}
	
	public static ArrayList<reservation> passengerslist(int flightno ,String date){
		Connection conn = null;
		Statement stmt =null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		ArrayList <reservation> arrreserv=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Airline_Reservation", "root", "");
			stmt = conn.createStatement();
			 stmt.execute("use airline_reservation");
			 
			 ps= conn.prepareStatement("select seat_number,customer_name,Customer_phone from seat_reservation where flight_number=? and date=?;");
			 ps.setInt(1, flightno);
			 ps.setString(2, date);
			 rs=ps.executeQuery();
			 arrreserv= new ArrayList<reservation>();
			 
			 while(rs.next()){
				 reservation rs1= new reservation();
				 rs1.setSeatno(rs.getString("seat_number"));
				 rs1.setCustomerName(rs.getString("customer_name"));
				 rs1.setContactNumber(rs.getString("customer_phone"));
				 arrreserv.add(rs1);
				 //System.out.println(rs1.getSeatno() + " "+ rs1.getCustomerName() + " "+ rs1.getContactNumber());
			 }
			 
		}
		catch(SQLException error){
			System.out.println("Error"+error.getMessage());
			}
		catch (ClassNotFoundException error) {
			System.out.println("Error"+error.getMessage());
			}	
		finally{
				if(conn!=null)try {conn.close();} catch (SQLException ignore) {}
				if(stmt!=null)try {stmt.close();} catch (SQLException ignore) {}
				if(rs !=null) try {rs.close();  } catch (SQLException ignore) {}
				if(ps !=null) try {ps.close();  } catch (SQLException ignore) {}
				}
		return arrreserv;
	}

}
