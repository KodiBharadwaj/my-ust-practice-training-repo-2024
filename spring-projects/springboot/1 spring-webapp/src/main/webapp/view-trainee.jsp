<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ust.webapp.model.Trainee" %>
<%@ page import="com.ust.webapp.dto.TraineeDto" %>
<%@ page isELIgnored = "false" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Hello UST from Trivandrum</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="jumbotron text-center">
        <h1 class="display-4">Hello UST from Trivandrum</h1>
        <p class="lead">Below is the list of trainees:</p>
    </div>

    <div>
        <form action = "/get-trainee-by-id" method = "get">
            <label> Search By Id </label>
            <input type = "text" name = "searchid" id = "searchid">
            <button type = "submit" class = "btn btn-primary"> Get Trainee </button>
        </form>
    </div>

    <div class="row">

        <%
            List<TraineeDto> list = (List<TraineeDto>) request.getAttribute("list");
            TraineeDto trainee = (TraineeDto) request.getAttribute("trainee");

            if(trainee != null){
            %>
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Trainee ID: <%=   trainee.id() %></h5>
                        <h6 class="card-subtitle mb-2 text-muted">Name: <%= trainee.name() %></h6>
                        <p class="card-text">Location: <%= trainee.location() %></p>
                        <button class="btn btn-danger"> <a href="/delete-trainee?id=<%=trainee.id()%>">Delete</a> </button>
                    </div>
                </div>
            </div>
            <%
            }

            if (list != null && !list.isEmpty()) {
                for (TraineeDto trainee1 : list) {
        %><div class="col-md-4 mb-4">
                          <div class="card">
                              <div class="card-body">
                                  <h5 class="card-title">Trainee ID: <%=   trainee1.id() %></h5>
                                  <h6 class="card-subtitle mb-2 text-muted">Name: <%= trainee1.name() %></h6>
                                  <p class="card-text">Location: <%= trainee1.location() %></p>
                                  <button class="btn btn-danger"> <a href="/delete-trainee?id=<%=trainee1.id()%>" style = "text-decoration:none; color:white;">Delete</a> </button>
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









