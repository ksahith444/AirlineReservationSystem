<HTML>
<body>
    
	<a href="#"
       onClick="setYears(1947, 2015);showCalender(this,'date');">
      <img src="<%=getServletContext().getContextPath() %>/images/cal.gif"></a>        <!-- Calender Script  -->     
      <table id="calenderTable" border=1>
       <tbody id="calenderTableHead">
         <tr>
           <td colspan="4" align="center">
	     <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,this.selectedIndex, false));"
                   id="selectMonth">
	              <option value="0">January</option>
	              <option value="1">February</option>
	              <option value="2">March</option>
	              <option value="3">April</option>
	              <option value="4">May</option>
	              <option value="5">June</option>
	              <option value="6">July</option>
	              <option value="7">August</option>
	              <option value="8">September</option>
	              <option value="9">October</option>
	              <option value="10">November</option>
	              <option value="11">December</option>
	          </select>
            </td>
            <td colspan="2" align="center">
	    <select onChange="showCalenderBody(createCalender(this.value, 
	      document.getElementById('selectMonth').selectedIndex, false));"
              id="selectYear">
	    </select>
			</td>
           <td align="center">
	    <a onClick="closeCalender();">
              <font color="#003333" ><img alt="Close" src="<%=getServletContext().getContextPath() %>/images/cross.jpg"></font>
            </a>
	   </td>
	</tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="font-size: 13px;text-align: center;">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td>
           <td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table><!-- End Calender Script  -->   </body>
</html>