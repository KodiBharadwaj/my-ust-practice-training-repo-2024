const url = "http://localhost:3000/tasks";

//document.addEventListener("DOMContentLoaded", getAllTrainees);
// document.getElementById("taskForm").addEventListener("submit", async (e) => {
//     e.preventDefault();
//     await submitDetails();
//      getAllTrainees();
// });

// Fetch and display all trainees
async function getAllTrainees() {
    const data = await fetch(url).then(response => response.json());
    const details = document.getElementById('details');
    details.innerHTML = '';

    data.forEach(element => {
        const res = document.createElement('div');
        res.className = 'col';
        res.innerHTML = `
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${element.name}</h5>
                    <p class="card-text">${element.description}</p>
                    <p class="card-text"><strong>Due Date:</strong> ${element.dueDate}</p>
                    <p class="card-text"><strong>Completed:</strong> ${element.completed}</p>
                    <button class="btn btn-danger" onclick="deletetrainee(${element.id})">Delete</button>
                </div>
            </div>
        `;
        details.appendChild(res);
    });
}

// Add a new trainee
async function submitDetails() {
    const trainee = {
        id: document.getElementById('userid').value,
        name: document.getElementById('username').value,
        description: document.getElementById('description').value,
        dueDate: document.getElementById('date').value,
        completed: document.getElementById('status').value.toLowerCase() === 'true'
    };
    await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(trainee)
    });
    alert("Details added!");
}

// Delete a trainee
async function deleteTrainee() {
    const deleteid = document.getElementById('deleteid').value;
    const response = await fetch(`${url}/${deleteid}`,
        {
            method: 'DELETE'
        });
    alert("Task with id " + deleteid + " has been deleted!");
}

async function deletetrainee(id) {
    await fetch(`${url}/${id}`, { method: 'DELETE' });
    getAllTrainees();
    alert("Task with id " + id + " has been deleted!")
}

async function updateTrainee() {

    const id = document.getElementById('userid').value;

        const trainee = {
            id1: id,
            name: document.getElementById('username').value,
            description: document.getElementById('description').value,
            dueDate: document.getElementById('date').value,
            completed: document.getElementById('status').value.toLowerCase() === 'true'
        };

    const response = await fetch(`${url}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(trainee)
    });
    alert("Data updated with id " + id);
    
}
