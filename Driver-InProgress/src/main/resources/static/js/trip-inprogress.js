/**
 * 
 */
 
 //setInterval('getReached()',10000);
var id = 101;
var xhr = new XMLHttpRequest();
var xhrTime = new XMLHttpRequest();
var time;
window.onload = screenOnLoadCalls;
var count;//number of passengers
var r = 0;//number of reached count
var show = "show";
var noshow ="noshow";
var arr;
var startTime;
//onload function
function screenOnLoadCalls(){
	
	getServerTime();
	tripInprogress();
}

function getServerTime(){
	xhrTime.open("GET", "http://localhost:8080/driver/inprogress/getServerTime/"+1050, true);

	xhrTime.onreadystatechange = processServerTimeResponse;

	xhrTime.send(null);
}

function tripInprogress() {
	xhr.open("GET", "http://localhost:8080/driver/inprogress/bookings/status/" + show + "/" + 1050, true);

	xhr.onreadystatechange = processResponse;

	xhr.send(null);
}
//to get server time------------------------------- beg
function processServerTimeResponse(){
	if (xhrTime.readyState == 4 && xhrTime.status == 200) {
		  time = JSON.parse(xhrTime.responseText);
		
		var p1 = document.createElement("p");
		p1.className = "trip-started";
	   
		//p1.innerHTML = "Trip Started At " + hour[0] + ":" + hour[1];

		var hour =time.startTime.split(":");
		if (hour[0] < 12) {
			if (hour[0] >= 10) {

				p1.innerHTML = "Trip Started At " + hour[0] + ":" + hour[1] + " AM";

			}
			else {
				if (hour[0] == 00) {
					p1.innerHTML = "Trip Started At " + "12" + ":" + hour[1] + " AM";
				}

				else {
					p1.innerHTML = "Trip Started At " + "0" + hour[0] + ":" + hour[1] + " AM";
				}
			}
		}
		else {
			var hr = hour[0] - 12;
			if (hour[0] >= 10) {

				p1.innerHTML = "Trip Started At " + hr + ":" + hour[1] + " PM";

			}


			else {
				p1.innerHTML = "Trip Started At " + "0" + hr + ":" + hour[1] + " PM";
			}
		}
		document.getElementById("triptime").appendChild(p1);
		}
}
//to get server time------------------------------- end
//----------------------------------------------------------------------------------------------------------------------------//
//to get trip details--beg
function processResponse() {

if (xhr.readyState == 4 && xhr.status == 200) {


		arr = JSON.parse(xhr.responseText);
		count = arr.length;

		var l = document.createElement('li');
		l.className = "trip-settings";
		var hour = arr[0].timeSlot.split(":");
		if (hour[0] < 12) {
			if (hour[0] >= 10) {

				l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + hour[0] + ":" + hour[1] + " AM";

			}
			else {
				if (hour[0] == 00) {
					l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + "12" + ":" + hour[1] + " AM";
				}

				else {
					l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + "0" + hour[0] + ":" + hour[1] + " AM";
				}
			}
		}
		else {
			var hr = hour[0] - 12;
			if (hour[0] >= 10) {

				l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + hr + ":" + hour[1] + " PM";

			}


			else {
				l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + "0" + hr + ":" + hour[1] + " PM";
			}
		}

		var l2 = document.createElement('li');
		l2.className = "trip-settings";
		l2.innerHTML = "<img src='images/Map.svg' alt='icon' class='mt-2 detail-icon'>" + arr[0].source + "  to  " + arr[0].destination;

		var l3 = document.createElement('li');
		l3.className = "trip-settings";
		l3.innerHTML = "<img src='images/People.svg' alt='icon' class='detail-icon'>" + count + " Passengers ";

       
		

		document.getElementById("trip").appendChild(l);
		document.getElementById("trip").appendChild(l2);
		document.getElementById("trip").appendChild(l3);
        
		
//to get trip details--end
//----------------------------------------------------------------------------------------------------------------------------//



//----------------------------------------------------------------------------------------------------------------------------//
//to get employee details--beg
		for (var i = 0; i < arr.length; i++) {


			if (i % 2 == 0) {

				var div1 = document.createElement('div');
				div1.className = "col-md-12 mt-2 alt-row";

			}

			else {
				var div1 = document.createElement('div');
				div1.className = "col-md-12 mt-2 ";
			}

			var div2 = document.createElement('div');
			div2.className = "row";

			var div3 = document.createElement('div');
			div3.className = "col-md-4 left-col mx-1 mt-2 float-start";


			var div4 = document.createElement('div');
			div4.className = "col-md-6 status-header mt-2";

			var div5 = document.createElement('div');
			div5.className = "parent";


			var div6 = document.createElement('div');
			div6.className = "map-location tivasta-w-100 no-show-button";

			var div7 = document.createElement('div');
			div7.className = "map-location tivasta-w-100 show-button";
			div7.dataset.target = "#reached-confirm";
			div7.id = "div7" + i;

			var list = document.createElement('ul');
			list.className = "p-0";
			list.id = "ul" + i;

			var listitem1 = document.createElement('li');
			listitem1.className = "Name";
			listitem1.innerText = arr[i].employeeName;


			var listitem2 = document.createElement('li');
			listitem2.className = "Emp-ID";
			listitem2.innerText = arr[i].employeeId;

			var listitem3 = document.createElement('li');
			listitem3.className = "Address";

			listitem3.innerHTML = "<img src='images/Map-table.svg' alt='icon' class= 'map-icon' >" + arr[i].dropPoint;

			list.appendChild(listitem1);
			list.appendChild(listitem2);
			list.appendChild(listitem3);

			div3.appendChild(list);


			div6.innerHTML = "<input type='radio'  id='radio-" + (i + (i + 1)) + "'name='radio" + i + "' value='r-opt1-db'  class='reached' checked=''>" + " <label for='radio-" + (i + (i + 1)) + "'></label>";
			div7.innerHTML = "<input type='radio' id='radio-" + (i + (i + 2)) + "' name='radio" + i + "' value='r-opt2-db'data-toggle='modal' data-target='#reached-confirm'onclick='myfunction(this)'>" + "<label for='radio-" + (i + (i + 2)) + "'></label>";

			div5.appendChild(div6);
			div5.appendChild(div7);
			div4.appendChild(div5);
			div2.appendChild(div3);
			div2.appendChild(div4);

			div1.appendChild(div2);
			document.getElementById('divid').appendChild(div1);

		}
	}

}
//to get employee details-end
//----------------------------------------------------------------------------------------------------------------------------//




