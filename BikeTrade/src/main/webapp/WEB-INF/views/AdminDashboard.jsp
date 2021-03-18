<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Data Review</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script>
  
  window.onload = function () {
	var chart1 = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "Bike Sell till Date"
		},
		data: [
		{
			
			type: "column",
			dataPoints: [
				{ label: "Honda",  y: 10  },
				{ label: "Suzuki", y: 15  },
				{ label: "Yamaha", y: 25  },
				{ label: "Bajaj",  y: 30  },
				{ label: "TVS",  y: 28  }
			]
		}
		]
	});
	

	var chart = new CanvasJS.Chart("PiechartContainer",
	{
		title:{
			text: "Bike Sold in 2020"
		},
		legend: {
			maxWidth: 350,
			itemWidth: 120
		},
		data: [
		{
			type: "pie",
			//showInLegend: true,
			legendText: "{indexLabel}",
			dataPoints: [
				{ y: 10, indexLabel: "Honda" },
				{ y: 15, indexLabel: "Suzuki" },
				{ y: 25, indexLabel: "Yamaha" },
				{ y: 30, indexLabel: "Bajaj"},
				{ y: 28, indexLabel: "TVS" },
				
			]
		}
		]
	});
	
	var chart2 = new CanvasJS.Chart("LinechartContainer",
    {

      title:{
      text: "Bike Sell - per month"
      },
      axisX: {
        valueFormatString: "MMM",
        interval:1,
        intervalType: "month"
      },
      axisY:{
        includeZero: false

      },
      data: [
      {
        type: "line",

        dataPoints: [
        { x: new Date(2012, 00, 1), y: 450 },
        { x: new Date(2012, 01, 1), y: 414},
          { x: new Date(2012, 02, 1), y: 520, indexLabel: "highest",markerColor: "red", markerType: "triangle"},
        { x: new Date(2012, 03, 1), y: 460 },
        { x: new Date(2012, 04, 1), y: 450 },
        { x: new Date(2012, 05, 1), y: 500 },
        { x: new Date(2012, 06, 1), y: 480 },
        { x: new Date(2012, 07, 1), y: 480 },
        { x: new Date(2012, 08, 1), y: 410 , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross"},
        { x: new Date(2012, 09, 1), y: 500 },
        { x: new Date(2012, 10, 1), y: 480 },
        { x: new Date(2012, 11, 1), y: 510 }
        ]
		
		
      }
      ]
    });
	
	
	var chart3 = new CanvasJS.Chart("StatusPiechartContainer",
	{
		title:{
			text: "Admin Approval Status"
		},
		legend: {
			maxWidth: 350,
			itemWidth: 120
		},
		data: [
		{
			type: "pie",
			//showInLegend: true,
			legendText: "{indexLabel}",
			dataPoints: [
				{ y: ${aprovedcount}, indexLabel: "Approved" },
				{ y: ${notaprovedcount}, indexLabel: "NOT Approved" },
				{ y: ${rejectedcount}, indexLabel: "Rejected" },
				{ y: ${cancelledcount}, indexLabel: "Cancelled"},
				{ y: ${soldcount}, indexLabel: "SOLD" },
				{ y: ${unsoldcount}, indexLabel: "UNSOLD" },
				
				
			]
		}
		]
	});
	
	chart.render();
	chart1.render();
	chart2.render();
	chart3.render();
}
  
  

  
  
  
  </script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 550px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: 767px) {
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse visible-xs">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Name : XYZ</a></li>
					<li><a href="#">Role : Admin</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav hidden-xs">

				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">Name : XYZ</a></li>
					<li><a href="#section2">Role : Admin</a></li>

				</ul>
				<br>
			</div>
			<br>

			<div class="col-sm-9">
				<div class="well">
					<h3>Admin Dashboard</h3>
					<h4>Bikes Sell Report</h4>
				</div>
				<div class="row">
					<div class="col-sm-4" style="">
						<div class="well">

							<div id="chartContainer" style="height: 300px; width: 100%;"></div>

						</div>
					</div>

					<div class="col-sm-4" style="">
						<div class="well">
							<div id="PiechartContainer" style="height: 300px; width: 100%;"></div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="well">
							<div id="LinechartContainer" style="height: 300px; width: 100%;"></div>
						</div>
					</div>
				</div>
				<div class="row">

					<div class="col-sm-5">
						<div class="well">
							<div id="StatusPiechartContainer"
								style="height: 300px; width: 100%;"></div>
							<p>
								<a>approve</a>
							</p>
						</div>
					</div>

					<div class="col-sm-5">
						<div class="well">
							<p>Bikes Pending For Admin Approval</p>
							<p>${notaprovedcount}</p>

						</div>
					</div>

				</div>


			</div>
		</div>
	</div>
	</div>
	</div>

</body>
</html>
