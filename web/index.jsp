<%@ page import="com.theah64.pdpts.pojos.DataBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.theah64.pdpts.database.Data" %>
<%@ page import="com.theah64.webengine.database.querybuilders.QueryBuilderException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<%
    List<DataBean> dataBeans = null;
    try {
        dataBeans = Data.getInstance().getAll(20);
    } catch (QueryBuilderException | SQLException e) {
        e.printStackTrace();
    }
    if (dataBeans == null) {
        dataBeans = new ArrayList<>();
    }
%>
<html>

<head>
    <title>pewdiepie-vs-tseries</title>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.bundle.js"></script>
    <script src="https://npmcdn.com/Chart.Zoom.js@latest/Chart.Zoom.min.js"></script>
    <script src="https://www.chartjs.org/samples/latest/utils.js"></script>
    <style>
        canvas {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }
    </style>
</head>

<body>
<div style="width:75%;">
    <canvas id="canvas"></canvas>
</div>
<br>
<br>
<button id="addData">Add Data</button>
<script>

    var config = {
        type: 'line',
        data: {
            labels: [
                <%
            for(final DataBean dataBean : dataBeans){
                %>
                '<%=dataBean.getTimeStamp()%>',
                <%
            }
        %>
            ],
            datasets: [{
                label: 'PewDiePie',
                backgroundColor: window.chartColors.red,
                borderColor: window.chartColors.red,
                data: [
                    <%
            for(final DataBean dataBean : dataBeans){
                %>
                    <%=dataBean.getPdpSub()%>,
                    <%
                }
            %>
                ],
                fill: false,
            }, {
                label: 'T-Series',
                fill: false,
                backgroundColor: window.chartColors.blue,
                borderColor: window.chartColors.blue,
                data: [
                    <%
           for(final DataBean dataBean : dataBeans){
               %>
                    <%=dataBean.getTsSub()%>,
                    <%
                }
            %>
                ],
            }]
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'PewDiePie vs TSeries'
            },
            tooltips: {
                mode: 'index',
                intersect: false,
            },
            hover: {
                mode: 'nearest',
                intersect: true
            },

            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Time'
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Value'
                    }
                }]
            },
            // Container for pan options
            pan: {
                // Boolean to enable panning
                enabled: true,

                // Panning directions. Remove the appropriate direction to disable
                // Eg. 'y' would only allow panning in the y direction
                mode: 'xy',
                rangeMin: {
                    // Format of min pan range depends on scale type
                    x: null,
                    y: null
                },
                rangeMax: {
                    // Format of max pan range depends on scale type
                    x: null,
                    y: null
                },
                // Function called once panning is completed
                // Useful for dynamic data loading
                onPan: function () {
                    console.log('I was panned!!!');
                }
            },

            // Container for zoom options
            zoom: {
                // Boolean to enable zooming
                enabled: true,

                // Enable drag-to-zoom behavior
                drag: true,

                // Zooming directions. Remove the appropriate direction to disable
                // Eg. 'y' would only allow zooming in the y direction
                mode: 'xy',
                rangeMin: {
                    // Format of min zoom range depends on scale type
                    x: null,
                    y: null
                },
                rangeMax: {
                    // Format of max zoom range depends on scale type
                    x: null,
                    y: null
                },
                // Function called once zooming is completed
                // Useful for dynamic data loading
                onZoom: function () {
                    console.log('I was zoomed!!!');
                }
            }
        }
    };

    window.onload = function () {
        var ctx = document.getElementById('canvas').getContext('2d');
        window.myLine = new Chart(ctx, config);
    };

    /*setInterval(function () {

        config.data.labels.push(new Date());

        fetch('v1/get_data')
            .then(function (r) {
                return r.json();
            }).then(function (json) {
            console.log(json)
        });



        window.myLine.update();
    }, 1000);*/

    /*if (config.data.datasets.length > 0) {
        var month = MONTHS[config.data.labels.length % MONTHS.length];

    }*/

</script>
</body>

</html>
