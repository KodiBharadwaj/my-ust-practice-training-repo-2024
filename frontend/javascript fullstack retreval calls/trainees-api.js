const baseUrl = "http://localhost:3000/trainees";


function displayTrainee(user) {
    let table = document.getElementById('table');

    user.forEach(element => {
        let res = document.createElement('div');

        res.innerHTML = `
<p>${element.id} </p>
<p>${element.name} </p>
<p>${element.location} </p>
<p>${element.joinedDate} </p>
`;

        table.appendChild(res);
    });

}

async function getTrainee() {

    const user = await getTrainees();
    displayTrainee(user);
}






async function getTrainees() {
    const response = await fetch(baseUrl);
    const data = await response.json();
    return data;
}

async function getTraineeById(id) {
    const response = await fetch(`${baseUrl}/${id}`);
    const data = await response.json();
    return data;
}

async function getTraineeByName(name) {
    const response = await fetch(`${baseUrl}?name=${name}`);
    const data = await response.json();
    return data;
}

async function addTrainee() {
    const trainee = {
        id: document.getElementById('newid').value,
        name: document.getElementById('newusername').value,
        location: document.getElementById('newlocation').value,
        joinedDate: document.getElementById('newdate').value
    };
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(trainee)
    });
    const data = await response.json();
    const users = await getTrainees();
    displayTrainee(users);
    return data;
}


async function deleteTraineeById(id) {
    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'DELETE'
    });

    const data = await response.json();

    // const user = await deleteTraineeById(id);
    return data;
}

async function updateTrainee() {

    const id = document.getElementById('updateid').value;

            const trainee = {
                id1 : id,
                name: document.getElementById('updatename').value,
                location: document.getElementById('updatelocation').value,
                joinedDate: document.getElementById('updatedate').value
            };

    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(trainee)
    });

    const data = response.json();
    const users = await getTrainees();
    displayTrainee(users);
    return data;
}