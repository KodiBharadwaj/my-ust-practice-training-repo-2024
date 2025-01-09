<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.task.webapp.model.Task" %>
<%@ page import="com.task.webapp.dto.TaskDto" %>
<%@ page isELIgnored = "false" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Task Management App</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel = "icon" type = "image/x-con" href = "tick.png">
    <style>
        .custom-jumbotron {
            padding: 1rem;
            margin-bottom: 2rem;
        }
        .searchByIdClass{
            margin-bottom : 15px
        }
        #panel ul li::after{
                	content:'';
                	width:0%;
                	height:2px;
                	background:#f44336;
                	display:block;
                	margin:auto;
                	transition:0.5s;
                }
                #panel ul li:hover::after{
                	width:70%;
                }
                .buttonList {
                    margin-top: 20px;
                }

                .row{
                    margin-top: 16px;
                }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">Task Management App</a>

    <div class="collapse navbar-collapse justify-content-end" id = "panel">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Add Tasks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#searchid">Search Task</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">About</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container mt-5">
    <div class="jumbotron text-center custom-jumbotron">
        <h1 class="display-4">Welcome to Task Management App</h1>
        <p class="lead">Below are the list of tasks:</p>
    </div>

    <div class="searchByIdClass">
        <form action="/get-task-by-id" method="get" class="d-flex align-items-center">

            <input type="text" name="searchid" id="searchid" class="form-control mr-2" style="width: auto; max-width: 200px;" placeholder = "Enter Id to fetch data">
            <button type="submit" class="btn btn-primary">Get Task</button>
        </form>
        <div class = "buttonList">
            <a href="/by-dates" style = "text-decoration:none; color:white;"> <button class="btn btn-primary"> Fetch by dates </button> </a>
            <a href="/overdue-dates" style = "text-decoration:none; color:white;"> <button class="btn btn-primary"> Overdue tasks </button> </a>
            <a href="/status?name=Completed" style = "text-decoration:none; color:white;"> <button class="btn btn-primary"> Completed Tasks </button> </a>
            <a href="/status?name=Not-Completed" style = "text-decoration:none; color:white;"> <button class="btn btn-primary"> Incomplete Tasks </button> </a>
        <div>
    </div>


    <div class="row">
        <%
            List<TaskDto> list = (List<TaskDto>) request.getAttribute("list");
            TaskDto task = (TaskDto) request.getAttribute("task");
            TaskDto taskError = (TaskDto) request.getAttribute("taskError");

            if (taskError != null) {
            %>
                <script>
                    alert("Id already exists! Please use another Id");
                </script>
            <%
            }

            if(task != null){
            %>
              <div class="col-md-4 mb-4">
                  <div class="card">
                      <div class="card-body">
                          <h5 class="card-title">Task ID: <%=   task.id() %></h5>
                          <h6 class="card-subtitle mb-2 text-muted">Username: <%= task.username() %></h6>
                          <h6 class="card-subtitle mb-2 text-muted">Date: <%= task.date() %></h6>
                          <h6 class="card-subtitle mb-2 text-muted">Status: <%= task.status() %></h6>
                          <p class="card-text">Description: <%= task.description() %></p>
                          <a href="/delete-task?id=<%=task.id()%>" style = "text-decoration:none; color:white;"> <button class="btn btn-danger"> Delete </button> </a>
                      </div>
                  </div>
              </div>
            <%
            }
            if (list != null && !list.isEmpty()) {
                for (TaskDto task1 : list) {

        %>         <div class="col-md-4 mb-4">
                      <div class="card">
                          <div class="card-body">
                              <h5 class="card-title">Task ID: <%=   task1.id() %></h5>
                              <h6 class="card-subtitle mb-2 text-muted">Username: <%= task1.username() %></h6>
                              <h6 class="card-subtitle mb-2 text-muted">Date: <%= task1.date() %></h6>
                              <h6 class="card-subtitle mb-2 text-muted">Status: <%= task1.status() %></h6>
                              <p class="card-text">Description: <%= task1.description() %></p>
                              <a href="/delete-task?id=<%=task1.id()%>" style = "text-decoration:none; color:white;"> <button class="btn btn-danger"> Delete </button> </a>
                          </div>
                      </div>
                   </div>

        <%
                }
            }
        %>
    </div>
</div>




<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>









