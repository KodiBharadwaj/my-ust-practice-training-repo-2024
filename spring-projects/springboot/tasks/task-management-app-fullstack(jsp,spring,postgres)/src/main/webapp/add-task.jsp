<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Task Management app</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel = "icon" type = "image/x-con" href = "tick.png">
    <style>
        .custom-form-width {
            max-width: 550px;
            margin: 0 auto; /* Centers the form horizontally */
        }
        .extraButton{
            display: flex;

        }
        #alignButtons{
            margin-top : 10px;
        }
        #alignButtons .col-9 {
            padding-right: 1px;
        }
        #alignButtons .col-3{
            padding-left:3px;
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

    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">Task Management App</a>
    <div class="collapse navbar-collapse justify-content-end" id = "panel">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/get-all-tasks">Tasks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">About</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
     <h2 class="text-center">Enter Task Details</h2>

     <form method = "post" class="border p-4 rounded bg-light custom-form-width">
         <div class="form-group">
             <label for="id">Id</label>
             <input type="text" class="form-control" id="id" name="id" placeholder = "Enter task Id here" required>
         </div>

         <div class="form-group">
             <label for="username">Username</label>
             <input type="text" class="form-control" id="username" name="username" placeholder = "Enter Username here" required>
         </div>

         <div class="form-group">
             <label for="description">Description</label>
             <input type="text" class="form-control" id="description" name="description" placeholder = "Enter Description here" required>
         </div>

         <div class="form-group">
             <label for="date">Due date</label>
             <input type="date" class="form-control" id="date" name="date" required>
         </div>

         <div class="form-group">
             <label for="status">Status</label>
             <input type="text" class="form-control" id="status" name="status" placeholder = "Completed/Not-Completed" required>
         </div>

         <button type="submit" class="btn btn-primary btn-block" formaction="/add-task">Add Task</button>

         <div class="row" id = "alignButtons">
             <div class="col-9">
                 <button type="submit" class="btn btn-primary btn-block" formaction="/update-task">Update Task</button>
             </div>
             <div class="col-3">
                 <button type="reset" class="btn btn-secondary btn-block">Reset</button>
             </div>
         </div>
     </form>
 </div>



<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
