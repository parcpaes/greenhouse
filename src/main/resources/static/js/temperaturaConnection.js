
let data = [];
let dataHumedad = [];

let chart = Morris.Line({
    element: 'line-example',
    data,
    xkey: 'y',
    ykeys: ['a'],
    labels: ['Temperatura'],
    parseTime: false,
    pointSize:4,
    lineWidth:1,
    continuousLine:true,
    pointFillColors: ['#ffffff'],
    pointStrokeColors: ['gray'],
    lineColors: ['green']
});

let chartHumedad = Morris.Line({
    element: 'line-humedad',
    data:dataHumedad,
    xkey: 'y',
    ykeys: ['a'],
    labels: ['Humedad'],
    parseTime: false,
    pointSize:4,
    lineWidth:1,
    continuousLine:true,
    pointFillColors: ['#ffffff'],
    pointStrokeColors: ['gray'],
    lineColors: ['green']
});

var stompClient = null;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
    var socket = new SockJS('/websocket-example');
    stompClient = Stomp.over(socket);
    const repeat = new Set();
    stompClient.connect({}, function (frame) {
        //setConnected(true);
        //console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/temperatura', function (greeting) {
        	let {grados,humedad} = JSON.parse(greeting.body);         	
        	//console.log(JSON.parse(greeting.body).content);
            //showGreeting(JSON.parse(greeting.body).content);
        	let date = new Date().toLocaleTimeString()
        	//let template = "<tr><td>"+grados +"C</td>"+
        				  //"<td>"+date+"</td></tr>";
        	
        	data.push({
        		y: date,
        		a: grados
        	});
        	dataHumedad.push({
        		y:date,
        		a: humedad
        	})
        	//$('.table-body').prepend(template);
        	if(data.length>0){
        		chart.setData(data);
        		chartHumedad.setData(dataHumedad);
        	}
        	if(data.length>50){
        		data = data.slice(-2);
        		chartHumedad = chartHumedad.slice(-2);
        	}
        });
    });
}
connect();
/*function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}*/

function sendName() {
    stompClient.send("/app/temperatura ", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(temperature) {
    //$("#userinfo").append("<tr><td>" + message + "</td></tr>");	
	//console.log(temperature);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    //$( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});