function saveTask() {
    event.preventDefault();
    let id = document.getElementById('id').value;
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;

    if(isNaN(id)){
        alert("Id should be a number!");
    }
    if(id && name && email && password && !isNaN(id)){
        let data = {
            id: id,
            name : name,
            email : email,
            password : password
        }
    
        addDetails(data).then(response => {
            alert('Details added successfully!');
        }).catch(error => {
            console.log(error);
        });
       loadDetails();
    }
}

async function loadDetails(){
    const tasks = await getDetails();
    displayDetails(tasks);
}

function displayDetails(tasks) {
    const displayTasksDiv = document.getElementById('displayTasks');
  
    displayTasksDiv.innerHTML = '';
  
    tasks.forEach(task => {
      const taskCard = document.createElement('div');
      taskCard.classList.add('col-md-4', 'mb-4'); 
  
      taskCard.innerHTML = `
        <div class="card h-100">
          <div class="card-body">
            <h5 class="card-title">Task ID: ${task.id}</h5>
            <h6 class="card-text"><strong> Username:</strong> ${task.name}</h6>
            <p class="card-text"><strong>Description:</strong> ${task.email}</p>
            <p class="card-text"><strong>Encrypted Password:</strong> ${task.password}</p>
          </div>
        </div>
      `;
  
      displayTasksDiv.appendChild(taskCard);
    });
  }
  

loadDetails();