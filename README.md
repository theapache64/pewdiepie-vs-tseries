# pewdiepie-vs-tseries
A simple API to get subscriber count of pewdiepie and tseries.


<div class="container">

<h1>pewdiepie-vs-tseries
</h1>

<hr>

<h2>API Documentation</h2>
<p>This is a lightweight web service, (REST interface), which provides an easy way to access
<b>`pewdiepie-vs-tseries`</b> data. The
API works through simple commands, so there should not be a problem coding some nice applications. This API
contains total <b>1
</b> route(s)</b>
</p>

<br>

<h2>API Endpoints</h2>
<p>All the API endpoints return the same data structure as below
</p>


<div class="row">
<div class="col-md-8">
<table class="table table-bordered ">
<thead>
<tr>
<th>Returned Key</th>
<th>Description</th>
<th>Example</th>
</tr>
</thead>
<tbody>
<tr>
<td>error</td>
<td>The returned status for the API call, can be either 'true' or 'false'</td>
<td>true</td>
</tr>
<tr>
<td>message</td>
<td>Either the error message or the successful message</td>
<td>OK</td>
</tr>
<tr>
<td>data</td>
<td>If 'error' is returned as 'false' the API query results will be inside 'data'</td>
<td>data</td>
</tr>
</tbody>
</table>
</div>
</div>


<div class="row">
<div class="col-md-9">
<h3>Success response format</h3>

```json
{
"error": false,
"message": "SUCCESS_MESSAGE",
"data": {}
}
```

<br>

<h3>Error response format</h3>
```json
{
"error": true,
"message": "ERROR_MESSAGE"
}
```
</div>
</div>


<div>
<h3 style="cursor: pointer;" class="h3RouteName">
<small>1
.
</small>
/get_data
</h3>

<br>

<div class="routeContent">

<div class="row">
<div class="col-md-9">
<table class="table table-bordered ">
<thead>
<tr>
<th>End Point</th>
<th>Type</th>
</tr>
</thead>
<tbody>
<tr>
<td>
    <a href="http://theapache64.com/pewdiepie-vs-tseries/v1/get_data">http://theapache64.com/pewdiepie-vs-tseries/v1/get_data
    </a></td>
<td>Actual URL</td>
</tr>
</table>
</div>
</div>

<br>

<h4><b>Description</b></h4>
<p>To get subscriber count
</p>
<br>





<div class="no-print">
<h4><b>Sample Response</b></h4>




<div class="row">
<div class="col-md-10">

```json
{
    "error": false,
    "message": "This is a sample success message",
    "data": {
        "pew_die_pie": "42342342423",
        "t_series": "523452346"
    }
}
```
</div>
</div>

<br>
</div>
<br>


<h4><b>Test URLs</b></h4>
<div class="row">
<div class="col-md-10">
<table class="table table-bordered ">
<thead>
<tr>
<th>URL</th>
<th>Type</th>
</tr>
</thead>
<tbody>


<tr>
<td>
    <a target="_blank" href="http://theapache64.com/pewdiepie-vs-tseries/v1/get_data">http://theapache64.com/pewdiepie-vs-tseries/v1/get_data
    </a></td>
<td>Actual URL</td>
</tr>

<tr>
<td>
    <a target="_blank"
       href="http://theapache64.com/pewdiepie-vs-tseries/v1/get_data?is_skip_auth=true">http://theapache64.com/pewdiepie-vs-tseries/v1/get_data
    </a></td>
<td>Actual URL (with required params.)</td>
</tr>


<tr>
<td>
    <a target="_blank"
       href="http://theapache64.com/mock_api/get_json/pewdiepie-vs-tseries/get_data?is_skip_auth=true">
        http://theapache64.com/mock_api/get_json/pewdiepie-vs-tseries/get_data
    </a></td>
<td>Mock URL (with required params.)</td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</div>




</div>