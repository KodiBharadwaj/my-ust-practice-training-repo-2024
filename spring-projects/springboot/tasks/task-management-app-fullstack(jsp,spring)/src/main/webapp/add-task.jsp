<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Task Management app</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .custom-form-width {
            max-width: 550px;
            margin: 0 auto; /* Centers the form horizontally */
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">Task Management App</a>
    <div class="collapse navbar-collapse justify-content-end">
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

     <form action="/add-task" method="post" class="border p-4 rounded bg-light custom-form-width">
         <div class="form-group">
             <label for="id">Id</label>
             <input type="text" class="form-control" id="id" name="id" required>
         </div>

         <div class="form-group">
             <label for="username">Username</label>
             <input type="text" class="form-control" id="username" name="username" required>
         </div>

         <div class="form-group">
             <label for="description">Description</label>
             <input type="text" class="form-control" id="description" name="description" required>
         </div>

         <div class="form-group">
             <label for="date">Due date</label>
             <input type="date" class="form-control" id="date" name="date" required>
         </div>

         <div class="form-group">
             <label for="status">Status</label>
             <input type="text" class="form-control" id="status" name="status" required>
         </div>

         <button type="submit" class="btn btn-primary btn-block">Add task</button>
     </form>
 </div>


<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