//----------------------------------------------------------------------------------------------------------------------------//
//to get employee id based on radio button
var sts;//notreached button
var ul;
var selected;
var sts1;//reached button
function myfunction(radio) {
	selected = radio.name;

	var id = radio.closest("div").id;
	var spiltid = id.replace("div7", "");
	ul = document.getElementById("ul" + spiltid).getElementsByTagName("li")[1].innerText;
	//alert(radio.id);//radio button id
	sts = radio.id.replace("radio-","")-1;
	//alert(sts);//not reached button id
	sts1=radio.id;
				
}
//----------------------------------------------------------------------------------------------------------------------------//



//----------------------------------------------------------------------------------------------------------------------------//
//to reached popup cancellation--beg
function notreached(){
		document.getElementById("radio-"+sts).checked=true;
		//alert("sts");
	}
//to reached popup cancellation--end
//----------------------------------------------------------------------------------------------------------------------------//




//----------------------------------------------------------------------------------------------------------------------------//
//for updating reached status of employee--beg
function reached() {
	

	var xhrReached = new XMLHttpRequest();
	xhrReached.open("PUT", "http://localhost:8080/driver/inprogress/employee/status/" + ul+ "?tripCabID=" + 1050, true);

	xhrReached.onreadystatechange = function() {
		if (xhrReached.readyState == 4 && xhrReached.status == 200) {
			
			r = r + 1;
			//alert(count + r);
			document.getElementById(sts1).disabled=true;
			document.getElementById("radio-"+sts).disabled=true;
			
				
			if (count == r) {
				$('#completed').modal('show');
			}
			

		}
	};



	xhrReached.send(null);
}
//for updating reached status of employee--end
//----------------------------------------------------------------------------------------------------------------------------//



//----------------------------------------------------------------------------------------------------------------------------//
//for updating endtime of trip--beg
function ok() {

	var xhrupdate = new XMLHttpRequest();
	xhrupdate.open("PUT", "http://localhost:8080/driver/inprogress/update/" + 1050, true);
	xhrupdate.onreadystatechange = function() {
		if (xhrupdate.readyState == 4 && xhrupdate.status == 200) {
			window.location.href = "No Trip Assigned Page.html";
		}
		

	};
	xhrupdate.send(null);
}
//for updating endtime of trip--end
//----------------------------------------------------------------------------------------------------------------------------//